package br.com.chucknorris.coreui.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import br.com.chucknorris.core.NetworkAvailability
import javax.inject.Inject

class NetworkAvailabilityImpl @Inject constructor(
    connectivityManager: ConnectivityManager
) : NetworkAvailability {

    private var networkCallback: NetworkCallback = NetworkCallback()

    init {
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                connectivityManager.registerDefaultNetworkCallback(networkCallback)
            }
            else -> {
                val networkRequest = createNetworkRequest()
                connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
            }
        }
    }

    override fun isAvailable(): Boolean {
        return networkCallback.hasConnection()
    }

    private fun createNetworkRequest() = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build()
}
