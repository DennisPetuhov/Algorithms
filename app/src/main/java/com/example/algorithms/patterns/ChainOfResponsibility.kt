package com.example.algorithms.patterns

class ChainOfResponsibility {
}


interface HeadersChain {
    fun addHeader(inputHeader: String): String
}

class AuthenticationHeader(val token: String?, var next: HeadersChain? = null) : HeadersChain {

    override fun addHeader(inputHeader: String): String {
        token ?: throw IllegalStateException("Token should be not null")

        return inputHeader + "Authorization: Bearer $token\n"
            .let {
                next?.addHeader(it) ?: it
            }
//        var newInputHeader = inputHeader + "Authorization: Bearer $token\n"
//        next?.addHeader(newInputHeader)
//        return newInputHeader



    }
}
class ContentTypeHeader(val contentType: String, var next: HeadersChain? = null) : HeadersChain {

    override fun addHeader(inputHeader: String): String =
        inputHeader + "ContentType: $contentType\n"
            .let {
                next?.addHeader(it) ?: it }
}

class BodyPayload(val body: String, var next: HeadersChain? = null) : HeadersChain {

    override fun addHeader(inputHeader: String): String =
        inputHeader + "$body"
            .let {
                next?.addHeader(it) ?: it }
}

fun main() {
//create chain elements
    val authenticationHeader = AuthenticationHeader("123456")
    val contentTypeHeader = ContentTypeHeader("json")
    val messageBody = BodyPayload("Body:\n{\n\"username\"=\"dbacinski\"\n}")

//construct chain
    authenticationHeader.next = contentTypeHeader
//    contentTypeHeader.next = messageBody
//    messageBody.next= authenticationHeader

//execute chain
    val messageWithAuthentication =
        authenticationHeader
            .addHeader("Headers with Authentication:\n")
    println(messageWithAuthentication)

//    val messageWithoutAuth =
//        contentTypeHeader.addHeader("Headers:\n")
//    println(messageWithoutAuth)
}