package api

import com.github.tomakehurst.wiremock.client.WireMock.*
import org.testng.annotations.Test

class WiremockTest: ApiBaseTest() {


    @Test
    fun test() {
        stubFor(
            post(
                urlEqualTo("/checkout")
            )
                .willReturn(
                    aResponse()
                        .withStatus(200)
                )
        );
    }
}
