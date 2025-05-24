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

List<List> invalidLoginData = [['', GlobalVariable.PASSWORD, 'Epic sadface: Username is required'], [GlobalVariable.USERNAME_STANDAR
        , '', 'Epic sadface: Password is required'], ['wrong_user', GlobalVariable.PASSWORD, 'Epic sadface: Username and password do not match any user in this service']
    , [GlobalVariable.USERNAME_LOCKED, GlobalVariable.PASSWORD, 'Epic sadface: Sorry, this user has been locked out.']]


for (List<String> data : invalidLoginData) {
    String username = data[0]

    String password = data[1]

    String expectedError = data[2]

    WebUI.waitForElementPresent(findTestObject('Login Page/inputUsername'), 10)

    WebUI.clearText(findTestObject('Login Page/inputUsername'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Login Page/inputUsername'), username)

    WebUI.clearText(findTestObject('Login Page/inputPassword'), FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('Login Page/inputPassword'), password)

    WebUI.click(findTestObject('Login Page/buttonLogin'), FailureHandling.STOP_ON_FAILURE)

    String actualError = WebUI.getText(findTestObject('Login Page/errorMessage'))

    WebUI.refresh()

    assert actualError.contains(expectedError)
}

