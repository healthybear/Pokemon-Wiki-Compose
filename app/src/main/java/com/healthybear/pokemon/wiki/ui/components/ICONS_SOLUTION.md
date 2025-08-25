# Material Icons 问题解决方案

## 问题描述
`Icons.Filled.Menu` 找不到引用，编译错误。

## 根本原因
缺少 Material Icons 依赖库。在 Jetpack Compose 中，Material Icons 是独立的库，需要单独添加依赖。

## 解决步骤

### 1. 添加 Gradle 依赖

在 `app/build.gradle` 文件的 `dependencies` 块中添加：

```gradle
dependencies {
    // 现有的依赖...
    
    // Material Icons 扩展库 (推荐，包含所有图标)
    implementation "androidx.compose.material:material-icons-extended:$compose_version"
    
    // 或者只使用核心库 (只包含常用图标)
    // implementation "androidx.compose.material:material-icons-core:$compose_version"
}
```

### 2. 确保 Compose 版本变量

确保你的 `build.gradle` 文件中定义了 `compose_version`：

```gradle
android {
    compileSdk 34
    
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_11
        targetCompatibility JavaVersion.VERSION_11
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion '1.5.14'
    }
}

dependencies {
    def compose_version = '1.6.8'
    
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material3:material3:1.2.1"
    implementation "androidx.compose.material:material-icons-extended:$compose_version"
    // 其他依赖...
}
```

### 3. 正确的导入方式

```kotlin
// 导入 Icons 对象
import androidx.compose.material.icons.Icons

// 导入具体的图标 (推荐方式)
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Palette

// 或者使用通配符导入 (不推荐，会导入所有图标)
// import androidx.compose.material.icons.filled.*
```

### 4. 使用示例

```kotlin
@Composable
fun MyTopBar() {
    TopAppBar(
        title = { Text("My App") },
        navigationIcon = {
            IconButton(onClick = { /* 处理点击 */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "菜单"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* 搜索 */ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "搜索"
                )
            }
        }
    )
}
```

## 可用的图标样式

- `Icons.Filled.*` - 填充样式 (最常用)
- `Icons.Outlined.*` - 轮廓样式
- `Icons.Rounded.*` - 圆角样式
- `Icons.Sharp.*` - 尖角样式
- `Icons.TwoTone.*` - 双色调样式

## 常用图标列表

```kotlin
Icons.Filled.Menu          // 菜单
Icons.Filled.Home          // 首页
Icons.Filled.Search        // 搜索
Icons.Filled.Settings      // 设置
Icons.Filled.Favorite      // 收藏
Icons.Filled.Info          // 信息
Icons.Filled.List          // 列表
Icons.Filled.Add           // 添加
Icons.Filled.Delete        // 删除
Icons.Filled.Edit          // 编辑
Icons.Filled.Share         // 分享
Icons.Filled.ArrowBack     // 返回箭头
Icons.Filled.MoreVert      // 更多 (垂直)
Icons.Filled.Palette      // 调色板
```

## 注意事项

1. **依赖大小**: `material-icons-extended` 会增加 APK 大小，如果只需要少量图标，考虑使用 `material-icons-core`
2. **版本兼容**: 确保 Material Icons 版本与 Compose 版本兼容
3. **导入优化**: 只导入需要的图标，避免使用通配符导入
4. **主题适配**: 图标会自动适配当前主题的颜色

## 同步项目

添加依赖后，在 Android Studio 中：
1. 点击 "Sync Now" 按钮
2. 或者使用菜单: File → Sync Project with Gradle Files
3. 等待同步完成后，图标引用就可以正常使用了