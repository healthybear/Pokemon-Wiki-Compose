# Pokemon Wiki - 口袋妖怪图鉴

[![Android](https://img.shields.io/badge/Android-API%2024+-brightgreen.svg)](https://developer.android.com/about/versions/android-7.0)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-blue.svg)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-1.6.0-orange.svg)](https://developer.android.com/jetpack/compose)
[![Material3](https://img.shields.io/badge/Material%20Design%203-最新版本-purple.svg)](https://m3.material.io/)

## 📱 项目概述

Pokemon Wiki 是一个专为口袋妖怪爱好者打造的现代化图鉴应用，采用最新的 Android 开发技术栈，提供流畅的用户体验和丰富的功能特性。

### ✨ 核心特性

- 🎨 **口袋妖怪主题设计** - 基于经典宝可梦元素的专属色彩方案
- 🌓 **智能主题切换** - 支持亮色、暗色、跟随系统、自动切换四种模式
- 📱 **现代化UI** - 基于 Jetpack Compose 和 Material Design 3
- 🌐 **网络数据获取** - 实时获取最新的宝可梦信息
- 💾 **本地缓存** - 使用 MMKV 进行高效数据存储
- 🖼️ **图片加载** - 支持 GIF、SVG、Video 等多种格式
- 📱 **响应式设计** - 适配各种屏幕尺寸和设备

## 🏗️ 技术架构

### 核心技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| **Android SDK** | API 24-36 | 支持 Android 7.0 及以上版本 |
| **Kotlin** | 2.0.21 | 主要开发语言 |
| **Jetpack Compose** | 1.6.0 | 现代化UI框架 |
| **Material Design 3** | 最新版本 | 设计系统 |
| **AGP** | 8.11.1 | Android Gradle Plugin |

### 架构组件

```
com.healthybear.pokemon.wiki/
├── App.kt                    # 应用程序入口
├── MainActivity.kt           # 主活动
├── mmkv/                     # 数据存储
├── network/                  # 网络层
│   ├── constant/            # 网络常量
│   ├── error/               # 错误处理
│   ├── manager/             # 网络管理
│   ├── repository/          # 数据仓库
│   └── response/            # 响应模型
└── ui/                      # 用户界面
    └── theme/               # 主题相关
        ├── Color.kt         # 核心色彩定义
        ├── Theme.kt         # 主题配置和状态管理
        ├── ThemeSwitcher.kt # 主题切换UI组件
        ├── ThemeData.kt     # 主题相关数据结构
        └── README.md        # 主题系统使用说明
```

### 网络架构

- **HTTP客户端**: Retrofit 3.0.0 + OkHttp 5.0.0
- **数据序列化**: Moshi (JSON)
- **网络拦截器**: OkHttp Logging Interceptor
- **错误处理**: 自定义异常处理机制

### 数据存储

- **键值存储**: MMKV (腾讯开源)
- **会话管理**: 自定义 SessionStorage

### 图片加载

- **主要**: Coil 2.7.0
- **支持格式**: GIF, SVG, Video
- **备选**: Glide 4.16.0

## 🎨 主题系统

### 口袋妖怪主题色彩

项目采用专门设计的口袋妖怪主题色彩系统，包括：

- **核心色彩**: 皮卡丘金、妙蛙绿、小火龙橙等
- **类型色彩**: 18种宝可梦类型专用色彩
- **状态色彩**: 成功、警告、错误等状态指示色彩
- **渐变色彩**: 多种主题渐变效果

### 主题模式

- **LIGHT**: 亮色主题
- **DARK**: 暗色主题  
- **SYSTEM**: 跟随系统设置
- **AUTO**: 自动切换

### 🚀 动态配色系统

项目实现了基于 Material Design 3 的智能动态配色系统：

- **🎨 智能配色生成**: 根据用户选择的宝可梦类型自动生成完整配色方案
- **🌓 主题模式支持**: 支持亮色/暗色主题切换，兼容 Android 12+ 系统动态配色
- **🔄 动态配色优先级**: 宝可梦动态配色 > 系统动态配色 > 静态配色回退
- **📱 完整UI组件**: 提供主题切换器、类型选择器、控制面板等完整组件

详细的主题系统使用说明请参考：[主题系统使用指南](app/src/main/java/com/healthybear/pokemon/wiki/ui/theme/README.md)

动态配色系统详细说明请参考：[动态配色系统使用指南](app/src/main/java/com/healthybear/pokemon/wiki/ui/theme/DynamicTheme_README.md)

## 🚀 快速开始

### 环境要求

- Android Studio Hedgehog | 2023.1.1 或更高版本
- Android SDK API 36
- JDK 11
- Gradle 8.0+

### 安装步骤

1. **克隆项目**
   ```bash
   git clone [项目地址]
   cd Pokemon-Wiki
   ```

2. **打开项目**
   - 使用 Android Studio 打开项目
   - 等待 Gradle 同步完成

3. **运行应用**
   - 连接 Android 设备或启动模拟器
   - 点击运行按钮

### 构建配置

- **调试版本**: `./gradlew assembleDebug`
- **发布版本**: `./gradlew assembleRelease`
- **测试**: `./gradlew test`

## 📚 开发指南

### 代码规范

- **语言**: 优先使用 Kotlin
- **UI框架**: 使用 Jetpack Compose
- **架构模式**: 遵循 MVVM 架构
- **命名规范**: 遵循 Android 官方命名约定

### 主题开发

- **色彩定义**: 在 `Color.kt` 中定义新色彩
- **主题配置**: 在 `Theme.kt` 中配置主题
- **组件开发**: 使用 `ThemeSwitcher.kt` 中的组件
- **数据结构**: 在 `ThemeData.kt` 中定义数据结构

### 网络开发

- **API接口**: 在 `network/repository` 中定义
- **数据模型**: 在 `network/response` 中定义
- **错误处理**: 使用自定义异常处理机制

## 📖 文档导航

### 核心文档

- [主题系统使用指南](app/src/main/java/com/healthybear/pokemon/wiki/ui/theme/README.md) - 口袋妖怪主题系统的详细使用说明

### 技术文档

- [项目规则](.cursorrules) - 项目开发规则和规范
- [构建配置](build.gradle.kts) - 项目构建配置
- [应用配置](app/build.gradle.kts) - 应用模块配置
- [版本管理](gradle/libs.versions.toml) - 依赖版本管理

### 代码文档

- [应用入口](app/src/main/java/com/healthybear/pokemon/wiki/App.kt) - 应用程序入口点
- [主活动](app/src/main/java/com/healthybear/pokemon/wiki/MainActivity.kt) - 主活动实现
- [主题色彩](app/src/main/java/com/healthybear/pokemon/wiki/ui/theme/Color.kt) - 主题色彩定义
- [主题配置](app/src/main/java/com/healthybear/pokemon/wiki/ui/theme/Theme.kt) - 主题配置和状态管理

## 🤝 贡献指南

### 开发流程

1. Fork 项目
2. 创建功能分支
3. 提交代码
4. 创建 Pull Request

### 代码审查

- 遵循项目代码规范
- 确保代码质量
- 添加必要的测试
- 更新相关文档

## 📄 许可证

本项目采用 [MIT 许可证](LICENSE)。

## 📞 联系我们

- **项目维护者**: HealthyBear Team
- **邮箱**: [联系邮箱]
- **项目地址**: [项目地址]

---

⭐ 如果这个项目对您有帮助，请给我们一个星标！
