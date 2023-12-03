package api.core.services

import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification

class BaseApiController {

    protected var spec: RequestSpecification = RequestSpecBuilder().build()

    constructor(baseUrl: String?) {
        this.spec = RequestSpecBuilder().setBaseUri(baseUrl.toString()).setBasePath("/").build()
    }

    companion object {
        const val CONTENT_TYPE = "Content-Type"
        const val APPLICATION_JSON = "application/json;charset=UTF-8"
        const val AGENT_NAME_KEY = "x-agentName"
        const val CORRELATION_ID_KEY = "x-correlationId"
    }

}
