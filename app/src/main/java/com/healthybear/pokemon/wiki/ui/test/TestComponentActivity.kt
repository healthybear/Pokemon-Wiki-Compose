package com.healthybear.pokemon.wiki.ui.test

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.healthybear.pokemon.wiki.R
import com.healthybear.pokemon.wiki.base.BaseActivity
import com.healthybear.pokemon.wiki.ui.main.MainActivity
import com.healthybear.pokemon.wiki.ui.theme.AppTheme

class TestComponentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                TestComponentScreen()
            }
        }
    }
}

@Composable
fun TestComponentScreen() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TestComponentScreenPreview() {
    AppTheme {
        TestComponentScreen()
    }
}