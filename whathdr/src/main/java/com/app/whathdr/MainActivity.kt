package com.app.whathdr

import android.Manifest
import android.content.Context
import android.content.Context.DISPLAY_SERVICE
import android.content.Intent
import android.hardware.display.DisplayManager
import android.os.Bundle
import android.view.Display
import android.view.Display.HdrCapabilities.HDR_TYPE_DOLBY_VISION
import android.view.Display.HdrCapabilities.HDR_TYPE_HDR10
import android.view.Display.HdrCapabilities.HDR_TYPE_HDR10_PLUS
import android.view.Display.HdrCapabilities.HDR_TYPE_HLG
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.WarningAmber
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.graphics.shapes.RoundedPolygon
import com.app.whathdr.ui.elements.ExpandableHdrItem
import com.app.whathdr.ui.theme.AppFonts.googleFlex600
import com.app.whathdr.ui.theme.AppFonts.robotoFlexTopBar
import com.app.whathdr.ui.theme.Typography
import com.app.whathdr.ui.theme.WhatHDRTheme

data class HdrInfo(
    val name: String,
    val description: Int
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 0)
        val isHdr = isDisplayHDR(this)
        val hdrCapabilities = getHdrTypes(this)
        setContent {
            HDRApp(isHdr, hdrCapabilities,this)
        }
    }
}
@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Preview(wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE)
@Composable
fun HDRApp(isHDR: Boolean = true, hdrCapabilities: IntArray = intArrayOf(HDR_TYPE_HDR10_PLUS, HDR_TYPE_DOLBY_VISION, HDR_TYPE_HDR10, HDR_TYPE_HLG), context: Context = LocalContext.current) {
    WhatHDRTheme {
        Scaffold(topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = colorScheme.primaryContainer,
                    titleContentColor = colorScheme.primary,
                ),
                title = { Text("WhatHDR", style = TextStyle(fontFamily = robotoFlexTopBar, fontSize = 20.sp)) }
            )
        }
        ) { innerPadding ->
            if(isHDR) {
                HdrList(innerPadding, hdrCapabilities, context)
            }
            else{
                IncompatibleDevice(innerPadding)
            }
        }
    }
}








fun isDisplayHDR(context: Context): Boolean {
    val displayManager = context.getSystemService(DISPLAY_SERVICE) as DisplayManager
    val display = displayManager.getDisplay(Display.DEFAULT_DISPLAY)
    return display != null && display.isHdrSdrRatioAvailable
}
fun getHdrTypes(context: Context): IntArray {
    val displayManager = context.getSystemService(DISPLAY_SERVICE) as DisplayManager
    val display = displayManager.getDisplay(Display.DEFAULT_DISPLAY)
    return display?.mode?.supportedHdrTypes?: intArrayOf()
}
fun hdrTypesAvailable(hdrCapabilities: IntArray): List<HdrInfo> {
    val allHdrTypesMap = mapOf(
        HDR_TYPE_HLG to HdrInfo(
            name = "HLG",
            description = R.string.hlg_description
        ),
        HDR_TYPE_DOLBY_VISION to HdrInfo(
            name = "Dolby Vision",
            description = R.string.dbvision_description
        ),
        HDR_TYPE_HDR10 to HdrInfo(
            name = "HDR10",
            description = R.string.hdr10_description
        ),
        HDR_TYPE_HDR10_PLUS to HdrInfo(
            name = "HDR10+",
            description = R.string.hdr10plus_description
        )
    )
    val availableHdrNames: List<HdrInfo> = hdrCapabilities.asList().mapNotNull { hdrType ->
        allHdrTypesMap[hdrType]
    }
    return availableHdrNames
}
@Composable
fun HdrList(innerPadding: PaddingValues, hdrCapabilities: IntArray, context: Context){
    val haptic = LocalHapticFeedback.current
    Column(modifier = Modifier
        .padding(innerPadding)
        .padding(horizontal = 16.dp)
        .padding(bottom = 16.dp)) {
        LazyColumn(modifier = Modifier
            .weight(1f)) {
            items(hdrTypesAvailable(hdrCapabilities)) { hdrInfo ->
                ExpandableHdrItem(hdrInfo = hdrInfo)
            }
        }
        var checked by remember { mutableStateOf(HDRService.isRunning) }

        ElevatedCard(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .toggleable(
                    value = checked,
                    onValueChange = { isChecked ->
                        checked = isChecked
                        haptic.performHapticFeedback(HapticFeedbackType.ContextClick)
                        val intent = Intent(context, HDRService::class.java)

                        if (isChecked) intent.action =
                            HDRService.Actions.START.toString()
                        else intent.action = HDRService.Actions.STOP.toString()

                        context.startService(intent)
                    },
                    role = Role.Switch
                ),
            colors = CardDefaults.cardColors(containerColor = colorScheme.primaryContainer)
        ) {
            Row(modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = if (checked) "HDR Service ON" else "HDR Service OFF",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontFamily = googleFlex600, fontSize = 18.sp)
                )
                Switch(checked = checked, onCheckedChange = null, thumbContent = {
                    if (checked) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize),
                        )}
                } )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun IncompatibleDevice(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorScheme.errorContainer
            ),
            shape = RoundedPolygon(MaterialShapes.Cookie9Sided).toShape(0),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.WarningAmber,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp),
                    tint = colorScheme.onSecondaryContainer
                )

                Text(
                    text = stringResource(R.string.your_device_isn_t_compatible),
                    style = Typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    color = colorScheme.onSecondaryContainer
                )

                Text(
                    text = stringResource(R.string.this_app_uses_the_hdrsdrratio_to_check_your_display_s_hdr_status_tap_below_to_learn_more),
                    style = Typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = colorScheme.onSecondaryContainer.copy(alpha = 0.8f)
                )
                val uriHandler = LocalUriHandler.current
                val uri= "https://developer.android.com/reference/android/view/Display#getHdrSdrRatio()"
                TextButton(onClick = { uriHandler.openUri(uri)}) {
                    Text("Learn more")
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(16.dp)
                    )
                }
            }
        }
    }
}


