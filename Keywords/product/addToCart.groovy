package product

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class addToCart {

	private TestObject getAddToCartButton(String productId) {
		TestObject to = new TestObject()
		to.addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS,
				"//button[@data-test='add-to-cart-${productId}']")
		return to
	}

	@Keyword
	def addProductToCart(String productId) {
		TestObject addButton = new TestObject()
		addButton.addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS,
				"//button[@data-test='add-to-cart-${productId}']")
		WebUI.click(addButton)
		WebUI.delay(1)
	}

	@Keyword
	def sauceLabsBackpack() {
		WebUI.click(getAddToCartButton("sauce-labs-backpack"))
	}

	@Keyword
	def sauceLabsBikeLight() {
		WebUI.click(getAddToCartButton("sauce-labs-bike-light"))
	}

	@Keyword
	def sauceLabsBoltTShirt() {
		WebUI.click(getAddToCartButton("sauce-labs-bolt-t-shirt"))
	}

	@Keyword
	def sauceLabsFleeceJacket() {
		WebUI.click(getAddToCartButton("sauce-labs-fleece-jacket"))
	}

	@Keyword
	def sauceLabsOnesie() {
		WebUI.click(getAddToCartButton("sauce-labs-onesie"))
	}

	@Keyword
	def testAllTheThingsRedShirt() {
		WebUI.click(getAddToCartButton("test.allthethings()-t-shirt-(red)"))
	}

	@Keyword
	def addMultipleProducts(List<String> productIds) {
		for (String productId : productIds) {
			addProductToCart(productId)
		}
	}
	
}