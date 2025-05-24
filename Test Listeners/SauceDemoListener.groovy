import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class SauceDemoListener {
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		println "[START] Test case: " + testCaseContext.getTestCaseId()
		
		WebUI.openBrowser(GlobalVariable.URL)
	
		
		WebUI.waitForElementPresent(findTestObject('Login Page/inputUsername'), 0)
		WebUI.setText(findTestObject('Login Page/inputUsername'), GlobalVariable.USERNAME_STANDAR)
		WebUI.setText(findTestObject('Login Page/inputPassword'), GlobalVariable.PASSWORD)
		WebUI.click(findTestObject('Login Page/buttonLogin'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementText(findTestObject('Login Page/labelProduct'), 'Products')
		
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		if (testCaseContext.getTestCaseStatus() == 'PASSED') {
			println "[PASS] Test case: " + testCaseContext.getTestCaseId()
		} else if (testCaseContext.getTestCaseStatus() == 'FAILED') {
			println "[FAIL] Test case: " + testCaseContext.getTestCaseId()
		}
		
		WebUI.closeBrowser()		
	}
}