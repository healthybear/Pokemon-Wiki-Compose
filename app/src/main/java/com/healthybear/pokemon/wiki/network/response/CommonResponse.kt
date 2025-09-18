package com.healthybear.pokemon.wiki.network.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 通用分页响应模型
 * @Author guojianhong
 * @Date 2025/9/18
 */
@JsonClass(generateAdapter = true)
data class PagedResponse<T>(
    @Json(name = "count")
    val count: Int, // 总数量
    
    @Json(name = "next")
    val next: String?, // 下一页链接
    
    @Json(name = "previous")
    val previous: String?, // 上一页链接
    
    @Json(name = "results")
    val results: List<T> // 结果列表
)

/**
 * 通用链接响应模型
 */
@JsonClass(generateAdapter = true)
data class LinkResponse(
    @Json(name = "name")
    val name: String, // 名称
    
    @Json(name = "url")
    val url: String // 链接
)

/**
 * 宝可梦能力响应模型
 */
@JsonClass(generateAdapter = true)
data class AbilityResponse(
    @Json(name = "id")
    val id: Int, // 能力ID
    
    @Json(name = "name")
    val name: String, // 能力名称
    
    @Json(name = "is_main_series")
    val isMainSeries: Boolean, // 是否为主系列
    
    @Json(name = "generation")
    val generation: GenerationResponse, // 世代
    
    @Json(name = "names")
    val names: List<NameResponse>, // 多语言名称列表
    
    @Json(name = "effect_entries")
    val effectEntries: List<EffectEntryResponse>, // 效果条目
    
    @Json(name = "effect_changes")
    val effectChanges: List<EffectChangeResponse>, // 效果变化
    
    @Json(name = "flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntryResponse>, // 描述文本条目
    
    @Json(name = "pokemon")
    val pokemon: List<PokemonAbilityResponse> // 拥有此能力的宝可梦列表
)

/**
 * 效果条目
 */
@JsonClass(generateAdapter = true)
data class EffectEntryResponse(
    @Json(name = "effect")
    val effect: String, // 效果描述
    
    @Json(name = "short_effect")
    val shortEffect: String, // 简短效果描述
    
    @Json(name = "language")
    val language: LanguageResponse // 语言信息
)

/**
 * 效果变化
 */
@JsonClass(generateAdapter = true)
data class EffectChangeResponse(
    @Json(name = "version_group")
    val versionGroup: VersionGroupResponse, // 版本组
    
    @Json(name = "effect_entries")
    val effectEntries: List<EffectEntryResponse> // 效果条目
)

/**
 * 版本组
 */
@JsonClass(generateAdapter = true)
data class VersionGroupResponse(
    @Json(name = "name")
    val name: String, // 版本组名称
    
    @Json(name = "url")
    val url: String // 版本组URL
)

/**
 * 宝可梦能力关联
 */
@JsonClass(generateAdapter = true)
data class PokemonAbilityResponse(
    @Json(name = "is_hidden")
    val isHidden: Boolean, // 是否为隐藏能力
    
    @Json(name = "slot")
    val slot: Int, // 能力槽位
    
    @Json(name = "pokemon")
    val pokemon: PokemonLinkResponse // 宝可梦链接
)

/**
 * 宝可梦特性响应模型
 */
@JsonClass(generateAdapter = true)
data class CharacteristicResponse(
    @Json(name = "id")
    val id: Int, // 特性ID
    
    @Json(name = "gene_modulo")
    val geneModulo: Int, // 基因模数
    
    @Json(name = "possible_values")
    val possibleValues: List<Int>, // 可能的值
    
    @Json(name = "highest_stat")
    val highestStat: StatResponse, // 最高属性
    
    @Json(name = "descriptions")
    val descriptions: List<DescriptionResponse> // 描述列表
)

/**
 * 属性响应模型
 */
@JsonClass(generateAdapter = true)
data class StatResponse(
    @Json(name = "name")
    val name: String, // 属性名称
    
    @Json(name = "url")
    val url: String // 属性URL
)

/**
 * 描述响应模型
 */
@JsonClass(generateAdapter = true)
data class DescriptionResponse(
    @Json(name = "description")
    val description: String, // 描述内容
    
    @Json(name = "language")
    val language: LanguageResponse // 语言信息
)

/**
 * 蛋群响应模型
 */
@JsonClass(generateAdapter = true)
data class EggGroupDetailResponse(
    @Json(name = "id")
    val id: Int, // 蛋群ID
    
    @Json(name = "name")
    val name: String, // 蛋群名称
    
    @Json(name = "names")
    val names: List<NameResponse>, // 多语言名称列表
    
    @Json(name = "pokemon_species")
    val pokemonSpecies: List<PokemonSpeciesLinkResponse> // 该蛋群的宝可梦种类列表
)

/**
 * 性别响应模型
 */
@JsonClass(generateAdapter = true)
data class GenderResponse(
    @Json(name = "id")
    val id: Int, // 性别ID
    
    @Json(name = "name")
    val name: String, // 性别名称
    
    @Json(name = "pokemon_species_details")
    val pokemonSpeciesDetails: List<PokemonSpeciesDetailResponse>, // 宝可梦种类详情
    
    @Json(name = "required_for_evolution")
    val requiredForEvolution: List<PokemonSpeciesLinkResponse> // 进化所需的种类
)

/**
 * 宝可梦种类详情
 */
@JsonClass(generateAdapter = true)
data class PokemonSpeciesDetailResponse(
    @Json(name = "rate")
    val rate: Int, // 比率
    
    @Json(name = "pokemon_species")
    val pokemonSpecies: PokemonSpeciesLinkResponse // 宝可梦种类链接
)

/**
 * 成长速度响应模型
 */
@JsonClass(generateAdapter = true)
data class GrowthRateDetailResponse(
    @Json(name = "id")
    val id: Int, // 成长速度ID
    
    @Json(name = "name")
    val name: String, // 成长速度名称
    
    @Json(name = "formula")
    val formula: String, // 成长公式
    
    @Json(name = "descriptions")
    val descriptions: List<DescriptionResponse>, // 描述列表
    
    @Json(name = "levels")
    val levels: List<LevelResponse>, // 等级列表
    
    @Json(name = "pokemon_species")
    val pokemonSpecies: List<PokemonSpeciesLinkResponse> // 使用此成长速度的宝可梦种类
)

/**
 * 等级响应模型
 */
@JsonClass(generateAdapter = true)
data class LevelResponse(
    @Json(name = "level")
    val level: Int, // 等级
    
    @Json(name = "experience")
    val experience: Int // 所需经验值
)

/**
 * 性格响应模型
 */
@JsonClass(generateAdapter = true)
data class NatureResponse(
    @Json(name = "id")
    val id: Int, // 性格ID
    
    @Json(name = "name")
    val name: String, // 性格名称
    
    @Json(name = "decreased_stat")
    val decreasedStat: StatResponse?, // 降低的属性
    
    @Json(name = "increased_stat")
    val increasedStat: StatResponse?, // 提升的属性
    
    @Json(name = "hates_flavor")
    val hatesFlavor: FlavorResponse?, // 讨厌的口味
    
    @Json(name = "likes_flavor")
    val likesFlavor: FlavorResponse?, // 喜欢的口味
    
    @Json(name = "pokeathlon_stat_changes")
    val pokeathlonStatChanges: List<PokeathlonStatChangeResponse>, // 竞技比赛属性变化
    
    @Json(name = "move_battle_style_preferences")
    val moveBattleStylePreferences: List<MoveBattleStylePreferenceResponse>, // 招式战斗风格偏好
    
    @Json(name = "names")
    val names: List<NameResponse> // 多语言名称列表
)

/**
 * 口味响应模型
 */
@JsonClass(generateAdapter = true)
data class FlavorResponse(
    @Json(name = "name")
    val name: String, // 口味名称
    
    @Json(name = "url")
    val url: String // 口味URL
)

/**
 * 竞技比赛属性变化
 */
@JsonClass(generateAdapter = true)
data class PokeathlonStatChangeResponse(
    @Json(name = "max_change")
    val maxChange: Int, // 最大变化值
    
    @Json(name = "pokeathlon_stat")
    val pokeathlonStat: PokeathlonStatResponse // 竞技比赛属性
)

/**
 * 竞技比赛属性
 */
@JsonClass(generateAdapter = true)
data class PokeathlonStatResponse(
    @Json(name = "name")
    val name: String, // 属性名称
    
    @Json(name = "url")
    val url: String // 属性URL
)

/**
 * 招式战斗风格偏好
 */
@JsonClass(generateAdapter = true)
data class MoveBattleStylePreferenceResponse(
    @Json(name = "low_hp_preference")
    val lowHpPreference: Int, // 低HP时的偏好
    
    @Json(name = "high_hp_preference")
    val highHpPreference: Int, // 高HP时的偏好
    
    @Json(name = "move_battle_style")
    val moveBattleStyle: MoveBattleStyleResponse // 招式战斗风格
)

/**
 * 招式战斗风格
 */
@JsonClass(generateAdapter = true)
data class MoveBattleStyleResponse(
    @Json(name = "name")
    val name: String, // 风格名称
    
    @Json(name = "url")
    val url: String // 风格URL
)

/**
 * 竞技比赛属性详情响应模型
 */
@JsonClass(generateAdapter = true)
data class PokeathlonStatDetailResponse(
    @Json(name = "id")
    val id: Int, // 竞技比赛属性ID
    
    @Json(name = "name")
    val name: String, // 属性名称
    
    @Json(name = "names")
    val names: List<NameResponse>, // 多语言名称列表
    
    @Json(name = "affecting_natures")
    val affectingNatures: AffectingNaturesResponse // 影响的性格
)

/**
 * 影响的性格
 */
@JsonClass(generateAdapter = true)
data class AffectingNaturesResponse(
    @Json(name = "increase")
    val increase: List<NatureStatAffectResponse>, // 增加的性格
    
    @Json(name = "decrease")
    val decrease: List<NatureStatAffectResponse> // 减少的性格
)

/**
 * 性格属性影响
 */
@JsonClass(generateAdapter = true)
data class NatureStatAffectResponse(
    @Json(name = "max_change")
    val maxChange: Int, // 最大变化值
    
    @Json(name = "nature")
    val nature: NatureLinkResponse // 性格链接
)

/**
 * 性格链接
 */
@JsonClass(generateAdapter = true)
data class NatureLinkResponse(
    @Json(name = "name")
    val name: String, // 性格名称
    
    @Json(name = "url")
    val url: String // 性格URL
)

/**
 * 属性详情响应模型
 */
@JsonClass(generateAdapter = true)
data class StatDetailResponse(
    @Json(name = "id")
    val id: Int, // 属性ID
    
    @Json(name = "name")
    val name: String, // 属性名称
    
    @Json(name = "game_index")
    val gameIndex: Int, // 游戏内索引
    
    @Json(name = "is_battle_only")
    val isBattleOnly: Boolean, // 是否仅限战斗
    
    @Json(name = "affecting_moves")
    val affectingMoves: AffectingMovesResponse, // 影响的招式
    
    @Json(name = "affecting_natures")
    val affectingNatures: AffectingNaturesResponse, // 影响的性格
    
    @Json(name = "characteristics")
    val characteristics: List<CharacteristicLinkResponse>, // 特性列表
    
    @Json(name = "move_damage_class")
    val moveDamageClass: MoveDamageClassResponse?, // 招式伤害类别
    
    @Json(name = "names")
    val names: List<NameResponse> // 多语言名称列表
)

/**
 * 影响的招式
 */
@JsonClass(generateAdapter = true)
data class AffectingMovesResponse(
    @Json(name = "increase")
    val increase: List<MoveStatAffectResponse>, // 增加的招式
    
    @Json(name = "decrease")
    val decrease: List<MoveStatAffectResponse> // 减少的招式
)

/**
 * 招式属性影响
 */
@JsonClass(generateAdapter = true)
data class MoveStatAffectResponse(
    @Json(name = "change")
    val change: Int, // 变化值
    
    @Json(name = "move")
    val move: MoveLinkResponse // 招式链接
)

/**
 * 招式链接
 */
@JsonClass(generateAdapter = true)
data class MoveLinkResponse(
    @Json(name = "name")
    val name: String, // 招式名称
    
    @Json(name = "url")
    val url: String // 招式URL
)

/**
 * 特性链接
 */
@JsonClass(generateAdapter = true)
data class CharacteristicLinkResponse(
    @Json(name = "url")
    val url: String // 特性URL
)

/**
 * 招式伤害类别
 */
@JsonClass(generateAdapter = true)
data class MoveDamageClassResponse(
    @Json(name = "name")
    val name: String, // 伤害类别名称
    
    @Json(name = "url")
    val url: String // 伤害类别URL
)

/**
 * 属性类型响应模型
 */
@JsonClass(generateAdapter = true)
data class TypeResponse(
    @Json(name = "id")
    val id: Int, // 类型ID
    
    @Json(name = "name")
    val name: String, // 类型名称
    
    @Json(name = "damage_relations")
    val damageRelations: DamageRelationsResponse, // 伤害关系
    
    @Json(name = "past_damage_relations")
    val pastDamageRelations: List<PastDamageRelationResponse>, // 过去的伤害关系
    
    @Json(name = "game_indices")
    val gameIndices: List<GameIndexResponse>, // 游戏索引
    
    @Json(name = "generation")
    val generation: GenerationResponse, // 世代
    
    @Json(name = "move_damage_class")
    val moveDamageClass: MoveDamageClassResponse?, // 招式伤害类别
    
    @Json(name = "names")
    val names: List<NameResponse>, // 多语言名称列表
    
    @Json(name = "pokemon")
    val pokemon: List<TypePokemonResponse>, // 该类型的宝可梦
    
    @Json(name = "moves")
    val moves: List<MoveLinkResponse> // 该类型的招式
)

/**
 * 伤害关系
 */
@JsonClass(generateAdapter = true)
data class DamageRelationsResponse(
    @Json(name = "no_damage_to")
    val noDamageTo: List<TypeLinkResponse>, // 对其无效的类型
    
    @Json(name = "half_damage_to")
    val halfDamageTo: List<TypeLinkResponse>, // 对其效果不佳的类型
    
    @Json(name = "double_damage_to")
    val doubleDamageTo: List<TypeLinkResponse>, // 对其超级有效的类型
    
    @Json(name = "no_damage_from")
    val noDamageFrom: List<TypeLinkResponse>, // 受其无效的类型
    
    @Json(name = "half_damage_from")
    val halfDamageFrom: List<TypeLinkResponse>, // 受其效果不佳的类型
    
    @Json(name = "double_damage_from")
    val doubleDamageFrom: List<TypeLinkResponse> // 受其超级有效的类型
)

/**
 * 类型链接
 */
@JsonClass(generateAdapter = true)
data class TypeLinkResponse(
    @Json(name = "name")
    val name: String, // 类型名称
    
    @Json(name = "url")
    val url: String // 类型URL
)

/**
 * 过去的伤害关系
 */
@JsonClass(generateAdapter = true)
data class PastDamageRelationResponse(
    @Json(name = "generation")
    val generation: GenerationResponse, // 世代
    
    @Json(name = "damage_relations")
    val damageRelations: DamageRelationsResponse // 伤害关系
)

/**
 * 游戏索引
 */
@JsonClass(generateAdapter = true)
data class GameIndexResponse(
    @Json(name = "game_index")
    val gameIndex: Int, // 游戏索引
    
    @Json(name = "generation")
    val generation: GenerationResponse // 世代
)

/**
 * 类型宝可梦
 */
@JsonClass(generateAdapter = true)
data class TypePokemonResponse(
    @Json(name = "slot")
    val slot: Int, // 类型槽位
    
    @Json(name = "pokemon")
    val pokemon: PokemonLinkResponse // 宝可梦链接
)

/**
 * 语言详情响应模型
 */
@JsonClass(generateAdapter = true)
data class LanguageDetailResponse(
    @Json(name = "id")
    val id: Int, // 语言ID
    
    @Json(name = "name")
    val name: String, // 语言名称
    
    @Json(name = "official")
    val official: Boolean, // 是否为官方语言
    
    @Json(name = "iso639")
    val iso639: String, // ISO639语言代码
    
    @Json(name = "iso3166")
    val iso3166: String, // ISO3166地区代码
    
    @Json(name = "names")
    val names: List<NameResponse> // 多语言名称列表
)
