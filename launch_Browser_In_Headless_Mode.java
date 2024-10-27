package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class launch_Browser_In_Headless_Mode
{
    public static void main(String[] args)
    {
       Playwright pw = Playwright.create();                            //Create a Playwright instance to start interacting with the API
       Browser brw = pw.chromium().launch();                           //Launch Browser in headless mode
        Page pg = brw.newPage();                                       //Open a new browser page (similar to opening a new tab)
        pg.navigate("https://www.youtube.com/");                    //Navigate to the specified URL in the newly opened page
        brw.close();                                                   //Close the browser instance, ending the session
        pw.close();                                                    //Close the Playwright instance to release resources
    }
}
