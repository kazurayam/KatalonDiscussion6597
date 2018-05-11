package mypackage

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

class WebElementListVerifier {

	@Keyword
	def boolean verifySortedNatural(List<WebElement> list) {
		List<WebElement> natural =
				list.sort(false, {left, right -> left.getText() <=> right.getText()})
		//natural.each {
		//	WebUI.comment("natural: ${it.getAttribute('outerHTML')}")
		//}
		def left, right
		try {
			for (int i = 0; i < list.size(); i++) {
				left  = list.get(i).getText()
				right = natural.get(i).getText()
				//WebUI.comment("left=${left},right=${right}")
				assert left == right
			}
		} catch (AssertionError e) {
			StringBuilder sb = new StringBuilder()
			list.each {
				sb.append("${it.getAttribute('outerHTML')}\n")
			}
			KeywordUtil.markFailed("Not ordered natural.\n${sb.toString()}\nactual <=> expected\n\'${left}\' <=> \'${right}\'")
			return false
		}
		return true
	}

	@Keyword
	def boolean verifySortedReverse(List<WebElement> list) {
		List<WebElement> reverse =
				list.sort(false, {left, right -> right.getText() <=> left.getText()})
		//list.each {
		//	WebUI.comment("list: ${it.getAttribute('outerHTML')}")
		//}
		//reverse.each {
		//	WebUI.comment("reverse: ${it.getAttribute('outerHTML')}")
		//}
		def left, right
		try {
			for (int i = 0; i < list.size(); i++) {
				left  = list.get(i).getText()
				right = reverse.get(i).getText()
				//WebUI.comment("left=${left},right=${right}")
				assert left == right
			}
		} catch (AssertionError e) {
			StringBuilder sb = new StringBuilder()
			list.each {
				sb.append("${it.getAttribute('outerHTML')}\n")
			}
			KeywordUtil.markFailed("Not ordered reverse.\n${sb.toString()}\nactual <=> expected\n\'${left}\' <=> \'${right}\'")
			return false
		}
		return true
	}
}