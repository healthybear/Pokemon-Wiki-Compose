# 宝可梦动态配色系统使用指南

## 概述

宝可梦动态配色系统是一个基于 Material Design 3 的智能主题系统，能够根据用户选择的宝可梦类型自动生成完整的配色方案。系统支持亮色/暗色主题切换，并保持与 Android 12+ 系统动态配色的兼容性。

## 核心特性

### 🎨 智能配色生成
- **基于宝可梦类型**: 根据18种宝可梦类型自动生成主题色彩
- **HSL色彩科学**: 使用HSL色彩空间进行智能色彩搭配
- **互补色生成**: 自动计算主色调的互补色作为第三色调
- **透明度调节**: 智能调节色彩透明度，确保可读性

### 🌓 主题模式支持
- **亮色主题**: 适合日间使用，色彩明亮清新
- **暗色主题**: 护眼舒适，适合夜间使用
- **系统跟随**: 自动跟随系统主题设置
- **自动切换**: 根据时间自动切换主题

### 🔄 动态配色优先级
1. **宝可梦动态配色** (最高优先级)
2. **系统动态配色** (Android 12+)
3. **静态配色回退** (兼容旧版Android)

## 文件结构

```
ui/theme/
├── Color.kt                    # 核心色彩定义
├── Theme.kt                    # 主题配置和动态配色生成器
├── ThemeSwitcher.kt           # 主题切换UI组件
├── ThemeData.kt               # 主题相关数据结构
├── DynamicTheme_README.md     # 动态配色系统说明文档
└── README.md                  # 主题系统总体说明
```

## 使用方法

### 1. 基本主题应用

```kotlin
@Composable
fun MyApp() {
    PokemonWiki_ComposeTheme {
        // 你的应用内容
    }
}
```

### 2. 宝可梦类型选择

```kotlin
@Composable
fun PokemonTypeSelectorExample() {
    PokemonTypeSelector(
        onPokemonTypeSelected = { type ->
            // type 可以是: "fire", "water", "grass" 等
            PokemonThemeState.setPokemonType(type)
        }
    )
}
```

### 3. 动态配色控制

```kotlin
@Composable
fun DynamicColorControlExample() {
    PokemonDynamicColorSwitch(
        onDynamicColorChanged = { use ->
            PokemonThemeState.setUseDynamicColors(use)
        }
    )
}
```

### 4. 主题模式切换

```kotlin
@Composable
fun ThemeSwitcherExample() {
    PokemonThemeSwitcher(
        onThemeChanged = { theme ->
            PokemonThemeState.setTheme(theme)
        }
    )
}
```

### 5. 综合控制面板

```kotlin
@Composable
fun ThemeControlPanelExample() {
    PokemonThemeControlPanel(
        onThemeChanged = { theme -> /* 处理主题变化 */ },
        onPokemonTypeChanged = { type -> /* 处理类型变化 */ },
        onDynamicColorChanged = { use -> /* 处理动态配色变化 */ }
    )
}
```

## 宝可梦类型色彩

### 支持的类型
| 类型 | 中文名 | 主色调 | 特点 |
|------|--------|--------|------|
| fire | 火 | 🔥 火焰红 | 热情、活力 |
| water | 水 | 💧 海洋蓝 | 冷静、深邃 |
| grass | 草 | 🌿 森林绿 | 自然、生机 |
| electric | 电 | ⚡ 闪电黄 | 明亮、能量 |
| ice | 冰 | ❄️ 冰雪蓝 | 纯净、寒冷 |
| fighting | 格斗 | 👊 战斗橙 | 力量、勇气 |
| poison | 毒 | ☠️ 毒液紫 | 神秘、危险 |
| ground | 地面 | 🌍 大地棕 | 稳重、踏实 |
| flying | 飞行 | 🦅 天空蓝 | 自由、轻盈 |
| psychic | 超能 | 🔮 超能粉 | 神秘、智慧 |
| bug | 虫 | 🐛 虫绿 | 自然、微小 |
| rock | 岩石 | 🗿 岩石灰 | 坚固、耐久 |
| ghost | 幽灵 | 👻 幽灵紫 | 神秘、诡异 |
| dragon | 龙 | 🐉 龙紫 | 强大、威严 |
| dark | 恶 | 🌑 黑暗黑 | 神秘、强大 |
| steel | 钢 | ⚙️ 钢铁银 | 坚固、现代 |
| fairy | 妖精 | 🧚 妖精粉 | 可爱、魔法 |
| normal | 一般 | ⚪ 普通白 | 平衡、中性 |

### 色彩生成算法

#### 主色调生成
```kotlin
val baseColor = getPokemonTypeColor(pokemonType, !isDark)
```

#### 互补色计算
```kotlin
private fun generateComplementaryColor(color: Color): Color {
    val hsl = color.toHsl()
    return Color.hsl(
        hue = (hsl.hue + 180f) % 360f,  // 色相旋转180度
        saturation = hsl.saturation,     // 保持饱和度
        lightness = hsl.lightness        // 保持明度
    )
}
```

#### 背景色生成
```kotlin
// 暗色背景：主色调 + 黑色，透明度5%
private fun generateDarkBackground(baseColor: Color): Color {
    return baseColor.copy(alpha = 0.05f).blendWith(Color.Black, 0.95f)
}

// 亮色背景：主色调 + 白色，透明度2%
private fun generateLightBackground(baseColor: Color): Color {
    return baseColor.copy(alpha = 0.02f).blendWith(Color.White, 0.98f)
}
```

## 主题状态管理

### 状态变量
```kotlin
object PokemonThemeState {
    var currentTheme by mutableStateOf(PokemonThemeMode.SYSTEM)
    var selectedPokemonType by mutableStateOf<String?>(null)
    var useDynamicColors by mutableStateOf(true)
}
```

### 状态操作
```kotlin
// 设置主题模式
PokemonThemeState.setTheme(PokemonThemeMode.LIGHT)

// 设置宝可梦类型
PokemonThemeState.setPokemonType("fire")

// 启用/禁用动态配色
PokemonThemeState.setUseDynamicColors(true)
```

## 性能优化

### 色彩缓存
- 宝可梦类型色彩使用预定义常量
- HSL转换结果可考虑缓存（当前实现为实时计算）

### 主题切换优化
- 使用 `mutableStateOf` 确保响应式更新
- 主题变化时只重新计算必要的色彩

### 内存管理
- 色彩对象轻量化，避免不必要的内存占用
- 及时释放不需要的色彩资源

## 无障碍设计

### 对比度保证
- 所有动态生成的色彩都经过对比度检查
- 确保文字在背景上的可读性
- 支持高对比度模式

### 色彩盲友好
- 避免仅依赖色彩传达信息
- 提供图标和文字作为辅助标识
- 支持系统无障碍设置

## 扩展开发

### 添加新的宝可梦类型
1. 在 `Color.kt` 中定义新类型的色彩
2. 在 `getPokemonTypeColor` 函数中添加映射
3. 在 `getPokemonTypeDisplayName` 中添加中文名称

### 自定义色彩生成算法
1. 继承或修改 `PokemonDynamicColorGenerator`
2. 实现自定义的 `generateDynamicColorScheme` 方法
3. 添加新的色彩混合算法

### 主题持久化
```kotlin
// 保存主题设置到本地存储
fun saveThemeSettings() {
    // 使用 MMKV 或其他存储方案
    // 保存 currentTheme, selectedPokemonType, useDynamicColors
}

// 恢复主题设置
fun restoreThemeSettings() {
    // 从本地存储读取设置
    // 恢复主题状态
}
```

## 故障排除

### 常见问题

#### Q: 动态配色不生效？
A: 检查以下几点：
- 确保 `useDynamicColors` 为 `true`
- 确保 `selectedPokemonType` 不为 `null`
- 检查 Android 版本兼容性

#### Q: 色彩显示异常？
A: 可能的原因：
- 宝可梦类型名称拼写错误
- 色彩值超出有效范围
- 透明度设置不当

#### Q: 主题切换卡顿？
A: 优化建议：
- 减少同时渲染的组件数量
- 使用 `remember` 缓存计算结果
- 避免在主题切换时进行复杂计算

### 调试技巧

#### 启用调试日志
```kotlin
// 在开发阶段启用详细日志
Log.d("PokemonTheme", "当前主题: ${PokemonThemeState.currentTheme}")
Log.d("PokemonTheme", "选择类型: ${PokemonThemeState.selectedPokemonType}")
Log.d("PokemonTheme", "动态配色: ${PokemonThemeState.useDynamicColors}")
```

#### 色彩值检查
```kotlin
// 检查生成的色彩值
val color = getPokemonTypeColor("fire", true)
Log.d("PokemonTheme", "火系色彩: R=${color.red}, G=${color.green}, B=${color.blue}")
```

## 更新日志

### v1.0.0 (当前版本)
- ✨ 实现基础动态配色系统
- ✨ 支持18种宝可梦类型
- ✨ 亮色/暗色主题切换
- ✨ 系统动态配色兼容
- ✨ 完整的UI组件库

### 计划功能
- 🔄 主题设置持久化
- 🎨 自定义色彩算法
- 📱 更多UI组件支持
- 🌈 渐变色彩支持
- 🎯 宝可梦图片识别

## 技术支持

如果你在使用过程中遇到问题或有改进建议，请：

1. 检查本文档的故障排除部分
2. 查看代码注释和示例
3. 提交 Issue 或 Pull Request
4. 联系开发团队

---

**注意**: 本系统基于 Material Design 3 设计规范，确保与 Android 原生体验保持一致。动态配色功能需要 Android 7.0 (API 24) 或更高版本。
