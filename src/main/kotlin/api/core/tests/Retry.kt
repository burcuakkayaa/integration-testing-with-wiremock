package api.core.tests

import api.core.constant.Keywords.FAILED_TEST_RETRY_COUNT
import org.testng.IRetryAnalyzer
import org.testng.ITestResult

class Retry: IRetryAnalyzer {

    companion object {
        private const val maxTry: Int = FAILED_TEST_RETRY_COUNT
    }

    private var count = 0
    override fun retry(result: ITestResult): Boolean {
        if (!result.isSuccess) {
            when {
                count < maxTry -> {
                    count++
                    return true
                }
                else -> {
                    result.status = ITestResult.FAILURE
                }
            }
        } else {
            result.status = ITestResult.SUCCESS
        }
        return false
    }
}
