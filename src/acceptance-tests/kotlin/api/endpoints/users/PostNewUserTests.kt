package api.endpoints.users

import api.ApiBaseTest
import api.controller.model.Sample
import api.core.constant.Keywords.BASE_URL
import api.core.services.mock.UsersMockApiController
import api.core.utilitys.SampleReaderUtils
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.apache.http.HttpStatus.SC_BAD_REQUEST
import org.apache.http.HttpStatus.SC_OK
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.util.*
import kotlin.test.assertEquals


class PostNewUserTests : ApiBaseTest() {

    private var stubPostUser: ThreadLocal<StubMapping>? = null

    @BeforeMethod(alwaysRun = true)
    fun beforeMethod() {
        stubPostUser = ThreadLocal<StubMapping>()
    }

    @AfterMethod(alwaysRun = true)
    fun afterMethod() {
        if (stubPostUser?.get() != null)
            removeStub(stubPostUser!!.get())
    }

    @Test
    fun shouldPostNewUserTest() {
        val requestBody = SampleReaderUtils.string(Sample.POST_USER_VALID_REQUEST)
        val responseBody = SampleReaderUtils.string(Sample.POST_USER_VALID_RESPONSE)

        stubPostUser?.set(UsersMockApiController.postNewUserMapping(
            requestBody = requestBody,
            statusCode = SC_OK,
            specificStubMockId = UUID.randomUUID(),
            responseBody = responseBody
        ))

        val response = given()
            .contentType(ContentType.JSON).body(requestBody).`when`().post("$BASE_URL/users")

        verify(postRequestedFor(urlMatching("/users")))

        assertEquals(200, response.statusCode)
        assertEquals(responseBody, response.asString())
    }

    @Test
    fun shouldNotPostNewUserTest() {
        val requestBody = SampleReaderUtils.string(Sample.POST_USER_INVALID_REQUEST)
        val responseBody = SampleReaderUtils.string(Sample.POST_USER_INVALID_RESPONSE)

        stubPostUser?.set(UsersMockApiController.postNewUserMapping(
            requestBody = requestBody,
            statusCode = SC_BAD_REQUEST,
            specificStubMockId = UUID.randomUUID(),
            responseBody = responseBody
        ))

        val response = given()
            .contentType(ContentType.JSON).body(requestBody).`when`().post("$BASE_URL/users")

        verify(postRequestedFor(urlMatching("/users")))

        assertEquals(400, response.statusCode)
        assertEquals(responseBody, response.asString())
    }
}
