package com.gzslt.boardgame.service.impl

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.gzslt.boardgame.service.NetworkService

class NetworkServiceImpl(
    private val context: Context,
) : NetworkService {

    override fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
                ?: return false

        val activeNetwork = connectivityManager.getNetworkCapabilities(
            connectivityManager.activeNetwork
        )

        return activeNetwork != null && (
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            )
    }
}
