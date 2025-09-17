package com.healthybear.pokemon.wiki.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthybear.pokemon.wiki.ui.theme.AppTheme
import com.healthybear.pokemon.wiki.ui.theme.AppTypography

/**
 * @Author guojianhong
 * @Date 2025/9/17
 * @description 两列布局的使用示例
 */

/**
 * 主要的两列布局演示页面
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoColumnListExampleScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("网格布局", "行布局", "表格样式", "自适应")
    
    Column(modifier = Modifier.fillMaxSize()) {
        // 顶部标签栏
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }
        
        // 内容区域
        when (selectedTab) {
//            0 -> GridLayoutExample()
            0 -> AdaptiveLayoutExample()
            1 -> RowLayoutExample()
            2 -> TableStyleExample()
            3 -> AdaptiveLayoutExample()
        }
    }
}

/**
 * 示例1: 网格布局
 */
@Composable
fun GridLayoutExample() {
    val pokemonList = remember {
        listOf(
            Pokemon("皮卡丘", "电系", 25, 100),
            Pokemon("妙蛙种子", "草系", 15, 90),
            Pokemon("小火龙", "火系", 18, 95),
            Pokemon("杰尼龟", "水系", 16, 88),
            Pokemon("胖丁", "一般系", 20, 110),
            Pokemon("喵喵", "一般系", 12, 70),
            Pokemon("可达鸭", "水系", 14, 75),
//            Pokemon("六尾", "火系", 22, 85)
        )
    }
    
    Column {
        Text(
            text = "网格布局示例 - 固定两列",
            style = AppTypography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
        
        TwoColumnGridListView(
            items = pokemonList,
            itemContent = { pokemon ->
                PokemonCard(pokemon = pokemon)
            }
        )
    }
}

/**
 * 示例2: 行布局
 */
@Composable
fun RowLayoutExample() {
    val pokemonList = remember {
        listOf(
            Pokemon("雷丘", "电系", 30, 120),
            Pokemon("妙蛙草", "草系", 20, 110),
            Pokemon("火恐龙", "火系", 25, 115),
            Pokemon("卡咪龟", "水系", 22, 105),
            Pokemon("波波", "飞行系", 8, 60)
        )
    }
    
    Column {
        Text(
            text = "行布局示例 - 手动分组",
            style = AppTypography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
        
        TwoColumnRowListView(
            items = pokemonList,
            itemContent = { pokemon ->
                PokemonCard(pokemon = pokemon)
            }
        )
    }
}

/**
 * 示例3: 表格样式
 */
@Composable
fun TableStyleExample() {
    val pokemonDetails = remember {
        listOf(
            PokemonInfo("名称", "皮卡丘"),
            PokemonInfo("类型", "电系"),
            PokemonInfo("等级", "25级"),
            PokemonInfo("HP", "100/100"),
            PokemonInfo("攻击力", "85"),
            PokemonInfo("防御力", "60"),
            PokemonInfo("速度", "90"),
            PokemonInfo("特攻", "75"),
            PokemonInfo("特防", "70"),
            PokemonInfo("身高", "0.4m"),
            PokemonInfo("体重", "6.0kg"),
            PokemonInfo("特性", "静电")
        )
    }
    
    Column {
        Text(
            text = "表格样式示例 - 键值对显示",
            style = AppTypography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
        
        TableStyleTwoColumnListView(items = pokemonDetails)
    }
}

/**
 * 示例4: 自适应布局
 */
@Composable
fun AdaptiveLayoutExample() {
    val pokemonList = remember {
        listOf(
            Pokemon("超梦", "超能力系", 70, 200),
            Pokemon("梦幻", "超能力系", 50, 180),
            Pokemon("炎帝", "火系", 60, 190),
            Pokemon("水君", "水系", 60, 190),
            Pokemon("雷公", "电系", 60, 190),
            Pokemon("洛奇亚", "飞行系", 70, 220)
        )
    }
    
    Column {
        Text(
            text = "自适应布局示例 - 根据屏幕宽度调整",
            style = AppTypography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )
        
        AdaptiveTwoColumnListView(
            items = pokemonList,
            minColumnWidth = 160,
            itemContent = { pokemon ->
                PokemonCard(pokemon = pokemon, isLegendary = true)
            }
        )
    }
}

/**
 * 自定义宝可梦卡片组件
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCard(
    pokemon: Pokemon,
    isLegendary: Boolean = false
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isLegendary) 4.dp else 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isLegendary) 
                MaterialTheme.colorScheme.secondaryContainer
            else 
                MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // 名称和等级
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = pokemon.name,
                    style = AppTypography.titleMedium.copy(
                        fontWeight = if (isLegendary) FontWeight.Bold else FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
                
                Text(
                    text = "Lv.${pokemon.level}",
                    style = AppTypography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            // 类型标签
            Surface(
                color = getTypeColor(pokemon.type),
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pokemon.type,
                    style = AppTypography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            
            // HP条
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "HP",
                        style = AppTypography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "${pokemon.hp}",
                        style = AppTypography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                LinearProgressIndicator(
                    progress = { pokemon.hp / 150f },
                    modifier = Modifier.fillMaxWidth(),
                    color = when {
                        pokemon.hp > 120 -> MaterialTheme.colorScheme.primary
                        pokemon.hp > 80 -> MaterialTheme.colorScheme.secondary
                        else -> MaterialTheme.colorScheme.error
                    }
                )
            }
        }
    }
}

/**
 * 根据宝可梦类型返回对应颜色
 */
@Composable
fun getTypeColor(type: String) = when (type) {
    "火系" -> MaterialTheme.colorScheme.error
    "水系" -> MaterialTheme.colorScheme.primary
    "草系" -> MaterialTheme.colorScheme.secondary
    "电系" -> MaterialTheme.colorScheme.tertiary
    "超能力系" -> MaterialTheme.colorScheme.primaryContainer
    "飞行系" -> MaterialTheme.colorScheme.secondaryContainer
    else -> MaterialTheme.colorScheme.outline
}

/**
 * 完整的演示页面预览
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TwoColumnListExamplePreview() {
    AppTheme {
        TwoColumnListExampleScreen()
    }
}
