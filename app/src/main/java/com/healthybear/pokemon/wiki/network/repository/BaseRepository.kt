package com.healthybear.library.network.repository

import com.healthybear.library.network.error.ExceptionHandler
import com.healthybear.library.network.response.ApiResponse
import retrofit2.Response

/**
 * @author: 郭健鸿
 * @Date: 2025-06-15 11:58
 * @Description: 基础仓库类，提供通用的网络请求处理方法
 */
open class BaseRepository {
    
    /**
     * 处理Retrofit Response的通用方法
     * @param requestCall suspend函数，返回Retrofit Response
     * @return ApiResponse封装的结果
     */
    suspend fun <T> requestResponse(requestCall: suspend () -> Response<T>): ApiResponse<T> {
        val response = requestCall()
        if (response.isSuccessful) {
            return ApiResponse.Success(response.body()!!)
        } else {
            return ApiResponse.Error("httpCode:${response.code()} httpMessage:${response.message()}", null)
        }
    }
    
    /**
     * 安全的API调用方法，自动处理异常
     * @param apiCall suspend函数，直接返回数据类型T
     * @return ApiResponse封装的结果
     */
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ApiResponse<T> {
        return try {
            val result = apiCall()
            ApiResponse.Success(result)
        } catch (e: Throwable) {
            val apiException = ExceptionHandler.handleException(e)
            ApiResponse.Error(apiException.errorMsg, apiException)
        }
    }
}