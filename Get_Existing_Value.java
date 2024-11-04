package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Get_Existing_Value
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser brw = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page pg = brw.newPage();
        pg.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        pg.locator("#sum1").type("I am Sudhanshu Yadav");
        String input1 = pg.locator("#sum1").inputValue();
        System.out.println("Input Value 1 = "+input1);
        pg.locator("#sum2").type("I work as Automation QA");
        String input2 = pg.locator("#sum2").inputValue();
        System.out.println("Input Value 2 = "+input2);
        pg.close();
        brw.close();
        pw.close();
    }
}
