package api.endpoints.products

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

class PostNewProductTests : ApiBaseTest() {

    private var stubPostProduct: ThreadLocal<StubMapping>? = null

    @BeforeMethod(alwaysRun = true)
    fun beforeMethod() {
        stubPostProduct = ThreadLocal<StubMapping>()
    }

    @AfterMethod(alwaysRun = true)
    fun afterMethod() {
        if (stubPostProduct?.get() != null)
            WireMock.removeStub(stubPostProduct!!.get())
    }

    @Test
    fun shouldPostNewProductTest() {
        val requestBody = SampleReaderUtils.string(Sample.POST_NEW_PRODUCT_VALID_REQUEST)
        val responseBody = SampleReaderUtils.string(Sample.POST_NEW_PRODUCT_VALID_RESPONSE)
        val mappingJson = SampleReaderUtils.string(Sample.POST_NEW_PRODUCT_MAPPING)

        val mappingResponse = RestAssured.given()
            .contentType(ContentType.JSON).body(mappingJson).`when`().post("${Keywords.BASE_URL}/__admin/mappings")

        val response = RestAssured.given()
            .contentType(ContentType.JSON).body(requestBody).`when`().post("${Keywords.BASE_URL}/products")

        WireMock.verify(WireMock.postRequestedFor(WireMock.urlMatching("/products")))

        assertEquals(201, mappingResponse.statusCode)
        assertEquals(201, response.statusCode)
        assertEquals(responseBody, response.asString())
    }
}
