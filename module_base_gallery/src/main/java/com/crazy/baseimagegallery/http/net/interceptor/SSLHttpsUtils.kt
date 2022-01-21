package com.crazy.baseimagegallery.http.net.interceptor

import java.security.KeyManagementException
import java.security.KeyStore
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: SSLHttpsUtils
 * Author: zy
 * Date: 2022/1/10 15:54
 * Description: 忽略ssl拦截
 * History:

 */
class SSLHttpsUtils   {
    companion object{
    private var manager: TrustManager = object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        }

        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        }

        override fun getAcceptedIssuers(): Array<X509Certificate>? {
            return  null
        }
    }

     fun initSSLContext():SSLSocketFactory {
         val sslc = SSLContext.getInstance("TLS")
        try {
            // 既然是跳过认证，我们把没有的都填null，此时发现第二个参数是一个数组，那么意思就是我们可以放多个证书认证；
            sslc.init(null, arrayOf<TrustManager>(manager), null)

        } catch (e: KeyManagementException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
         return sslc.socketFactory
    }

        //获取getHostnameVerifier
        fun getHostnameVerifier() =
              HostnameVerifier { s, sslSession ->
                  // true表示信任所有域名
                true
            }

        fun getTrustManager ():X509TrustManager{
            val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
            trustManagerFactory.init(null as KeyStore)

            val trustManagers = trustManagerFactory.trustManagers
            return trustManagers[0] as X509TrustManager
        }

  }
}