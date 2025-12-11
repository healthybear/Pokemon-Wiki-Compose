package com.healthybear.pokemon.wiki

import android.app.Application
import com.healthybear.pokemon.wiki.util.SSLUtil

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // 初始化SSL绕过（仅开发环境！）
        SSLUtil.initGlobalSSL()
    }
}