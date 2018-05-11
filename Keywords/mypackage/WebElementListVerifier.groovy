package mypackage

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

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