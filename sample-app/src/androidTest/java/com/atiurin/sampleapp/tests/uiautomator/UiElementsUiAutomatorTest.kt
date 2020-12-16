package com.atiurin.sampleapp.tests.uiautomator

import androidx.test.platform.app.InstrumentationRegistry
import com.atiurin.sampleapp.R
import com.atiurin.sampleapp.framework.Log
import com.atiurin.sampleapp.framework.utils.TestDataUtils
import com.atiurin.sampleapp.pages.BySelectorUiElementsPage
import com.atiurin.sampleapp.tests.UiElementsTest
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.extensions.click
import com.atiurin.ultron.extensions.containsText
import com.atiurin.ultron.extensions.getText
import com.atiurin.ultron.extensions.hasText
import com.atiurin.ultron.utils.getTargetString
import junit.framework.Assert
import org.junit.Before
import org.junit.Test

class UiElementsUiAutomatorTest: UiElementsTest() {
    val page = BySelectorUiElementsPage()

    @Before
    fun speedUpAutomator(){
        UltronConfig.UiAutomator.setIdlingTimeout(0)
    }
    @Test
    fun click_onClickable() {
        page.button.click()
        page.eventStatus.containsText(TestDataUtils.getResourceString(R.string.button_event_click))
    }

    @Test
    fun hasText_CorrectText_withResourceId() {
        Thread.sleep(2000)
        page.editTextContentDesc.hasText("Default content description")
    }

    @Test
    fun getTextTest(){
        Assert.assertEquals(getTargetString(R.string.button_text), page.button.getText())
    }
}