import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

import static java.util.Comparator.*
import java.util.stream.Collectors

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demoaut-mimic.kazurayam.com/6597_testbed.html')

WebDriver driver = DriverFactory.getWebDriver()

'To locate table'
/*
 <table id="customers">
 <tbody>
 <tr>
   <th>Company</th>
   <th>Contact</th>
   <th>Country</th>
 </tr>
 <tr>
   <td>Alfreds Futterkiste</td>
   <td>Maria Anders</td>
   <td>Germany</td>
 </tr>
 <tr>
   <td>Centro comercial Moctezuma</td>
   <td>Francisco Chang</td>
   <td>Mexico</td>
 </tr>
 <tr>
   <td>Ernst Handel</td>
   <td>Roland Mendel</td>
   <td>Austria</td>
 </tr>
 <tr>
   <td>Island Trading</td>
   <td>Helen Bennett</td>
   <td>UK</td>
 </tr>
 <tr>
   <td>Laughing Bacchus Winecellars</td>
   <td>Yoshi Tannamuri</td>
   <td>Canada</td>
 </tr>
 <tr>
   <td>Magazzini Alimentari Riuniti</td>
   <td>Giovanni Rovelli</td>
   <td>Italy</td>
 </tr>
 </tbody>
 </table>
 */
WebElement table = driver.findElement(By.xpath('//table[@id="customers"]'))
WebUI.comment("${table.getAttribute('outerHTML')}")

'To select a set of <td> element of each rows'
List<WebElement> original = table.findElements(By.xpath('./tbody/tr/td[1]'))
original.each {
	WebUI.comment("original: ${it.getAttribute('outerHTML')}")
}

'verify if the original is NATURAL ordered --> should PASS'
CustomKeywords.'mypackage.WebElementListVerifier.verifySortedNatural'(original)

'verify if the original is REVERSE ordered --> should FAIL'
CustomKeywords.'mypackage.WebElementListVerifier.verifySortedReverse'(original)

WebUI.closeBrowser()

