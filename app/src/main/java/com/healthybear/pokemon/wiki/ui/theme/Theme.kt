package com.healthybear.pokemon.wiki.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import kotlin.math.abs
import androidx.compose.runtime.State

// ===== 口袋妖怪亮色主题 =====
private val PokemonLightColorScheme = lightColorScheme(
    // 主色调
    primary = PokemonPrimary,
    onPrimary = PokemonOnPrimary,
    primaryContainer = PokemonPrimaryLight,
    onPrimaryContainer = PokemonOnPrimary,
    
    // 次要色调
    secondary = PokemonSecondary,
    onSecondary = PokemonOnSecondary,
    secondaryContainer = PokemonSecondaryLight,
    onSecondaryContainer = PokemonOnPrimary,
    
    // 第三色调
    tertiary = PokemonTertiary,
    onTertiary = PokemonOnTertiary,
    tertiaryContainer = PokemonTertiaryLight,
    onTertiaryContainer = PokemonOnPrimary,
    
    // 错误色
    error = PokemonError,
    onError = PokemonOnError,
    errorContainer = PokemonErrorLight,
    onErrorContainer = PokemonOnPrimary,
    
    // 背景色
    background = PokemonBackground,
    onBackground = PokemonOnBackground,
    surface = PokemonSurface,
    onSurface = PokemonOnSurface,
    surfaceVariant = PokemonSurfaceVariant,
    onSurfaceVariant = PokemonOnSurfaceVariant,
    
    // 轮廓色
    outline = PokemonOutline,
    outlineVariant = PokemonOutlineVariant,
    
    // 逆色
    inversePrimary = PokemonInversePrimary,
    inverseOnSurface = PokemonInverseOnSurface,
    inverseSurface = PokemonInverseSurface,
    
    // 阴影色
    scrim = PokemonScrim
)

// ===== 口袋妖怪暗色主题 =====
private val PokemonDarkColorScheme = darkColorScheme(
    // 主色调
    primary = PokemonPrimary,
    onPrimary = PokemonOnPrimaryDark,
    primaryContainer = PokemonPrimaryDark,
    onPrimaryContainer = PokemonOnPrimaryDark,
    
    // 次要色调
    secondary = PokemonSecondary,
    onSecondary = PokemonOnSecondaryDark,
    secondaryContainer = PokemonSecondaryDark,
    onSecondaryContainer = PokemonOnSecondaryDark,
    
    // 第三色调
    tertiary = PokemonTertiary,
    onTertiary = PokemonOnTertiaryDark,
    tertiaryContainer = PokemonTertiaryDark,
    onTertiaryContainer = PokemonOnTertiaryDark,
    
    // 错误色
    error = PokemonError,
    onError = PokemonOnErrorDark,
    errorContainer = PokemonErrorDark,
    onErrorContainer = PokemonOnErrorDark,
    
    // 背景色
    background = PokemonBackgroundDark,
    onBackground = PokemonOnBackgroundDark,
    surface = PokemonSurfaceDark,
    onSurface = PokemonOnSurfaceDark,
    surfaceVariant = PokemonSurfaceVariantDark,
    onSurfaceVariant = PokemonOnSurfaceVariantDark,
    
    // 轮廓色
    outline = PokemonOutlineDark,
    outlineVariant = PokemonOutlineVariantDark,
    
    // 逆色
    inversePrimary = PokemonInversePrimaryDark,
    inverseOnSurface = PokemonInverseOnSurfaceDark,
    inverseSurface = PokemonInverseSurfaceDark,
    
    // 阴影色
    scrim = PokemonScrim
)

// ===== 宝可梦动态配色生成器 =====
object PokemonDynamicColorGenerator {
    
    /**
     * 根据宝可梦类型生成动态配色方案
     * @param pokemonType 宝可梦类型
     * @param isDark 是否为暗色主题
     * @return 动态生成的配色方案
     */
    fun generateDynamicColorScheme(
        pokemonType: String,
        isDark: Boolean = false
    ): ColorScheme {
        val baseColor = getPokemonTypeColor(pokemonType, !isDark)
        val onBaseColor = if (isDark) Color.White else Color.Black
        
        return if (isDark) {
            darkColorScheme(
                // 主色调 - 基于宝可梦类型
                primary = baseColor,
                onPrimary = onBaseColor,
                primaryContainer = baseColor.copy(alpha = 0.2f),
                onPrimaryContainer = baseColor,
                
                // 次要色调 - 基于主色调的变体
                secondary = baseColor.copy(alpha = 0.8f),
                onSecondary = onBaseColor,
                secondaryContainer = baseColor.copy(alpha = 0.15f),
                onSecondaryContainer = baseColor,
                
                // 第三色调 - 基于主色调的互补色
                tertiary = generateComplementaryColor(baseColor),
                onTertiary = onBaseColor,
                tertiaryContainer = generateComplementaryColor(baseColor).copy(alpha = 0.2f),
                onTertiaryContainer = generateComplementaryColor(baseColor),
                
                // 错误色 - 保持原有的错误色
                error = PokemonError,
                onError = PokemonOnErrorDark,
                errorContainer = PokemonErrorDark,
                onErrorContainer = PokemonOnErrorDark,
                
                // 背景色 - 基于宝可梦类型的暗色变体
                background = generateDarkBackground(baseColor),
                onBackground = Color.White,
                surface = generateDarkSurface(baseColor),
                onSurface = Color.White,
                surfaceVariant = generateDarkSurfaceVariant(baseColor),
                onSurfaceVariant = Color.White.copy(alpha = 0.7f),
                
                // 轮廓色
                outline = baseColor.copy(alpha = 0.5f),
                outlineVariant = baseColor.copy(alpha = 0.3f),
                
                // 逆色
                inversePrimary = baseColor,
                inverseOnSurface = Color.Black,
                inverseSurface = Color.White,
                
                // 阴影色
                scrim = Color.Black.copy(alpha = 0.32f)
            )
        } else {
            lightColorScheme(
                // 主色调 - 基于宝可梦类型
                primary = baseColor,
                onPrimary = onBaseColor,
                primaryContainer = baseColor.copy(alpha = 0.2f),
                onPrimaryContainer = baseColor,
                
                // 次要色调 - 基于主色调的变体
                secondary = baseColor.copy(alpha = 0.8f),
                onSecondary = onBaseColor,
                secondaryContainer = baseColor.copy(alpha = 0.15f),
                onSecondaryContainer = baseColor,
                
                // 第三色调 - 基于主色调的互补色
                tertiary = generateComplementaryColor(baseColor),
                onTertiary = onBaseColor,
                tertiaryContainer = generateComplementaryColor(baseColor).copy(alpha = 0.2f),
                onTertiaryContainer = generateComplementaryColor(baseColor),
                
                // 错误色 - 保持原有的错误色
                error = PokemonError,
                onError = PokemonOnError,
                errorContainer = PokemonErrorLight,
                onErrorContainer = PokemonOnError,
                
                // 背景色 - 基于宝可梦类型的亮色变体
                background = generateLightBackground(baseColor),
                onBackground = Color.Black,
                surface = generateLightSurface(baseColor),
                onSurface = Color.Black,
                surfaceVariant = generateLightSurfaceVariant(baseColor),
                onSurfaceVariant = Color.Black.copy(alpha = 0.7f),
                
                // 轮廓色
                outline = baseColor.copy(alpha = 0.5f),
                outlineVariant = baseColor.copy(alpha = 0.3f),
                
                // 逆色
                inversePrimary = baseColor,
                inverseOnSurface = Color.White,
                inverseSurface = Color.Black,
                
                // 阴影色
                scrim = Color.Black.copy(alpha = 0.32f)
            )
        }
    }
    
    /**
     * 生成互补色
     */
    private fun generateComplementaryColor(color: Color): Color {
        val hsl = color.toHsl()
        return Color.hsl(
            hue = (hsl.hue + 180f) % 360f,
            saturation = hsl.saturation,
            lightness = hsl.lightness
        )
    }
    
    /**
     * 生成暗色背景
     */
    private fun generateDarkBackground(baseColor: Color): Color {
        return baseColor.copy(alpha = 0.05f).blendWith(Color.Black, 0.95f)
    }
    
    /**
     * 生成暗色表面
     */
    private fun generateDarkSurface(baseColor: Color): Color {
        return baseColor.copy(alpha = 0.08f).blendWith(Color.Black, 0.92f)
    }
    
    /**
     * 生成暗色表面变体
     */
    private fun generateDarkSurfaceVariant(baseColor: Color): Color {
        return baseColor.copy(alpha = 0.12f).blendWith(Color.Black, 0.88f)
    }
    
    /**
     * 生成亮色背景
     */
    private fun generateLightBackground(baseColor: Color): Color {
        return baseColor.copy(alpha = 0.02f).blendWith(Color.White, 0.98f)
    }
    
    /**
     * 生成亮色表面
     */
    private fun generateLightSurface(baseColor: Color): Color {
        return baseColor.copy(alpha = 0.03f).blendWith(Color.White, 0.97f)
    }
    
    /**
     * 生成亮色表面变体
     */
    private fun generateLightSurfaceVariant(baseColor: Color): Color {
        return baseColor.copy(alpha = 0.05f).blendWith(Color.White, 0.95f)
    }
}

// ===== 扩展函数：颜色混合 =====
fun Color.blendWith(other: Color, ratio: Float): Color {
    return Color(
        red = this.red * (1 - ratio) + other.red * ratio,
        green = this.green * (1 - ratio) + other.green * ratio,
        blue = this.blue * (1 - ratio) + other.blue * ratio,
        alpha = this.alpha * (1 - ratio) + other.alpha * ratio
    )
}

// ===== 扩展函数：颜色转HSL =====
fun Color.toHsl(): HslColor {
    val max = maxOf(red, green, blue)
    val min = minOf(red, green, blue)
    val delta = max - min
    
    val lightness = (max + min) / 2f
    
    val saturation = when {
        delta == 0f -> 0f
        else -> delta / (1f - abs(2f * lightness - 1f))
    }
    
    val hue = when {
        delta == 0f -> 0f
        max == red -> ((green - blue) / delta) % 6f
        max == green -> (blue - red) / delta + 2f
        else -> (red - green) / delta + 4f
    } * 60f
    
    return HslColor(
        hue = if (hue < 0f) hue + 360f else hue,
        saturation = saturation.coerceIn(0f, 1f),
        lightness = lightness.coerceIn(0f, 1f)
    )
}

// ===== HSL颜色数据类 =====
data class HslColor(
    val hue: Float,
    val saturation: Float,
    val lightness: Float
)

// ===== 扩展函数：HSL转Color =====
fun Color.Companion.hsl(hue: Float, saturation: Float, lightness: Float): Color {
    val c = (1f - abs(2f * lightness - 1f)) * saturation
    val x = c * (1f - abs((hue / 60f) % 2f - 1f))
    val m = lightness - c / 2f
    
    val (r, g, b) = when {
        hue < 60f -> Triple(c, x, 0f)
        hue < 120f -> Triple(x, c, 0f)
        hue < 180f -> Triple(0f, c, x)
        hue < 240f -> Triple(0f, x, c)
        hue < 300f -> Triple(x, 0f, c)
        else -> Triple(c, 0f, x)
    }
    
    return Color(
        red = (r + m).coerceIn(0f, 1f),
        green = (g + m).coerceIn(0f, 1f),
        blue = (b + m).coerceIn(0f, 1f),
        alpha = 1f
    )
}

// ===== 主题状态管理 =====
enum class PokemonThemeMode {
    LIGHT,      // 亮色主题
    DARK,       // 暗色主题
    SYSTEM,     // 跟随系统
    AUTO        // 自动切换
}

// 主题状态管理
class PokemonThemeStateManager {
    private var _currentTheme = mutableStateOf(PokemonThemeMode.SYSTEM)
    private var _selectedPokemonType = mutableStateOf<String?>(null)
    private var _useDynamicColors = mutableStateOf(true)
    
    val currentTheme: State<PokemonThemeMode> get() = _currentTheme
    val selectedPokemonType: State<String?> get() = _selectedPokemonType
    val useDynamicColors: State<Boolean> get() = _useDynamicColors
    
    fun setTheme(theme: PokemonThemeMode) {
        _currentTheme.value = theme
    }
    
    fun setPokemonType(type: String?) {
        _selectedPokemonType.value = type
    }
    
    fun setUseDynamicColors(use: Boolean) {
        _useDynamicColors.value = use
    }
    
    fun toggleTheme() {
        _currentTheme.value = when (_currentTheme.value) {
            PokemonThemeMode.LIGHT -> PokemonThemeMode.DARK
            PokemonThemeMode.DARK -> PokemonThemeMode.LIGHT
            PokemonThemeMode.SYSTEM -> PokemonThemeMode.LIGHT
            PokemonThemeMode.AUTO -> PokemonThemeMode.LIGHT
        }
    }
}

// 全局主题状态管理器实例
val PokemonThemeState = PokemonThemeStateManager()

// ===== 主题组合函数 =====
@Composable
fun PokemonWiki_ComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val view = LocalView.current
    
    // 使用 by 委托来监听主题状态变化，确保 Compose 重组
    val currentTheme by PokemonThemeState.currentTheme
    val selectedPokemonType by PokemonThemeState.selectedPokemonType
    val useDynamicColors by PokemonThemeState.useDynamicColors
    
    // 根据主题状态决定是否使用暗色主题
    val shouldUseDarkTheme = when (currentTheme) {
        PokemonThemeMode.LIGHT -> false
        PokemonThemeMode.DARK -> true
        PokemonThemeMode.SYSTEM -> darkTheme
        PokemonThemeMode.AUTO -> darkTheme
        else -> darkTheme
    }
    
    val colorScheme = when {
        // 优先使用宝可梦动态配色
        useDynamicColors && selectedPokemonType != null -> {
            PokemonDynamicColorGenerator.generateDynamicColorScheme(
                pokemonType = selectedPokemonType!!,
                isDark = shouldUseDarkTheme
            )
        }
        // 其次使用系统动态配色（Android 12+）
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (shouldUseDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        // 最后使用静态配色作为回退方案
        shouldUseDarkTheme -> PokemonDarkColorScheme
        else -> PokemonLightColorScheme
    }
    
    // 设置状态栏和导航栏颜色
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.primary.toArgb()
        window.navigationBarColor = colorScheme.surface.toArgb()
        
        // 设置状态栏图标颜色
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !shouldUseDarkTheme
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// ===== 主题切换组合函数 =====
@Composable
fun PokemonThemeProvider(
    content: @Composable () -> Unit
) {
    val currentTheme by PokemonThemeState.currentTheme
    
    CompositionLocalProvider(
        LocalPokemonTheme provides currentTheme
    ) {
        content()
    }
}

// ===== 本地主题提供者 =====
val LocalPokemonTheme = androidx.compose.runtime.staticCompositionLocalOf<PokemonThemeMode> {
    PokemonThemeMode.SYSTEM
}

// ===== 主题工具函数 =====
@Composable
fun rememberPokemonTheme(): PokemonThemeMode {
    val currentTheme by PokemonThemeState.currentTheme
    return currentTheme
}

@Composable
fun isPokemonDarkTheme(): Boolean {
    val currentTheme by PokemonThemeState.currentTheme
    return when (currentTheme) {
        PokemonThemeMode.LIGHT -> false
        PokemonThemeMode.DARK -> true
        PokemonThemeMode.SYSTEM -> isSystemInDarkTheme()
        PokemonThemeMode.AUTO -> isSystemInDarkTheme()
    }
}

// ===== 主题切换器 =====
@Composable
fun PokemonThemeSwitcher(
    onThemeChanged: (PokemonThemeMode) -> Unit = {}
) {
    val currentTheme = rememberPokemonTheme()
    
    // 这里可以添加主题切换UI组件
    // 例如：Switch、RadioButton等
}

// ===== 扩展函数：获取宝可梦类型颜色 =====
fun getPokemonTypeColor(type: String, isLight: Boolean = true): Color {
    return when (type.lowercase()) {
        "fire" -> if (isLight) PokemonFire else PokemonFireLight
        "water" -> if (isLight) PokemonWater else PokemonWaterLight
        "grass" -> if (isLight) PokemonGrass else PokemonGrassLight
        "electric" -> if (isLight) PokemonElectric else PokemonElectricLight
        "ice" -> if (isLight) PokemonIce else PokemonIceLight
        "fighting" -> if (isLight) PokemonFighting else PokemonFightingLight
        "poison" -> if (isLight) PokemonPoison else PokemonPoisonLight
        "ground" -> if (isLight) PokemonGround else PokemonGroundLight
        "flying" -> if (isLight) PokemonFlying else PokemonFlyingLight
        "psychic" -> if (isLight) PokemonPsychic else PokemonPsychicLight
        "bug" -> if (isLight) PokemonBug else PokemonBugLight
        "rock" -> if (isLight) PokemonRock else PokemonRockLight
        "ghost" -> if (isLight) PokemonGhost else PokemonGhostLight
        "steel" -> if (isLight) PokemonSteel else PokemonSteelLight
        "fairy" -> if (isLight) PokemonFairy else PokemonFairyLight
        "dragon" -> if (isLight) PokemonDragon else PokemonDragonLight
        "dark" -> if (isLight) PokemonDark else PokemonDarkLight
        else -> PokemonPrimary
    }
}