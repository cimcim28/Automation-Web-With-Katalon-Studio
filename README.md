# 🧪 SauceDemo Test Automation – Katalon Studio

Automated UI testing project for [SauceDemo](https://www.saucedemo.com/) using **Katalon Studio**.  
This project demonstrates login, product interaction, cart validation, and checkout processes on SauceDemo.

---

## 📁 Project Structure

├── Test Cases/
│ ├── Login/
│ │ └── TC_Login_Valid
│ │ └── TC_Login_Invalid
│ ├── Product/
│ │ └── TC_Add_Product_To_Cart
│ │ └── TC_Checkout_Process
│
├── Object Repository/
│ ├── LoginPage/
│ ├── ProductPage/
│ └── CheckoutPage/
│
├── Test Listeners/
│ └── SauceDemoListener.groovy
│
├── Reports/
│ └── (Generated after test run)


---

## ▶️ How to Run the Tests

1. **Open Katalon Studio**  
   Open the project folder via Katalon Studio.

2. **Set Base URL (optional)**  
   Configure base URL via `Profiles > default` if needed.

3. **Run Individual Test Cases**  
   Right-click a test case → **Run**.

4. **Run Test Suite**  
   - Open `Test Suites/` folder
   - Run `SauceDemo_TestSuite` (or your test suite)

---

## 🧠 Features

- ✅ Login test (valid & invalid)
- 🛒 Add to cart & validate products
- 💳 Checkout process
- 📸 Auto-capture screenshot on test failure (via Test Listener)
- 📋 Centralized object repository

---

## 🧩 Test Listener

This project uses a listener named `SauceDemoListener` to log and manage test events.

- Logs test start, pass, fail status
- Automatically takes screenshot on test failure

You can find it in:  
`Test Listeners/SauceDemoListener.groovy`

```groovy
@AfterTestCase
def afterTestCase(TestCaseContext testCaseContext) {
    if (testCaseContext.getTestCaseStatus() == 'FAILED') {
        WebUI.takeScreenshot()
    }
}

---

🔧 Dependencies & Tools
Katalon Studio (tested on version 10.1.0

No external dependencies required

---

🛠 Environment Profiles
You can define test data or environment config in:
Profiles/default or create additional profiles for staging, production, etc.

---

📞 Author
Created by: cimcim28
GitHub: https://github.com/cimcim28



