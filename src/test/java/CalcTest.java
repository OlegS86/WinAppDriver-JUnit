import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;


public class CalcTest {

    private static WindowsDriver CalcSession = null;
    private static WebElement CalcResult = null;

    @BeforeClass
    public static void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App"/*"C:\\Waterman\\bat\\run_me_vrn.bat"*/);
            CalcSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            CalcSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            CalcResult = CalcSession.findElementByAccessibilityId("CalculatorResults");
            Assert.assertNotNull(CalcResult);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

    @Before
    public void Clear()
    {
        CalcSession.findElementByName("Очистить").click();
        Assert.assertEquals("На экране показано 0", _GetCalculatorResultText());
    }



    @Test
    public void Addition()
    {

        CalcSession.findElementByName("Семь").click();
        CalcSession.findElementByName("Плюс").click();
        CalcSession.findElementByName("Три").click();
        CalcSession.findElementByName("Равно").click();
        Assert.assertEquals("На экране показано 10", _GetCalculatorResultText());
    }

    @Test
    public void Subtraction()
    {
        CalcSession.findElementByName("Один").click();
        CalcSession.findElementByName("Пять").click();
        CalcSession.findElementByName("Минус").click();
        CalcSession.findElementByName("Три").click();
        CalcSession.findElementByName("Равно").click();
        Assert.assertEquals("На экране показано 12", _GetCalculatorResultText());
    }

    @Test
    public void Division()
    {
        CalcSession.findElementByName("Пять").click();
        CalcSession.findElementByName("Разделить на").click();
        CalcSession.findElementByName("Пять").click();
        CalcSession.findElementByName("Равно").click();
        Assert.assertEquals("На экране показано 1", _GetCalculatorResultText());
    }

    @Test
    public void Multiplication()
    {
        CalcSession.findElementByName("Пять").click();
        CalcSession.findElementByName("Умножить на").click();
        CalcSession.findElementByName("Девять").click();
        CalcSession.findElementByName("Равно").click();
        Assert.assertEquals("На экране показано 45", _GetCalculatorResultText());
    }

    @Test
    public void Percent() {
        CalcSession.findElementByName("Один").click();
        CalcSession.findElementByName("Нуль").click();
        CalcSession.findElementByName("Минус").click();
        CalcSession.findElementByName("Два").click();
        CalcSession.findElementByName("Нуль").click();
        CalcSession.findElementByName("Процент").click();
        CalcSession.findElementByName("Равно").click();
        Assert.assertEquals("На экране показано 8", _GetCalculatorResultText());
    }

    @Test
    public void SquareRoot() {
        CalcSession.findElementByName("Три").click();
        CalcSession.findElementByName("Шесть").click();
        CalcSession.findElementByName("Квадратный корень").click();
        CalcSession.findElementByName("Равно").click();
        Assert.assertEquals("На экране показано 6", _GetCalculatorResultText());
    }

    @AfterClass
    public static void TearDown()
    {
        CalcResult = null;
        if (CalcSession != null) {
            CalcSession.quit();
        }
        CalcSession = null;
    }

    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return CalcResult.getText().replace("Display is", "").trim();
    }

}