package com.healthybear.pokemon.wiki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthybear.pokemon.wiki.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonWiki_ComposeTheme {
                PokemonThemeDemo()
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonThemeDemo() {
    var showThemePanel by remember { mutableStateOf(false) }
    
    // 获取当前颜色方案
    val colorScheme = MaterialTheme.colorScheme
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("🎨 宝可梦动态主题演示") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.primary,
                    titleContentColor = colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            PokemonThemeControlPanel(
                onThemeChanged = { theme ->
                    PokemonThemeState.setTheme(theme)
                },
                onPokemonTypeChanged = { type ->
                    PokemonThemeState.setPokemonType(type)
                },
                onDynamicColorChanged = { use ->
                    PokemonThemeState.setUseDynamicColors(use)
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 当前主题状态显示
            CurrentThemeStatus()
            
            // 宝可梦类型选择器
            PokemonTypeSelector(
                onPokemonTypeSelected = { type ->
                    PokemonThemeState.setPokemonType(type)
                }
            )
            
            // 动态配色开关
            PokemonDynamicColorSwitch(
                onDynamicColorChanged = { use ->
                    PokemonThemeState.setUseDynamicColors(use)
                }
            )
            
            // 主题模式选择器
            PokemonThemeSwitcher(
                onThemeChanged = { theme ->
                    PokemonThemeState.setTheme(theme)
                }
            )
            
            // 主题预览卡片
            ThemePreviewCards()
            
            // 示例UI组件展示
            SampleUIComponents()
        }
    }
}

@Composable
fun CurrentThemeStatus() {
    val currentTheme = rememberPokemonTheme()
    val selectedType by PokemonThemeState.selectedPokemonType
    val useDynamicColors by PokemonThemeState.useDynamicColors
    
    // 获取当前颜色方案
    val colorScheme = MaterialTheme.colorScheme
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "当前主题状态",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("主题模式:")
                Text(
                    text = when (currentTheme) {
                        PokemonThemeMode.LIGHT -> "☀️ 亮色"
                        PokemonThemeMode.DARK -> "🌙 暗色"
                        PokemonThemeMode.SYSTEM -> "⚙️ 系统"
                        PokemonThemeMode.AUTO -> "🔄 自动"
                    },
                    fontWeight = FontWeight.Medium
                )
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("宝可梦类型:")
                Text(
                    text = selectedType?.let { type -> "🎯 ${getPokemonTypeDisplayName(type)}" } ?: "未选择",
                    fontWeight = FontWeight.Medium
                )
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("动态配色:")
                Text(
                    text = if (useDynamicColors) "✅ 开启" else "❌ 关闭",
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun ThemePreviewCards() {
    val selectedType by PokemonThemeState.selectedPokemonType
    
    Text(
        text = "主题预览",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
    
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PokemonEnhancedThemePreviewCard(
            theme = PokemonThemeMode.LIGHT,
            pokemonType = selectedType,
            modifier = Modifier.weight(1f)
        )
        
        PokemonEnhancedThemePreviewCard(
            theme = PokemonThemeMode.DARK,
            pokemonType = selectedType,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SampleUIComponents() {
    Text(
        text = "示例UI组件",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
    
    // 获取当前颜色方案
    val colorScheme = MaterialTheme.colorScheme
    
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // 按钮示例
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("主要按钮")
        }
        
        OutlinedButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("轮廓按钮")
        }
        
        TextButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("文本按钮")
        }
        
        // 卡片示例
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "示例卡片",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "这是一个使用当前主题配色的示例卡片，展示了动态配色方案的效果。",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        // 输入框示例
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("示例输入框") },
            modifier = Modifier.fillMaxWidth()
        )
        
        // 开关示例
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("示例开关")
            Switch(
                checked = false,
                onCheckedChange = { }
            )
        }
    }
}