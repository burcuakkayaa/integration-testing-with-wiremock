package api.controller.model

enum class Sample(val path: String)  {
    EMPTY("empty.json"),
    POST_USER_VALID_REQUEST("users/post-user-valid-request.json"),
    POST_USER_INVALID_REQUEST("users/post-user-invalid-request.json"),
    POST_USER_VALID_RESPONSE("users/post-user-valid-response.json"),
    POST_USER_INVALID_RESPONSE("users/post-user-invalid-response.json"),

    POST_NEW_PRODUCT_VALID_REQUEST("products/post-new-product-valid-request.json"),
    POST_NEW_PRODUCT_VALID_RESPONSE("products/post-new-product-valid-response.json"),

    //Mapping
    POST_NEW_PRODUCT_MAPPING("mappings/post-new-product-mapping.json"),
    GET_A_SINGLE_CART_MAPPING("mappings/get-a-single-cart-mapping.json"),

}
