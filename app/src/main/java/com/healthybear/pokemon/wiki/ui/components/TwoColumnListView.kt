package com.healthybear.pokemon.wiki.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthybear.pokemon.wiki.ui.theme.AppTheme
import com.healthybear.pokemon.wiki.ui.theme.AppTypography

/**
 * @Author guojianhong
 * @Date 2025/9/17
 * @description 一行内显示两个数据的列表组件集合
 */

/**
 * 方案1: 使用LazyVerticalGrid实现网格布局（推荐）
 * 自动处理两列布局，响应式设计
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : ListItem> TwoColumnGridListView(
    items: List<T>,
    modifier: Modifier = Modifier,
    itemContent: @Composable (T) -> Unit = { item ->
        DefaultTwoColumnItem(item)
    }
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 固定两列
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            itemContent(item)
        }
    }
}

/**
 * 方案2: 使用Row手动分组实现两列布局
 * 更灵活的控制，可以处理奇数个数据项
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : ListItem> TwoColumnRowListView(
    items: List<T>,
    modifier: Modifier = Modifier,
    itemContent: @Composable (T) -> Unit = { item ->
        DefaultTwoColumnItem(item)
    }
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 将数据按两个一组进行分组
        val groupedItems = items.chunked(2)
        
        items(groupedItems) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // 第一个项目
                Box(modifier = Modifier.weight(1f)) {
                    itemContent(rowItems[0])
                }
                
                // 第二个项目（如果存在）
                if (rowItems.size > 1) {
                    Box(modifier = Modifier.weight(1f)) {
                        itemContent(rowItems[1])
                    }
                } else {
                    // 如果只有一个项目，添加空白占位符保持布局平衡
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

/**
 * 方案3: 表格样式的两列布局
 * 适合显示键值对数据
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : TwoColumnData> TableStyleTwoColumnListView(
    items: List<T>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // 左列（标签）
                    Text(
                        text = item.leftText,
                        style = AppTypography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.weight(1f)
                    )
                    
                    // 右列（值）
                    Text(
                        text = item.rightText,
                        style = AppTypography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.End,
                        modifier = Modifier.weight(1f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

/**
 * 方案4: 自适应列数的网格布局
 * 根据屏幕宽度自动调整列数，最少2列
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : ListItem> AdaptiveTwoColumnListView(
    items: List<T>,
    modifier: Modifier = Modifier,
    minColumnWidth: Int = 150, // 最小列宽度（dp）
    itemContent: @Composable (T) -> Unit = { item ->
        DefaultTwoColumnItem(item)
    }
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = minColumnWidth.dp),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            itemContent(item)
        }
    }
}

/**
 * 默认的两列项目样式
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : ListItem> DefaultTwoColumnItem(item: T) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = item.name,
                style = AppTypography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            
            // 如果是SampleItem，显示描述
            if (item is SampleItem && item.description.isNotEmpty()) {
                Text(
                    text = item.description,
                    style = AppTypography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

/**
 * 用于表格样式的数据接口
 */
interface TwoColumnData {
    val leftText: String
    val rightText: String
}

/**
 * 宝可梦信息数据类，用于演示表格样式
 */
data class PokemonInfo(
    override val leftText: String,
    override val rightText: String
) : TwoColumnData

/**
 * 扩展的宝可梦数据类，包含更多信息
 */
data class Pokemon(
    override val name: String,
    val type: String,
    val level: Int,
    val hp: Int
) : ListItem

// 预览组件
@Preview(showBackground = true)
@Composable
fun TwoColumnListPreview() {
    AppTheme {
        val sampleItems = listOf(
            SampleItem("皮卡丘", "电系宝可梦"),
            SampleItem("妙蛙种子", "草系宝可梦"),
            SampleItem("小火龙", "火系宝可梦"),
            SampleItem("杰尼龟", "水系宝可梦"),
            SampleItem("胖丁", "一般系宝可梦")
        )
        
        TwoColumnGridListView(items = sampleItems)
    }
}

@Preview(showBackground = true)
@Composable
fun TableStylePreview() {
    AppTheme {
        val pokemonInfos = listOf(
            PokemonInfo("名称", "皮卡丘"),
            PokemonInfo("类型", "电系"),
            PokemonInfo("等级", "25"),
            PokemonInfo("HP", "100"),
            PokemonInfo("攻击力", "85"),
            PokemonInfo("防御力", "60")
        )
        
        TableStyleTwoColumnListView(items = pokemonInfos)
    }
}
