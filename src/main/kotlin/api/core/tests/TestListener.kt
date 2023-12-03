package api.core.tests

import api.core.utilitys.LogUtils.Companion.logError
import api.core.utilitys.LogUtils.Companion.logInfo
import api.core.utilitys.LogUtils.Companion.logWarn
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult

class TestListener: ITestListener {

    override fun onTestStart(iTestResult: ITestResult) {
        try {
            logInfo("TEST STARTED: { ${iTestResult.name} }")
        } catch (e: ArrayIndexOutOfBoundsException) {
            logError("Cannot log test name!")
        }
    }

    override fun onStart(p0: ITestContext) {
        // not implementation yet
    }

    override fun onTestSuccess(iTestResult: ITestResult) {
        logInfo("Test Finished Successfully: " + iTestResult.name)
    }

    override fun onTestFailure(iTestResult: ITestResult) {
        logError("Test Failed: " + iTestResult.name + " Exception is: " + iTestResult.throwable.message)
    }

    override fun onTestFailedButWithinSuccessPercentage(p0: ITestResult) {
        // not implementation yet
    }

    override fun onFinish(iTestResult: ITestContext) {
        // not implementation yet
    }

    override fun onTestSkipped(iTestResult: ITestResult) {
        if (iTestResult.parameters.isEmpty()) {
            logWarn("Test Has Been Skipped: " + iTestResult.name)
        } else {
            iTestResult.status = 2
            iTestResult.parameters = arrayOf<String>()
        }
    }
}
