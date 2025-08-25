package com.healthybear.pokemon.wiki.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Search 
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.healthybear.pokemon.wiki.ui.theme.AppTheme

/**
 * 应用顶部标题栏组件
 * 基于 Material3 设计规范的标题栏，支持左侧菜单按钮和自定义标题
 * 
 * @param title 标题文本
 * @param onMenuClick 左侧菜单按钮点击回调
 * @param modifier 修饰符
 * @param navigationIcon 导航图标，默认为菜单图标
 * @param actions 右侧操作按钮组合
 * @param colors 标题栏颜色配置
 * @param scrollBehavior 滚动行为配置
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: ImageVector = Icons.Filled.Menu,
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onMenuClick,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = "打开菜单",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        actions = actions,
        colors = colors,
        modifier = modifier,
        scrollBehavior = scrollBehavior
    )
}

/**
 * 带侧边菜单的应用标题栏组件
 * 集成了侧边菜单抽屉的完整标题栏解决方案
 * 
 * @param title 标题文本
 * @param drawerState 抽屉状态
 * @param modifier 修饰符
 * @param navigationIcon 导航图标
 * @param actions 右侧操作按钮
 * @param colors 标题栏颜色配置
 * @param scrollBehavior 滚动行为配置
 * @param drawerContent 侧边菜单内容
 * @param content 主要内容
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarWithDrawer(
    title: String,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    modifier: Modifier = Modifier,
    navigationIcon: ImageVector = Icons.Filled.Menu,
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    drawerContent: @Composable () -> Unit = { DefaultDrawerContent() },
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                drawerContent()
            }
        },
        modifier = modifier
    ) {
        Column {
            AppTopBar(
                title = title,
                onMenuClick = {
                    scope.launch {
                        if (drawerState.isClosed) {
                            drawerState.open()
                        } else {
                            drawerState.close()
                        }
                    }
                },
                navigationIcon = navigationIcon,
                actions = actions,
                colors = colors,
                scrollBehavior = scrollBehavior
            )
            content()
        }
    }
}

/**
 * 默认侧边菜单内容
 * 提供基础的菜单项示例
 */
@Composable
private fun DefaultDrawerContent() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .padding(16.dp)
    ) {
        // 菜单标题区域
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 应用图标占位符
            Surface(
                modifier = Modifier.size(48.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "P",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Column {
                Text(
                    text = "Pokemon Wiki",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "宝可梦百科全书",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        
        Divider(
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // 主要菜单项
        DrawerMenuItem(
            text = "首页",
            icon = Icons.Filled.Home,
            onClick = { /* TODO: 导航到首页 */ }
        )
        
        DrawerMenuItem(
            text = "宝可梦图鉴",
            icon = Icons.Filled.List,
            onClick = { /* TODO: 导航到图鉴 */ }
        )
        
        DrawerMenuItem(
            text = "收藏夹",
            icon = Icons.Filled.Favorite,
            onClick = { /* TODO: 导航到收藏夹 */ }
        )
        
        DrawerMenuItem(
            text = "搜索",
            icon = Icons.Filled.Search,
            onClick = { /* TODO: 打开搜索 */ }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Divider(
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        // 设置菜单项
        DrawerMenuItem(
            text = "主题设置",
            icon = Icons.Filled.Palette,
            onClick = { /* TODO: 导航到主题设置 */ }
        )
        
        DrawerMenuItem(
            text = "设置",
            icon = Icons.Filled.Settings,
            onClick = { /* TODO: 导航到设置 */ }
        )
        
        DrawerMenuItem(
            text = "关于",
            icon = Icons.Filled.Info,
            onClick = { /* TODO: 导航到关于页面 */ }
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        // 底部信息
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surfaceContainer,
            shape = MaterialTheme.shapes.small
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = "Pokemon Wiki",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "版本 1.0.0",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

/**
 * 侧边菜单项组件
 * 
 * @param text 菜单项文本
 * @param onClick 点击回调
 * @param modifier 修饰符
 * @param icon 菜单项图标
 * @param selected 是否选中状态
 */
@Composable
private fun DrawerMenuItem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    selected: Boolean = false
) {
    NavigationDrawerItem(
        label = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        selected = selected,
        onClick = onClick,
        modifier = modifier.padding(vertical = 2.dp),
        icon = icon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = text,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unselectedTextColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

// ========================================
// 预览组件
// ========================================

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "标题栏 - 浅色主题")
@Composable
private fun AppTopBarLightPreview() {
    AppTheme(darkTheme = false) {
        Surface {
            AppTopBar(
                title = "Pokemon Wiki",
                onMenuClick = { }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "标题栏 - 深色主题")
@Composable
private fun AppTopBarDarkPreview() {
    AppTheme(darkTheme = true) {
        Surface {
            AppTopBar(
                title = "Pokemon Wiki",
                onMenuClick = { }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "带侧边菜单的标题栏")
@Composable
private fun AppTopBarWithDrawerPreview() {
    AppTheme {
        AppTopBarWithDrawer(
            title = "Pokemon Wiki"
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "主要内容区域\n点击左上角菜单按钮打开侧边菜单",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}