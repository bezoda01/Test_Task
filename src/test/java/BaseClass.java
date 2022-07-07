import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.nio.file.Paths;

import static selen.Selen.*;
import static utils.AllureUtils.*;
import static selen.settings.Settings.*;

public class BaseClass implements IHookable {

    @BeforeClass
    public void beforeClass() {
        browser().goTo();
    }

    @AfterClass
    public void afterClass() {
        browser().quit();
        addAttachment(Paths.get("log.log"), "Log");
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String> builder()
                        .put("Browser", settings.get("browserName").toString())
                        .put("ENV", browser().getHostName())
                        .put("URL", settings.get("url").toString())
                        .build(),"allure-results/");
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            browser().makeScreenShotByByte(testResult.getMethod().getMethodName());
        }
    }
}