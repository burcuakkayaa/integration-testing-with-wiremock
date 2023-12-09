package api.core.services.mock

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import java.util.*

class UsersMockApiController {

    companion object {

        fun postNewUserMapping(
            requestBody: String,
            statusCode: Int,
            specificStubMockId: UUID,
            responseBody: String
        ): StubMapping {

            return stubFor(
                post(WireMock.urlMatching("/users"))
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
