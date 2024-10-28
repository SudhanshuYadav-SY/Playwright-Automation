package day2;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class login_to_Application
{
    public static void main(String[] args) {
        Playwright pw = Playwright.create();
        Browser brw = pw.webkit().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page pg = brw.newPage();
        pg.navigate("https://tutorialsninja.com/demo/index.php");
        Locator loc = pg.locator("//span[text()='My Account']");
        loc.click();
        pg.locator("//a[text()='Login']").click();
        assertThat(pg).hasTitle("Account Login");
        pg.getByPlaceholder("E-Mail Address").type("amotooricap8@gmail.com");
        pg.getByPlaceholder("Password").type("12345");
        pg.locator("//*[@value='Login']").click();
        assertThat(pg).hasTitle("My Account");
        pg.close();
        brw.close();
        pw.close();
    }
}