package com.crazy.baseimagegallery.http.net

import com.beyondsoft.smarthome.utils.logs.LogTag
import okhttp3.*

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: AddParameterInterceptor
 * Author: zy
 * Date: 2022/1/4 17:04
 * Description: 拦截并添加公共参数
 * History:

 */
class AddParameterInterceptor:Interceptor {

    private val METHOD_GET :String = "GET"
    private val METHOD_POST :String= "POST"
    private val HEADER_KEY_USER_AGENT :String= "User-Agent"

    override fun intercept(chain: Interceptor.Chain): Response {
        var mRequest = chain.request()
        var requestBuilder = mRequest.newBuilder()


        if (mRequest.method == METHOD_GET){
            val newUrl = mRequest.url.newBuilder()
//            .addEncodedQueryParameter("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJub25lIiwic3ViIjoibm9uZSIsIm93bl9wYXJhbXMiOnsibG9naW5Vc2VySWQiOiJjNDllOGVmMTRjOWZlNmM4ZjgxNzdhODkyM2UyMjc2ZCIsImRldGFpbCI6eyJpZCI6ImM0OWU4ZWYxNGM5ZmU2YzhmODE3N2E4OTIzZTIyNzZkIiwiY3JlYXRlVGltZSI6MTYyNzM1NjYyNjA4OCwidXBkYXRlVGltZSI6MTYyNzYxMDI4MjUyMCwiYWNjb3VudCI6InNodWFuZ2FuMDAxIiwicGFzc3dvcmQiOiJZWUJVSlEwTXVyS2ZEczgwSHE5a1dnPT0iLCJjb21wYW55TmFtZSI6IuWPjOWuieWVhuWcuiIsInJlZ2lvbkNvZGUiOiIxLDIsMyw5IiwiY29udGFjdFBlcnNvbiI6IuWPjOWuiSIsIm1vYmlsZVBob25lIjoiMTUzODI2OTc4OTYiLCJlbWFpbCI6IiIsImRldmljZUNvZGUiOm51bGwsInZhbGlkaXR5U3RhcnRUaW1lIjp7InllYXIiOjIwMjEsIm1vbnRoVmFsdWUiOjcsIm1vbnRoIjoiSlVMWSIsImRheU9mTW9udGgiOjI2LCJkYXlPZlllYXIiOjIwNywiZGF5T2ZXZWVrIjoiTU9OREFZIiwiaG91ciI6MTksIm1pbnV0ZSI6MjksInNlY29uZCI6NDYsIm5hbm8iOjAsImNocm9ub2xvZ3kiOnsiY2FsZW5kYXJUeXBlIjoiaXNvODYwMSIsImlkIjoiSVNPIn19LCJ2YWxpZGl0eUVuZFRpbWUiOnsieWVhciI6MjAyMiwibW9udGhWYWx1ZSI6NywibW9udGgiOiJKVUxZIiwiZGF5T2ZNb250aCI6MjYsImRheU9mWWVhciI6MjA3LCJkYXlPZldlZWsiOiJUVUVTREFZIiwiaG91ciI6MTksIm1pbnV0ZSI6MjksInNlY29uZCI6NDYsIm5hbm8iOjAsImNocm9ub2xvZ3kiOnsiY2FsZW5kYXJUeXBlIjoiaXNvODYwMSIsImlkIjoiSVNPIn19LCJhcHBseVN0YXR1cyI6MCwiYWNjb3VudFB3ZEZhaWwiOm51bGwsImNyZWF0ZVVzZXJJZCI6bnVsbCwidXBkYXRlVXNlcklkIjpudWxsLCJpZkRlbGV0ZSI6MCwiY29tcGFueUlkIjoiNSIsInByaW1hcnlBY2NvdW50IjoxLCJhY2NvdW50U291cmNlIjoxLCJwb3NpdGlvbk5hbWUiOm51bGwsImRlbGV0ZVRpbWUiOm51bGx9fSwiZXhwIjoxNjQxODA3ODAxLCJpYXQiOjE2NDEzNzU4MDF9.yzrE81jIx53BlGLmW3rVB2gLQ3avTDpI9lysVWbJY2E")
            .build()

             requestBuilder.url(newUrl)

        }else if (mRequest.method == METHOD_POST){

            val fb = FormBody.Builder()

            if (mRequest.body is FormBody){
                val mFormBody = mRequest.method as FormBody

                for (i in 0 until mFormBody.size) {
                    fb.addEncoded(mFormBody.encodedName(i), mFormBody.encodedValue(i))
                    LogTag.d("headers ${mFormBody.encodedName(i)+"-----"+mFormBody.encodedValue(i)}")
                }
            }

//            fb.addEncoded("Authorization","eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJub25lIiwic3ViIjoibm9uZSIsIm93bl9wYXJhbXMiOnsibG9naW5Vc2VySWQiOiJjNDllOGVmMTRjOWZlNmM4ZjgxNzdhODkyM2UyMjc2ZCIsImRldGFpbCI6eyJpZCI6ImM0OWU4ZWYxNGM5ZmU2YzhmODE3N2E4OTIzZTIyNzZkIiwiY3JlYXRlVGltZSI6MTYyNzM1NjYyNjA4OCwidXBkYXRlVGltZSI6MTYyNzYxMDI4MjUyMCwiYWNjb3VudCI6InNodWFuZ2FuMDAxIiwicGFzc3dvcmQiOiJZWUJVSlEwTXVyS2ZEczgwSHE5a1dnPT0iLCJjb21wYW55TmFtZSI6IuWPjOWuieWVhuWcuiIsInJlZ2lvbkNvZGUiOiIxLDIsMyw5IiwiY29udGFjdFBlcnNvbiI6IuWPjOWuiSIsIm1vYmlsZVBob25lIjoiMTUzODI2OTc4OTYiLCJlbWFpbCI6IiIsImRldmljZUNvZGUiOm51bGwsInZhbGlkaXR5U3RhcnRUaW1lIjp7InllYXIiOjIwMjEsIm1vbnRoVmFsdWUiOjcsIm1vbnRoIjoiSlVMWSIsImRheU9mTW9udGgiOjI2LCJkYXlPZlllYXIiOjIwNywiZGF5T2ZXZWVrIjoiTU9OREFZIiwiaG91ciI6MTksIm1pbnV0ZSI6MjksInNlY29uZCI6NDYsIm5hbm8iOjAsImNocm9ub2xvZ3kiOnsiY2FsZW5kYXJUeXBlIjoiaXNvODYwMSIsImlkIjoiSVNPIn19LCJ2YWxpZGl0eUVuZFRpbWUiOnsieWVhciI6MjAyMiwibW9udGhWYWx1ZSI6NywibW9udGgiOiJKVUxZIiwiZGF5T2ZNb250aCI6MjYsImRheU9mWWVhciI6MjA3LCJkYXlPZldlZWsiOiJUVUVTREFZIiwiaG91ciI6MTksIm1pbnV0ZSI6MjksInNlY29uZCI6NDYsIm5hbm8iOjAsImNocm9ub2xvZ3kiOnsiY2FsZW5kYXJUeXBlIjoiaXNvODYwMSIsImlkIjoiSVNPIn19LCJhcHBseVN0YXR1cyI6MCwiYWNjb3VudFB3ZEZhaWwiOm51bGwsImNyZWF0ZVVzZXJJZCI6bnVsbCwidXBkYXRlVXNlcklkIjpudWxsLCJpZkRlbGV0ZSI6MCwiY29tcGFueUlkIjoiNSIsInByaW1hcnlBY2NvdW50IjoxLCJhY2NvdW50U291cmNlIjoxLCJwb3NpdGlvbk5hbWUiOm51bGwsImRlbGV0ZVRpbWUiOm51bGx9fSwiZXhwIjoxNjQxODA3ODAxLCJpYXQiOjE2NDEzNzU4MDF9.yzrE81jIx53BlGLmW3rVB2gLQ3avTDpI9lysVWbJY2E")
             requestBuilder.post(fb.build())
        }


      /*  //请求之前拦截
        val request = chain.request()
        val header= request.newBuilder()
            .header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJub25lIiwic3ViIjoibm9uZSIsIm93bl9wYXJhbXMiOnsibG9naW5Vc2VySWQiOiJjNDllOGVmMTRjOWZlNmM4ZjgxNzdhODkyM2UyMjc2ZCIsImRldGFpbCI6eyJpZCI6ImM0OWU4ZWYxNGM5ZmU2YzhmODE3N2E4OTIzZTIyNzZkIiwiY3JlYXRlVGltZSI6MTYyNzM1NjYyNjA4OCwidXBkYXRlVGltZSI6MTYyNzYxMDI4MjUyMCwiYWNjb3VudCI6InNodWFuZ2FuMDAxIiwicGFzc3dvcmQiOiJZWUJVSlEwTXVyS2ZEczgwSHE5a1dnPT0iLCJjb21wYW55TmFtZSI6IuWPjOWuieWVhuWcuiIsInJlZ2lvbkNvZGUiOiIxLDIsMyw5IiwiY29udGFjdFBlcnNvbiI6IuWPjOWuiSIsIm1vYmlsZVBob25lIjoiMTUzODI2OTc4OTYiLCJlbWFpbCI6IiIsImRldmljZUNvZGUiOm51bGwsInZhbGlkaXR5U3RhcnRUaW1lIjp7InllYXIiOjIwMjEsIm1vbnRoVmFsdWUiOjcsIm1vbnRoIjoiSlVMWSIsImRheU9mTW9udGgiOjI2LCJkYXlPZlllYXIiOjIwNywiZGF5T2ZXZWVrIjoiTU9OREFZIiwiaG91ciI6MTksIm1pbnV0ZSI6MjksInNlY29uZCI6NDYsIm5hbm8iOjAsImNocm9ub2xvZ3kiOnsiY2FsZW5kYXJUeXBlIjoiaXNvODYwMSIsImlkIjoiSVNPIn19LCJ2YWxpZGl0eUVuZFRpbWUiOnsieWVhciI6MjAyMiwibW9udGhWYWx1ZSI6NywibW9udGgiOiJKVUxZIiwiZGF5T2ZNb250aCI6MjYsImRheU9mWWVhciI6MjA3LCJkYXlPZldlZWsiOiJUVUVTREFZIiwiaG91ciI6MTksIm1pbnV0ZSI6MjksInNlY29uZCI6NDYsIm5hbm8iOjAsImNocm9ub2xvZ3kiOnsiY2FsZW5kYXJUeXBlIjoiaXNvODYwMSIsImlkIjoiSVNPIn19LCJhcHBseVN0YXR1cyI6MCwiYWNjb3VudFB3ZEZhaWwiOm51bGwsImNyZWF0ZVVzZXJJZCI6bnVsbCwidXBkYXRlVXNlcklkIjpudWxsLCJpZkRlbGV0ZSI6MCwiY29tcGFueUlkIjoiNSIsInByaW1hcnlBY2NvdW50IjoxLCJhY2NvdW50U291cmNlIjoxLCJwb3NpdGlvbk5hbWUiOm51bGwsImRlbGV0ZVRpbWUiOm51bGx9fSwiZXhwIjoxNjQxODA3ODAxLCJpYXQiOjE2NDEzNzU4MDF9.yzrE81jIx53BlGLmW3rVB2gLQ3avTDpI9lysVWbJY2E")

        val build: Request = header.build()
        LogTag.d("url:" + build.url.toUrl())
        LogTag.d("headers:" + build.headers)
        return chain.proceed(build)*/
        val rs = chain.proceed(requestBuilder.build())

        LogTag.d("-------------"+(requestBuilder.build().body is MultipartBody))
        LogTag.d("-------------"+requestBuilder.build().headers)
        LogTag.d("-------------"+requestBuilder.build().url)
        return rs
    }

    /**
     * 打印全部参数
     */
    private fun printParameter(httpUrl :HttpUrl) {
        val qpns = httpUrl.queryParameterNames
        for (e in qpns){
            val name = httpUrl.queryParameter(e)
            LogTag.d("参加的公共参数：$name")
        }
    }
}