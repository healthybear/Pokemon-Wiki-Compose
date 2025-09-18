package com.healthybear.pokemon.wiki.network.manager

import com.healthybear.library.network.constant.BASE_URL
import com.healthybear.pokemon.wiki.network.retrofit.PokemonApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Retrofit单例管理器
 * 提供统一的网络请求配置和API接口实例获取
 * @Author guojianhong
 * @Date 2025/9/18
 * @Description 基于Context7最佳实践的Retrofit单例实现
 */
object RetrofitManager {
    
    // 连接超时时间（秒）
    private const val CONNECT_TIMEOUT = 30L
    // 读取超时时间（秒）
    private const val READ_TIMEOUT = 30L
    // 写入超时时间（秒）
    private const val WRITE_TIMEOUT = 30L
    
    /**
     * OkHttp客户端实例（懒加载）
     */
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(createLoggingInterceptor())
            .build()
    }
    
    /**
     * Moshi JSON转换器实例（懒加载）
     */
    private val moshi: Moshi by lazy {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }
    
    /**
     * Retrofit实例（懒加载）
     */
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    
    /**
     * 创建HTTP日志拦截器
     * 在Debug模式下显示详细日志，Release模式下不显示
     */
    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
    
    /**
     * 获取PokemonApi接口实例
     * @return PokemonApi接口实现
     */
    fun getPokemonApi(): PokemonApi = retrofit.create(PokemonApi::class.java)
    
    /**
     * 通用方法：获取任意API接口实例
     * @param serviceClass API接口类
     * @return API接口实现
     */
    fun <T> getApiService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    
    /**
     * 内联泛型版本：获取任意API接口实例
     * 使用示例：val pokemonApi = RetrofitManager.getApiService<PokemonApi>()
     * @return API接口实现
     */
    inline fun <reified T> getApiService(): T = retrofit.create(T::class.java)
    
    /**
     * 获取Retrofit实例（用于高级配置或测试）
     * @return Retrofit实例
     */
    fun getRetrofitInstance(): Retrofit = retrofit
    
    /**
     * 获取OkHttpClient实例（用于高级配置或测试）
     * @return OkHttpClient实例
     */
    fun getOkHttpClient(): OkHttpClient = okHttpClient
}
