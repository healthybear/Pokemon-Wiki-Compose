package com.healthybear.pokemon.wiki.ui.theme
import androidx.compose.ui.graphics.Color

/**
 * 浅色主题颜色调色板，包含不同对比度级别
 * 用于定义应用在浅色模式下的所有颜色方案，支持标准、中等和高对比度三种级别
 */
object LightTheme {
    
    /**
     * 标准对比度浅色主题
     * 适用于大多数用户的日常使用场景，提供良好的视觉体验和可读性
     */
    object Standard {
        /** 主要颜色 - 用于应用的主要品牌色彩，如主要按钮、重要元素等 */
        val primary = Color(0xFF984300)
        /** 主要颜色上的文本颜色 - 在主要颜色背景上显示的文本和图标颜色 */
        val onPrimary = Color(0xFFFFFFFF)
        /** 主要容器颜色 - 用于包含主要内容的容器背景色 */
        val primaryContainer = Color(0xFFBC570E)
        /** 主要容器上的文本颜色 - 在主要容器背景上显示的文本和图标颜色 */
        val onPrimaryContainer = Color(0xFFFFFBFF)
        /** 次要颜色 - 用于辅助元素，提供视觉层次和强调作用 */
        val secondary = Color(0xFF855234)
        /** 次要颜色上的文本颜色 - 在次要颜色背景上显示的文本和图标颜色 */
        val onSecondary = Color(0xFFFFFFFF)
        /** 次要容器颜色 - 用于包含次要内容的容器背景色 */
        val secondaryContainer = Color(0xFFFEBA96)
        /** 次要容器上的文本颜色 - 在次要容器背景上显示的文本和图标颜色 */
        val onSecondaryContainer = Color(0xFF79482B)
        /** 第三级颜色 - 用于强调和区分特定元素，增加视觉丰富性 */
        val tertiary = Color(0xFF5E5F00)
        /** 第三级颜色上的文本颜色 - 在第三级颜色背景上显示的文本和图标颜色 */
        val onTertiary = Color(0xFFFFFFFF)
        /** 第三级容器颜色 - 用于包含第三级内容的容器背景色 */
        val tertiaryContainer = Color(0xFF777900)
        /** 第三级容器上的文本颜色 - 在第三级容器背景上显示的文本和图标颜色 */
        val onTertiaryContainer = Color(0xFFFFFBFF)
        /** 错误颜色 - 用于显示错误状态、警告信息和危险操作 */
        val error = Color(0xFFBA1A1A)
        /** 错误颜色上的文本颜色 - 在错误颜色背景上显示的文本和图标颜色 */
        val onError = Color(0xFFFFFFFF)
        /** 错误容器颜色 - 用于包含错误信息的容器背景色 */
        val errorContainer = Color(0xFFFFDAD6)
        /** 错误容器上的文本颜色 - 在错误容器背景上显示的文本和图标颜色 */
        val onErrorContainer = Color(0xFF93000A)
        /** 背景颜色 - 应用的主要背景色，为整个界面提供基础色调 */
        val background = Color(0xFFFFF8F6)
        /** 背景上的文本颜色 - 在背景色上显示的主要文本和图标颜色 */
        val onBackground = Color(0xFF241914)
        /** 表面颜色 - 用于卡片、对话框等表面元素的背景色 */
        val surface = Color(0xFFFFF8F6)
        /** 表面上的文本颜色 - 在表面色上显示的文本和图标颜色 */
        val onSurface = Color(0xFF241914)
        /** 表面变体颜色 - 用于需要与主表面区分的次级表面元素 */
        val surfaceVariant = Color(0xFFFADCCE)
        /** 表面变体上的文本颜色 - 在表面变体色上显示的文本和图标颜色 */
        val onSurfaceVariant = Color(0xFF564238)
        /** 轮廓颜色 - 用于边框、分割线等轮廓元素 */
        val outline = Color(0xFF8A7266)
        /** 轮廓变体颜色 - 用于需要更柔和轮廓效果的元素 */
        val outlineVariant = Color(0xFFDDC1B3)
        /** 遮罩颜色 - 用于模态对话框、底部表单等的背景遮罩 */
        val scrim = Color(0xFF000000)
        /** 反转表面颜色 - 用于需要与主题相反色调的表面元素 */
        val inverseSurface = Color(0xFF3A2E28)
        /** 反转表面上的文本颜色 - 在反转表面色上显示的文本和图标颜色 */
        val inverseOnSurface = Color(0xFFFFEDE5)
        /** 反转主要颜色 - 用于在反转表面上显示的主要颜色元素 */
        val inversePrimary = Color(0xFFFFB68F)
        /** 暗淡表面颜色 - 用于需要降低视觉重要性的表面元素 */
        val surfaceDim = Color(0xFFEAD6CD)
        /** 明亮表面颜色 - 用于需要突出显示的表面元素 */
        val surfaceBright = Color(0xFFFFF8F6)
        /** 最低层级表面容器颜色 - 用于最底层的容器元素 */
        val surfaceContainerLowest = Color(0xFFFFFFFF)
        /** 低层级表面容器颜色 - 用于较低层级的容器元素 */
        val surfaceContainerLow = Color(0xFFFFF1EB)
        /** 标准表面容器颜色 - 用于标准层级的容器元素 */
        val surfaceContainer = Color(0xFFFEEAE1)
        /** 高层级表面容器颜色 - 用于较高层级的容器元素 */
        val surfaceContainerHigh = Color(0xFFF9E4DB)
        /** 最高层级表面容器颜色 - 用于最顶层的容器元素 */
        val surfaceContainerHighest = Color(0xFFF3DED5)
    }
    
    /**
     * 中等对比度浅色主题
     * 适用于需要更好可读性的用户，提供比标准对比度更强的视觉区分
     */
    object MediumContrast {
        /** 主要颜色 - 中等对比度下的主要品牌色彩，颜色更深以提高对比度 */
        val primary = Color(0xFF5D2600)
        /** 主要颜色上的文本颜色 - 在中等对比度主要颜色背景上的文本颜色 */
        val onPrimary = Color(0xFFFFFFFF)
        /** 主要容器颜色 - 中等对比度下的主要容器背景色 */
        val primaryContainer = Color(0xFFB25003)
        /** 主要容器上的文本颜色 - 在中等对比度主要容器背景上的文本颜色 */
        val onPrimaryContainer = Color(0xFFFFFFFF)
        /** 次要颜色 - 中等对比度下的次要色彩，增强视觉层次 */
        val secondary = Color(0xFF552B11)
        /** 次要颜色上的文本颜色 - 在中等对比度次要颜色背景上的文本颜色 */
        val onSecondary = Color(0xFFFFFFFF)
        /** 次要容器颜色 - 中等对比度下的次要容器背景色 */
        val secondaryContainer = Color(0xFF966042)
        /** 次要容器上的文本颜色 - 在中等对比度次要容器背景上的文本颜色 */
        val onSecondaryContainer = Color(0xFFFFFFFF)
        /** 第三级颜色 - 中等对比度下的第三级色彩，提供更强的视觉区分 */
        val tertiary = Color(0xFF383800)
        /** 第三级颜色上的文本颜色 - 在中等对比度第三级颜色背景上的文本颜色 */
        val onTertiary = Color(0xFFFFFFFF)
        /** 第三级容器颜色 - 中等对比度下的第三级容器背景色 */
        val tertiaryContainer = Color(0xFF707100)
        /** 第三级容器上的文本颜色 - 在中等对比度第三级容器背景上的文本颜色 */
        val onTertiaryContainer = Color(0xFFFFFFFF)
        /** 错误颜色 - 中等对比度下的错误状态颜色，更加醒目 */
        val error = Color(0xFF740006)
        /** 错误颜色上的文本颜色 - 在中等对比度错误颜色背景上的文本颜色 */
        val onError = Color(0xFFFFFFFF)
        /** 错误容器颜色 - 中等对比度下的错误容器背景色 */
        val errorContainer = Color(0xFFCF2C27)
        /** 错误容器上的文本颜色 - 在中等对比度错误容器背景上的文本颜色 */
        val onErrorContainer = Color(0xFFFFFFFF)
        /** 背景颜色 - 中等对比度下的应用主要背景色 */
        val background = Color(0xFFFFF8F6)
        /** 背景上的文本颜色 - 在中等对比度背景色上的文本颜色 */
        val onBackground = Color(0xFF241914)
        /** 表面颜色 - 中等对比度下的表面元素背景色 */
        val surface = Color(0xFFFFF8F6)
        /** 表面上的文本颜色 - 在中等对比度表面色上的文本颜色，更深以提高可读性 */
        val onSurface = Color(0xFF180F0A)
        /** 表面变体颜色 - 中等对比度下的表面变体背景色 */
        val surfaceVariant = Color(0xFFFADCCE)
        /** 表面变体上的文本颜色 - 在中等对比度表面变体色上的文本颜色 */
        val onSurfaceVariant = Color(0xFF443229)
        /** 轮廓颜色 - 中等对比度下的边框和分割线颜色，更加明显 */
        val outline = Color(0xFF634E43)
        /** 轮廓变体颜色 - 中等对比度下的柔和轮廓颜色 */
        val outlineVariant = Color(0xFF7F685D)
        /** 遮罩颜色 - 中等对比度下的背景遮罩颜色 */
        val scrim = Color(0xFF000000)
        /** 反转表面颜色 - 中等对比度下的反转表面背景色 */
        val inverseSurface = Color(0xFF3A2E28)
        /** 反转表面上的文本颜色 - 在中等对比度反转表面色上的文本颜色 */
        val inverseOnSurface = Color(0xFFFFEDE5)
        /** 反转主要颜色 - 中等对比度下的反转主要颜色 */
        val inversePrimary = Color(0xFFFFB68F)
        /** 暗淡表面颜色 - 中等对比度下的暗淡表面背景色 */
        val surfaceDim = Color(0xFFD6C3BA)
        /** 明亮表面颜色 - 中等对比度下的明亮表面背景色 */
        val surfaceBright = Color(0xFFFFF8F6)
        /** 最低层级表面容器颜色 - 中等对比度下的最底层容器背景色 */
        val surfaceContainerLowest = Color(0xFFFFFFFF)
        /** 低层级表面容器颜色 - 中等对比度下的较低层级容器背景色 */
        val surfaceContainerLow = Color(0xFFFFF1EB)
        /** 标准表面容器颜色 - 中等对比度下的标准层级容器背景色 */
        val surfaceContainer = Color(0xFFF9E4DB)
        /** 高层级表面容器颜色 - 中等对比度下的较高层级容器背景色 */
        val surfaceContainerHigh = Color(0xFFEDD9D0)
        /** 最高层级表面容器颜色 - 中等对比度下的最顶层容器背景色 */
        val surfaceContainerHighest = Color(0xFFE1CEC5)
    }
    
    /**
     * 高对比度浅色主题
     * 适用于视力障碍用户或需要最大可读性的场景，提供最强的颜色对比度
     */
    object HighContrast {
        /** 主要颜色 - 高对比度下的主要品牌色彩，颜色最深以确保最佳可读性 */
        val primary = Color(0xFF4D1E00)
        /** 主要颜色上的文本颜色 - 在高对比度主要颜色背景上的文本颜色 */
        val onPrimary = Color(0xFFFFFFFF)
        /** 主要容器颜色 - 高对比度下的主要容器背景色 */
        val primaryContainer = Color(0xFF7B3400)
        /** 主要容器上的文本颜色 - 在高对比度主要容器背景上的文本颜色 */
        val onPrimaryContainer = Color(0xFFFFFFFF)
        /** 次要颜色 - 高对比度下的次要色彩，确保最大视觉区分 */
        val secondary = Color(0xFF492107)
        /** 次要颜色上的文本颜色 - 在高对比度次要颜色背景上的文本颜色 */
        val onSecondary = Color(0xFFFFFFFF)
        /** 次要容器颜色 - 高对比度下的次要容器背景色 */
        val secondaryContainer = Color(0xFF6C3D21)
        /** 次要容器上的文本颜色 - 在高对比度次要容器背景上的文本颜色 */
        val onSecondaryContainer = Color(0xFFFFFFFF)
        /** 第三级颜色 - 高对比度下的第三级色彩，提供最强的视觉对比 */
        val tertiary = Color(0xFF2D2E00)
        /** 第三级颜色上的文本颜色 - 在高对比度第三级颜色背景上的文本颜色 */
        val onTertiary = Color(0xFFFFFFFF)
        /** 第三级容器颜色 - 高对比度下的第三级容器背景色 */
        val tertiaryContainer = Color(0xFF4B4C00)
        /** 第三级容器上的文本颜色 - 在高对比度第三级容器背景上的文本颜色 */
        val onTertiaryContainer = Color(0xFFFFFFFF)
        /** 错误颜色 - 高对比度下的错误状态颜色，最为醒目和警示 */
        val error = Color(0xFF600004)
        /** 错误颜色上的文本颜色 - 在高对比度错误颜色背景上的文本颜色 */
        val onError = Color(0xFFFFFFFF)
        /** 错误容器颜色 - 高对比度下的错误容器背景色 */
        val errorContainer = Color(0xFF98000A)
        /** 错误容器上的文本颜色 - 在高对比度错误容器背景上的文本颜色 */
        val onErrorContainer = Color(0xFFFFFFFF)
        /** 背景颜色 - 高对比度下的应用主要背景色 */
        val background = Color(0xFFFFF8F6)
        /** 背景上的文本颜色 - 在高对比度背景色上的文本颜色 */
        val onBackground = Color(0xFF241914)
        /** 表面颜色 - 高对比度下的表面元素背景色 */
        val surface = Color(0xFFFFF8F6)
        /** 表面上的文本颜色 - 在高对比度表面色上的文本颜色，使用纯黑色确保最佳对比度 */
        val onSurface = Color(0xFF000000)
        /** 表面变体颜色 - 高对比度下的表面变体背景色 */
        val surfaceVariant = Color(0xFFFADCCE)
        /** 表面变体上的文本颜色 - 在高对比度表面变体色上的文本颜色，使用纯黑色 */
        val onSurfaceVariant = Color(0xFF000000)
        /** 轮廓颜色 - 高对比度下的边框和分割线颜色，最为明显 */
        val outline = Color(0xFF3A281F)
        /** 轮廓变体颜色 - 高对比度下的柔和轮廓颜色 */
        val outlineVariant = Color(0xFF59453B)
        /** 遮罩颜色 - 高对比度下的背景遮罩颜色 */
        val scrim = Color(0xFF000000)
        /** 反转表面颜色 - 高对比度下的反转表面背景色 */
        val inverseSurface = Color(0xFF3A2E28)
        /** 反转表面上的文本颜色 - 在高对比度反转表面色上的文本颜色 */
        val inverseOnSurface = Color(0xFFFFFFFF)
        /** 反转主要颜色 - 高对比度下的反转主要颜色 */
        val inversePrimary = Color(0xFFFFB68F)
        /** 暗淡表面颜色 - 高对比度下的暗淡表面背景色 */
        val surfaceDim = Color(0xFFC8B5AC)
        /** 明亮表面颜色 - 高对比度下的明亮表面背景色 */
        val surfaceBright = Color(0xFFFFF8F6)
        /** 最低层级表面容器颜色 - 高对比度下的最底层容器背景色 */
        val surfaceContainerLowest = Color(0xFFFFFFFF)
        /** 低层级表面容器颜色 - 高对比度下的较低层级容器背景色 */
        val surfaceContainerLow = Color(0xFFFFEDE5)
        /** 标准表面容器颜色 - 高对比度下的标准层级容器背景色 */
        val surfaceContainer = Color(0xFFF3DED5)
        /** 高层级表面容器颜色 - 高对比度下的较高层级容器背景色 */
        val surfaceContainerHigh = Color(0xFFE4D0C8)
        /** 最高层级表面容器颜色 - 高对比度下的最顶层容器背景色 */
        val surfaceContainerHighest = Color(0xFFD6C3BA)
    }
}

/**
 * 深色主题颜色调色板，包含不同对比度级别
 * 用于定义应用在深色模式下的所有颜色方案，适合夜间使用和节省电池电量
 */
object DarkTheme {
    
    /**
     * 标准对比度深色主题
     * 适用于大多数用户的夜间使用场景，提供舒适的视觉体验并减少眼部疲劳
     */
    object Standard {
        /** 主要颜色 - 深色主题下的主要品牌色彩，通常比浅色主题更亮以确保可见性 */
        val primary = Color(0xFFFFB68F)
        /** 主要颜色上的文本颜色 - 在深色主题主要颜色背景上显示的文本和图标颜色 */
        val onPrimary = Color(0xFF542200)
        /** 主要容器颜色 - 深色主题下的主要容器背景色 */
        val primaryContainer = Color(0xFFE0722B)
        /** 主要容器上的文本颜色 - 在深色主题主要容器背景上显示的文本和图标颜色 */
        val onPrimaryContainer = Color(0xFF3F1800)
        /** 次要颜色 - 深色主题下的次要色彩，提供视觉层次和强调作用 */
        val secondary = Color(0xFFFBB793)
        /** 次要颜色上的文本颜色 - 在深色主题次要颜色背景上显示的文本和图标颜色 */
        val onSecondary = Color(0xFF4E250B)
        /** 次要容器颜色 - 深色主题下的次要容器背景色 */
        val secondaryContainer = Color(0xFF6C3D21)
        /** 次要容器上的文本颜色 - 在深色主题次要容器背景上显示的文本和图标颜色 */
        val onSecondaryContainer = Color(0xFFECAA86)
        /** 第三级颜色 - 深色主题下的第三级色彩，增加视觉丰富性 */
        val tertiary = Color(0xFFCBCD48)
        /** 第三级颜色上的文本颜色 - 在深色主题第三级颜色背景上显示的文本和图标颜色 */
        val onTertiary = Color(0xFF323200)
        /** 第三级容器颜色 - 深色主题下的第三级容器背景色 */
        val tertiaryContainer = Color(0xFF94960D)
        /** 第三级容器上的文本颜色 - 在深色主题第三级容器背景上显示的文本和图标颜色 */
        val onTertiaryContainer = Color(0xFF242500)
        /** 错误颜色 - 深色主题下的错误状态颜色，通常比浅色主题更柔和 */
        val error = Color(0xFFFFB4AB)
        /** 错误颜色上的文本颜色 - 在深色主题错误颜色背景上显示的文本和图标颜色 */
        val onError = Color(0xFF690005)
        /** 错误容器颜色 - 深色主题下的错误容器背景色 */
        val errorContainer = Color(0xFF93000A)
        /** 错误容器上的文本颜色 - 在深色主题错误容器背景上显示的文本和图标颜色 */
        val onErrorContainer = Color(0xFFFFDAD6)
        /** 背景颜色 - 深色主题的主要背景色，通常为深色调以减少眼部疲劳 */
        val background = Color(0xFF1B110C)
        /** 背景上的文本颜色 - 在深色主题背景色上显示的主要文本和图标颜色 */
        val onBackground = Color(0xFFF3DED5)
        /** 表面颜色 - 深色主题下卡片、对话框等表面元素的背景色 */
        val surface = Color(0xFF1B110C)
        /** 表面上的文本颜色 - 在深色主题表面色上显示的文本和图标颜色 */
        val onSurface = Color(0xFFF3DED5)
        /** 表面变体颜色 - 深色主题下需要与主表面区分的次级表面元素颜色 */
        val surfaceVariant = Color(0xFF564238)
        /** 表面变体上的文本颜色 - 在深色主题表面变体色上显示的文本和图标颜色 */
        val onSurfaceVariant = Color(0xFFDDC1B3)
        /** 轮廓颜色 - 深色主题下的边框、分割线等轮廓元素颜色 */
        val outline = Color(0xFFA58C7F)
        /** 轮廓变体颜色 - 深色主题下需要更柔和轮廓效果的元素颜色 */
        val outlineVariant = Color(0xFF564238)
        /** 遮罩颜色 - 深色主题下模态对话框、底部表单等的背景遮罩颜色 */
        val scrim = Color(0xFF000000)
        /** 反转表面颜色 - 深色主题下需要与主题相反色调的表面元素颜色 */
        val inverseSurface = Color(0xFFF3DED5)
        /** 反转表面上的文本颜色 - 在深色主题反转表面色上显示的文本和图标颜色 */
        val inverseOnSurface = Color(0xFF3A2E28)
        /** 反转主要颜色 - 深色主题下在反转表面上显示的主要颜色元素 */
        val inversePrimary = Color(0xFF9C4400)
        /** 暗淡表面颜色 - 深色主题下需要降低视觉重要性的表面元素颜色 */
        val surfaceDim = Color(0xFF1B110C)
        /** 明亮表面颜色 - 深色主题下需要突出显示的表面元素颜色 */
        val surfaceBright = Color(0xFF433730)
        /** 最低层级表面容器颜色 - 深色主题下最底层的容器元素颜色 */
        val surfaceContainerLowest = Color(0xFF150C07)
        /** 低层级表面容器颜色 - 深色主题下较低层级的容器元素颜色 */
        val surfaceContainerLow = Color(0xFF241914)
        /** 标准表面容器颜色 - 深色主题下标准层级的容器元素颜色 */
        val surfaceContainer = Color(0xFF281D18)
        /** 高层级表面容器颜色 - 深色主题下较高层级的容器元素颜色 */
        val surfaceContainerHigh = Color(0xFF332822)
        /** 最高层级表面容器颜色 - 深色主题下最顶层的容器元素颜色 */
        val surfaceContainerHighest = Color(0xFF3E322C)
    }
    
    /**
     * 中等对比度深色主题
     * 适用于需要更好可读性的深色环境，提供比标准深色主题更强的视觉区分
     */
    object MediumContrast {
        /** 主要颜色 - 中等对比度深色主题下的主要品牌色彩，更亮以提高对比度 */
        val primary = Color(0xFFFFD3BD)
        /** 主要颜色上的文本颜色 - 在中等对比度深色主题主要颜色背景上的文本颜色 */
        val onPrimary = Color(0xFF431900)
        /** 主要容器颜色 - 中等对比度深色主题下的主要容器背景色 */
        val primaryContainer = Color(0xFFE0722B)
        /** 主要容器上的文本颜色 - 在中等对比度深色主题主要容器背景上的文本颜色 */
        val onPrimaryContainer = Color(0xFF000000)
        /** 次要颜色 - 中等对比度深色主题下的次要色彩，增强视觉层次 */
        val secondary = Color(0xFFFFD3BD)
        /** 次要颜色上的文本颜色 - 在中等对比度深色主题次要颜色背景上的文本颜色 */
        val onSecondary = Color(0xFF411B03)
        /** 次要容器颜色 - 中等对比度深色主题下的次要容器背景色 */
        val secondaryContainer = Color(0xFFBF8362)
        /** 次要容器上的文本颜色 - 在中等对比度深色主题次要容器背景上的文本颜色 */
        val onSecondaryContainer = Color(0xFF000000)
        /** 第三级颜色 - 中等对比度深色主题下的第三级色彩，提供更强的视觉区分 */
        val tertiary = Color(0xFFE1E35C)
        /** 第三级颜色上的文本颜色 - 在中等对比度深色主题第三级颜色背景上的文本颜色 */
        val onTertiary = Color(0xFF272700)
        /** 第三级容器颜色 - 中等对比度深色主题下的第三级容器背景色 */
        val tertiaryContainer = Color(0xFF94960D)
        /** 第三级容器上的文本颜色 - 在中等对比度深色主题第三级容器背景上的文本颜色 */
        val onTertiaryContainer = Color(0xFF000000)
        /** 错误颜色 - 中等对比度深色主题下的错误状态颜色，更加醒目 */
        val error = Color(0xFFFFD2CC)
        /** 错误颜色上的文本颜色 - 在中等对比度深色主题错误颜色背景上的文本颜色 */
        val onError = Color(0xFF540003)
        /** 错误容器颜色 - 中等对比度深色主题下的错误容器背景色 */
        val errorContainer = Color(0xFFFF5449)
        /** 错误容器上的文本颜色 - 在中等对比度深色主题错误容器背景上的文本颜色 */
        val onErrorContainer = Color(0xFF000000)
        /** 背景颜色 - 中等对比度深色主题下的应用主要背景色 */
        val background = Color(0xFF1B110C)
        /** 背景上的文本颜色 - 在中等对比度深色主题背景色上的文本颜色 */
        val onBackground = Color(0xFFF3DED5)
        /** 表面颜色 - 中等对比度深色主题下的表面元素背景色 */
        val surface = Color(0xFF1B110C)
        /** 表面上的文本颜色 - 在中等对比度深色主题表面色上的文本颜色，使用纯白色提高可读性 */
        val onSurface = Color(0xFFFFFFFF)
        /** 表面变体颜色 - 中等对比度深色主题下的表面变体背景色 */
        val surfaceVariant = Color(0xFF564238)
        /** 表面变体上的文本颜色 - 在中等对比度深色主题表面变体色上的文本颜色 */
        val onSurfaceVariant = Color(0xFFF4D6C8)
        /** 轮廓颜色 - 中等对比度深色主题下的边框和分割线颜色，更加明显 */
        val outline = Color(0xFFC8AC9F)
        /** 轮廓变体颜色 - 中等对比度深色主题下的柔和轮廓颜色 */
        val outlineVariant = Color(0xFFA48B7F)
        /** 遮罩颜色 - 中等对比度深色主题下的背景遮罩颜色 */
        val scrim = Color(0xFF000000)
        /** 反转表面颜色 - 中等对比度深色主题下的反转表面背景色 */
        val inverseSurface = Color(0xFFF3DED5)
        /** 反转表面上的文本颜色 - 在中等对比度深色主题反转表面色上的文本颜色 */
        val inverseOnSurface = Color(0xFF332822)
        /** 反转主要颜色 - 中等对比度深色主题下的反转主要颜色 */
        val inversePrimary = Color(0xFF793300)
        /** 暗淡表面颜色 - 中等对比度深色主题下的暗淡表面背景色 */
        val surfaceDim = Color(0xFF1B110C)
        /** 明亮表面颜色 - 中等对比度深色主题下的明亮表面背景色 */
        val surfaceBright = Color(0xFF4F423B)
        /** 最低层级表面容器颜色 - 中等对比度深色主题下的最底层容器背景色 */
        val surfaceContainerLowest = Color(0xFF0D0603)
        /** 低层级表面容器颜色 - 中等对比度深色主题下的较低层级容器背景色 */
        val surfaceContainerLow = Color(0xFF261B16)
        /** 标准表面容器颜色 - 中等对比度深色主题下的标准层级容器背景色 */
        val surfaceContainer = Color(0xFF312520)
        /** 高层级表面容器颜色 - 中等对比度深色主题下的较高层级容器背景色 */
        val surfaceContainerHigh = Color(0xFF3C302A)
        /** 最高层级表面容器颜色 - 中等对比度深色主题下的最顶层容器背景色 */
        val surfaceContainerHighest = Color(0xFF483B35)
    }
    
    /**
     * 高对比度深色主题
     * 适用于视力障碍用户或需要最大可读性的深色环境，提供最强的颜色对比度
     */
    object HighContrast {
        /** 主要颜色 - 高对比度深色主题下的主要品牌色彩，最亮以确保最佳可见性 */
        val primary = Color(0xFFFFECE4)
        /** 主要颜色上的文本颜色 - 在高对比度深色主题主要颜色背景上的文本颜色 */
        val onPrimary = Color(0xFF000000)
        /** 主要容器颜色 - 高对比度深色主题下的主要容器背景色 */
        val primaryContainer = Color(0xFFFFB186)
        /** 主要容器上的文本颜色 - 在高对比度深色主题主要容器背景上的文本颜色 */
        val onPrimaryContainer = Color(0xFF190600)
        /** 次要颜色 - 高对比度深色主题下的次要色彩，确保最大视觉区分 */
        val secondary = Color(0xFFFFECE4)
        /** 次要颜色上的文本颜色 - 在高对比度深色主题次要颜色背景上的文本颜色 */
        val onSecondary = Color(0xFF000000)
        /** 次要容器颜色 - 高对比度深色主题下的次要容器背景色 */
        val secondaryContainer = Color(0xFFF7B48F)
        /** 次要容器上的文本颜色 - 在高对比度深色主题次要容器背景上的文本颜色 */
        val onSecondaryContainer = Color(0xFF190600)
        /** 第三级颜色 - 高对比度深色主题下的第三级色彩，提供最强的视觉对比 */
        val tertiary = Color(0xFFF5F76D)
        /** 第三级颜色上的文本颜色 - 在高对比度深色主题第三级颜色背景上的文本颜色 */
        val onTertiary = Color(0xFF000000)
        /** 第三级容器颜色 - 高对比度深色主题下的第三级容器背景色 */
        val tertiaryContainer = Color(0xFFC7C945)
        /** 第三级容器上的文本颜色 - 在高对比度深色主题第三级容器背景上的文本颜色 */
        val onTertiaryContainer = Color(0xFF0C0C00)
        /** 错误颜色 - 高对比度深色主题下的错误状态颜色，最为醒目和警示 */
        val error = Color(0xFFFFECE9)
        /** 错误颜色上的文本颜色 - 在高对比度深色主题错误颜色背景上的文本颜色 */
        val onError = Color(0xFF000000)
        /** 错误容器颜色 - 高对比度深色主题下的错误容器背景色 */
        val errorContainer = Color(0xFFFFAEA4)
        /** 错误容器上的文本颜色 - 在高对比度深色主题错误容器背景上的文本颜色 */
        val onErrorContainer = Color(0xFF220001)
        /** 背景颜色 - 高对比度深色主题下的应用主要背景色 */
        val background = Color(0xFF1B110C)
        /** 背景上的文本颜色 - 在高对比度深色主题背景色上的文本颜色 */
        val onBackground = Color(0xFFF3DED5)
        /** 表面颜色 - 高对比度深色主题下的表面元素背景色 */
        val surface = Color(0xFF1B110C)
        /** 表面上的文本颜色 - 在高对比度深色主题表面色上的文本颜色，使用纯白色确保最佳对比度 */
        val onSurface = Color(0xFFFFFFFF)
        /** 表面变体颜色 - 高对比度深色主题下的表面变体背景色 */
        val surfaceVariant = Color(0xFF564238)
        /** 表面变体上的文本颜色 - 在高对比度深色主题表面变体色上的文本颜色，使用纯白色 */
        val onSurfaceVariant = Color(0xFFFFFFFF)
        /** 轮廓颜色 - 高对比度深色主题下的边框和分割线颜色，最为明显 */
        val outline = Color(0xFFFFECE4)
        /** 轮廓变体颜色 - 高对比度深色主题下的柔和轮廓颜色 */
        val outlineVariant = Color(0xFFD9BDAF)
        /** 遮罩颜色 - 高对比度深色主题下的背景遮罩颜色 */
        val scrim = Color(0xFF000000)
        /** 反转表面颜色 - 高对比度深色主题下的反转表面背景色 */
        val inverseSurface = Color(0xFFF3DED5)
        /** 反转表面上的文本颜色 - 在高对比度深色主题反转表面色上的文本颜色 */
        val inverseOnSurface = Color(0xFF000000)
        /** 反转主要颜色 - 高对比度深色主题下的反转主要颜色 */
        val inversePrimary = Color(0xFF793300)
        /** 暗淡表面颜色 - 高对比度深色主题下的暗淡表面背景色 */
        val surfaceDim = Color(0xFF1B110C)
        /** 明亮表面颜色 - 高对比度深色主题下的明亮表面背景色 */
        val surfaceBright = Color(0xFF5B4D47)
        /** 最低层级表面容器颜色 - 高对比度深色主题下的最底层容器背景色 */
        val surfaceContainerLowest = Color(0xFF000000)
        /** 低层级表面容器颜色 - 高对比度深色主题下的较低层级容器背景色 */
        val surfaceContainerLow = Color(0xFF281D18)
        /** 标准表面容器颜色 - 高对比度深色主题下的标准层级容器背景色 */
        val surfaceContainer = Color(0xFF3A2E28)
        /** 高层级表面容器颜色 - 高对比度深色主题下的较高层级容器背景色 */
        val surfaceContainerHigh = Color(0xFF453933)
        /** 最高层级表面容器颜色 - 高对比度深色主题下的最顶层容器背景色 */
        val surfaceContainerHighest = Color(0xFF51443D)
    }
}







