package com.app.whathdr

import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.graphics.shapes.RoundedPolygon
import com.app.whathdr.ui.theme.AppFonts.robotoFlexTopBar
import com.app.whathdr.ui.theme.MyTypography
import com.app.whathdr.ui.theme.WhatHDRTheme

@Composable
fun AboutScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current

    // Ασφαλής ανάκτηση στοιχείων έκδοσης
    val (versionName, versionCode) = remember {
        try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, PackageManager.PackageInfoFlags.of(0))
            (packageInfo.versionName ?: "1.0.0") to (packageInfo.longVersionCode.toString())
        } catch (_: Exception) {
            "1.0.0" to "1"
        }
    }

    AboutContent(
        versionName = versionName,
        versionCode = versionCode,
        onBack = onBack
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun AboutContent(
    versionName: String,
    versionCode: String,
    onBack: () -> Unit
) {
    WhatHDRTheme {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    colors = topAppBarColors(
                        containerColor = colorScheme.surface,
                        titleContentColor = colorScheme.onSurface,
                    ),
                    title = {
                        Text(
                            "About",
                            style = TextStyle(fontFamily = robotoFlexTopBar, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                // App Logo Section
                Box(modifier = Modifier
                        .size(200.dp)
                        .background(colorScheme.primaryContainer, RoundedPolygon(MaterialShapes.Cookie6Sided).toShape(0)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(colorScheme.primary, BlendMode.SrcIn),
                        modifier = Modifier.size(150.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "WhatHDR",
                    style = MyTypography.displayLargeEmphasized,
                    color = colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(8.dp))

                VersionPill(versionName, versionCode)

                Spacer(modifier = Modifier.height(32.dp))

                // Info Cards
                InfoCard(
                    icon = Icons.Default.Person,
                    label = "Developer",
                    value = "Lefteris T."
                )

                Spacer(modifier = Modifier.height(12.dp))

                InfoCard(
                    icon = Icons.Default.Code,
                    label = "License",
                    value = "GPL-3 License"
                )

                Spacer(modifier = Modifier.height(12.dp))

                InfoCard(
                    icon = Icons.Default.Info,
                    label = "Description",
                    value = "An app that informs you whenever HDR content is being played on your device."
                )
            }
        }
    }
}

@Composable
private fun InfoCard(icon: ImageVector, label: String, value: String) {
    Surface(
        color = colorScheme.surfaceContainerLow,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = label,
                    style = MyTypography.labelMedium,
                    color = colorScheme.onSurfaceVariant
                )
                Text(
                    text = value,
                    style = MyTypography.bodyLarge,
                    color = colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
private fun VersionPill(versionName: String, versionCode: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(CircleShape)
            .background(colorScheme.secondaryContainer)
            .padding(horizontal = 4.dp, vertical = 4.dp)
    ) {
        Text(
            text = "v$versionName",
            modifier = Modifier.padding(horizontal = 12.dp),
            style = MyTypography.labelLarge,
            color = colorScheme.onSecondaryContainer
        )
        Surface(
            color = colorScheme.secondary,
            shape = CircleShape
        ) {
            Text(
                text = versionCode,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                style = MyTypography.labelSmall,
                color = colorScheme.onSecondary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutScreen() {
    AboutContent(
        versionName = "0.0.0",
        versionCode = "0",
        onBack = {}
    )
}

data class SocialLink(
    val icon: ImageVector,
    val url: String
)
