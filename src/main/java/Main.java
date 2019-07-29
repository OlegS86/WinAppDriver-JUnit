import com.sun.jndi.toolkit.url.Uri;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class Main {
    public String WindowsAplicationDriverUrl = "http://127.0.0.1:4723";
    public String CalculatorAppId = "Microsoft.WindowsCalculator__8wekyb3d8bbwe!App";
    protected static WindowsDriver<WindowsElement> session;

    public static void main(String[] args) {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");

     //       session = new RemoteWebDriver(new Uri("http://127.0.0.1:4723"), cap);

        session.findElementByClassName("Edit").sendKeys("Hi Appium!");



    }
}

