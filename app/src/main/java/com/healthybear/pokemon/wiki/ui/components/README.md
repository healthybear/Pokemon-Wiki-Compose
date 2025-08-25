# UI Components

## AppTopBar 组件

### 功能特性
- Material3 设计风格的标题栏
- 支持左侧菜单按钮和侧边抽屉
- 可自定义右侧操作按钮
- 响应式设计，支持浅色和深色主题
- 完整的侧边菜单实现

### 使用方法

#### 基础标题栏
```kotlin
AppTopBar(
    title = "页面标题",
    onMenuClick = { 
        // 处理菜单点击事件
    }
)
```

#### 带侧边菜单的标题栏
```kotlin
AppTopBarWithDrawer(
    title = "应用标题",
    actions = {
        IconButton(onClick = { /* 搜索 */ }) {
            Icon(Icons.Default.Search, contentDescription = "搜索")
        }
        IconButton(onClick = { /* 设置 */ }) {
            Icon(Icons.Default.Settings, contentDescription = "设置")
        }
    }
) {
    // 主要内容区域
    YourMainContent()
}
```

### 组件参数

#### AppTopBar
- `title`: 标题文本
- `onMenuClick`: 菜单按钮点击回调
- `modifier`: 修饰符
- `navigationIcon`: 导航图标（默认为菜单图标）
- `actions`: 右侧操作按钮
- `colors`: 标题栏颜色配置
- `scrollBehavior`: 滚动行为配置

#### AppTopBarWithDrawer
- 包含 AppTopBar 的所有参数
- `drawerState`: 抽屉状态
- `drawerContent`: 自定义侧边菜单内容
- `content`: 主要内容区域

### 自定义侧边菜单

如果需要自定义侧边菜单内容，可以传入 `drawerContent` 参数：

```kotlin
AppTopBarWithDrawer(
    title = "自定义菜单",
    drawerContent = {
        // 自定义菜单内容
        Column(modifier = Modifier.padding(16.dp)) {
            Text("自定义菜单项 1")
            Text("自定义菜单项 2")
        }
    }
) {
    // 主要内容
}
```

### 主题支持

组件完全支持应用的主题系统，会自动适配：
- 浅色/深色主题
- 动态颜色（Android 12+）
- 自定义颜色方案

### 无障碍支持

- 所有交互元素都有适当的 `contentDescription`
- 支持键盘导航
- 符合 Material Design 无障碍指南