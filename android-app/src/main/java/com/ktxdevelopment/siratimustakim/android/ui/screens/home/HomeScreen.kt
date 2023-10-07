package com.ktxdevelopment.siratimustakim.android.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ktxdevelopment.siratimustakim.android.R
import com.ktxdevelopment.siratimustakim.android.nav.Navigation


@Composable
fun HomeScreen() {

    var onTopBarIconClick by remember { mutableStateOf({})}
    var iconDrawable by remember { mutableStateOf(androidx.core.R.drawable.notification_icon_background) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painterResource(id = iconDrawable),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(MaterialTheme.shapes.small)
                            .clickable { onTopBarIconClick.invoke() }
                    )
                },
                actions = {
                    IconButton(onClick = onTopBarIconClick) {
                        Icon(Icons.Default.Home, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier.padding(padding)
        ) {
            Navigation(setOnTopBarIconClick = { action -> onTopBarIconClick = action }, onUpdateIcon = { icon -> iconDrawable = icon })
            
        }
    }
}