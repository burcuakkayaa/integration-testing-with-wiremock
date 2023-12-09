package api.endpoints.products

import api.ApiBaseTest
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class GetAllProductsTests : ApiBaseTest() {

    private var stubGetProduct: StubMapping? = null

    @BeforeMethod(alwaysRun = true)
    fun beforeMethod() {
        stubGetProduct = StubMapping()
    }

    @AfterMethod(alwaysRun = true)
    fun afterMethod() {
        WireMock.removeStub(stubGetProduct)
    }

    @Test
    fun shouldGetAllProducts() {

    }


}
