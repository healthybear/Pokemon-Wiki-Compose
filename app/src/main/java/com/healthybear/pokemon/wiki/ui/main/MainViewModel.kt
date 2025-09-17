package com.healthybear.pokemon.wiki.ui.main

import com.healthybear.pokemon.wiki.base.BaseViewModel
import com.healthybear.pokemon.wiki.ui.components.SampleItem

/**
 * @Author guojianhong
 * @Date 2025/9/17
 * @description
 */
class MainViewModel: BaseViewModel() {
    fun getTest(): String {
        return "test"
    }

    fun getTestList(): List<SampleItem> {
        return listOf(
            SampleItem("tes1", "cstes1"),
            SampleItem("tes2", "cstes2"),
            SampleItem("tes3", "cstes2"),
            SampleItem("tes4", "cstes2"),
            SampleItem("tes5", "cstes2")
        )
    }
}