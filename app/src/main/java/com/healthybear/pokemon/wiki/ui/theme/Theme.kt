package com.healthybear.pokemon.wiki.ui.theme
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * 浅色主题标准对比度颜色方案
 * 使用 LightTheme.Standard 中定义的颜色，适用于大多数用户的日常使用场景
 */
private val lightScheme = lightColorScheme(
    primary = LightTheme.Standard.primary,
    onPrimary = LightTheme.Standard.onPrimary,
    primaryContainer = LightTheme.Standard.primaryContainer,
    onPrimaryContainer = LightTheme.Standard.onPrimaryContainer,
    secondary = LightTheme.Standard.secondary,
    onSecondary = LightTheme.Standard.onSecondary,
    secondaryContainer = LightTheme.Standard.secondaryContainer,
    onSecondaryContainer = LightTheme.Standard.onSecondaryContainer,
    tertiary = LightTheme.Standard.tertiary,
    onTertiary = LightTheme.Standard.onTertiary,
    tertiaryContainer = LightTheme.Standard.tertiaryContainer,
    onTertiaryContainer = LightTheme.Standard.onTertiaryContainer,
    error = LightTheme.Standard.error,
    onError = LightTheme.Standard.onError,
    errorContainer = LightTheme.Standard.errorContainer,
    onErrorContainer = LightTheme.Standard.onErrorContainer,
    background = LightTheme.Standard.background,
    onBackground = LightTheme.Standard.onBackground,
    surface = LightTheme.Standard.surface,
    onSurface = LightTheme.Standard.onSurface,
    surfaceVariant = LightTheme.Standard.surfaceVariant,
    onSurfaceVariant = LightTheme.Standard.onSurfaceVariant,
    outline = LightTheme.Standard.outline,
    outlineVariant = LightTheme.Standard.outlineVariant,
    scrim = LightTheme.Standard.scrim,
    inverseSurface = LightTheme.Standard.inverseSurface,
    inverseOnSurface = LightTheme.Standard.inverseOnSurface,
    inversePrimary = LightTheme.Standard.inversePrimary,
    surfaceDim = LightTheme.Standard.surfaceDim,
    surfaceBright = LightTheme.Standard.surfaceBright,
    surfaceContainerLowest = LightTheme.Standard.surfaceContainerLowest,
    surfaceContainerLow = LightTheme.Standard.surfaceContainerLow,
    surfaceContainer = LightTheme.Standard.surfaceContainer,
    surfaceContainerHigh = LightTheme.Standard.surfaceContainerHigh,
    surfaceContainerHighest = LightTheme.Standard.surfaceContainerHighest,
)

/**
 * 深色主题标准对比度颜色方案
 * 使用 DarkTheme.Standard 中定义的颜色，适用于夜间使用和节省电池电量
 */
private val darkScheme = darkColorScheme(
    primary = DarkTheme.Standard.primary,
    onPrimary = DarkTheme.Standard.onPrimary,
    primaryContainer = DarkTheme.Standard.primaryContainer,
    onPrimaryContainer = DarkTheme.Standard.onPrimaryContainer,
    secondary = DarkTheme.Standard.secondary,
    onSecondary = DarkTheme.Standard.onSecondary,
    secondaryContainer = DarkTheme.Standard.secondaryContainer,
    onSecondaryContainer = DarkTheme.Standard.onSecondaryContainer,
    tertiary = DarkTheme.Standard.tertiary,
    onTertiary = DarkTheme.Standard.onTertiary,
    tertiaryContainer = DarkTheme.Standard.tertiaryContainer,
    onTertiaryContainer = DarkTheme.Standard.onTertiaryContainer,
    error = DarkTheme.Standard.error,
    onError = DarkTheme.Standard.onError,
    errorContainer = DarkTheme.Standard.errorContainer,
    onErrorContainer = DarkTheme.Standard.onErrorContainer,
    background = DarkTheme.Standard.background,
    onBackground = DarkTheme.Standard.onBackground,
    surface = DarkTheme.Standard.surface,
    onSurface = DarkTheme.Standard.onSurface,
    surfaceVariant = DarkTheme.Standard.surfaceVariant,
    onSurfaceVariant = DarkTheme.Standard.onSurfaceVariant,
    outline = DarkTheme.Standard.outline,
    outlineVariant = DarkTheme.Standard.outlineVariant,
    scrim = DarkTheme.Standard.scrim,
    inverseSurface = DarkTheme.Standard.inverseSurface,
    inverseOnSurface = DarkTheme.Standard.inverseOnSurface,
    inversePrimary = DarkTheme.Standard.inversePrimary,
    surfaceDim = DarkTheme.Standard.surfaceDim,
    surfaceBright = DarkTheme.Standard.surfaceBright,
    surfaceContainerLowest = DarkTheme.Standard.surfaceContainerLowest,
    surfaceContainerLow = DarkTheme.Standard.surfaceContainerLow,
    surfaceContainer = DarkTheme.Standard.surfaceContainer,
    surfaceContainerHigh = DarkTheme.Standard.surfaceContainerHigh,
    surfaceContainerHighest = DarkTheme.Standard.surfaceContainerHighest,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = LightTheme.MediumContrast.primary,
    onPrimary = LightTheme.MediumContrast.onPrimary,
    primaryContainer = LightTheme.MediumContrast.primaryContainer,
    onPrimaryContainer = LightTheme.MediumContrast.onPrimaryContainer,
    secondary = LightTheme.MediumContrast.secondary,
    onSecondary = LightTheme.MediumContrast.onSecondary,
    secondaryContainer = LightTheme.MediumContrast.secondaryContainer,
    onSecondaryContainer = LightTheme.MediumContrast.onSecondaryContainer,
    tertiary = LightTheme.MediumContrast.tertiary,
    onTertiary = LightTheme.MediumContrast.onTertiary,
    tertiaryContainer = LightTheme.MediumContrast.tertiaryContainer,
    onTertiaryContainer = LightTheme.MediumContrast.onTertiaryContainer,
    error = LightTheme.MediumContrast.error,
    onError = LightTheme.MediumContrast.onError,
    errorContainer = LightTheme.MediumContrast.errorContainer,
    onErrorContainer = LightTheme.MediumContrast.onErrorContainer,
    background = LightTheme.MediumContrast.background,
    onBackground = LightTheme.MediumContrast.onBackground,
    surface = LightTheme.MediumContrast.surface,
    onSurface = LightTheme.MediumContrast.onSurface,
    surfaceVariant = LightTheme.MediumContrast.surfaceVariant,
    onSurfaceVariant = LightTheme.MediumContrast.onSurfaceVariant,
    outline = LightTheme.MediumContrast.outline,
    outlineVariant = LightTheme.MediumContrast.outlineVariant,
    scrim = LightTheme.MediumContrast.scrim,
    inverseSurface = LightTheme.MediumContrast.inverseSurface,
    inverseOnSurface = LightTheme.MediumContrast.inverseOnSurface,
    inversePrimary = LightTheme.MediumContrast.inversePrimary,
    surfaceDim = LightTheme.MediumContrast.surfaceDim,
    surfaceBright = LightTheme.MediumContrast.surfaceBright,
    surfaceContainerLowest = LightTheme.MediumContrast.surfaceContainerLowest,
    surfaceContainerLow = LightTheme.MediumContrast.surfaceContainerLow,
    surfaceContainer = LightTheme.MediumContrast.surfaceContainer,
    surfaceContainerHigh = LightTheme.MediumContrast.surfaceContainerHigh,
    surfaceContainerHighest = LightTheme.MediumContrast.surfaceContainerHighest,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = LightTheme.HighContrast.primary,
    onPrimary = LightTheme.HighContrast.onPrimary,
    primaryContainer = LightTheme.HighContrast.primaryContainer,
    onPrimaryContainer = LightTheme.HighContrast.onPrimaryContainer,
    secondary = LightTheme.HighContrast.secondary,
    onSecondary = LightTheme.HighContrast.onSecondary,
    secondaryContainer = LightTheme.HighContrast.secondaryContainer,
    onSecondaryContainer = LightTheme.HighContrast.onSecondaryContainer,
    tertiary = LightTheme.HighContrast.tertiary,
    onTertiary = LightTheme.HighContrast.onTertiary,
    tertiaryContainer = LightTheme.HighContrast.tertiaryContainer,
    onTertiaryContainer = LightTheme.HighContrast.onTertiaryContainer,
    error = LightTheme.HighContrast.error,
    onError = LightTheme.HighContrast.onError,
    errorContainer = LightTheme.HighContrast.errorContainer,
    onErrorContainer = LightTheme.HighContrast.onErrorContainer,
    background = LightTheme.HighContrast.background,
    onBackground = LightTheme.HighContrast.onBackground,
    surface = LightTheme.HighContrast.surface,
    onSurface = LightTheme.HighContrast.onSurface,
    surfaceVariant = LightTheme.HighContrast.surfaceVariant,
    onSurfaceVariant = LightTheme.HighContrast.onSurfaceVariant,
    outline = LightTheme.HighContrast.outline,
    outlineVariant = LightTheme.HighContrast.outlineVariant,
    scrim = LightTheme.HighContrast.scrim,
    inverseSurface = LightTheme.HighContrast.inverseSurface,
    inverseOnSurface = LightTheme.HighContrast.inverseOnSurface,
    inversePrimary = LightTheme.HighContrast.inversePrimary,
    surfaceDim = LightTheme.HighContrast.surfaceDim,
    surfaceBright = LightTheme.HighContrast.surfaceBright,
    surfaceContainerLowest = LightTheme.HighContrast.surfaceContainerLowest,
    surfaceContainerLow = LightTheme.HighContrast.surfaceContainerLow,
    surfaceContainer = LightTheme.HighContrast.surfaceContainer,
    surfaceContainerHigh = LightTheme.HighContrast.surfaceContainerHigh,
    surfaceContainerHighest = LightTheme.HighContrast.surfaceContainerHighest,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = DarkTheme.MediumContrast.primary,
    onPrimary = DarkTheme.MediumContrast.onPrimary,
    primaryContainer = DarkTheme.MediumContrast.primaryContainer,
    onPrimaryContainer = DarkTheme.MediumContrast.onPrimaryContainer,
    secondary = DarkTheme.MediumContrast.secondary,
    onSecondary = DarkTheme.MediumContrast.onSecondary,
    secondaryContainer = DarkTheme.MediumContrast.secondaryContainer,
    onSecondaryContainer = DarkTheme.MediumContrast.onSecondaryContainer,
    tertiary = DarkTheme.MediumContrast.tertiary,
    onTertiary = DarkTheme.MediumContrast.onTertiary,
    tertiaryContainer = DarkTheme.MediumContrast.tertiaryContainer,
    onTertiaryContainer = DarkTheme.MediumContrast.onTertiaryContainer,
    error = DarkTheme.MediumContrast.error,
    onError = DarkTheme.MediumContrast.onError,
    errorContainer = DarkTheme.MediumContrast.errorContainer,
    onErrorContainer = DarkTheme.MediumContrast.onErrorContainer,
    background = DarkTheme.MediumContrast.background,
    onBackground = DarkTheme.MediumContrast.onBackground,
    surface = DarkTheme.MediumContrast.surface,
    onSurface = DarkTheme.MediumContrast.onSurface,
    surfaceVariant = DarkTheme.MediumContrast.surfaceVariant,
    onSurfaceVariant = DarkTheme.MediumContrast.onSurfaceVariant,
    outline = DarkTheme.MediumContrast.outline,
    outlineVariant = DarkTheme.MediumContrast.outlineVariant,
    scrim = DarkTheme.MediumContrast.scrim,
    inverseSurface = DarkTheme.MediumContrast.inverseSurface,
    inverseOnSurface = DarkTheme.MediumContrast.inverseOnSurface,
    inversePrimary = DarkTheme.MediumContrast.inversePrimary,
    surfaceDim = DarkTheme.MediumContrast.surfaceDim,
    surfaceBright = DarkTheme.MediumContrast.surfaceBright,
    surfaceContainerLowest = DarkTheme.MediumContrast.surfaceContainerLowest,
    surfaceContainerLow = DarkTheme.MediumContrast.surfaceContainerLow,
    surfaceContainer = DarkTheme.MediumContrast.surfaceContainer,
    surfaceContainerHigh = DarkTheme.MediumContrast.surfaceContainerHigh,
    surfaceContainerHighest = DarkTheme.MediumContrast.surfaceContainerHighest,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = DarkTheme.HighContrast.primary,
    onPrimary = DarkTheme.HighContrast.onPrimary,
    primaryContainer = DarkTheme.HighContrast.primaryContainer,
    onPrimaryContainer = DarkTheme.HighContrast.onPrimaryContainer,
    secondary = DarkTheme.HighContrast.secondary,
    onSecondary = DarkTheme.HighContrast.onSecondary,
    secondaryContainer = DarkTheme.HighContrast.secondaryContainer,
    onSecondaryContainer = DarkTheme.HighContrast.onSecondaryContainer,
    tertiary = DarkTheme.HighContrast.tertiary,
    onTertiary = DarkTheme.HighContrast.onTertiary,
    tertiaryContainer = DarkTheme.HighContrast.tertiaryContainer,
    onTertiaryContainer = DarkTheme.HighContrast.onTertiaryContainer,
    error = DarkTheme.HighContrast.error,
    onError = DarkTheme.HighContrast.onError,
    errorContainer = DarkTheme.HighContrast.errorContainer,
    onErrorContainer = DarkTheme.HighContrast.onErrorContainer,
    background = DarkTheme.HighContrast.background,
    onBackground = DarkTheme.HighContrast.onBackground,
    surface = DarkTheme.HighContrast.surface,
    onSurface = DarkTheme.HighContrast.onSurface,
    surfaceVariant = DarkTheme.HighContrast.surfaceVariant,
    onSurfaceVariant = DarkTheme.HighContrast.onSurfaceVariant,
    outline = DarkTheme.HighContrast.outline,
    outlineVariant = DarkTheme.HighContrast.outlineVariant,
    scrim = DarkTheme.HighContrast.scrim,
    inverseSurface = DarkTheme.HighContrast.inverseSurface,
    inverseOnSurface = DarkTheme.HighContrast.inverseOnSurface,
    inversePrimary = DarkTheme.HighContrast.inversePrimary,
    surfaceDim = DarkTheme.HighContrast.surfaceDim,
    surfaceBright = DarkTheme.HighContrast.surfaceBright,
    surfaceContainerLowest = DarkTheme.HighContrast.surfaceContainerLowest,
    surfaceContainerLow = DarkTheme.HighContrast.surfaceContainerLow,
    surfaceContainer = DarkTheme.HighContrast.surfaceContainer,
    surfaceContainerHigh = DarkTheme.HighContrast.surfaceContainerHigh,
    surfaceContainerHighest = DarkTheme.HighContrast.surfaceContainerHighest,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

