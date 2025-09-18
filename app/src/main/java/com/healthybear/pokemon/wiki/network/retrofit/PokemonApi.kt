package com.healthybear.pokemon.wiki.network.retrofit

import com.healthybear.pokemon.wiki.network.response.*
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 宝可梦API接口定义
 * @Author guojianhong
 * @Date 2025/9/18
 * @description 提供宝可梦相关数据的网络接口
 */
interface PokemonApi {
    
    /**
     * 获取宝可梦详细信息
     * @param id 宝可梦ID或名称
     * @return 宝可梦详细信息
     */
    @GET("/pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: String): PokemonResponse
    
    /**
     * 获取宝可梦遭遇位置信息
     * @param id 宝可梦ID或名称
     * @return 宝可梦遭遇位置列表
     */
    @GET("/pokemon/{id}/encounters")
    suspend fun getPokemonEncounters(@Path("id") id: String): List<PokemonEncounterResponse>
    
    /**
     * 获取宝可梦颜色信息
     * @param id 颜色ID或名称
     * @return 宝可梦颜色详细信息
     */
    @GET("/pokemon-color/{id}")
    suspend fun getPokemonColor(@Path("id") id: String): PokemonColorResponse
    
    /**
     * 获取宝可梦形态信息
     * @param id 形态ID或名称
     * @return 宝可梦形态详细信息
     */
    @GET("/pokemon-form/{id}")
    suspend fun getPokemonForm(@Path("id") id: String): PokemonFormResponse
    
    /**
     * 获取宝可梦栖息地信息
     * @param id 栖息地ID或名称
     * @return 宝可梦栖息地详细信息
     */
    @GET("/pokemon-habitat/{id}")
    suspend fun getPokemonHabitat(@Path("id") id: String): PokemonHabitatResponse
    
    /**
     * 获取宝可梦形状信息
     * @param id 形状ID或名称
     * @return 宝可梦形状详细信息
     */
    @GET("/pokemon-shape/{id}/")
    suspend fun getPokemonShape(@Path("id") id: String): PokemonShapeResponse
    
    /**
     * 获取宝可梦种类信息
     * @param id 种类ID或名称
     * @return 宝可梦种类详细信息
     */
    @GET("/pokemon-species/{id}")
    suspend fun getPokemonSpecies(@Path("id") id: String): PokemonSpeciesResponse
    
    // ========== 其他API接口 ==========
    
    /**
     * 获取宝可梦能力信息
     * @param id 能力ID或名称
     * @return 宝可梦能力详细信息
     */
    @GET("/ability/{id}")
    suspend fun getAbility(@Path("id") id: String): AbilityResponse
    
    /**
     * 获取宝可梦特性信息
     * @param id 特性ID
     * @return 宝可梦特性详细信息
     */
    @GET("/characteristic/{id}/")
    suspend fun getCharacteristic(@Path("id") id: String): CharacteristicResponse
    
    /**
     * 获取蛋群信息
     * @param id 蛋群ID或名称
     * @return 蛋群详细信息
     */
    @GET("/egg-group/{id}")
    suspend fun getEggGroup(@Path("id") id: String): EggGroupDetailResponse
    
    /**
     * 获取性别信息
     * @param id 性别ID或名称
     * @return 性别详细信息
     */
    @GET("/gender/{id}")
    suspend fun getGender(@Path("id") id: String): GenderResponse
    
    /**
     * 获取成长速度信息
     * @param id 成长速度ID或名称
     * @return 成长速度详细信息
     */
    @GET("/growth-rate/{id}")
    suspend fun getGrowthRate(@Path("id") id: String): GrowthRateDetailResponse
    
    /**
     * 获取性格信息
     * @param id 性格ID或名称
     * @return 性格详细信息
     */
    @GET("/nature/{id}")
    suspend fun getNature(@Path("id") id: String): NatureResponse
    
    /**
     * 获取竞技比赛属性信息
     * @param id 竞技比赛属性ID或名称
     * @return 竞技比赛属性详细信息
     */
    @GET("/pokeathlon-stat/{id}")
    suspend fun getPokeathlonStat(@Path("id") id: String): PokeathlonStatDetailResponse
    
    /**
     * 获取属性值信息
     * @param id 属性值ID或名称
     * @return 属性值详细信息
     */
    @GET("/stat/{id}")
    suspend fun getStat(@Path("id") id: String): StatDetailResponse
    
    /**
     * 获取属性类型信息
     * @param id 属性类型ID或名称
     * @return 属性类型详细信息
     */
    @GET("/type/{id}")
    suspend fun getType(@Path("id") id: String): TypeResponse
    
    /**
     * 获取语言列表
     * @return 语言列表
     */
    @GET("/language/")
    suspend fun getLanguages(): PagedResponse<LinkResponse>
    
    /**
     * 获取语言信息
     * @param id 语言ID
     * @return 语言详细信息
     */
    @GET("/language/{id}")
    suspend fun getLanguage(@Path("id") id: String): LanguageDetailResponse
}