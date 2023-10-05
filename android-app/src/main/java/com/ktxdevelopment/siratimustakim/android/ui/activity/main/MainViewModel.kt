package com.ktxdevelopment.siratimustakim.android.ui.activity.main

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.ViewModel
import com.ktxdevelopment.siratimustakim.android.util.NetState
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.category.GetAllCategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(context: Context) : ViewModel() {

    var networkAvailable: MutableStateFlow<NetState> = MutableStateFlow(NetState.NetworkUnknown)
        private set

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private val networkRequest: NetworkRequest = NetworkRequest.Builder().addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build()

    private val networkCallback: ConnectivityManager.NetworkCallback =
        object : ConnectivityManager.NetworkCallback() {
            override fun onLost(network: Network) {
                super.onLost(network)
                networkAvailable.value = NetState.NetworkOff
            }

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                networkAvailable.value = NetState.NetworkOn
            }
        }

    fun registerCallback() {
        networkAvailable.value = NetState.NetworkUnknown
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }
}
