package com.healthybear.pokemon.wiki.util

import android.annotation.SuppressLint
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object SSLUtil {
    /**
     * 初始化全局SSL配置，绕过所有证书校验
     */
    @SuppressLint("TrustAllX509TrustManager")
    fun initGlobalSSL() {
        try {
            // 1. 创建信任所有证书的TrustManager
            val trustAllCerts = arrayOf<TrustManager>(
                object : X509TrustManager {
                    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
                    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
                    override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
                }
            )

            // 2. 初始化SSL上下文
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // 3. 设置全局默认SSLSocketFactory
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.socketFactory)

            // 4. 禁用主机名校验（解决证书域名不匹配问题）
            HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}