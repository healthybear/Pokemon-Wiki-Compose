package com.healthybear.pokemon.wiki.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.healthybear.pokemon.wiki.base.BaseActivity
import com.healthybear.pokemon.wiki.ui.components.AppTopBarWithDrawer
import com.healthybear.pokemon.wiki.ui.components.DynamicLiewView
import com.healthybear.pokemon.wiki.ui.theme.AppTheme

class MainActivity : BaseActivity() {
    val mMainViewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                // 方法1: 传递Activity中的ViewModel实例
                PokemonWikiApp(viewModel = mMainViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonWikiApp(viewModel: MainViewModel) {
    AppTopBarWithDrawer(
        title = "Pokemon Wiki",
        actions = {
            // 搜索按钮
            IconButton(onClick = { /* TODO: 实现搜索功能 */ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "搜索",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            // 设置按钮
            IconButton(onClick = { /* TODO: 打开设置页面 */ }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "设置",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    ) {
        // 主要内容区域
        MainContent(viewModel = viewModel)
    }
}

@Composable
private fun MainContent(viewModel: MainViewModel) {
    val testList = viewModel.getTestList()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        DynamicLiewView(
            items = testList
        )
    }
}

@Preview(name = "Pokemon Wiki App")
@Composable
private fun PokemonWikiAppPreview() {
    val thiViewModel: MainViewModel = viewModel()
    AppTheme {
        PokemonWikiApp(viewModel = thiViewModel)
    }
}