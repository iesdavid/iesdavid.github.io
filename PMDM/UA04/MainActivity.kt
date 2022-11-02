package com.example.ua04_01

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.loadUrl("https://ciclo.iesnervion.es")
        myWebView.setWebViewClient(object : WebViewClient() {
            // evita que los enlaces se abran fuera de nuestra app en el navegador de android
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        })

        val uploadWorkRequest: WorkRequest = PeriodicWorkRequestBuilder<testConexion>(10,TimeUnit.SECONDS).build()
        WorkManager
            .getInstance(this)
            .enqueue(uploadWorkRequest)

        // registra el elemento button
        val checkButton: Button = findViewById(R.id.buttonCheck)

        // Listener para que el botón llame a la función
        // checkForInternet y muestre un mensaje acorde al resultado
       checkButton.setOnClickListener() {
            if (checkForInternet(this)) {
                Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun checkForInternet(context: Context): Boolean {
        // registra la actividad mediante el Servicio de control de conectividad
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // Devuelve un objeto de tipo Network correspondiente a la conexión actual o FALSE
        val network = connectivityManager.activeNetwork ?: return false

        // Devuelve las capacidades de la conexión activa
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            // Indica si la red usa un transporte WIFI,
            // o si WiFi tiene conectividad
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

            // Indica si la red usa un transporte de red móvil,
            // o si la red móvil tiene conectividad
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

            // si no, devuelve false
            else -> false
        }
    }

}