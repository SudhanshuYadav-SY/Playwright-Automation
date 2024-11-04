package day3;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Handle_Check_Boxes
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser brw = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page pg = brw.newPage();
        pg.navigate("https://www.tutorialspoint.com/selenium/practice/check-box.php");
        Locator loc = pg.locator("#c_bs_1");
        assertThat(loc).not().isChecked();
        loc.check();
        assertThat(loc).isChecked();
        pg.close();
        brw.close();
        pw.close();
    }
}
