import static java.util.Comparator.*

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

