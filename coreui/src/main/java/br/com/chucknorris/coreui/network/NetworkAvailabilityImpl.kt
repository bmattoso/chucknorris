package br.com.chucknorris.coreui.network

import br.com.chucknorris.core.NetworkAvailability

class NetworkAvailabilityImpl : NetworkAvailability {

    override fun isAvailable(): Boolean {
        return false
    }
}
