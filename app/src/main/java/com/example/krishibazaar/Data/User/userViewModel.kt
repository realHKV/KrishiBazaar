package com.example.krishibazaar.Data.User

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

// Define the ViewModel
class UserViewModel : ViewModel() {

    // Function to upload user to Firestore
    private suspend fun uploadToFirestore(user: User) {
        val firestore = FirebaseFirestore.getInstance()
        val currentUser = FirebaseAuth.getInstance().currentUser

        currentUser?.let { firebaseUser ->
            firestore.collection("users").document(firebaseUser.uid).set(user).await()
        }
    }

    // Function to check if the user exists and upload if needed
    fun checkUserAndUploadIfNeeded(defaultUser: User, onUserChecked: (Boolean) -> Unit) {
        viewModelScope.launch {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val firestore = FirebaseFirestore.getInstance()

            currentUser?.let { user ->
                val userDoc = firestore.collection("users").document(user.uid).get().await()

                if (userDoc.exists()) {
                    // User exists in Firestore
                    onUserChecked(true)
                } else {
                    // User does not exist, upload the user
                    uploadToFirestore(defaultUser.copy(UserId = user.uid))
                    onUserChecked(false)
                }
            }
        }
    }
    //get User from firestore
    // MutableStateFlow to hold user data and UI state
    private val _userData = MutableStateFlow<User?>(null)
    val userData = _userData.asStateFlow()

    // Function to get User from Firestore based on current user's uid
    fun getUserFromFirestore() {
        viewModelScope.launch {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val firestore = FirebaseFirestore.getInstance()

            currentUser?.let { user ->
                val userDoc = firestore.collection("users").document(user.uid).get().await()

                if (userDoc.exists()) {
                    // Convert Firestore document to User object
                    val retrievedUser = userDoc.toObject(User::class.java)
                    _userData.value = retrievedUser
                } else {
                    // Handle user not found case
                    _userData.value = null
                }
            }
        }
    }

    // Function to update the user's name and phone number and refresh data after update
    fun updateUserInFirestore(newName: String, newPhoneNumber: String, onSuccess: () -> Unit, onError: (Exception) -> Unit) {
        viewModelScope.launch {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val firestore = FirebaseFirestore.getInstance()

            currentUser?.let { user ->
                val userRef = firestore.collection("users").document(user.uid)

                val updatedData = mapOf(
                    "name" to newName,
                    "phoneNumber" to newPhoneNumber
                )

                try {
                    userRef.update(updatedData).await()
                    // After successful update, refresh the user data
                    getUserFromFirestore() // Re-fetch the updated user data
                    onSuccess()
                } catch (e: Exception) {
                    onError(e)
                }
            }
        }
    }



}