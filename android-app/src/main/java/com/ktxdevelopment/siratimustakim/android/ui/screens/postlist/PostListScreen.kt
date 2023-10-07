@file:OptIn(ExperimentalFoundationApi::class)

package com.ktxdevelopment.siratimustakim.android.ui.screens.postlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import com.ktxdevelopment.siratimustakim.android.util.NetType
import kotlin.reflect.KFunction1

@Composable
fun PostListScreen(
    state: PostListScreenState,
    onTriggerEvent: KFunction1<PostListEvent, Unit>,
    onSelectRecipe: (recipeId: Int, netType: NetType)-> Unit
) {


    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState()



}