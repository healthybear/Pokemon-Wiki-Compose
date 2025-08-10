# 口袋妖怪主题系统使用指南

## 概述

这是一个专为口袋妖怪图鉴APP设计的完整主题系统，基于Material Design 3原则，结合宝可梦经典元素打造独特的色彩方案。系统支持亮色/暗色主题切换，并提供多种宝可梦主题变体。

## 文件结构

```
ui/theme/
├── Color.kt           # 核心色彩定义
├── Theme.kt           # 主题配置和状态管理
├── ThemeSwitcher.kt   # 主题切换UI组件
├── ThemeData.kt       # 主题相关数据结构
└── README.md          # 使用说明文档
```

## 核心特性

### 1. 宝可梦主题色彩
- **主色调**: 基于皮卡丘的金黄色 (`PokemonPrimary`)
- **次要色调**: 基于精灵球的蓝色 (`PokemonSecondary`)
- **第三色调**: 基于妙蛙种子的绿色 (`PokemonTertiary`)
- **错误色**: 基于火系宝可梦的红色 (`PokemonError`)

### 2. 宝可梦类型专用色彩
系统为所有18种宝可梦类型提供了专用色彩：
- 火系、水系、草系、电系、冰系
- 格斗系、毒系、地面系、飞行系、超能力系
- 虫系、岩石系、幽灵系、钢系、妖精系、龙系、恶系

### 3. 主题模式支持
- **LIGHT**: 亮色主题
- **DARK**: 暗色主题
- **SYSTEM**: 跟随系统设置
- **AUTO**: 自动切换（可根据时间）

## 使用方法

### 1. 基本主题应用

```kotlin
@Composable
fun MyApp() {
    PokemonWiki_ComposeTheme {
        // 你的应用内容
        MaterialTheme {
            // 使用主题色彩
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                Text(
                    text = "Hello Pokemon!",
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
```

### 2. 主题切换

```kotlin
@Composable
fun ThemeSwitcherExample() {
    // 基本主题切换按钮
    PokemonThemeSwitcher(
        onThemeChanged = { theme ->
            // 处理主题变化
            println("主题已切换到: $theme")
        }
    )
    
    // 快速主题切换按钮
    PokemonQuickThemeToggle(
        onThemeChanged = { theme ->
            // 处理主题变化
        }
    )
    
    // 主题状态指示器
    PokemonThemeIndicator()
}
```

### 3. 使用宝可梦类型色彩

```kotlin
@Composable
fun PokemonTypeExample() {
    // 获取特定类型的颜色
    val fireColor = getPokemonTypeColor("fire")
    val waterColor = getPokemonTypeColor("water", isLight = false)
    
    // 使用预定义的类型数据
    val fireType = PokemonTypes.FIRE
    val firePrimaryColor = fireType.primaryColor
    val fireDescription = fireType.description
    
    // 显示宝可梦类型
    Box(
        modifier = Modifier
            .background(firePrimaryColor, CircleShape)
            .padding(8.dp)
    ) {
        Text(
            text = fireType.displayName,
            color = Color.White
        )
    }
}
```

### 4. 自定义主题配置

```kotlin
@Composable
fun CustomThemeExample() {
    // 使用预定义的主题配置
    val pikachuTheme = PokemonThemeConfigs.PIKACHU
    val charizardTheme = PokemonThemeConfigs.CHARIZARD
    
    // 创建自定义主题
    val customTheme = PokemonThemeConfig(
        name = "custom",
        displayName = "自定义主题",
        description = "我的专属主题",
        isDark = false,
        primaryColor = Color(0xFF00FF00),
        secondaryColor = Color(0xFF0000FF),
        accentColor = Color(0xFFFF0000)
    )
}
```

### 5. 渐变色彩使用

```kotlin
@Composable
fun GradientExample() {
    // 使用预定义渐变
    val pikachuGradient = PokemonGradients.PIKACHU
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        pikachuGradient.startColor,
                        pikachuGradient.endColor
                    )
                )
            )
    ) {
        Text(
            text = "皮卡丘渐变背景",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
```

## 主题状态管理

### 1. 获取当前主题

```kotlin
@Composable
fun CurrentThemeExample() {
    val currentTheme = rememberPokemonTheme()
    val isDark = isPokemonDarkTheme()
    
    Text("当前主题: $currentTheme")
    Text("是否为暗色主题: $isDark")
}
```

### 2. 手动切换主题

```kotlin
// 设置特定主题
PokemonThemeState.setTheme(PokemonThemeMode.DARK)

// 切换主题
PokemonThemeState.toggleTheme()
```

### 3. 主题状态数据

```kotlin
val themeData = PokemonThemeUtils.getCurrentThemeStateData()
val primaryColor = themeData.primaryColor
val backgroundColor = themeData.backgroundColor
```

## 最佳实践

### 1. 色彩使用原则
- 使用 `MaterialTheme.colorScheme` 中的标准色彩
- 宝可梦类型色彩仅用于特定类型标识
- 确保文字与背景的对比度满足可访问性要求

### 2. 主题切换时机
- 在应用启动时恢复用户上次选择的主题
- 提供明显的主题切换入口
- 支持跟随系统主题设置

### 3. 性能优化
- 主题切换时避免不必要的重组
- 使用 `remember` 缓存主题相关状态
- 合理使用 `SideEffect` 处理主题变化

## 扩展开发

### 1. 添加新的宝可梦类型

```kotlin
// 在 PokemonTypes 对象中添加新类型
val NEW_TYPE = PokemonType(
    name = "new_type",
    displayName = "新类型",
    primaryColor = Color(0xFF123456),
    secondaryColor = Color(0xFF789ABC),
    description = "新类型的描述"
)
```

### 2. 创建自定义主题

```kotlin
// 在 PokemonThemeConfigs 对象中添加新主题
val CUSTOM_THEME = PokemonThemeConfig(
    name = "custom",
    displayName = "自定义主题",
    description = "自定义主题描述",
    isDark = false,
    primaryColor = Color(0xFF123456),
    secondaryColor = Color(0xFF789ABC),
    accentColor = Color(0xFFDEF012)
)
```

### 3. 添加新的渐变

```kotlin
// 在 PokemonGradients 对象中添加新渐变
val CUSTOM_GRADIENT = PokemonGradient(
    name = "custom",
    displayName = "自定义渐变",
    startColor = Color(0xFF123456),
    endColor = Color(0xFF789ABC),
    description = "自定义渐变描述"
)
```

## 注意事项

1. **色彩对比度**: 确保所有文字与背景的对比度满足WCAG 2.1 AA标准
2. **主题一致性**: 在整个应用中保持主题色彩的一致性
3. **用户偏好**: 尊重用户的主题选择，不要强制切换
4. **系统兼容**: 支持Android 12+的动态色彩功能
5. **性能考虑**: 主题切换应该是即时的，避免延迟

## 故障排除

### 常见问题

1. **主题不生效**: 检查是否正确调用了 `PokemonWiki_ComposeTheme`
2. **色彩显示异常**: 确认颜色值格式正确（0xFF开头）
3. **主题切换失败**: 检查主题状态管理是否正确

### 调试技巧

```kotlin
// 打印当前主题状态
println("当前主题: ${PokemonThemeState.currentTheme}")
println("是否为暗色: ${isPokemonDarkTheme()}")

// 检查主题数据
val themeData = PokemonThemeUtils.getCurrentThemeStateData()
println("主题数据: $themeData")
```

## 更新日志

- **v1.0.0**: 初始版本，包含基础主题系统
- **v1.1.0**: 添加宝可梦类型色彩支持
- **v1.2.0**: 增加主题切换UI组件
- **v1.3.0**: 完善主题数据结构和工具函数

---

如有问题或建议，请参考项目文档或联系开发团队。
