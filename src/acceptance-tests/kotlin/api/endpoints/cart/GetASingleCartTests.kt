package api.endpoints.cart

import api.ApiBaseTest
import api.controller.model.Sample
import api.core.constant.Keywords
import api.core.utilitys.SampleReaderUtils
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.test.assertEquals

class GetASingleCartTests: ApiBaseTest() {

    private var stupGetCart: ThreadLocal<StubMapping>? = null

    @BeforeMethod(alwaysRun = true)
    fun beforeMethod() {
        stupGetCart = ThreadLocal<StubMapping>()
    }

    @AfterMethod(alwaysRun = true)
    fun afterMethod() {
        if (stupGetCart?.get() != null)
            WireMock.removeStub(stupGetCart!!.get())
    }


    @Test
    fun shouldNotGetASingleCart() {
        val mappingJson = SampleReaderUtils.string(Sample.GET_A_SINGLE_CART_MAPPING)

        val mappingResponse = RestAssured.given()
            .contentType(ContentType.JSON).body(mappingJson).`when`().post("${Keywords.BASE_URL}/__admin/mappings")

        val response = RestAssured.given()
            .contentType(ContentType.JSON).`when`().get("${Keywords.BASE_URL}/cart/5")

        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/cart/5")))

        assertEquals(201, mappingResponse.statusCode)
        assertEquals(404, response.statusCode) //unmatched example
    }
}
