package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class interact_With_Inputs
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser brw = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page pg = brw.newPage();
        pg.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        pg.locator("input#user-message").fill("Hello I am Sudhanshu Yadav And We are Learning Playwright Automation");
        pg.locator("id=showInput").click();
        String  context = pg.locator("#message").textContent();
        System.out.println("You just wrote : "+context);
        pg.close();
        brw.close();
        pw.close();
    }
}
