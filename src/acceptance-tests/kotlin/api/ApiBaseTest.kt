package api

import api.core.constant.Keywords.HOST
import api.core.constant.Keywords.PORT
import api.core.constant.Keywords.TR_ZONE_ID
import api.core.utilitys.LogUtils.Companion.logInfo
import com.github.tomakehurst.wiremock.client.WireMock
import org.testng.annotations.BeforeSuite
import java.time.ZoneId
import java.util.*

open class ApiBaseTest {

    @BeforeSuite
    fun setUpSuite() {
        logInfo("(*) START TIME OF TESTS: " + Date().toInstant().atZone(ZoneId.of(TR_ZONE_ID)))
        mockServerConfiguration()
    }

    /**
     * To Configure Wiremock Server
     */
    open fun mockServerConfiguration() {
        WireMock.configureFor(HOST, PORT)

        WireMock.removeAllMappings()
        WireMock.resetAllRequests()
        WireMock.saveAllMappings()

    }

}
