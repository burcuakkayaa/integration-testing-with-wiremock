package api.core.services.mock

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import java.util.*

class ProductsMockApiController {

    companion object {

        fun getAllProductMapping(
            statusCode: Int,
            specificStubMockId: UUID,
            responseBody: String
        ): StubMapping {
            return WireMock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/products"))
                    .withId(specificStubMockId)
                    .willReturn(
                        WireMock.aResponse()
                            .withStatus(statusCode)
                            .withHeader("Content-Type", "application/json; charset=UTF-8")
                            .withBody(responseBody)
                    )
            )
        }

        fun postNewProductMapping(
            requestBody: String,
            statusCode: Int,
            specificStubMockId: UUID,
            responseBody: String
        ): StubMapping {
            return WireMock.stubFor(
                WireMock.post(WireMock.urlEqualTo("/products"))
                    .withId(specificStubMockId)
                    .withRequestBody(WireMock.equalToJson(requestBody))
                    .willReturn(
                        WireMock.aResponse()
                            .withStatus(statusCode)
                            .withHeader("Content-Type", "application/json; charset=UTF-8")
                            .withBody(responseBody)
                    )
            )

        }

        fun deleteProductMapping(
            productNumber: Int,
            statusCode: Int,
            specificStubMockId: UUID,
            responseBody: String
        ): StubMapping {

            return WireMock.stubFor(
                WireMock.delete(WireMock.urlEqualTo("/products/$productNumber"))
                    .withId(specificStubMockId)
                    .willReturn(
                        WireMock.aResponse()
                            .withStatus(statusCode)
                            .withHeader("Content-Type", "application/json; charset=UTF-8")
                            .withBody(responseBody)
                    )
            )

        }


        fun updateProductMapping(
            productNumber: Int,
            requestBody: String,
            statusCode: Int,
            specificStubMockId: UUID,
            responseBody: String
        ): StubMapping {

            return WireMock.stubFor(
                WireMock.patch(WireMock.urlEqualTo("/products/$productNumber"))
                    .withId(specificStubMockId)
                    .withRequestBody(WireMock.equalToJson(requestBody))
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
