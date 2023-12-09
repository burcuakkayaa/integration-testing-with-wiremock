package api.core.services.mock

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import java.util.*

class CartMockApiController {

    companion object {

        fun getSingleCartMapping(
            cartNumber: Int,
            statusCode: Int,
            specificStubMockId: UUID,
            responseBody: String
        ): StubMapping {
            return WireMock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/carts/$cartNumber"))
                    .withId(specificStubMockId)
                    .willReturn(
                        WireMock.aResponse()
                            .withStatus(statusCode)
                            .withHeader("Content-Type", "application/json; charset=UTF-8")
                            .withBody(responseBody)
                    )
            )

        }
    }
}
