package com.healthybear.pokemon.wiki.ui.theme

import androidx.compose.ui.graphics.Color

// ===== 宝可梦类型数据 =====
data class PokemonType(
    val name: String,
    val displayName: String,
    val primaryColor: Color,
    val secondaryColor: Color,
    val icon: String = "",
    val description: String = ""
)

// ===== 宝可梦类型列表 =====
object PokemonTypes {
    val FIRE = PokemonType(
        name = "fire",
        displayName = "火",
        primaryColor = PokemonFire,
        secondaryColor = PokemonFireLight,
        description = "火系宝可梦，擅长火属性攻击"
    )
    
    val WATER = PokemonType(
        name = "water",
        displayName = "水",
        primaryColor = PokemonWater,
        secondaryColor = PokemonWaterLight,
        description = "水系宝可梦，擅长水属性攻击"
    )
    
    val GRASS = PokemonType(
        name = "grass",
        displayName = "草",
        primaryColor = PokemonGrass,
        secondaryColor = PokemonGrassLight,
        description = "草系宝可梦，擅长草属性攻击"
    )
    
    val ELECTRIC = PokemonType(
        name = "electric",
        displayName = "电",
        primaryColor = PokemonElectric,
        secondaryColor = PokemonElectricLight,
        description = "电系宝可梦，擅长电属性攻击"
    )
    
    val ICE = PokemonType(
        name = "ice",
        displayName = "冰",
        primaryColor = PokemonIce,
        secondaryColor = PokemonIceLight,
        description = "冰系宝可梦，擅长冰属性攻击"
    )
    
    val FIGHTING = PokemonType(
        name = "fighting",
        displayName = "格斗",
        primaryColor = PokemonFighting,
        secondaryColor = PokemonFightingLight,
        description = "格斗系宝可梦，擅长格斗属性攻击"
    )
    
    val POISON = PokemonType(
        name = "poison",
        displayName = "毒",
        primaryColor = PokemonPoison,
        secondaryColor = PokemonPoisonLight,
        description = "毒系宝可梦，擅长毒属性攻击"
    )
    
    val GROUND = PokemonType(
        name = "ground",
        displayName = "地面",
        primaryColor = PokemonGround,
        secondaryColor = PokemonGroundLight,
        description = "地面系宝可梦，擅长地面属性攻击"
    )
    
    val FLYING = PokemonType(
        name = "flying",
        displayName = "飞行",
        primaryColor = PokemonFlying,
        secondaryColor = PokemonFlyingLight,
        description = "飞行系宝可梦，擅长飞行属性攻击"
    )
    
    val PSYCHIC = PokemonType(
        name = "psychic",
        displayName = "超能力",
        primaryColor = PokemonPsychic,
        secondaryColor = PokemonPsychicLight,
        description = "超能力系宝可梦，擅长超能力属性攻击"
    )
    
    val BUG = PokemonType(
        name = "bug",
        displayName = "虫",
        primaryColor = PokemonBug,
        secondaryColor = PokemonBugLight,
        description = "虫系宝可梦，擅长虫属性攻击"
    )
    
    val ROCK = PokemonType(
        name = "rock",
        displayName = "岩石",
        primaryColor = PokemonRock,
        secondaryColor = PokemonRockLight,
        description = "岩石系宝可梦，擅长岩石属性攻击"
    )
    
    val GHOST = PokemonType(
        name = "ghost",
        displayName = "幽灵",
        primaryColor = PokemonGhost,
        secondaryColor = PokemonGhostLight,
        description = "幽灵系宝可梦，擅长幽灵属性攻击"
    )
    
    val STEEL = PokemonType(
        name = "steel",
        displayName = "钢",
        primaryColor = PokemonSteel,
        secondaryColor = PokemonSteelLight,
        description = "钢系宝可梦，擅长钢属性攻击"
    )
    
    val FAIRY = PokemonType(
        name = "fairy",
        displayName = "妖精",
        primaryColor = PokemonFairy,
        secondaryColor = PokemonFairyLight,
        description = "妖精系宝可梦，擅长妖精属性攻击"
    )
    
    val DRAGON = PokemonType(
        name = "dragon",
        displayName = "龙",
        primaryColor = PokemonDragon,
        secondaryColor = PokemonDragonLight,
        description = "龙系宝可梦，擅长龙属性攻击"
    )
    
    val DARK = PokemonType(
        name = "dark",
        displayName = "恶",
        primaryColor = PokemonDark,
        secondaryColor = PokemonDarkLight,
        description = "恶系宝可梦，擅长恶属性攻击"
    )
    
    // 获取所有类型
    fun getAllTypes(): List<PokemonType> = listOf(
        FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, GROUND,
        FLYING, PSYCHIC, BUG, ROCK, GHOST, STEEL, FAIRY, DRAGON, DARK
    )
    
    // 根据名称获取类型
    fun getTypeByName(name: String): PokemonType? {
        return getAllTypes().find { it.name.lowercase() == name.lowercase() }
    }
}

// ===== 主题配置数据 =====
data class PokemonThemeConfig(
    val name: String,
    val displayName: String,
    val description: String,
    val isDark: Boolean,
    val primaryColor: Color,
    val secondaryColor: Color,
    val accentColor: Color
)

// ===== 预定义主题配置 =====
object PokemonThemeConfigs {
    val LIGHT = PokemonThemeConfig(
        name = "light",
        displayName = "亮色主题",
        description = "经典明亮的配色方案，适合白天使用",
        isDark = false,
        primaryColor = PokemonPrimary,
        secondaryColor = PokemonSecondary,
        accentColor = PokemonTertiary
    )
    
    val DARK = PokemonThemeConfig(
        name = "dark",
        displayName = "暗色主题",
        description = "护眼的深色配色方案，适合夜间使用",
        isDark = true,
        primaryColor = PokemonPrimaryDark,
        secondaryColor = PokemonSecondaryDark,
        accentColor = PokemonTertiaryDark
    )
    
    val PIKACHU = PokemonThemeConfig(
        name = "pikachu",
        displayName = "皮卡丘主题",
        description = "以皮卡丘为灵感的黄色主题",
        isDark = false,
        primaryColor = PokemonPrimary,
        secondaryColor = PokemonElectric,
        accentColor = PokemonWarning
    )
    
    val CHARIZARD = PokemonThemeConfig(
        name = "charizard",
        displayName = "喷火龙主题",
        description = "以喷火龙为灵感的火系主题",
        isDark = false,
        primaryColor = PokemonFire,
        secondaryColor = PokemonFireLight,
        accentColor = PokemonError
    )
    
    val BLASTOISE = PokemonThemeConfig(
        name = "blastoise",
        displayName = "水箭龟主题",
        description = "以水箭龟为灵感的水系主题",
        isDark = false,
        primaryColor = PokemonWater,
        secondaryColor = PokemonWaterLight,
        accentColor = PokemonInfo
    )
    
    val VENUSAUR = PokemonThemeConfig(
        name = "venusaur",
        displayName = "妙蛙花主题",
        description = "以妙蛙花为灵感的草系主题",
        isDark = false,
        primaryColor = PokemonGrass,
        secondaryColor = PokemonGrassLight,
        accentColor = PokemonSuccess
    )
    
    // 获取所有主题配置
    fun getAllConfigs(): List<PokemonThemeConfig> = listOf(
        LIGHT, DARK, PIKACHU, CHARIZARD, BLASTOISE, VENUSAUR
    )
    
    // 根据名称获取主题配置
    fun getConfigByName(name: String): PokemonThemeConfig? {
        return getAllConfigs().find { it.name.lowercase() == name.lowercase() }
    }
}

// ===== 主题渐变数据 =====
data class PokemonGradient(
    val name: String,
    val displayName: String,
    val startColor: Color,
    val endColor: Color,
    val description: String = ""
)

// ===== 预定义渐变 =====
object PokemonGradients {
    val PIKACHU = PokemonGradient(
        name = "pikachu",
        displayName = "皮卡丘渐变",
        startColor = PokemonPikachuGradientStart,
        endColor = PokemonPikachuGradientEnd,
        description = "从皮卡丘金到深金的渐变"
    )
    
    val POKEBALL = PokemonGradient(
        name = "pokeball",
        displayName = "精灵球渐变",
        startColor = PokemonPokeballGradientStart,
        endColor = PokemonPokeballGradientEnd,
        description = "从精灵球红到深红的渐变"
    )
    
    val SKY = PokemonGradient(
        name = "sky",
        displayName = "天空渐变",
        startColor = PokemonSkyGradientStart,
        endColor = PokemonSkyGradientEnd,
        description = "从天空蓝到深蓝的渐变"
    )
    
    val GRASS = PokemonGradient(
        name = "grass",
        displayName = "草地渐变",
        startColor = PokemonGrassGradientStart,
        endColor = PokemonGrassGradientEnd,
        description = "从草地绿到深绿的渐变"
    )
    
    // 获取所有渐变
    fun getAllGradients(): List<PokemonGradient> = listOf(
        PIKACHU, POKEBALL, SKY, GRASS
    )
    
    // 根据名称获取渐变
    fun getGradientByName(name: String): PokemonGradient? {
        return getAllGradients().find { it.name.lowercase() == name.lowercase() }
    }
}

// ===== 主题状态数据 =====
data class PokemonThemeStateData(
    val currentTheme: PokemonThemeMode,
    val isDark: Boolean,
    val primaryColor: Color,
    val secondaryColor: Color,
    val accentColor: Color,
    val backgroundColor: Color,
    val surfaceColor: Color,
    val onPrimaryColor: Color,
    val onSecondaryColor: Color,
    val onBackgroundColor: Color,
    val onSurfaceColor: Color
)

// ===== 主题工具函数 =====
object PokemonThemeUtils {
    // 获取当前主题的状态数据
    fun getCurrentThemeStateData(): PokemonThemeStateData {
        val isDark = when (PokemonThemeState.currentTheme.value) {
            PokemonThemeMode.LIGHT -> false
            PokemonThemeMode.DARK -> true
            PokemonThemeMode.SYSTEM -> false // 这里需要根据系统状态判断
            PokemonThemeMode.AUTO -> false // 这里需要根据时间判断
        }
        
        return if (isDark) {
            PokemonThemeStateData(
                currentTheme = PokemonThemeState.currentTheme.value,
                isDark = true,
                primaryColor = PokemonPrimary,
                secondaryColor = PokemonSecondary,
                accentColor = PokemonTertiary,
                backgroundColor = PokemonBackgroundDark,
                surfaceColor = PokemonSurfaceDark,
                onPrimaryColor = PokemonOnPrimaryDark,
                onSecondaryColor = PokemonOnSecondaryDark,
                onBackgroundColor = PokemonOnBackgroundDark,
                onSurfaceColor = PokemonOnSurfaceDark
            )
        } else {
            PokemonThemeStateData(
                currentTheme = PokemonThemeState.currentTheme.value,
                isDark = false,
                primaryColor = PokemonPrimary,
                secondaryColor = PokemonSecondary,
                accentColor = PokemonTertiary,
                backgroundColor = PokemonBackground,
                surfaceColor = PokemonSurface,
                onPrimaryColor = PokemonOnPrimary,
                onSecondaryColor = PokemonOnSecondary,
                onBackgroundColor = PokemonOnBackground,
                onSurfaceColor = PokemonOnSurface
            )
        }
    }
    
    // 获取宝可梦类型的颜色
    fun getPokemonTypeColor(typeName: String, isLight: Boolean = true): Color {
        return PokemonTypes.getTypeByName(typeName)?.let { type ->
            if (isLight) type.primaryColor else type.secondaryColor
        } ?: PokemonPrimary
    }
    
    // 检查颜色对比度是否满足可访问性要求
    fun isAccessibleContrast(foreground: Color, background: Color): Boolean {
        // 这里可以实现对比度计算逻辑
        // 暂时返回true，实际应用中需要计算对比度
        return true
    }
}
