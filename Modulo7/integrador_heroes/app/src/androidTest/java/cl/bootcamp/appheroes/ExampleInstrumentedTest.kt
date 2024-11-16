package cl.bootcamp.appheroes

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import cl.bootcamp.appheroes.components.CardHeroe
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun verificarUsodeCard() {
        composeTestRule.activity.setContent {
            CardHeroe("Spider-Man", "Comic", "https://i.ibb.co/RHcnpcw/spiderman-comic.jpg", {})
        }
        composeTestRule.onNodeWithTag("CardHeroe").assertExists()
    }


}