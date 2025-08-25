# Material Icons 依赖说明

## 必需的 Gradle 依赖

为了使用 Material Icons，需要在 `app/build.gradle` 文件中添加以下依赖：

```gradle
dependencies {
    // Material Icons Extended (包含更多图标)
    implementation "androidx.compose.material:material-icons-extended:$compose_version"
    
    // 或者使用基础版本 (只包含常用图标)
    implementation "androidx.compose.material:material-icons-core:$compose_version"
}
```

## 图标使用方法

### 基础图标 (Icons.Filled)
```kotlin
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

// 使用示例
Icon(
    imageVector = Icons.Filled.Menu,
    contentDescription = "菜单"
)
```

### 可用的图标样式
- `Icons.Filled.*` - 填充样式图标
- `Icons.Outlined.*` - 轮廓样式图标  
- `Icons.Rounded.*` - 圆角样式图标
- `Icons.Sharp.*` - 尖角样式图标
- `Icons.TwoTone.*` - 双色调样式图标

### 常用图标列表
- `Icons.Filled.Menu` - 菜单图标
- `Icons.Filled.Home` - 首页图标
- `Icons.Filled.Search` - 搜索图标
- `Icons.Filled.Settings` - 设置图标
- `Icons.Filled.Favorite` - 收藏图标
- `Icons.Filled.Info` - 信息图标
- `Icons.Filled.List` - 列表图标
- `Icons.Filled.Palette` - 调色板图标

## 注意事项

1. 如果使用 `material-icons-extended`，会增加 APK 大小，但提供更多图标选择
2. 如果只需要基础图标，使用 `material-icons-core` 即可
3. 图标颜色会自动适配当前主题的颜色方案
4. 可以通过 `tint` 参数自定义图标颜色

## 项目中的使用

本项目的 `AppTopBar.kt` 组件已经正确配置了 Material Icons 的使用：

```kotlin
Icon(
    imageVector = Icons.Filled.Menu,
    contentDescription = "打开菜单",
    tint = MaterialTheme.colorScheme.onSurface
)
```