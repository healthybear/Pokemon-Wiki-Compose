package com.healthybear.pokemon.wiki.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * 应用字体排版系统
 * 基于 Material Design 3 的字体排版规范，定义了应用中所有文本样式
 * 包含从大标题到小标签的完整字体层次结构，确保一致的视觉体验和良好的可读性
 */
val AppTypography = Typography(
    // ========================================
    // Display 系列 - 用于最大最醒目的文本
    // ========================================
    
    /** 
     * 超大显示文本样式 - 用于应用中最重要的标题
     * 适用场景：启动页标题、主要功能区标题、重要公告标题
     * 字体大小：57sp，适合大屏幕显示和强调重要信息
     */
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    
    /** 
     * 大显示文本样式 - 用于重要的标题文本
     * 适用场景：页面主标题、功能模块标题、重要内容标题
     * 字体大小：45sp，提供良好的视觉层次和可读性
     */
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),
    
    /** 
     * 小显示文本样式 - 用于次级重要的标题
     * 适用场景：卡片标题、对话框标题、次要功能标题
     * 字体大小：36sp，在保持醒目的同时适合更多使用场景
     */
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp,
    ),
    
    // ========================================
    // Headline 系列 - 用于标题文本
    // ========================================
    
    /** 
     * 大标题文本样式 - 用于页面或区域的主要标题
     * 适用场景：页面标题、主要内容区标题、重要列表标题
     * 字体大小：32sp，提供清晰的内容层次结构
     */
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    
    /** 
     * 中标题文本样式 - 用于次级标题
     * 适用场景：章节标题、功能区标题、重要信息标题
     * 字体大小：28sp，在标题层次中提供中等重要性
     */
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),
    
    /** 
     * 小标题文本样式 - 用于小节标题
     * 适用场景：子标题、卡片标题、列表组标题
     * 字体大小：24sp，适合较小区域的标题显示
     */
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    
    // ========================================
    // Title 系列 - 用于标题和重要文本
    // ========================================
    
    /** 
     * 大标题文本样式 - 用于重要的内容标题
     * 适用场景：工具栏标题、重要按钮文本、强调内容
     * 字体大小：22sp，字重中等，提供良好的视觉重量
     */
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    
    /** 
     * 中标题文本样式 - 用于中等重要性的标题
     * 适用场景：列表项标题、卡片标题、对话框标题
     * 字体大小：16sp，字重中等，适合多种UI组件
     */
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    
    /** 
     * 小标题文本样式 - 用于较小的标题文本
     * 适用场景：标签页标题、小按钮文本、次要标题
     * 字体大小：14sp，字重中等，适合紧凑的界面元素
     */
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    
    // ========================================
    // Body 系列 - 用于正文内容
    // ========================================
    
    /** 
     * 大正文文本样式 - 用于主要的正文内容
     * 适用场景：文章正文、详细描述、主要信息展示
     * 字体大小：16sp，提供良好的阅读体验和可读性
     */
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    
    /** 
     * 中正文文本样式 - 用于标准的正文内容
     * 适用场景：列表项描述、卡片内容、一般信息文本
     * 字体大小：14sp，是最常用的正文字体大小
     */
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    
    /** 
     * 小正文文本样式 - 用于较小的正文内容
     * 适用场景：辅助信息、说明文字、次要描述
     * 字体大小：12sp，适合显示补充信息
     */
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),
    
    // ========================================
    // Label 系列 - 用于标签和按钮文本
    // ========================================
    
    /** 
     * 大标签文本样式 - 用于重要的标签和按钮
     * 适用场景：主要按钮文本、重要标签、强调性标识
     * 字体大小：14sp，字重中等，确保按钮文本的可读性
     */
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    
    /** 
     * 中标签文本样式 - 用于标准的标签和按钮
     * 适用场景：普通按钮、标签、导航项文本
     * 字体大小：12sp，字重中等，适合大多数交互元素
     */
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    
    /** 
     * 小标签文本样式 - 用于小型标签和按钮
     * 适用场景：小按钮、标签、状态指示器、徽章文本
     * 字体大小：11sp，字重中等，适合紧凑的UI元素
     */
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
)
