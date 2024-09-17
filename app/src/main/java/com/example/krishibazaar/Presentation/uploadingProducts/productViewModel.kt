package com.example.krishibazaar.Presentation.uploadingProducts

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.krishibazaar.Data.Item.onlineItemData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID

class ProductViewModel : ViewModel() {
    private val _uploadState = mutableStateOf(false) // Internal mutable state
    val uploadState: State<Boolean> get() = _uploadState // Expose immutable state

    fun uploadProduct(
        product: onlineItemData,
        imageUri: Uri,
        onProductAdded: () -> Unit
    ) {
        val storageReference = FirebaseStorage.getInstance().reference
        val fileName = UUID.randomUUID().toString() + ".jpg"
        val imageRef = storageReference.child("products/$fileName")

        // Upload image to Firebase Storage
        imageRef.putFile(imageUri)
            .addOnSuccessListener {
                Log.d("hkv3", "Image uploaded successfully")
                imageRef.downloadUrl.addOnSuccessListener { imageUrl ->
                    val updatedProduct = product.copy(imageUrl = imageUrl.toString())
                    //Update product with image URL
                    Log.d("hkv3", "initiated firestore upload")
                    saveProductToFirestore(updatedProduct, onProductAdded)// Save product to Firestore
                }
            }
            .addOnFailureListener { exception ->
                Log.e("hkv3", "Image upload failed: ${exception.message}")
                _uploadState.value = false // Update state on failure
            }
    }

    private fun saveProductToFirestore(product: onlineItemData, onProductAdded: () -> Unit) {
        val firestore = FirebaseFirestore.getInstance()

        // Add product to Firestore collection
        firestore.collection("products")
            .add(product)
            .addOnSuccessListener {
                Log.d("Firestore1", "Product added successfully")
                _uploadState.value = true // Update state on success
                onProductAdded()
            }
            .addOnFailureListener { exception ->
                Log.e("Firestore1", "Failed to add product: ${exception.message}")
                _uploadState.value = false // Update state on failure
            }
    }
}
