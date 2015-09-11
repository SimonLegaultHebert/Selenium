To use the ChromeWebDriver you need to install the WebDriver for Chrome :
https://sites.google.com/a/chromium.org/chromedriver/downloads

You also need to have the Chrome browser installed on your computer.

System.setProperty("webdriver.chrome.driver", "path to\\chromedriver.exe");
WebDriver driver = new ChromeDriver();