@file:OptIn(ExperimentalFoundationApi::class)

package com.ktxdevelopment.siratimustakim.android.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import kotlin.reflect.KFunction1

@Composable
fun HomeScreen(
    state: HomeScreenState,
    onTriggerEvent: KFunction1<HomeEvent, Unit>,
    onSelectRecipe: (recipeId: Int)-> Unit
) {

    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState()



}