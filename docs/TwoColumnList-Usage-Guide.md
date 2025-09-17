# 两列布局列表组件使用指南

## 概述

本项目提供了四种不同的两列布局列表组件，适用于不同的使用场景。每种方案都有其独特的优势和适用情况。

## 🎯 四种实现方案

### 方案1: TwoColumnGridListView（推荐）⭐⭐⭐⭐⭐

**使用场景**: 需要固定两列显示，数据项大小相同
**特点**: 
- ✅ 自动处理布局
- ✅ 性能最佳
- ✅ 代码最简洁

```kotlin
TwoColumnGridListView(
    items = pokemonList,
    itemContent = { pokemon ->
        PokemonCard(pokemon = pokemon)
    }
)
```

### 方案2: TwoColumnRowListView

**使用场景**: 需要处理奇数个数据项，要求灵活控制
**特点**:
- ✅ 自动处理奇数项
- ✅ 更灵活的布局控制
- ✅ 可以自定义空白区域

```kotlin
TwoColumnRowListView(
    items = pokemonList,
    itemContent = { pokemon ->
        CustomPokemonCard(pokemon)
    }
)
```

### 方案3: TableStyleTwoColumnListView

**使用场景**: 显示键值对数据，类似设置页面
**特点**:
- ✅ 专为键值对设计
- ✅ 自动对齐
- ✅ 适合信息展示

```kotlin
val pokemonDetails = listOf(
    PokemonInfo("名称", "皮卡丘"),
    PokemonInfo("类型", "电系"),
    PokemonInfo("等级", "25级")
)

TableStyleTwoColumnListView(items = pokemonDetails)
```

### 方案4: AdaptiveTwoColumnListView

**使用场景**: 响应式设计，根据屏幕大小调整列数
**特点**:
- ✅ 自适应屏幕宽度
- ✅ 最少保证两列
- ✅ 适合不同设备

```kotlin
AdaptiveTwoColumnListView(
    items = pokemonList,
    minColumnWidth = 160, // 最小列宽
    itemContent = { pokemon ->
        ResponsivePokemonCard(pokemon)
    }
)
```

## 📋 数据结构要求

### 基础接口
```kotlin
interface ListItem {
    val name: String
}
```

### 表格样式专用接口
```kotlin
interface TwoColumnData {
    val leftText: String
    val rightText: String
}
```

### 示例数据类
```kotlin
// 基础宝可梦数据
data class Pokemon(
    override val name: String,
    val type: String,
    val level: Int,
    val hp: Int
) : ListItem

// 表格样式数据
data class PokemonInfo(
    override val leftText: String,
    override val rightText: String
) : TwoColumnData
```

## 🎨 自定义样式

### 自定义卡片内容
```kotlin
@Composable
fun CustomPokemonCard(pokemon: Pokemon) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.titleMedium
            )
            
            Surface(
                color = getTypeColor(pokemon.type),
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = pokemon.type,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            
            LinearProgressIndicator(
                progress = { pokemon.hp / 150f },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
```

### 类型颜色映射
```kotlin
@Composable
fun getTypeColor(type: String) = when (type) {
    "火系" -> MaterialTheme.colorScheme.error
    "水系" -> MaterialTheme.colorScheme.primary
    "草系" -> MaterialTheme.colorScheme.secondary
    "电系" -> MaterialTheme.colorScheme.tertiary
    else -> MaterialTheme.colorScheme.outline
}
```

## 🚀 使用建议

### 性能优化
1. **使用remember缓存数据列表**
```kotlin
val pokemonList = remember {
    listOf(
        Pokemon("皮卡丘", "电系", 25, 100),
        // ... 更多数据
    )
}
```

2. **避免在itemContent中创建复杂计算**
```kotlin
// ❌ 不推荐 - 每次重组都会计算
itemContent = { pokemon ->
    val color = calculateComplexColor(pokemon.type) // 避免
    PokemonCard(pokemon, color)
}

// ✅ 推荐 - 使用remember或预计算
itemContent = { pokemon ->
    val color = remember(pokemon.type) { 
        calculateComplexColor(pokemon.type) 
    }
    PokemonCard(pokemon, color)
}
```

### 响应式设计
```kotlin
// 根据屏幕密度调整最小列宽
val minColumnWidth = with(LocalDensity.current) {
    when {
        LocalConfiguration.current.screenWidthDp < 600 -> 140.dp
        else -> 180.dp
    }
}

AdaptiveTwoColumnListView(
    items = items,
    minColumnWidth = minColumnWidth.value.toInt()
)
```

## 🔧 完整示例

查看 `TwoColumnListExample.kt` 文件获取完整的使用示例，包括：
- 四种布局的对比演示
- 自定义卡片样式
- 交互式标签页切换
- 响应式设计实现

## 🎯 选择指南

| 使用场景 | 推荐方案 | 原因 |
|---------|---------|------|
| 一般的网格布局 | TwoColumnGridListView | 性能最佳，代码简洁 |
| 奇数个数据项 | TwoColumnRowListView | 自动处理奇数项 |
| 键值对显示 | TableStyleTwoColumnListView | 专为此场景设计 |
| 响应式设计 | AdaptiveTwoColumnListView | 适配不同屏幕 |
| 复杂自定义布局 | TwoColumnRowListView | 最灵活的控制 |

选择合适的方案能让您的应用在不同设备上都有最佳的用户体验！
