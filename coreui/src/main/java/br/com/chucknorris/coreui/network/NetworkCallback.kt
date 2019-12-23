package br.com.chucknorris.coreui.network

import android.net.ConnectivityManager
import android.net.Network

class NetworkCallback : ConnectivityManager.NetworkCallback() {

    private var hasConnection = false

    fun hasConnection(): Boolean = hasConnection

    override fun onAvailable(network: Network) {
        hasConnection = true
    }

    override fun onLost(network: Network) {
        hasConnection = false
    }
}