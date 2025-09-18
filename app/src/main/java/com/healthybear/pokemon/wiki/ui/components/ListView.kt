package com.healthybear.pokemon.wiki.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.healthybear.pokemon.wiki.ui.theme.AppTypography

/**
 * 数据项接口，用于定义列表项必须具备的属性
 */
interface ListItem {
    val name: String
}

/**
 * 动态列表视图组件
 * @param items 要显示的数据项列表，可以是Array或ArrayList
 * @param modifier 修饰符
 * @param itemContent 自定义列表项内容的组合函数
 * @Author guojianhong
 * @Date 2025/9/17
 * @description 支持泛型数据的动态列表组件
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : ListItem> DynamicLiewView(
    items: List<T>,
    modifier: Modifier = Modifier,
    minColumnWidth: Int = 180, // 最小列宽度（dp）
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
 * 示例数据类，实现了ListItem接口
 */
data class SampleItem(
    override val name: String,
    val description: String = ""
) : ListItem