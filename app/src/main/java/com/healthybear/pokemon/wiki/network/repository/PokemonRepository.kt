package com.healthybear.pokemon.wiki.network.repository

import com.healthybear.library.network.repository.BaseRepository
import com.healthybear.library.network.response.ApiResponse
import com.healthybear.pokemon.wiki.network.manager.RetrofitManager
import com.healthybear.pokemon.wiki.network.response.*
import com.healthybear.pokemon.wiki.network.retrofit.PokemonApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 宝可梦数据仓库
 * 负责从PokemonApi获取数据并提供给ViewModel
 * 使用RetrofitManager单例获取API接口实例
 * @Author guojianhong
 * @Date 2025/9/18
 * @description 提供宝可梦相关数据的统一访问接口，支持错误处理和协程调度
 */
class PokemonRepository : BaseRepository() {
    
    private val pokemonApi: PokemonApi = RetrofitManager.getPokemonApi()

    /**
     * 获取宝可梦详细信息
     * @param id 宝可梦ID或名称
     * @return 宝可梦详细信息的ApiResponse
     */
    suspend fun getPokemon(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getPokemon(id) }
    }

    /**
     * 获取宝可梦遭遇位置信息
     * @param id 宝可梦ID或名称
     * @return 宝可梦遭遇位置列表的ApiResponse
     */
    suspend fun getPokemonEncounters(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getPokemonEncounters(id) }
    }

    /**
     * 获取宝可梦颜色信息
     * @param id 颜色ID或名称
     * @return 宝可梦颜色详细信息的ApiResponse
     */
    suspend fun getPokemonColor(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getPokemonColor(id) }
    }

    /**
     * 获取宝可梦形态信息
     * @param id 形态ID或名称
     * @return 宝可梦形态详细信息的ApiResponse
     */
    suspend fun getPokemonForm(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getPokemonForm(id) }
    }

    /**
     * 获取宝可梦栖息地信息
     * @param id 栖息地ID或名称
     * @return 宝可梦栖息地详细信息的ApiResponse
     */
    suspend fun getPokemonHabitat(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getPokemonHabitat(id) }
    }

    /**
     * 获取宝可梦形状信息
     * @param id 形状ID或名称
     * @return 宝可梦形状详细信息的ApiResponse
     */
    suspend fun getPokemonShape(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getPokemonShape(id) }
    }

    /**
     * 获取宝可梦种类信息
     * @param id 种类ID或名称
     * @return 宝可梦种类详细信息的ApiResponse
     */
    suspend fun getPokemonSpecies(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getPokemonSpecies(id) }
    }

    /**
     * 获取宝可梦能力信息
     * @param id 能力ID或名称
     * @return 宝可梦能力详细信息的ApiResponse
     */
    suspend fun getAbility(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getAbility(id) }
    }

    /**
     * 获取宝可梦特性信息
     * @param id 特性ID
     * @return 宝可梦特性详细信息的ApiResponse
     */
    suspend fun getCharacteristic(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getCharacteristic(id) }
    }

    /**
     * 获取蛋群信息
     * @param id 蛋群ID或名称
     * @return 蛋群详细信息的ApiResponse
     */
    suspend fun getEggGroup(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getEggGroup(id) }
    }

    /**
     * 获取性别信息
     * @param id 性别ID或名称
     * @return 性别详细信息的ApiResponse
     */
    suspend fun getGender(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getGender(id) }
    }

    /**
     * 获取成长速度信息
     * @param id 成长速度ID或名称
     * @return 成长速度详细信息的ApiResponse
     */
    suspend fun getGrowthRate(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getGrowthRate(id) }
    }

    /**
     * 获取性格信息
     * @param id 性格ID或名称
     * @return 性格详细信息的ApiResponse
     */
    suspend fun getNature(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getNature(id) }
    }

    /**
     * 获取竞技比赛属性信息
     * @param id 竞技比赛属性ID或名称
     * @return 竞技比赛属性详细信息的ApiResponse
     */
    suspend fun getPokeathlonStat(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getPokeathlonStat(id) }
    }

    /**
     * 获取属性值信息
     * @param id 属性值ID或名称
     * @return 属性值详细信息的ApiResponse
     */
    suspend fun getStat(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getStat(id) }
    }

    /**
     * 获取属性类型信息
     * @param id 属性类型ID或名称
     * @return 属性类型详细信息的ApiResponse
     */
    suspend fun getType(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getType(id) }
    }

    /**
     * 获取语言列表
     * @return 语言列表的ApiResponse
     */
    suspend fun getLanguages() = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getLanguages() }
    }

    /**
     * 获取语言信息
     * @param id 语言ID
     * @return 语言详细信息的ApiResponse
     */
    suspend fun getLanguage(id: String) = withContext(Dispatchers.IO) {
        safeApiCall { pokemonApi.getLanguage(id) }
    }
}