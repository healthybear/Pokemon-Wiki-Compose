package com.healthybear.pokemon.wiki.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

// ===== 主题切换器主组件 =====
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonThemeSwitcher(
    modifier: Modifier = Modifier,
    onThemeChanged: (PokemonThemeMode) -> Unit = {}
) {
    var showThemeDialog by remember { mutableStateOf(false) }
    val currentTheme = rememberPokemonTheme()
    
    // 主题切换按钮 - 使用文本而不是图标
    Button(
        onClick = { showThemeDialog = true },
        modifier = modifier
    ) {
        Text(
            text = when (currentTheme) {
                PokemonThemeMode.LIGHT -> "☀️"
                PokemonThemeMode.DARK -> "🌙"
                PokemonThemeMode.SYSTEM -> "⚙️"
                PokemonThemeMode.AUTO -> "🔄"
            }
        )
    }
    
    // 主题选择对话框
    if (showThemeDialog) {
        PokemonThemeDialog(
            currentTheme = currentTheme,
            onThemeSelected = { theme ->
                PokemonThemeState.setTheme(theme)
                onThemeChanged(theme)
                showThemeDialog = false
            },
            onDismiss = { showThemeDialog = false }
        )
    }
}

// ===== 主题选择对话框 =====
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonThemeDialog(
    currentTheme: PokemonThemeMode,
    onThemeSelected: (PokemonThemeMode) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "选择主题",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                PokemonThemeOption(
                    theme = PokemonThemeMode.LIGHT,
                    icon = "☀️",
                    title = "亮色主题",
                    subtitle = "经典明亮的配色方案",
                    isSelected = currentTheme == PokemonThemeMode.LIGHT,
                    onClick = { onThemeSelected(PokemonThemeMode.LIGHT) }
                )
                
                PokemonThemeOption(
                    theme = PokemonThemeMode.DARK,
                    icon = "🌙",
                    title = "暗色主题",
                    subtitle = "护眼舒适的配色方案",
                    isSelected = currentTheme == PokemonThemeMode.DARK,
                    onClick = { onThemeSelected(PokemonThemeMode.DARK) }
                )
                
                PokemonThemeOption(
                    theme = PokemonThemeMode.SYSTEM,
                    icon = "⚙️",
                    title = "跟随系统",
                    subtitle = "自动跟随系统主题设置",
                    isSelected = currentTheme == PokemonThemeMode.SYSTEM,
                    onClick = { onThemeSelected(PokemonThemeMode.SYSTEM) }
                )
                
                PokemonThemeOption(
                    theme = PokemonThemeMode.AUTO,
                    icon = "🔄",
                    title = "自动切换",
                    subtitle = "根据时间自动切换主题",
                    isSelected = currentTheme == PokemonThemeMode.AUTO,
                    onClick = { onThemeSelected(PokemonThemeMode.AUTO) }
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}

// ===== 主题选项组件 =====
@Composable
fun PokemonThemeOption(
    theme: PokemonThemeMode,
    icon: String,
    title: String,
    subtitle: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // 图标
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(
                    if (isSelected) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.surfaceVariant
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icon,
                fontSize = 20.sp
            )
        }
        
        // 文本内容
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                color = if (isSelected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        // 选择指示器
        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = CircleShape
                    )
            )
        }
    }
}

// ===== 快速主题切换按钮 =====
@Composable
fun PokemonQuickThemeToggle(
    modifier: Modifier = Modifier,
    onThemeChanged: (PokemonThemeMode) -> Unit = {}
) {
    val currentTheme = rememberPokemonTheme()
    
    FloatingActionButton(
        onClick = {
            val newTheme = when (currentTheme) {
                PokemonThemeMode.LIGHT -> PokemonThemeMode.DARK
                PokemonThemeMode.DARK -> PokemonThemeMode.LIGHT
                PokemonThemeMode.SYSTEM -> PokemonThemeMode.LIGHT
                PokemonThemeMode.AUTO -> PokemonThemeMode.LIGHT
            }
            PokemonThemeState.setTheme(newTheme)
            onThemeChanged(newTheme)
        },
        modifier = modifier
    ) {
        Text(
            text = when (currentTheme) {
                PokemonThemeMode.LIGHT -> "🌙"
                PokemonThemeMode.DARK -> "☀️"
                else -> "🔄"
            }
        )
    }
}

// ===== 主题状态指示器 =====
@Composable
fun PokemonThemeIndicator(
    modifier: Modifier = Modifier
) {
    val currentTheme = rememberPokemonTheme()
    
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = when (currentTheme) {
                    PokemonThemeMode.LIGHT -> "☀️"
                    PokemonThemeMode.DARK -> "🌙"
                    PokemonThemeMode.SYSTEM -> "⚙️"
                    PokemonThemeMode.AUTO -> "🔄"
                }
            )
            Text(
                text = when (currentTheme) {
                    PokemonThemeMode.LIGHT -> "亮色"
                    PokemonThemeMode.DARK -> "暗色"
                    PokemonThemeMode.SYSTEM -> "系统"
                    PokemonThemeMode.AUTO -> "自动"
                },
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

// ===== 主题预览卡片 =====
@Composable
fun PokemonThemePreviewCard(
    theme: PokemonThemeMode,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val previewColor = getThemePreviewColor(theme)
    
    Card(
        modifier = modifier.clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = previewColor
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = when (theme) {
                    PokemonThemeMode.LIGHT -> "☀️"
                    PokemonThemeMode.DARK -> "🌙"
                    PokemonThemeMode.SYSTEM -> "⚙️"
                    PokemonThemeMode.AUTO -> "🔄"
                },
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = when (theme) {
                    PokemonThemeMode.LIGHT -> "亮色"
                    PokemonThemeMode.DARK -> "暗色"
                    PokemonThemeMode.SYSTEM -> "系统"
                    PokemonThemeMode.AUTO -> "自动"
                },
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}

// ===== 主题预览色彩获取 =====
@Composable
fun getThemePreviewColor(theme: PokemonThemeMode): Color {
    return when (theme) {
        PokemonThemeMode.LIGHT -> PokemonPrimary
        PokemonThemeMode.DARK -> PokemonPrimaryDark
        PokemonThemeMode.SYSTEM -> PokemonSecondary
        PokemonThemeMode.AUTO -> PokemonTertiary
    }
}

// ===== 宝可梦类型选择器 =====
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTypeSelector(
    modifier: Modifier = Modifier,
    onPokemonTypeSelected: (String?) -> Unit = {}
) {
    var showTypeDialog by remember { mutableStateOf(false) }
    val currentType = PokemonThemeState.selectedPokemonType.value
    
    // 宝可梦类型选择按钮
    Button(
        onClick = { showTypeDialog = true },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (currentType != null) {
                getPokemonTypeColor(currentType.toString(), true)
            } else {
                MaterialTheme.colorScheme.secondary
            }
        )
    ) {
        Text(
            text = currentType?.let { "🎯 $it" } ?: "🎯 选择宝可梦",
            color = if (currentType != null) Color.White else MaterialTheme.colorScheme.onSecondary
        )
    }
    
    // 宝可梦类型选择对话框
    if (showTypeDialog) {
        PokemonTypeDialog(
            currentType = currentType,
            onTypeSelected = { type ->
                PokemonThemeState.setPokemonType(type)
                onPokemonTypeSelected(type)
                showTypeDialog = false
            },
            onDismiss = { showTypeDialog = false }
        )
    }
}

// ===== 宝可梦类型选择对话框 =====
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTypeDialog(
    currentType: String?,
    onTypeSelected: (String?) -> Unit,
    onDismiss: () -> Unit
) {
    val pokemonTypes = listOf(
        "fire", "water", "grass", "electric", "ice", "fighting",
        "poison", "ground", "flying", "psychic", "bug", "rock",
        "ghost", "dragon", "dark", "steel", "fairy", "normal"
    )
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "选择宝可梦类型",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.height(300.dp)
            ) {
                // 清除选择选项
                item {
                    PokemonTypeOption(
                        type = null,
                        title = "清除",
                        isSelected = currentType == null,
                        onClick = { onTypeSelected(null) }
                    )
                }
                
                // 宝可梦类型选项
                items(pokemonTypes) { type ->
                    PokemonTypeOption(
                        type = type,
                        title = getPokemonTypeDisplayName(type),
                        isSelected = currentType == type,
                        onClick = { onTypeSelected(type) }
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}

// ===== 宝可梦类型选项组件 =====
@Composable
fun PokemonTypeOption(
    type: String?,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        type?.let { getPokemonTypeColor(it, true) } ?: MaterialTheme.colorScheme.surfaceVariant
    }
    
    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        type?.let { Color.White } ?: MaterialTheme.colorScheme.onSurfaceVariant
    }
    
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .border(
                width = if (isSelected) 3.dp else 1.dp,
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = textColor,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}

// ===== 宝可梦类型显示名称 =====
fun getPokemonTypeDisplayName(type: String): String {
    return when (type.lowercase()) {
        "fire" -> "火"
        "water" -> "水"
        "grass" -> "草"
        "electric" -> "电"
        "ice" -> "冰"
        "fighting" -> "格斗"
        "poison" -> "毒"
        "ground" -> "地面"
        "flying" -> "飞行"
        "psychic" -> "超能"
        "bug" -> "虫"
        "rock" -> "岩石"
        "ghost" -> "幽灵"
        "dragon" -> "龙"
        "dark" -> "恶"
        "steel" -> "钢"
        "fairy" -> "妖精"
        "normal" -> "一般"
        else -> type.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }
}

// ===== 动态配色开关 =====
@Composable
fun PokemonDynamicColorSwitch(
    modifier: Modifier = Modifier,
    onDynamicColorChanged: (Boolean) -> Unit = {}
) {
    val useDynamicColors = PokemonThemeState.useDynamicColors.value
    
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "动态配色",
            style = MaterialTheme.typography.bodyMedium
        )
        
        Switch(
            checked = useDynamicColors,
            onCheckedChange = { checked ->
                PokemonThemeState.setUseDynamicColors(checked)
                onDynamicColorChanged(checked)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

// ===== 主题预览卡片（增强版） =====
@Composable
fun PokemonEnhancedThemePreviewCard(
    theme: PokemonThemeMode,
    pokemonType: String? = null,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val previewColor = if (pokemonType != null && PokemonThemeState.useDynamicColors.value) {
        getPokemonTypeColor(pokemonType, theme != PokemonThemeMode.DARK)
    } else {
        getThemePreviewColor(theme)
    }
    
    Card(
        modifier = modifier.clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = previewColor
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 主题图标
            Text(
                text = when (theme) {
                    PokemonThemeMode.LIGHT -> "☀️"
                    PokemonThemeMode.DARK -> "🌙"
                    PokemonThemeMode.SYSTEM -> "⚙️"
                    PokemonThemeMode.AUTO -> "🔄"
                },
                fontSize = 24.sp
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // 主题名称
            Text(
                text = when (theme) {
                    PokemonThemeMode.LIGHT -> "亮色"
                    PokemonThemeMode.DARK -> "暗色"
                    PokemonThemeMode.SYSTEM -> "系统"
                    PokemonThemeMode.AUTO -> "自动"
                },
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            
            // 宝可梦类型指示
            if (pokemonType != null && PokemonThemeState.useDynamicColors.value) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = getPokemonTypeDisplayName(pokemonType),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
        }
    }
}

// ===== 综合主题控制面板 =====
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonThemeControlPanel(
    modifier: Modifier = Modifier,
    onThemeChanged: (PokemonThemeMode) -> Unit = {},
    onPokemonTypeChanged: (String?) -> Unit = {},
    onDynamicColorChanged: (Boolean) -> Unit = {}
) {
    var showPanel by remember { mutableStateOf(false) }
    
    // 控制面板按钮
    FloatingActionButton(
        onClick = { showPanel = !showPanel },
        modifier = modifier
    ) {
        Text("🎨")
    }
    
    // 控制面板
    if (showPanel) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 标题
                Text(
                    text = "主题设置",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                
                // 动态配色开关
                PokemonDynamicColorSwitch(
                    onDynamicColorChanged = onDynamicColorChanged
                )
                
                // 宝可梦类型选择器
                PokemonTypeSelector(
                    onPokemonTypeSelected = onPokemonTypeChanged
                )
                
                // 主题模式选择器
                PokemonThemeSwitcher(
                    onThemeChanged = onThemeChanged
                )
                
                // 当前主题预览
                PokemonThemeIndicator()
            }
        }
    }
}
