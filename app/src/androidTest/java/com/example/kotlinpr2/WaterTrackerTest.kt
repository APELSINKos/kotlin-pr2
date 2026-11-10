package com.example.kotlinpr2

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// Task 9: UI tests for the WaterTracker screen from task 8
class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            WaterTracker()
        }
    }

    // 1) the "+250 мл" button is shown and adds 250 ml on every click
    @Test
    fun addWaterButton_adds250ml() {
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("500 мл").assertIsDisplayed()
    }

    // 2) the "Завершить день" button is shown and resets the water counter
    @Test
    fun finishDayButton_resetsWater() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("Завершить день").performClick()

        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
    }

    // 3) the text with days in a row grows after 1500 ml and is reset after less
    @Test
    fun daysText_showsDaysInARow() {
        composeTestRule.onNodeWithText("Дней подряд (от 1500 мл): 0").assertIsDisplayed()

        repeat(6) {
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }
        composeTestRule.onNodeWithText("1500 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд (от 1500 мл): 1").assertIsDisplayed()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд (от 1500 мл): 0").assertIsDisplayed()
    }
}
