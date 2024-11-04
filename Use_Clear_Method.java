package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Use_Clear_Method
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser brw = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page pg = brw.newPage();
        pg.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        pg.locator("#sum1").type("Hello I am Sudhanshu Yadav");
        String input1 = pg.locator("#sum1").inputValue();
        System.out.println("Input Value Before Clearing = "+input1);
        pg.locator("#sum1").clear();
        String input2 = pg.locator("#sum1").inputValue();
        System.out.println("Input Value After Cleaning = "+input2);
        pg.close();
        brw.close();
        pw.close();
    }
}
