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

List<List> dataCart = [['sauce-labs-bike-light', 'Sauce Labs Bike Light'], ['sauce-labs-backpack', 'Sauce Labs Backpack']]

for (List item : dataCart) {
    String productId = item[0]

    CustomKeywords.'product.addToCart.addProductToCart'(productId)
}

WebUI.click(findTestObject('Product Page/cartButton'))

for (List item : dataCart) {
    String expectedName = item[1]

    TestObject cartItem = new TestObject()

    cartItem.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//div[@data-test='inventory-item-name' and text()='$expectedName']")

    WebUI.verifyElementPresent(cartItem, 5)
}

WebUI.delay(5)

