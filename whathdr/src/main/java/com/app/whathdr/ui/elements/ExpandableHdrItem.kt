package com.app.whathdr.ui.elements

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.whathdr.HdrInfo
import com.app.whathdr.R
import com.app.whathdr.ui.icons.expandLess
import com.app.whathdr.ui.icons.expandMore
import com.app.whathdr.ui.theme.AppFonts.googleFlex600
import com.app.whathdr.ui.theme.WhatHDRTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ExpandableHdrItem(index: Int, totalItems: Int, hdrInfo: HdrInfo) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    val haptic = LocalHapticFeedback.current
    SegmentedListItem(
        modifier = Modifier.fillMaxWidth()
            .animateContentSize()
            .padding(bottom = 4.dp)
            .clickable {
                isExpanded = !isExpanded
                haptic.performHapticFeedback(HapticFeedbackType.SegmentTick)
            },
        elevation = ListItemDefaults.elevation(2.dp),
        shapes = ListItemDefaults.segmentedShapes(index = index, count = totalItems),
        colors = ListItemDefaults.colors(containerColor = colorScheme.secondaryContainer),
        overlineContent = {
            Text(
                text = hdrInfo.name,
                style = TextStyle(fontFamily = googleFlex600)
            )
        },
        trailingContent = {
            Icon(
                if (isExpanded) expandMore else expandLess,
                contentDescription = if (isExpanded) "Collapse" else "Expand"
            )
        },
        content={
            if (isExpanded) {
            Text(
                text = stringResource(hdrInfo.description),
                style = TextStyle(fontFamily = googleFlex600),
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ExpandableHdrItemPreview() {
    WhatHDRTheme {
        ExpandableHdrItem(1,
            hdrInfo = HdrInfo(
                name = "HDR10",
                description = R.string.hdr10_description
            ), totalItems = 5
        )
    }
}