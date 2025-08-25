# Pokemon Wiki Android 项目

## 项目概述

Pokemon Wiki 是一个基于 Jetpack Compose 的 Android 应用，提供宝可梦图鉴功能和动态主题系统。项目采用现代化的 Android 开发架构，遵循单一责任原则和最佳实践。

## 技术架构

### 核心技术栈
- **UI框架**: Jetpack Compose + Material3
- **语言**: Kotlin 2.0.21
- **最低SDK**: API 24 (Android 7.0)
- **目标SDK**: API 36 (Android 14)
- **Java版本**: 11
- **AGP版本**: 8.11.1

### 架构模式
- **MVVM架构**: 使用 ViewModel 和 State 管理UI状态
- **单一责任原则**: 每个类和文件都有明确的职责
- **组件化设计**: UI组件按功能模块分离
- **状态管理**: 使用 Compose State 进行响应式状态管理

## 项目结构

```
com.healthybear.pokemon.wiki/
├── App.kt                           # 应用程序入口
├── MainActivity.kt                  # 主活动
├── mmkv/                           # 数据存储
│   └── SessionStorage.kt          # 会话存储管理
├── network/                        # 网络层
│   ├── constant/                   # 网络常量
│   ├── error/                      # 错误处理
│   ├── manager/                    # 网络管理
│   ├── repository/                 # 数据仓库
│   └── response/                   # 响应模型
└── ui/                            # 用户界面
    ├── components/                 # UI组件
    │   └── theme/                  # 主题相关组件
    │       ├── CurrentThemeStatus.kt      # 当前主题状态显示
    │       ├── PokemonDynamicColorSwitch.kt # 动态配色开关
    │       ├── PokemonThemeControlPanel.kt  # 主题控制面板
    │       ├── PokemonThemeSwitcher.kt      # 主题切换器
    │       ├── PokemonTypeSelector.kt       # 宝可梦类型选择器
    │       ├── SampleUIComponents.kt        # 示例UI组件
    │       └── ThemePreviewCards.kt         # 主题预览卡片
    └── theme/                      # 主题系统
        ├── Color.kt                # 颜色定义
        ├── ColorUtils.kt           # 颜色工具类
        ├── DynamicColorGenerator.kt # 动态配色生成器
        ├── Theme.kt                # 主题组合函数
        ├── ThemeData.kt            # 主题数据结构
        ├── ThemeStateManager.kt    # 主题状态管理
        └── Type.kt                 # 类型定义
```

## 核心功能

### 1. 动态主题系统
- **多主题支持**: 亮色、暗色、系统跟随、自动切换
- **宝可梦类型配色**: 根据选择的宝可梦类型自动生成配色方案
- **动态配色**: 支持 Android 12+ 的动态配色和自定义宝可梦配色
- **实时预览**: 提供主题和配色的实时预览功能

### 2. 宝可梦类型系统
- **18种类型**: 火、水、草、电、冰、格斗、毒、地面、飞行、超能、虫、岩石、幽灵、钢、妖精、龙、恶、一般
- **智能配色**: 每种类型都有对应的主色调和变体色
- **HSL色彩科学**: 使用HSL色彩空间进行智能色彩搭配

### 3. 组件化UI设计
- **模块化组件**: 每个UI功能都有独立的组件文件
- **可复用性**: 组件设计遵循可复用原则
- **响应式设计**: 支持不同屏幕尺寸和方向

## 开发规范

### 代码组织原则
1. **单一责任原则**: 每个类和方法只负责一个功能
2. **包结构清晰**: 按功能模块组织包结构
3. **命名规范**: 使用描述性的类名和方法名
4. **文档完整**: 每个公共API都有完整的文档注释

### 文件命名规范
- **类名**: PascalCase (如: `PokemonThemeSwitcher`)
- **文件名**: 与类名保持一致
- **包名**: 全小写，点分隔
- **常量**: UPPER_SNAKE_CASE

### 组件设计原则
- **职责单一**: 每个组件只负责一个UI功能
- **参数明确**: 组件参数使用有意义的名称
- **状态管理**: 使用 Compose State 管理组件状态
- **可测试性**: 组件设计便于单元测试

## 快速开始

### 环境要求
- Android Studio Hedgehog | 2023.1.1 或更高版本
- JDK 11 或更高版本
- Android SDK API 24-36

### 构建步骤
1. 克隆项目到本地
2. 在 Android Studio 中打开项目
3. 同步 Gradle 依赖
4. 运行应用到设备或模拟器

### 运行命令
```bash
# 构建项目
./gradlew build

# 安装到设备
./gradlew installDebug

# 运行测试
./gradlew test
```

## 主题系统使用

### 基本主题切换
```kotlin
// 切换到亮色主题
PokemonThemeState.setTheme(PokemonThemeMode.LIGHT)

// 切换到暗色主题
PokemonThemeState.setTheme(PokemonThemeMode.DARK)

// 跟随系统设置
PokemonThemeState.setTheme(PokemonThemeMode.SYSTEM)
```

### 宝可梦类型选择
```kotlin
// 选择火系宝可梦类型
PokemonThemeState.setPokemonType("fire")

// 启用动态配色
PokemonThemeState.setUseDynamicColors(true)
```

### 自定义组件使用
```kotlin
// 使用主题切换器
PokemonThemeSwitcher(
    onThemeChanged = { theme ->
        // 处理主题变化
    }
)

// 使用类型选择器
PokemonTypeSelector(
    onPokemonTypeSelected = { type ->
        // 处理类型选择
    }
)
```

## 测试

### 测试策略
- **单元测试**: 使用 JUnit 4 测试业务逻辑
- **UI测试**: 使用 Compose Testing 测试UI组件
- **集成测试**: 测试组件间的交互

### 测试覆盖率目标
- 代码覆盖率 > 80%
- 关键业务逻辑 100% 覆盖
- UI组件交互测试完整

## 性能优化

### 内存管理
- 使用 MMKV 进行高效数据存储
- 及时释放不需要的资源
- 避免内存泄漏

### UI性能
- 使用 Compose 进行声明式UI开发
- 避免过度绘制
- 使用 LazyColumn 等懒加载组件

### 网络优化
- 使用 Retrofit 进行网络请求
- 实现请求拦截器和响应缓存
- 错误重试机制

## 贡献指南

### 代码提交规范
- 提交信息格式: `type: description`
- 类型包括: `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`

### 代码审查要求
- 遵循项目命名规范
- 确保错误处理机制完善
- 添加必要的单元测试
- 更新相关文档

## 许可证

本项目采用 Apache License 2.0 许可证。

## 联系方式

如有问题或建议，请通过以下方式联系：
- 项目Issues: [GitHub Issues](https://github.com/your-repo/issues)
- 邮箱: your-email@example.com

## 更新日志

### v1.0.0 (2024-01-XX)
- 🎉 初始版本发布
- ✨ 实现动态主题系统
- ✨ 支持18种宝可梦类型配色
- ✨ 组件化UI设计
- ✨ 完整的主题预览功能
