import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

List<String> products = ['sauce-labs-backpack', 'sauce-labs-bike-light', 'sauce-labs-bolt-t-shirt', 'sauce-labs-fleece-jacket']

for (String product : products) {
    CustomKeywords.'product.addToCart.addProductToCart'(product)
}

WebUI.click(findTestObject('Product Page/cartButton'))

WebUI.scrollToElement(findTestObject('Product Page/checkoutButton'), 0)

WebUI.waitForElementPresent(findTestObject('Product Page/checkoutButton'), 0)

WebUI.click(findTestObject('Product Page/checkoutButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Checkout Page/inputFirstName'), 0)

WebUI.setText(findTestObject('Checkout Page/inputFirstName'), 'Jhon')

WebUI.setText(findTestObject('Checkout Page/inputLastName'), 'Doe')

WebUI.setText(findTestObject('Checkout Page/inputPostalCode'), '112233')

WebUI.scrollToElement(findTestObject('Checkout Page/continueButton'), 0)

WebUI.click(findTestObject('Checkout Page/continueButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Checkout Page/finishButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(WebUI.getText(findTestObject('Checkout Page/successMessage')), 'Thank you for your order!', false)

