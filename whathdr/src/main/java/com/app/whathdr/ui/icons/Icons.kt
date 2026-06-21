package com.app.whathdr.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

/** Info Icon*/
@Suppress("CheckReturnValue")
val infoIcon: ImageVector
get() {
    if (info != null) return info!!
    info =
        ImageVector.Builder(name = "info", defaultWidth = 24.dp, defaultHeight = 24.dp, viewportWidth = 24f, viewportHeight = 24f)
            .apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Bevel,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero,
                ) {
                    moveTo(11f, 17f)
                    horizontalLineToRelative(2f)
                    verticalLineTo(11f)
                    horizontalLineTo(11f)
                    verticalLineToRelative(6f)
                    close()
                    moveTo(12.71f, 8.71f)
                    quadTo(13f, 8.42f, 13f, 8f)
                    quadTo(13f, 7.57f, 12.71f, 7.29f)
                    reflectiveQuadTo(12f, 7f)
                    reflectiveQuadTo(11.29f, 7.29f)
                    reflectiveQuadTo(11f, 8f)
                    quadToRelative(0f, 0.42f, 0.29f, 0.71f)
                    reflectiveQuadTo(12f, 9f)
                    reflectiveQuadTo(12.71f, 8.71f)
                    close()
                    moveTo(12f, 22f)
                    quadTo(9.93f, 22f, 8.1f, 21.21f)
                    quadTo(6.28f, 20.43f, 4.93f, 19.08f)
                    quadTo(3.58f, 17.73f, 2.79f, 15.9f)
                    reflectiveQuadTo(2f, 12f)
                    quadTo(2f, 9.92f, 2.79f, 8.1f)
                    quadTo(3.58f, 6.27f, 4.93f, 4.93f)
                    quadTo(6.28f, 3.57f, 8.1f, 2.79f)
                    quadTo(9.93f, 2f, 12f, 2f)
                    reflectiveQuadToRelative(3.9f, 0.79f)
                    reflectiveQuadToRelative(3.17f, 2.14f)
                    quadToRelative(1.35f, 1.35f, 2.14f, 3.17f)
                    quadTo(22f, 9.92f, 22f, 12f)
                    reflectiveQuadToRelative(-0.79f, 3.9f)
                    reflectiveQuadToRelative(-2.14f, 3.17f)
                    quadToRelative(-1.35f, 1.35f, -3.17f, 2.14f)
                    reflectiveQuadTo(12f, 22f)
                    close()
                    moveToRelative(0f, -2f)
                    quadToRelative(3.35f, 0f, 5.68f, -2.32f)
                    reflectiveQuadTo(20f, 12f)
                    reflectiveQuadTo(17.68f, 6.32f)
                    reflectiveQuadTo(12f, 4f)
                    reflectiveQuadTo(6.33f, 6.32f)
                    reflectiveQuadTo(4f, 12f)
                    reflectiveQuadToRelative(2.33f, 5.68f)
                    reflectiveQuadTo(12f, 20f)
                    close()
                    moveToRelative(0f, -8f)
                    close()
                }
            }
            .build()
    return info!!
}

private var info: ImageVector? = null

/** Check Icon */
@Suppress("CheckReturnValue")
val check: ImageVector
    get() {
        if (_check != null)
            return _check!!
        _check =
            ImageVector.Builder(
                name = "check",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(9.55f, 18f)
                        lineTo(3.85f, 12.3f)
                        lineTo(5.28f, 10.88f)
                        lineToRelative(4.28f, 4.28f)
                        lineTo(18.73f, 5.97f)
                        lineTo(20.15f, 7.4f)
                        lineTo(9.55f, 18f)
                        close()
                    }
                }
                .build()
        return _check!!
    }

private var _check: ImageVector? = null

/** Warning icon*/
@Suppress("CheckReturnValue")
val warning: ImageVector
    get() {
        if (_warning != null) {
            return _warning!!
        }
        _warning =
            ImageVector.Builder(
                name = "warning",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(1f, 21f)
                        lineTo(12f, 2f)
                        lineTo(23f, 21f)
                        horizontalLineTo(1f)
                        close()
                        moveTo(4.45f, 19f)
                        horizontalLineToRelative(15.1f)
                        lineTo(12f, 6f)
                        lineTo(4.45f, 19f)
                        close()
                        moveToRelative(8.26f, -1.29f)
                        quadTo(13f, 17.43f, 13f, 17f)
                        reflectiveQuadTo(12.71f, 16.29f)
                        reflectiveQuadTo(12f, 16f)
                        reflectiveQuadToRelative(-0.71f, 0.29f)
                        reflectiveQuadTo(11f, 17f)
                        reflectiveQuadToRelative(0.29f, 0.71f)
                        reflectiveQuadTo(12f, 18f)
                        reflectiveQuadToRelative(0.71f, -0.29f)
                        close()
                        moveTo(11f, 15f)
                        horizontalLineToRelative(2f)
                        verticalLineTo(10f)
                        horizontalLineTo(11f)
                        verticalLineToRelative(5f)
                        close()
                        moveToRelative(1f, -2.5f)
                        close()
                    }
                }
                .build()
        return _warning!!
    }

private var _warning: ImageVector? = null

/** Arrow Forward icon*/
@Suppress("CheckReturnValue")
val arrowForward: ImageVector
    get() {
        if (_arrow_forward != null) {
            return _arrow_forward!!
        }
        _arrow_forward =
            ImageVector.Builder(
                name = "arrow_forward",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(16.18f, 13f)
                        horizontalLineTo(4f)
                        verticalLineTo(11f)
                        horizontalLineTo(16.18f)
                        lineTo(10.58f, 5.4f)
                        lineTo(12f, 4f)
                        lineToRelative(8f, 8f)
                        lineToRelative(-8f, 8f)
                        lineTo(10.58f, 18.6f)
                        lineTo(16.18f, 13f)
                        close()
                    }
                }
                .build()
        return _arrow_forward!!
    }

private var _arrow_forward: ImageVector? = null

/** Code Icon*/
@Suppress("CheckReturnValue")
val code: ImageVector
    get() {
        if (_code != null) {
            return _code!!
        }
        _code =
            ImageVector.Builder(
                name = "code",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(8f, 18f)
                        lineTo(2f, 12f)
                        lineTo(8f, 6f)
                        lineTo(9.43f, 7.43f)
                        lineToRelative(-4.6f, 4.6f)
                        lineTo(9.4f, 16.6f)
                        lineTo(8f, 18f)
                        close()
                        moveToRelative(8f, 0f)
                        lineTo(14.58f, 16.58f)
                        lineToRelative(4.6f, -4.6f)
                        lineTo(14.6f, 7.4f)
                        lineTo(16f, 6f)
                        lineToRelative(6f, 6f)
                        lineToRelative(-6f, 6f)
                        close()
                    }
                }
                .build()
        return _code!!
    }

private var _code: ImageVector? = null

/** Person icon*/
@Suppress("CheckReturnValue")
val person: ImageVector
    get() {
        if (_person != null) {
            return _person!!
        }
        _person =
            ImageVector.Builder(
                name = "person",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(9.18f, 10.83f)
                        quadTo(8f, 9.65f, 8f, 8f)
                        reflectiveQuadTo(9.18f, 5.18f)
                        reflectiveQuadTo(12f, 4f)
                        reflectiveQuadToRelative(2.83f, 1.18f)
                        reflectiveQuadTo(16f, 8f)
                        reflectiveQuadToRelative(-1.17f, 2.82f)
                        reflectiveQuadTo(12f, 12f)
                        reflectiveQuadTo(9.18f, 10.83f)
                        close()
                        moveTo(4f, 20f)
                        verticalLineTo(17.2f)
                        quadTo(4f, 16.35f, 4.44f, 15.64f)
                        quadTo(4.88f, 14.93f, 5.6f, 14.55f)
                        quadTo(7.15f, 13.77f, 8.75f, 13.39f)
                        reflectiveQuadTo(12f, 13f)
                        reflectiveQuadToRelative(3.25f, 0.39f)
                        reflectiveQuadToRelative(3.15f, 1.16f)
                        quadToRelative(0.72f, 0.38f, 1.16f, 1.09f)
                        reflectiveQuadTo(20f, 17.2f)
                        verticalLineTo(20f)
                        horizontalLineTo(4f)
                        close()
                        moveTo(6f, 18f)
                        horizontalLineTo(18f)
                        verticalLineTo(17.2f)
                        quadToRelative(0f, -0.27f, -0.14f, -0.5f)
                        quadTo(17.73f, 16.48f, 17.5f, 16.35f)
                        quadTo(16.15f, 15.68f, 14.78f, 15.34f)
                        reflectiveQuadTo(12f, 15f)
                        reflectiveQuadTo(9.23f, 15.34f)
                        reflectiveQuadTo(6.5f, 16.35f)
                        quadTo(6.28f, 16.48f, 6.14f, 16.7f)
                        quadTo(6f, 16.93f, 6f, 17.2f)
                        verticalLineTo(18f)
                        close()
                        moveTo(13.41f, 9.41f)
                        quadTo(14f, 8.82f, 14f, 8f)
                        reflectiveQuadTo(13.41f, 6.59f)
                        reflectiveQuadTo(12f, 6f)
                        reflectiveQuadTo(10.59f, 6.59f)
                        quadTo(10f, 7.18f, 10f, 8f)
                        reflectiveQuadToRelative(0.59f, 1.41f)
                        reflectiveQuadTo(12f, 10f)
                        reflectiveQuadTo(13.41f, 9.41f)
                        close()
                        moveTo(12f, 8f)
                        close()
                        moveToRelative(0f, 10f)
                        close()
                    }
                }
                .build()
        return _person!!
    }

private var _person: ImageVector? = null

/**License icon*/
@Suppress("CheckReturnValue")
val license: ImageVector
    get() {
        if (_license != null) {
            return _license!!
        }
        _license =
            ImageVector.Builder(
                name = "license",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(9.88f, 12.13f)
                        quadTo(9f, 11.25f, 9f, 10f)
                        reflectiveQuadTo(9.88f, 7.88f)
                        reflectiveQuadTo(12f, 7f)
                        reflectiveQuadToRelative(2.13f, 0.88f)
                        reflectiveQuadTo(15f, 10f)
                        reflectiveQuadToRelative(-0.88f, 2.13f)
                        reflectiveQuadTo(12f, 13f)
                        reflectiveQuadTo(9.88f, 12.13f)
                        close()
                        moveTo(6f, 23f)
                        verticalLineTo(15.28f)
                        quadTo(5.05f, 14.23f, 4.53f, 12.88f)
                        quadTo(4f, 11.52f, 4f, 10f)
                        quadTo(4f, 6.65f, 6.33f, 4.32f)
                        reflectiveQuadTo(12f, 2f)
                        reflectiveQuadToRelative(5.68f, 2.32f)
                        reflectiveQuadTo(20f, 10f)
                        quadToRelative(0f, 1.52f, -0.52f, 2.88f)
                        reflectiveQuadTo(18f, 15.28f)
                        verticalLineTo(23f)
                        lineTo(12f, 21f)
                        lineTo(6f, 23f)
                        close()
                        moveTo(16.25f, 14.25f)
                        quadTo(18f, 12.5f, 18f, 10f)
                        reflectiveQuadTo(16.25f, 5.75f)
                        reflectiveQuadTo(12f, 4f)
                        reflectiveQuadTo(7.75f, 5.75f)
                        reflectiveQuadTo(6f, 10f)
                        reflectiveQuadToRelative(1.75f, 4.25f)
                        reflectiveQuadTo(12f, 16f)
                        reflectiveQuadToRelative(4.25f, -1.75f)
                        close()
                        moveTo(8f, 20.02f)
                        lineTo(12f, 19f)
                        lineToRelative(4f, 1.02f)
                        verticalLineToRelative(-3.1f)
                        quadToRelative(-0.88f, 0.5f, -1.89f, 0.79f)
                        reflectiveQuadTo(12f, 18f)
                        reflectiveQuadTo(9.89f, 17.71f)
                        quadTo(8.88f, 17.43f, 8f, 16.93f)
                        verticalLineToRelative(3.1f)
                        close()
                        moveToRelative(4f, -1.55f)
                        close()
                    }
                }
                .build()
        return _license!!
    }

private var _license: ImageVector? = null

/**Arrow back icon*/
@Suppress("CheckReturnValue")
val arrowBack: ImageVector
    get() {
        if (_arrow_back != null) {
            return _arrow_back!!
        }
        _arrow_back =
            ImageVector.Builder(
                name = "arrow_back",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(7.83f, 13f)
                        lineToRelative(5.6f, 5.6f)
                        lineTo(12f, 20f)
                        lineTo(4f, 12f)
                        lineTo(12f, 4f)
                        lineToRelative(1.43f, 1.4f)
                        lineTo(7.83f, 11f)
                        horizontalLineTo(20f)
                        verticalLineToRelative(2f)
                        horizontalLineTo(7.83f)
                        close()
                    }
                }
                .build()
        return _arrow_back!!
    }

private var _arrow_back: ImageVector? = null