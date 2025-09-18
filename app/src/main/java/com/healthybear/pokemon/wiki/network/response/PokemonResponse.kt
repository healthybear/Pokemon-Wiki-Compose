package com.healthybear.pokemon.wiki.network.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 宝可梦数据响应模型
 * @Author guojianhong
 * @Date 2025/9/18
 */
@JsonClass(generateAdapter = true)
data class PokemonResponse(
    @Json(name = "id")
    val id: Int, // 宝可梦ID
    
    @Json(name = "name")
    val name: String, // 宝可梦名称
    
    @Json(name = "height")
    val height: Int, // 高度（分米）
    
    @Json(name = "weight")
    val weight: Int, // 重量（hectograms）
    
    @Json(name = "types")
    val types: List<String>, // 属性类型列表
    
    @Json(name = "abilities")
    val abilities: List<String>, // 能力列表
    
    @Json(name = "stats")
    val stats: List<String> // 种族值
)

/**
 * 宝可梦遭遇位置响应模型
 */
@JsonClass(generateAdapter = true)
data class PokemonEncounterResponse(
    @Json(name = "location_area")
    val locationArea: LocationAreaResponse, // 位置区域信息
    
    @Json(name = "version_details")
    val versionDetails: List<VersionDetailResponse> // 版本详细信息
)

/**
 * 位置区域信息
 */
@JsonClass(generateAdapter = true)
data class LocationAreaResponse(
    @Json(name = "name")
    val name: String, // 位置区域名称
    
    @Json(name = "url")
    val url: String // 位置区域URL
)

/**
 * 版本详细信息
 */
@JsonClass(generateAdapter = true)
data class VersionDetailResponse(
    @Json(name = "version")
    val version: VersionResponse, // 版本信息
    
    @Json(name = "max_chance")
    val maxChance: Int, // 最大遭遇几率
    
    @Json(name = "encounter_details")
    val encounterDetails: List<EncounterDetailResponse> // 遭遇详细信息
)

/**
 * 版本信息
 */
@JsonClass(generateAdapter = true)
data class VersionResponse(
    @Json(name = "name")
    val name: String, // 版本名称
    
    @Json(name = "url")
    val url: String // 版本URL
)

/**
 * 遭遇详细信息
 */
@JsonClass(generateAdapter = true)
data class EncounterDetailResponse(
    @Json(name = "min_level")
    val minLevel: Int, // 最小等级
    
    @Json(name = "max_level")
    val maxLevel: Int, // 最大等级
    
    @Json(name = "chance")
    val chance: Int, // 遭遇几率
    
    @Json(name = "method")
    val method: EncounterMethodResponse // 遭遇方法
)

/**
 * 遭遇方法
 */
@JsonClass(generateAdapter = true)
data class EncounterMethodResponse(
    @Json(name = "name")
    val name: String, // 方法名称
    
    @Json(name = "url")
    val url: String // 方法URL
)

/**
 * 宝可梦颜色响应模型
 */
@JsonClass(generateAdapter = true)
data class PokemonColorResponse(
    @Json(name = "id")
    val id: Int, // 颜色ID
    
    @Json(name = "name")
    val name: String, // 颜色名称
    
    @Json(name = "names")
    val names: List<NameResponse>, // 多语言名称列表
    
    @Json(name = "pokemon_species")
    val pokemonSpecies: List<PokemonSpeciesLinkResponse> // 该颜色的宝可梦种类列表
)

/**
 * 多语言名称
 */
@JsonClass(generateAdapter = true)
data class NameResponse(
    @Json(name = "name")
    val name: String, // 名称
    
    @Json(name = "language")
    val language: LanguageResponse // 语言信息
)

/**
 * 语言信息
 */
@JsonClass(generateAdapter = true)
data class LanguageResponse(
    @Json(name = "name")
    val name: String, // 语言名称
    
    @Json(name = "url")
    val url: String // 语言URL
)

/**
 * 宝可梦种类链接
 */
@JsonClass(generateAdapter = true)
data class PokemonSpeciesLinkResponse(
    @Json(name = "name")
    val name: String, // 种类名称
    
    @Json(name = "url")
    val url: String // 种类URL
)

/**
 * 宝可梦形态响应模型
 */
@JsonClass(generateAdapter = true)
data class PokemonFormResponse(
    @Json(name = "id")
    val id: Int, // 形态ID
    
    @Json(name = "name")
    val name: String, // 形态名称
    
    @Json(name = "order")
    val order: Int, // 排序
    
    @Json(name = "form_order")
    val formOrder: Int, // 形态排序
    
    @Json(name = "is_default")
    val isDefault: Boolean, // 是否为默认形态
    
    @Json(name = "is_battle_only")
    val isBattleOnly: Boolean, // 是否仅限战斗
    
    @Json(name = "is_mega")
    val isMega: Boolean, // 是否为超进化
    
    @Json(name = "form_name")
    val formName: String, // 形态名称
    
    @Json(name = "pokemon")
    val pokemon: PokemonLinkResponse, // 宝可梦链接
    
    @Json(name = "sprites")
    val sprites: SpritesResponse // 精灵图像
)

/**
 * 宝可梦链接
 */
@JsonClass(generateAdapter = true)
data class PokemonLinkResponse(
    @Json(name = "name")
    val name: String, // 宝可梦名称
    
    @Json(name = "url")
    val url: String // 宝可梦URL
)

/**
 * 精灵图像
 */
@JsonClass(generateAdapter = true)
data class SpritesResponse(
    @Json(name = "front_default")
    val frontDefault: String?, // 正面默认图像
    
    @Json(name = "front_shiny")
    val frontShiny: String?, // 正面闪光图像
    
    @Json(name = "back_default")
    val backDefault: String?, // 背面默认图像
    
    @Json(name = "back_shiny")
    val backShiny: String? // 背面闪光图像
)

/**
 * 宝可梦栖息地响应模型
 */
@JsonClass(generateAdapter = true)
data class PokemonHabitatResponse(
    @Json(name = "id")
    val id: Int, // 栖息地ID
    
    @Json(name = "name")
    val name: String, // 栖息地名称
    
    @Json(name = "names")
    val names: List<NameResponse>, // 多语言名称列表
    
    @Json(name = "pokemon_species")
    val pokemonSpecies: List<PokemonSpeciesLinkResponse> // 该栖息地的宝可梦种类列表
)

/**
 * 宝可梦形状响应模型
 */
@JsonClass(generateAdapter = true)
data class PokemonShapeResponse(
    @Json(name = "id")
    val id: Int, // 形状ID
    
    @Json(name = "name")
    val name: String, // 形状名称
    
    @Json(name = "awesome_names")
    val awesomeNames: List<AwesomeNameResponse>, // 精彩名称列表
    
    @Json(name = "names")
    val names: List<NameResponse>, // 多语言名称列表
    
    @Json(name = "pokemon_species")
    val pokemonSpecies: List<PokemonSpeciesLinkResponse> // 该形状的宝可梦种类列表
)

/**
 * 精彩名称
 */
@JsonClass(generateAdapter = true)
data class AwesomeNameResponse(
    @Json(name = "awesome_name")
    val awesomeName: String, // 精彩名称
    
    @Json(name = "language")
    val language: LanguageResponse // 语言信息
)

/**
 * 宝可梦种类响应模型
 */
@JsonClass(generateAdapter = true)
data class PokemonSpeciesResponse(
    @Json(name = "id")
    val id: Int, // 种类ID
    
    @Json(name = "name")
    val name: String, // 种类名称
    
    @Json(name = "order")
    val order: Int, // 排序
    
    @Json(name = "gender_rate")
    val genderRate: Int, // 性别比率
    
    @Json(name = "capture_rate")
    val captureRate: Int, // 捕获率
    
    @Json(name = "base_happiness")
    val baseHappiness: Int, // 基础亲密度
    
    @Json(name = "is_baby")
    val isBaby: Boolean, // 是否为幼体
    
    @Json(name = "is_legendary")
    val isLegendary: Boolean, // 是否为传说
    
    @Json(name = "is_mythical")
    val isMythical: Boolean, // 是否为幻兽
    
    @Json(name = "hatch_counter")
    val hatchCounter: Int, // 孵化计数器
    
    @Json(name = "has_gender_differences")
    val hasGenderDifferences: Boolean, // 是否有性别差异
    
    @Json(name = "forms_switchable")
    val formsSwitchable: Boolean, // 形态是否可切换
    
    @Json(name = "growth_rate")
    val growthRate: GrowthRateResponse, // 成长速度
    
    @Json(name = "pokedex_numbers")
    val pokedexNumbers: List<PokedexNumberResponse>, // 图鉴编号列表
    
    @Json(name = "egg_groups")
    val eggGroups: List<EggGroupResponse>, // 蛋群列表
    
    @Json(name = "color")
    val color: PokemonColorLinkResponse, // 颜色
    
    @Json(name = "shape")
    val shape: PokemonShapeLinkResponse, // 形状
    
    @Json(name = "evolves_from_species")
    val evolvesFromSpecies: PokemonSpeciesLinkResponse?, // 进化前种类
    
    @Json(name = "evolution_chain")
    val evolutionChain: EvolutionChainResponse, // 进化链
    
    @Json(name = "habitat")
    val habitat: PokemonHabitatLinkResponse?, // 栖息地
    
    @Json(name = "generation")
    val generation: GenerationResponse, // 世代
    
    @Json(name = "names")
    val names: List<NameResponse>, // 多语言名称列表
    
    @Json(name = "pal_park_encounters")
    val palParkEncounters: List<PalParkEncounterResponse>, // 帕尔公园遭遇
    
    @Json(name = "flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntryResponse>, // 描述文本条目
    
    @Json(name = "form_descriptions")
    val formDescriptions: List<FormDescriptionResponse>, // 形态描述
    
    @Json(name = "genera")
    val genera: List<GenusResponse>, // 属类
    
    @Json(name = "varieties")
    val varieties: List<PokemonVarietyResponse> // 变种
)

/**
 * 成长速度
 */
@JsonClass(generateAdapter = true)
data class GrowthRateResponse(
    @Json(name = "name")
    val name: String, // 成长速度名称
    
    @Json(name = "url")
    val url: String // 成长速度URL
)

/**
 * 图鉴编号
 */
@JsonClass(generateAdapter = true)
data class PokedexNumberResponse(
    @Json(name = "entry_number")
    val entryNumber: Int, // 条目编号
    
    @Json(name = "pokedex")
    val pokedex: PokedexResponse // 图鉴信息
)

/**
 * 图鉴信息
 */
@JsonClass(generateAdapter = true)
data class PokedexResponse(
    @Json(name = "name")
    val name: String, // 图鉴名称
    
    @Json(name = "url")
    val url: String // 图鉴URL
)

/**
 * 蛋群
 */
@JsonClass(generateAdapter = true)
data class EggGroupResponse(
    @Json(name = "name")
    val name: String, // 蛋群名称
    
    @Json(name = "url")
    val url: String // 蛋群URL
)

/**
 * 宝可梦颜色链接
 */
@JsonClass(generateAdapter = true)
data class PokemonColorLinkResponse(
    @Json(name = "name")
    val name: String, // 颜色名称
    
    @Json(name = "url")
    val url: String // 颜色URL
)

/**
 * 宝可梦形状链接
 */
@JsonClass(generateAdapter = true)
data class PokemonShapeLinkResponse(
    @Json(name = "name")
    val name: String, // 形状名称
    
    @Json(name = "url")
    val url: String // 形状URL
)

/**
 * 进化链
 */
@JsonClass(generateAdapter = true)
data class EvolutionChainResponse(
    @Json(name = "url")
    val url: String // 进化链URL
)

/**
 * 宝可梦栖息地链接
 */
@JsonClass(generateAdapter = true)
data class PokemonHabitatLinkResponse(
    @Json(name = "name")
    val name: String, // 栖息地名称
    
    @Json(name = "url")
    val url: String // 栖息地URL
)

/**
 * 世代
 */
@JsonClass(generateAdapter = true)
data class GenerationResponse(
    @Json(name = "name")
    val name: String, // 世代名称
    
    @Json(name = "url")
    val url: String // 世代URL
)

/**
 * 帕尔公园遭遇
 */
@JsonClass(generateAdapter = true)
data class PalParkEncounterResponse(
    @Json(name = "base_score")
    val baseScore: Int, // 基础分数
    
    @Json(name = "rate")
    val rate: Int, // 比率
    
    @Json(name = "area")
    val area: PalParkAreaResponse // 区域
)

/**
 * 帕尔公园区域
 */
@JsonClass(generateAdapter = true)
data class PalParkAreaResponse(
    @Json(name = "name")
    val name: String, // 区域名称
    
    @Json(name = "url")
    val url: String // 区域URL
)

/**
 * 描述文本条目
 */
@JsonClass(generateAdapter = true)
data class FlavorTextEntryResponse(
    @Json(name = "flavor_text")
    val flavorText: String, // 描述文本
    
    @Json(name = "language")
    val language: LanguageResponse, // 语言
    
    @Json(name = "version")
    val version: VersionResponse // 版本
)

/**
 * 形态描述
 */
@JsonClass(generateAdapter = true)
data class FormDescriptionResponse(
    @Json(name = "description")
    val description: String, // 描述
    
    @Json(name = "language")
    val language: LanguageResponse // 语言
)

/**
 * 属类
 */
@JsonClass(generateAdapter = true)
data class GenusResponse(
    @Json(name = "genus")
    val genus: String, // 属类名称
    
    @Json(name = "language")
    val language: LanguageResponse // 语言
)

/**
 * 宝可梦变种
 */
@JsonClass(generateAdapter = true)
data class PokemonVarietyResponse(
    @Json(name = "is_default")
    val isDefault: Boolean, // 是否为默认变种
    
    @Json(name = "pokemon")
    val pokemon: PokemonLinkResponse // 宝可梦链接
)
