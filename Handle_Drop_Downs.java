package day4;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Handle_Drop_Downs
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser brw = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page pg = brw.newPage();
        pg.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        Locator loc = pg.locator("select#select-demo");
        loc.selectOption(new SelectOption().setValue("Friday"));
        assertThat(pg.locator("p.selected-value")).containsText("Friday");
        pg.close();
        brw.close();
        pw.close();
    }
}