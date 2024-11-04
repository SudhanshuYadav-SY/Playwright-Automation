package day4;

import com.microsoft.playwright.*;
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
        loc.selectOption("Monday");                         //Here, we use value to select dropdown
        assertThat(pg.locator("p.selected-value")).containsText("Monday");
        pg.close();
        brw.close();
        pw.close();
    }
}
