package com.example.krishibazaar.ui

//package io.github.composegears.valkyrie

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

val TractorIcon: ImageVector
    get() {
        if (_TractorIcon != null) {
            return _TractorIcon!!
        }
        _TractorIcon = ImageVector.Builder(
            name = "TractorIcon",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(9f, 23f)
                moveToRelative(-7f, 0f)
                arcToRelative(7f, 7f, 0f, isMoreThanHalf = true, isPositiveArc = true, 14f, 0f)
                arcToRelative(7f, 7f, 0f, isMoreThanHalf = true, isPositiveArc = true, -14f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(27f, 26f)
                moveToRelative(-4f, 0f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, 8f, 0f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, -8f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(19f, 5f)
                lineTo(7f, 5f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(1.9f, 16f)
                curveToRelative(1.8f, -1.9f, 4.3f, -3f, 7.1f, -3f)
                curveToRelative(5.5f, 0f, 10f, 4.5f, 10f, 10f)
                curveToRelative(0f, 0.3f, 0f, 0.7f, 0f, 1f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(30.5f, 24f)
                lineToRelative(0.5f, 0f)
                lineToRelative(0f, -11f)
                lineToRelative(-11.8f, 0f)
                lineToRelative(-3.2f, -8f)
                lineToRelative(-9f, 0f)
                lineToRelative(-1.8f, 8.8f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(19f, 24f)
                lineToRelative(3f, 0f)
                lineToRelative(1.5f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(9f, 23f)
                moveToRelative(-2f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 4f, 0f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -4f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(23f, 8f)
                lineTo(23f, 8f)
                curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f)
                verticalLineToRelative(6f)
            }
        }.build()

        return _TractorIcon!!
    }

@Suppress("ObjectPropertyName")
private var _TractorIcon: ImageVector? = null

val Sell: ImageVector
    get() {
        if (_Sell != null) {
            return _Sell!!
        }
        _Sell = ImageVector.Builder(
            name = "Sell",
            defaultWidth = 64.dp,
            defaultHeight = 64.dp,
            viewportWidth = 64f,
            viewportHeight = 64f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(52.3f, 41f)
                curveTo(51.7f, 41f, 51.1f, 41.1f, 50.6f, 41.3f)
                curveTo(50.8f, 40.2f, 51f, 39.1f, 51f, 38f)
                curveTo(51f, 33.3f, 49.3f, 28.6f, 46.3f, 25f)
                lineTo(41.7f, 19.5f)
                curveTo(42.5f, 18.9f, 43f, 18f, 43f, 17f)
                curveTo(43f, 16.3f, 42.7f, 15.6f, 42.3f, 15.1f)
                lineTo(43.3f, 14.1f)
                curveTo(45.7f, 11.7f, 46.6f, 8.3f, 45.8f, 5.1f)
                curveTo(45.5f, 4.1f, 44.8f, 3.3f, 43.7f, 3f)
                curveTo(42.7f, 2.7f, 41.6f, 3f, 40.8f, 3.8f)
                lineTo(40.6f, 4f)
                curveTo(40.2f, 4.4f, 39.6f, 4.4f, 39.3f, 4f)
                lineTo(38.3f, 2.9f)
                curveTo(37.7f, 2.3f, 36.9f, 1.9f, 36f, 2f)
                curveTo(35.2f, 2.1f, 34.4f, 2.5f, 33.9f, 3.2f)
                lineTo(33.6f, 3.6f)
                curveTo(33.4f, 3.8f, 33.1f, 4f, 32.9f, 4f)
                curveTo(32.6f, 4f, 32.4f, 3.9f, 32.2f, 3.7f)
                curveTo(31.4f, 2.9f, 30.4f, 2.7f, 29.3f, 2.9f)
                curveTo(28.3f, 3.2f, 27.5f, 4f, 27.2f, 5f)
                curveTo(26.4f, 8.2f, 27.4f, 11.7f, 29.7f, 14f)
                lineTo(30.2f, 14.5f)
                curveTo(29.5f, 15.2f, 29f, 16f, 29f, 17f)
                curveTo(29f, 18f, 29.5f, 18.9f, 30.3f, 19.5f)
                lineTo(29.5f, 20.5f)
                curveTo(28.9f, 18.4f, 27.8f, 16.5f, 26.2f, 14.9f)
                curveTo(21.1f, 9.8f, 12.9f, 9.8f, 7.8f, 14.9f)
                curveTo(2.7f, 20f, 2.7f, 28.2f, 7.8f, 33.3f)
                curveTo(10.3f, 35.8f, 13.7f, 37.1f, 17f, 37.1f)
                curveTo(18.4f, 37.1f, 19.8f, 36.9f, 21.1f, 36.4f)
                curveTo(21.1f, 37f, 21f, 37.5f, 21f, 38.1f)
                curveTo(21f, 38.8f, 21.1f, 39.4f, 21.2f, 40.1f)
                horizontalLineTo(17f)
                verticalLineTo(39.1f)
                curveTo(17f, 38.5f, 16.6f, 38.1f, 16f, 38.1f)
                horizontalLineTo(3f)
                curveTo(2.4f, 38.1f, 2f, 38.5f, 2f, 39.1f)
                verticalLineTo(61.1f)
                curveTo(2f, 61.7f, 2.4f, 62.1f, 3f, 62.1f)
                horizontalLineTo(16f)
                curveTo(16.6f, 62.1f, 17f, 61.7f, 17f, 61.1f)
                verticalLineTo(60.1f)
                horizontalLineTo(22.2f)
                curveTo(22.8f, 60.1f, 23.2f, 59.7f, 23.2f, 59.1f)
                verticalLineTo(58.1f)
                horizontalLineTo(41f)
                curveTo(42.8f, 58.1f, 44.4f, 57.4f, 45.7f, 56.3f)
                lineTo(54.5f, 48.2f)
                curveTo(56.1f, 46.7f, 56.4f, 44.2f, 55f, 42.6f)
                curveTo(54.4f, 41.6f, 53.4f, 41.1f, 52.3f, 41f)
                close()
                moveTo(10f, 58f)
                curveTo(8.3f, 58f, 7f, 56.7f, 7f, 55f)
                curveTo(7f, 53.3f, 8.3f, 52f, 10f, 52f)
                curveTo(11.7f, 52f, 13f, 53.3f, 13f, 55f)
                curveTo(13f, 56.7f, 11.7f, 58f, 10f, 58f)
                close()
                moveTo(32f, 16f)
                horizontalLineTo(40f)
                curveTo(40.6f, 16f, 41f, 16.4f, 41f, 17f)
                curveTo(41f, 17.6f, 40.6f, 18f, 40f, 18f)
                horizontalLineTo(32f)
                curveTo(31.4f, 18f, 31f, 17.6f, 31f, 17f)
                curveTo(31f, 16.4f, 31.4f, 16f, 32f, 16f)
                close()
                moveTo(36f, 33f)
                curveTo(37.9f, 33f, 39.5f, 34.6f, 39.5f, 36.5f)
                curveTo(39.5f, 38.1f, 38.4f, 39.4f, 37f, 39.8f)
                verticalLineTo(41f)
                curveTo(37f, 41.6f, 36.6f, 42f, 36f, 42f)
                curveTo(35.4f, 42f, 35f, 41.6f, 35f, 41f)
                verticalLineTo(39.8f)
                curveTo(33.6f, 39.4f, 32.5f, 38f, 32.5f, 36.5f)
                curveTo(32.5f, 35.9f, 32.9f, 35.5f, 33.5f, 35.5f)
                curveTo(34.1f, 35.5f, 34.5f, 35.9f, 34.5f, 36.5f)
                curveTo(34.5f, 37.3f, 35.2f, 38f, 36f, 38f)
                curveTo(36.8f, 38f, 37.5f, 37.3f, 37.5f, 36.5f)
                curveTo(37.5f, 35.7f, 36.8f, 35f, 36f, 35f)
                curveTo(34.1f, 35f, 32.5f, 33.4f, 32.5f, 31.5f)
                curveTo(32.5f, 29.9f, 33.6f, 28.6f, 35f, 28.2f)
                verticalLineTo(27f)
                curveTo(35f, 26.4f, 35.4f, 26f, 36f, 26f)
                curveTo(36.6f, 26f, 37f, 26.4f, 37f, 27f)
                verticalLineTo(28.2f)
                curveTo(38.4f, 28.6f, 39.5f, 30f, 39.5f, 31.5f)
                curveTo(39.5f, 32.1f, 39.1f, 32.5f, 38.5f, 32.5f)
                curveTo(37.9f, 32.5f, 37.5f, 32.1f, 37.5f, 31.5f)
                curveTo(37.5f, 30.7f, 36.8f, 30f, 36f, 30f)
                curveTo(35.2f, 30f, 34.5f, 30.7f, 34.5f, 31.5f)
                curveTo(34.5f, 32.3f, 35.2f, 33f, 36f, 33f)
                close()
                moveTo(21.2f, 43f)
                verticalLineTo(57f)
                verticalLineTo(58f)
                horizontalLineTo(17f)
                verticalLineTo(42f)
                horizontalLineTo(21.2f)
                verticalLineTo(43f)
                close()
                moveTo(9.2f, 31.8f)
                curveTo(4.9f, 27.5f, 4.9f, 20.5f, 9.2f, 16.2f)
                curveTo(11.3f, 14.1f, 14.2f, 13f, 17f, 13f)
                curveTo(19.8f, 13f, 22.6f, 14.1f, 24.8f, 16.2f)
                curveTo(29.1f, 20.5f, 29.1f, 27.5f, 24.8f, 31.8f)
                curveTo(20.5f, 36.1f, 13.5f, 36.1f, 9.2f, 31.8f)
                close()
                moveTo(53.3f, 46.6f)
                lineTo(44.5f, 54.7f)
                curveTo(43.6f, 55.5f, 42.4f, 56f, 41.1f, 56f)
                horizontalLineTo(23.2f)
                verticalLineTo(44f)
                horizontalLineTo(27.2f)
                lineTo(37f, 45.7f)
                curveTo(38.1f, 45.9f, 38.8f, 46.9f, 38.6f, 48.1f)
                verticalLineTo(48.2f)
                curveTo(38.3f, 49.2f, 37.4f, 49.8f, 36.3f, 49.6f)
                lineTo(29.5f, 48.4f)
                curveTo(29f, 48.3f, 28.4f, 48.7f, 28.3f, 49.2f)
                curveTo(28.2f, 49.7f, 28.6f, 50.3f, 29.1f, 50.4f)
                lineTo(35.9f, 51.6f)
                curveTo(36.1f, 51.6f, 36.4f, 51.7f, 36.6f, 51.7f)
                curveTo(38.1f, 51.7f, 39.4f, 50.9f, 40.1f, 49.6f)
                lineTo(42.4f, 49.8f)
                curveTo(43.2f, 49.9f, 44.1f, 49.6f, 44.7f, 49f)
                lineTo(50.6f, 43.6f)
                curveTo(51f, 43.2f, 51.5f, 43f, 52.1f, 43.1f)
                curveTo(52.7f, 43.1f, 53.2f, 43.4f, 53.5f, 43.8f)
                curveTo(54.2f, 44.6f, 54.1f, 45.8f, 53.3f, 46.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(19.1f, 26.1f)
                curveTo(17.9f, 27.3f, 17.9f, 29.2f, 19.1f, 30.3f)
                curveTo(19.7f, 30.9f, 20.5f, 31.2f, 21.2f, 31.2f)
                curveTo(22f, 31.2f, 22.7f, 30.9f, 23.3f, 30.3f)
                curveTo(24.5f, 29.1f, 24.5f, 27.2f, 23.3f, 26.1f)
                curveTo(22.2f, 25f, 20.3f, 25f, 19.1f, 26.1f)
                close()
                moveTo(22f, 28.9f)
                curveTo(21.6f, 29.3f, 21f, 29.3f, 20.6f, 28.9f)
                curveTo(20.2f, 28.5f, 20.2f, 27.9f, 20.6f, 27.5f)
                curveTo(20.8f, 27.3f, 21.1f, 27.2f, 21.3f, 27.2f)
                curveTo(21.6f, 27.2f, 21.8f, 27.3f, 22f, 27.5f)
                curveTo(22.3f, 27.9f, 22.3f, 28.6f, 22f, 28.9f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(23.4f, 17.6f)
                curveTo(23f, 17.2f, 22.4f, 17.2f, 22f, 17.6f)
                lineTo(10.6f, 28.9f)
                curveTo(10.2f, 29.3f, 10.2f, 29.9f, 10.6f, 30.3f)
                curveTo(10.8f, 30.5f, 11.1f, 30.6f, 11.3f, 30.6f)
                curveTo(11.5f, 30.6f, 11.8f, 30.5f, 12f, 30.3f)
                lineTo(23.3f, 19f)
                curveTo(23.8f, 18.7f, 23.8f, 18f, 23.4f, 17.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(12.8f, 22.8f)
                curveTo(13.6f, 22.8f, 14.3f, 22.5f, 14.9f, 21.9f)
                curveTo(16.1f, 20.7f, 16.1f, 18.8f, 14.9f, 17.7f)
                curveTo(13.7f, 16.5f, 11.8f, 16.5f, 10.7f, 17.7f)
                curveTo(9.5f, 18.9f, 9.5f, 20.8f, 10.7f, 21.9f)
                curveTo(11.2f, 22.5f, 12f, 22.8f, 12.8f, 22.8f)
                close()
                moveTo(12f, 19.1f)
                curveTo(12.2f, 18.9f, 12.5f, 18.8f, 12.7f, 18.8f)
                curveTo(13f, 18.8f, 13.2f, 18.9f, 13.4f, 19.1f)
                curveTo(13.8f, 19.5f, 13.8f, 20.1f, 13.4f, 20.5f)
                curveTo(13f, 20.9f, 12.4f, 20.9f, 12f, 20.5f)
                curveTo(11.7f, 20.1f, 11.7f, 19.4f, 12f, 19.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(61.9f, 15.3f)
                curveTo(62f, 14.9f, 61.9f, 14.5f, 61.6f, 14.2f)
                lineTo(54.6f, 8.2f)
                curveTo(54.2f, 7.9f, 53.7f, 7.9f, 53.3f, 8.2f)
                lineTo(46.3f, 14.2f)
                curveTo(46f, 14.5f, 45.9f, 14.9f, 46f, 15.3f)
                curveTo(46.1f, 15.7f, 46.5f, 16f, 46.9f, 16f)
                horizontalLineTo(49.9f)
                verticalLineTo(25f)
                curveTo(49.9f, 25.6f, 50.3f, 26f, 50.9f, 26f)
                horizontalLineTo(56.9f)
                curveTo(57.5f, 26f, 57.9f, 25.6f, 57.9f, 25f)
                verticalLineTo(16f)
                horizontalLineTo(60.9f)
                curveTo(61.4f, 16f, 61.8f, 15.7f, 61.9f, 15.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(57f, 28f)
                curveTo(56.4f, 28f, 56f, 28.4f, 56f, 29f)
                verticalLineTo(39f)
                curveTo(56f, 39.6f, 56.4f, 40f, 57f, 40f)
                curveTo(57.6f, 40f, 58f, 39.6f, 58f, 39f)
                verticalLineTo(29f)
                curveTo(58f, 28.4f, 57.6f, 28f, 57f, 28f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(61f, 35f)
                curveTo(60.4f, 35f, 60f, 35.4f, 60f, 36f)
                verticalLineTo(48f)
                curveTo(60f, 48.6f, 60.4f, 49f, 61f, 49f)
                curveTo(61.6f, 49f, 62f, 48.6f, 62f, 48f)
                verticalLineTo(36f)
                curveTo(62f, 35.4f, 61.6f, 35f, 61f, 35f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(54f, 32f)
                verticalLineTo(29f)
                curveTo(54f, 28.4f, 53.6f, 28f, 53f, 28f)
                curveTo(52.4f, 28f, 52f, 28.4f, 52f, 29f)
                verticalLineTo(32f)
                curveTo(52f, 32.6f, 52.4f, 33f, 53f, 33f)
                curveTo(53.6f, 33f, 54f, 32.6f, 54f, 32f)
                close()
            }
        }.build()

        return _Sell!!
    }

@Suppress("ObjectPropertyName")
private var _Sell: ImageVector? = null

val Bot: ImageVector
    get() {
        if (_Bot != null) {
            return _Bot!!
        }
        _Bot = ImageVector.Builder(
            name = "Bot",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveToRelative(21f, 25f)
                curveToRelative(0f, -1.654f, -1.346f, -3f, -3f, -3f)
                reflectiveCurveToRelative(-3f, 1.346f, -3f, 3f)
                reflectiveCurveToRelative(1.346f, 3f, 3f, 3f)
                reflectiveCurveToRelative(3f, -1.346f, 3f, -3f)
                close()
                moveTo(18f, 26f)
                curveToRelative(-0.551f, 0f, -1f, -0.448f, -1f, -1f)
                reflectiveCurveToRelative(0.449f, -1f, 1f, -1f)
                reflectiveCurveToRelative(1f, 0.449f, 1f, 1f)
                reflectiveCurveToRelative(-0.449f, 1f, -1f, 1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveToRelative(30f, 22f)
                curveToRelative(-1.654f, 0f, -3f, 1.346f, -3f, 3f)
                reflectiveCurveToRelative(1.346f, 3f, 3f, 3f)
                reflectiveCurveToRelative(3f, -1.346f, 3f, -3f)
                reflectiveCurveToRelative(-1.346f, -3f, -3f, -3f)
                close()
                moveTo(30f, 26f)
                curveToRelative(-0.551f, 0f, -1f, -0.448f, -1f, -1f)
                reflectiveCurveToRelative(0.449f, -1f, 1f, -1f)
                reflectiveCurveToRelative(1f, 0.449f, 1f, 1f)
                reflectiveCurveToRelative(-0.449f, 1f, -1f, 1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveToRelative(28.543f, 33.91f)
                curveToRelative(-2.815f, 1.447f, -6.271f, 1.447f, -9.086f, 0f)
                curveToRelative(-0.492f, -0.253f, -1.094f, -0.059f, -1.347f, 0.433f)
                reflectiveCurveToRelative(-0.059f, 1.094f, 0.433f, 1.347f)
                curveToRelative(1.669f, 0.857f, 3.556f, 1.311f, 5.457f, 1.311f)
                reflectiveCurveToRelative(3.788f, -0.453f, 5.457f, -1.311f)
                curveToRelative(0.491f, -0.253f, 0.685f, -0.855f, 0.433f, -1.347f)
                reflectiveCurveToRelative(-0.855f, -0.686f, -1.347f, -0.433f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveToRelative(45f, 22f)
                horizontalLineToRelative(-3f)
                verticalLineToRelative(-3f)
                curveToRelative(0f, -2.757f, -2.243f, -5f, -5f, -5f)
                horizontalLineToRelative(-12f)
                verticalLineToRelative(-4.142f)
                curveToRelative(1.72f, -0.447f, 3f, -2f, 3f, -3.858f)
                curveToRelative(0f, -2.206f, -1.794f, -4f, -4f, -4f)
                reflectiveCurveToRelative(-4f, 1.794f, -4f, 4f)
                curveToRelative(0f, 1.858f, 1.28f, 3.411f, 3f, 3.858f)
                verticalLineToRelative(4.142f)
                horizontalLineToRelative(-12f)
                curveToRelative(-2.757f, 0f, -5f, 2.243f, -5f, 5f)
                verticalLineToRelative(3f)
                horizontalLineToRelative(-3f)
                curveToRelative(-1.654f, 0f, -3f, 1.346f, -3f, 3f)
                verticalLineToRelative(9f)
                curveToRelative(0f, 1.654f, 1.346f, 3f, 3f, 3f)
                horizontalLineToRelative(3f)
                verticalLineToRelative(3f)
                curveToRelative(0f, 2.757f, 2.243f, 5f, 5f, 5f)
                horizontalLineToRelative(26f)
                curveToRelative(2.757f, 0f, 5f, -2.243f, 5f, -5f)
                verticalLineToRelative(-3f)
                horizontalLineToRelative(3f)
                curveToRelative(1.654f, 0f, 3f, -1.346f, 3f, -3f)
                verticalLineToRelative(-9f)
                curveToRelative(0f, -1.654f, -1.346f, -3f, -3f, -3f)
                close()
                moveTo(22f, 6f)
                curveToRelative(0f, -1.103f, 0.897f, -2f, 2f, -2f)
                reflectiveCurveToRelative(2f, 0.897f, 2f, 2f)
                reflectiveCurveToRelative(-0.897f, 2f, -2f, 2f)
                reflectiveCurveToRelative(-2f, -0.897f, -2f, -2f)
                close()
                moveTo(3f, 35f)
                curveToRelative(-0.551f, 0f, -1f, -0.448f, -1f, -1f)
                verticalLineToRelative(-9f)
                curveToRelative(0f, -0.551f, 0.449f, -1f, 1f, -1f)
                horizontalLineToRelative(3f)
                verticalLineToRelative(11f)
                horizontalLineToRelative(-3f)
                close()
                moveTo(40f, 40f)
                curveToRelative(0f, 1.654f, -1.346f, 3f, -3f, 3f)
                lineTo(11f, 43f)
                curveToRelative(-1.654f, 0f, -3f, -1.346f, -3f, -3f)
                verticalLineToRelative(-21f)
                curveToRelative(0f, -1.654f, 1.346f, -3f, 3f, -3f)
                horizontalLineToRelative(26f)
                curveToRelative(1.654f, 0f, 3f, 1.346f, 3f, 3f)
                verticalLineToRelative(21f)
                close()
                moveTo(46f, 34f)
                curveToRelative(0f, 0.552f, -0.449f, 1f, -1f, 1f)
                horizontalLineToRelative(-3f)
                verticalLineToRelative(-11f)
                horizontalLineToRelative(3f)
                curveToRelative(0.551f, 0f, 1f, 0.449f, 1f, 1f)
                verticalLineToRelative(9f)
                close()
            }
        }.build()

        return _Bot!!
    }

@Suppress("ObjectPropertyName")
private var _Bot: ImageVector? = null

val Category: ImageVector
    get() {
        if (_Category != null) {
            return _Category!!
        }
        _Category = ImageVector.Builder(
            name = "Category",
            defaultWidth = 64.dp,
            defaultHeight = 64.dp,
            viewportWidth = 64f,
            viewportHeight = 64f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(27.71f, 2.5f)
                horizontalLineTo(8f)
                curveTo(6.542f, 2.503f, 5.145f, 3.083f, 4.114f, 4.114f)
                curveTo(3.083f, 5.145f, 2.503f, 6.542f, 2.5f, 8f)
                verticalLineTo(27.71f)
                curveTo(2.5f, 28.108f, 2.658f, 28.489f, 2.939f, 28.771f)
                curveTo(3.221f, 29.052f, 3.602f, 29.21f, 4f, 29.21f)
                horizontalLineTo(23.71f)
                curveTo(25.169f, 29.21f, 26.568f, 28.631f, 27.599f, 27.599f)
                curveTo(28.631f, 26.568f, 29.21f, 25.169f, 29.21f, 23.71f)
                verticalLineTo(4f)
                curveTo(29.21f, 3.602f, 29.052f, 3.221f, 28.771f, 2.939f)
                curveTo(28.489f, 2.658f, 28.108f, 2.5f, 27.71f, 2.5f)
                close()
                moveTo(26.21f, 23.71f)
                curveTo(26.21f, 24.038f, 26.145f, 24.363f, 26.02f, 24.667f)
                curveTo(25.894f, 24.97f, 25.71f, 25.246f, 25.478f, 25.478f)
                curveTo(25.246f, 25.71f, 24.97f, 25.894f, 24.667f, 26.02f)
                curveTo(24.363f, 26.145f, 24.038f, 26.21f, 23.71f, 26.21f)
                horizontalLineTo(5.5f)
                verticalLineTo(8f)
                curveTo(5.5f, 7.337f, 5.763f, 6.701f, 6.232f, 6.232f)
                curveTo(6.701f, 5.763f, 7.337f, 5.5f, 8f, 5.5f)
                horizontalLineTo(26.21f)
                verticalLineTo(23.71f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(23.71f, 34.79f)
                horizontalLineTo(4f)
                curveTo(3.602f, 34.79f, 3.221f, 34.948f, 2.939f, 35.229f)
                curveTo(2.658f, 35.511f, 2.5f, 35.892f, 2.5f, 36.29f)
                verticalLineTo(56f)
                curveTo(2.503f, 57.458f, 3.083f, 58.855f, 4.114f, 59.886f)
                curveTo(5.145f, 60.917f, 6.542f, 61.497f, 8f, 61.5f)
                horizontalLineTo(27.71f)
                curveTo(28.108f, 61.5f, 28.489f, 61.342f, 28.771f, 61.061f)
                curveTo(29.052f, 60.779f, 29.21f, 60.398f, 29.21f, 60f)
                verticalLineTo(40.29f)
                curveTo(29.21f, 38.831f, 28.631f, 37.432f, 27.599f, 36.401f)
                curveTo(26.568f, 35.369f, 25.169f, 34.79f, 23.71f, 34.79f)
                verticalLineTo(34.79f)
                close()
                moveTo(26.21f, 58.5f)
                horizontalLineTo(8f)
                curveTo(7.337f, 58.5f, 6.701f, 58.237f, 6.232f, 57.768f)
                curveTo(5.763f, 57.299f, 5.5f, 56.663f, 5.5f, 56f)
                verticalLineTo(37.79f)
                horizontalLineTo(23.71f)
                curveTo(24.038f, 37.79f, 24.363f, 37.855f, 24.667f, 37.98f)
                curveTo(24.97f, 38.106f, 25.246f, 38.29f, 25.478f, 38.522f)
                curveTo(25.71f, 38.754f, 25.894f, 39.03f, 26.02f, 39.333f)
                curveTo(26.145f, 39.637f, 26.21f, 39.962f, 26.21f, 40.29f)
                verticalLineTo(58.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(60f, 34.79f)
                horizontalLineTo(40.29f)
                curveTo(38.831f, 34.79f, 37.432f, 35.369f, 36.401f, 36.401f)
                curveTo(35.369f, 37.432f, 34.79f, 38.831f, 34.79f, 40.29f)
                verticalLineTo(60f)
                curveTo(34.79f, 60.398f, 34.948f, 60.779f, 35.229f, 61.061f)
                curveTo(35.511f, 61.342f, 35.892f, 61.5f, 36.29f, 61.5f)
                horizontalLineTo(56f)
                curveTo(57.458f, 61.497f, 58.855f, 60.917f, 59.886f, 59.886f)
                curveTo(60.917f, 58.855f, 61.497f, 57.458f, 61.5f, 56f)
                verticalLineTo(36.29f)
                curveTo(61.5f, 35.892f, 61.342f, 35.511f, 61.061f, 35.229f)
                curveTo(60.779f, 34.948f, 60.398f, 34.79f, 60f, 34.79f)
                close()
                moveTo(58.5f, 56f)
                curveTo(58.5f, 56.663f, 58.237f, 57.299f, 57.768f, 57.768f)
                curveTo(57.299f, 58.237f, 56.663f, 58.5f, 56f, 58.5f)
                horizontalLineTo(37.79f)
                verticalLineTo(40.29f)
                curveTo(37.79f, 39.627f, 38.053f, 38.991f, 38.522f, 38.522f)
                curveTo(38.991f, 38.053f, 39.627f, 37.79f, 40.29f, 37.79f)
                horizontalLineTo(58.5f)
                verticalLineTo(56f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(40.29f, 21.36f)
                horizontalLineTo(42.64f)
                verticalLineTo(23.71f)
                curveTo(42.64f, 25.169f, 43.22f, 26.568f, 44.251f, 27.599f)
                curveTo(45.282f, 28.631f, 46.681f, 29.21f, 48.14f, 29.21f)
                curveTo(49.599f, 29.21f, 50.998f, 28.631f, 52.029f, 27.599f)
                curveTo(53.061f, 26.568f, 53.64f, 25.169f, 53.64f, 23.71f)
                verticalLineTo(21.36f)
                horizontalLineTo(56f)
                curveTo(57.459f, 21.36f, 58.858f, 20.781f, 59.889f, 19.749f)
                curveTo(60.921f, 18.718f, 61.5f, 17.319f, 61.5f, 15.86f)
                curveTo(61.5f, 14.401f, 60.921f, 13.002f, 59.889f, 11.971f)
                curveTo(58.858f, 10.939f, 57.459f, 10.36f, 56f, 10.36f)
                horizontalLineTo(53.64f)
                verticalLineTo(8f)
                curveTo(53.64f, 6.541f, 53.061f, 5.142f, 52.029f, 4.111f)
                curveTo(50.998f, 3.079f, 49.599f, 2.5f, 48.14f, 2.5f)
                curveTo(46.681f, 2.5f, 45.282f, 3.079f, 44.251f, 4.111f)
                curveTo(43.22f, 5.142f, 42.64f, 6.541f, 42.64f, 8f)
                verticalLineTo(10.36f)
                horizontalLineTo(40.29f)
                curveTo(38.831f, 10.36f, 37.432f, 10.939f, 36.401f, 11.971f)
                curveTo(35.369f, 13.002f, 34.79f, 14.401f, 34.79f, 15.86f)
                curveTo(34.79f, 17.319f, 35.369f, 18.718f, 36.401f, 19.749f)
                curveTo(37.432f, 20.781f, 38.831f, 21.36f, 40.29f, 21.36f)
                verticalLineTo(21.36f)
                close()
                moveTo(40.29f, 13.36f)
                horizontalLineTo(44.14f)
                curveTo(44.538f, 13.36f, 44.919f, 13.202f, 45.201f, 12.921f)
                curveTo(45.482f, 12.639f, 45.64f, 12.258f, 45.64f, 11.86f)
                verticalLineTo(8f)
                curveTo(45.64f, 7.337f, 45.903f, 6.701f, 46.372f, 6.232f)
                curveTo(46.841f, 5.763f, 47.477f, 5.5f, 48.14f, 5.5f)
                curveTo(48.803f, 5.5f, 49.439f, 5.763f, 49.908f, 6.232f)
                curveTo(50.377f, 6.701f, 50.64f, 7.337f, 50.64f, 8f)
                verticalLineTo(11.86f)
                curveTo(50.64f, 12.258f, 50.798f, 12.639f, 51.079f, 12.921f)
                curveTo(51.361f, 13.202f, 51.742f, 13.36f, 52.14f, 13.36f)
                horizontalLineTo(56f)
                curveTo(56.663f, 13.36f, 57.299f, 13.623f, 57.768f, 14.092f)
                curveTo(58.237f, 14.561f, 58.5f, 15.197f, 58.5f, 15.86f)
                curveTo(58.5f, 16.523f, 58.237f, 17.159f, 57.768f, 17.628f)
                curveTo(57.299f, 18.097f, 56.663f, 18.36f, 56f, 18.36f)
                horizontalLineTo(52.14f)
                curveTo(51.742f, 18.36f, 51.361f, 18.518f, 51.079f, 18.799f)
                curveTo(50.798f, 19.081f, 50.64f, 19.462f, 50.64f, 19.86f)
                verticalLineTo(23.71f)
                curveTo(50.64f, 24.373f, 50.377f, 25.009f, 49.908f, 25.478f)
                curveTo(49.439f, 25.947f, 48.803f, 26.21f, 48.14f, 26.21f)
                curveTo(47.477f, 26.21f, 46.841f, 25.947f, 46.372f, 25.478f)
                curveTo(45.903f, 25.009f, 45.64f, 24.373f, 45.64f, 23.71f)
                verticalLineTo(19.86f)
                curveTo(45.64f, 19.462f, 45.482f, 19.081f, 45.201f, 18.799f)
                curveTo(44.919f, 18.518f, 44.538f, 18.36f, 44.14f, 18.36f)
                horizontalLineTo(40.29f)
                curveTo(39.627f, 18.36f, 38.991f, 18.097f, 38.522f, 17.628f)
                curveTo(38.053f, 17.159f, 37.79f, 16.523f, 37.79f, 15.86f)
                curveTo(37.79f, 15.197f, 38.053f, 14.561f, 38.522f, 14.092f)
                curveTo(38.991f, 13.623f, 39.627f, 13.36f, 40.29f, 13.36f)
                verticalLineTo(13.36f)
                close()
            }
        }.build()

        return _Category!!
    }

@Suppress("ObjectPropertyName")
private var _Category: ImageVector? = null