# 必需的 Gradle 依赖配置

## 在 app/build.gradle 文件中添加以下依赖：

```gradle
dependencies {
    // Material 3 核心库
    implementation "androidx.compose.material3:material3:1.2.1"
    
    // Material Icons 核心库 (包含基础图标)
    implementation "androidx.compose.material:material-icons-core:$compose_version"
    
    // Material Icons 扩展库 (包含更多图标，推荐使用)
    implementation "androidx.compose.material:material-icons-extended:$compose_version"
    
    // 或者使用具体版本号
    implementation "androidx.compose.material:material-icons-extended:1.6.8"
}
```

## 版本变量配置

如果你的项目使用版本变量，确保在 `build.gradle` 顶部或 `gradle/libs.versions.toml` 中定义：

```gradle
// 在 build.gradle 顶部
ext {
    compose_version = '1.6.8'
}

// 或者在 gradle/libs.versions.toml 中
[versions]
compose = "1.6.8"
material-icons = "1.6.8"

[libraries]
compose-material-icons-extended = { module = "androidx.compose.material:material-icons-extended", version.ref = "material-icons" }
```

## 同步项目

添加依赖后，点击 Android Studio 中的 "Sync Now" 按钮同步项目。