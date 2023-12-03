package api.core.tests

import org.testng.ITestNGMethod
import org.testng.annotations.BeforeSuite
import org.testng.annotations.ITestAnnotation
import org.testng.annotations.Listeners


@Listeners(TestListener::class)
open class BaseTest {
    @BeforeSuite(alwaysRun = true)
    open fun beforeSuite(
        annotation: ITestAnnotation,
        testClass: Class<*>?,
        testMethod: ITestNGMethod?
    ) {
        annotation.setRetryAnalyzer(Retry::class.java)
    }

}
