package api.controller.model

enum class Sample(val path: String)  {
    EMPTY("empty.json"),
    POST_USER_VALID_REQUEST("users/post-user-valid-request.json"),
    POST_USER_INVALID_REQUEST("users/post-user-invalid-request.json"),
    POST_USER_VALID_RESPONSE("users/post-user-valid-response.json"),
    POST_USER_INVALID_RESPONSE("users/post-user-invalid-response.json"),
}
