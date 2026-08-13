package com.app.whathdr.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import com.app.whathdr.R
import com.app.whathdr.ui.theme.AppFonts.googleFlex400
import com.app.whathdr.ui.theme.AppFonts.googleFlex600

object AppFonts {
    val googleFlex400 = FontFamily(Font(R.font.google_sans_flex, variationSettings = FontVariation.Settings(FontVariation.weight(400))))

    val googleFlex600 = FontFamily(Font(R.font.google_sans_flex, variationSettings = FontVariation.Settings(FontVariation.weight(600))))

    val robotoFlexTopBar = FontFamily(Font(R.font.roboto_flex_logo))

    val QuirkyGoogleSansFlex = FontFamily(
        Font(
            resId = R.font.google_sans_flex,
            weight = FontWeight.Normal,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(900),      // Super Black
                FontVariation.width(30f),       // Condensed
                FontVariation.slant(-12f),      // Backslant
                FontVariation.Setting("opsz", 10f),
                FontVariation.Setting("GRAD", 150f)
            )
        )
    )
}

private fun TextStyle.withGoogleFlex(family: FontFamily = googleFlex600) = copy(fontFamily = family, fontFeatureSettings = "ss02, dlig")

private val defaultTypography = Typography()
val MyTypography = Typography(
    displayLarge = defaultTypography.displayLarge.withGoogleFlex(),
    displayMedium = defaultTypography.displayMedium.withGoogleFlex(),
    displaySmall = defaultTypography.displaySmall.withGoogleFlex(),
    headlineLarge = defaultTypography.headlineLarge.withGoogleFlex(),
    headlineMedium = defaultTypography.headlineMedium.withGoogleFlex(),
    headlineSmall = defaultTypography.headlineSmall.withGoogleFlex(),
    titleLarge = defaultTypography.titleLarge.withGoogleFlex(googleFlex400), // 400 weight
    titleMedium = defaultTypography.titleMedium.withGoogleFlex(),
    titleSmall = defaultTypography.titleSmall.withGoogleFlex(),
    bodyLarge = defaultTypography.bodyLarge.withGoogleFlex(),
    bodyMedium = defaultTypography.bodyMedium.withGoogleFlex(googleFlex400), // 400 weight
    bodySmall = defaultTypography.bodySmall.withGoogleFlex(googleFlex400),   // 400 weight
    labelLarge = defaultTypography.labelLarge.withGoogleFlex(),
    labelMedium = defaultTypography.labelMedium.withGoogleFlex(),
    labelSmall = defaultTypography.labelSmall.withGoogleFlex(),
    displayLargeEmphasized = defaultTypography.bodyLargeEmphasized.withGoogleFlex()
)