package com.app.whathdr.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import com.app.whathdr.R
import com.app.whathdr.ui.theme.AppFonts.QuirkyGoogleSansFlex
import com.app.whathdr.ui.theme.AppFonts.googleFlex400
import com.app.whathdr.ui.theme.AppFonts.googleFlex600

// Set of Material typography styles to start with
val TYPOGRAPHY = Typography()
val MyTypography = Typography(
    displayLarge = TYPOGRAPHY.displayLarge.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    displayMedium = TYPOGRAPHY.displayMedium.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    displaySmall = TYPOGRAPHY.displaySmall.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    headlineLarge = TYPOGRAPHY.headlineLarge.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    headlineMedium = TYPOGRAPHY.headlineMedium.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    headlineSmall = TYPOGRAPHY.headlineSmall.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    titleLarge = TYPOGRAPHY.titleLarge.copy(
        fontFamily = googleFlex400,
        fontFeatureSettings = "ss02, dlig"
    ),
    titleMedium = TYPOGRAPHY.titleMedium.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    titleSmall = TYPOGRAPHY.titleSmall.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    bodyLarge = TYPOGRAPHY.bodyLarge.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    bodyMedium = TYPOGRAPHY.bodyMedium.copy(
        fontFamily = googleFlex400,
        fontFeatureSettings = "ss02, dlig"
    ),
    bodySmall = TYPOGRAPHY.bodySmall.copy(
        fontFamily = googleFlex400,
        fontFeatureSettings = "ss02, dlig"
    ),
    labelLarge = TYPOGRAPHY.labelLarge.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    labelMedium = TYPOGRAPHY.labelMedium.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    labelSmall = TYPOGRAPHY.labelSmall.copy(
        fontFamily = googleFlex600,
        fontFeatureSettings = "ss02, dlig"
    ),
    displayLargeEmphasized = TYPOGRAPHY.displayLarge.copy(
        fontFamily = QuirkyGoogleSansFlex,
        fontFeatureSettings = "ss02,dlig"
    )
)

@OptIn(ExperimentalTextApi::class)
object AppFonts {
    val googleFlex400 = FontFamily(Font(R.font.google_sans_flex_400))

    val googleFlex600 = FontFamily(Font(R.font.google_sans_flex_600))

    val robotoFlexTopBar = FontFamily(Font(R.font.roboto_flex_logo))

    val QuirkyGoogleSansFlex = FontFamily(
        Font(
            resId = R.font.google_sans_flex,
            variationSettings = FontVariation.Settings(
                // Βασικοί άξονες που υποστηρίζονται εγγενώς από το Compose
                FontVariation.weight(900),     // Ακραίο πάχος (Super Black)
                FontVariation.width(50f),      // Πολύ συμπιεσμένο πλάτος (Condensed)
                FontVariation.slant(-12f),     // Αρνητική κλίση (Backslant) για περίεργο εφέ

                // Προσαρμοσμένοι άξονες (Custom Axes) μέσω του 4 γραμμάτων tag τους
                FontVariation.Setting("opsz", 10f), // Optical Size (Μικρό νούμερο συνήθως αλλάζει τις λεπτομέρειες των γραμμάτων)
                FontVariation.Setting("GRAD", 150f) // Grade (Αλλάζει το οπτικό βάρος χωρίς να αλλάζει το πλάτος)
            ),
            weight = FontWeight.Normal
        )
    )
}