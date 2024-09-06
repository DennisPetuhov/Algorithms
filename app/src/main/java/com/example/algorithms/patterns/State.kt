package com.example.algorithms.patterns

class State {
}


sealed class AuthorizationState {

    object Unauthorized : AuthorizationState()

    class Authorized(val userName: String) : AuthorizationState()
}

class AuthorizationPresenter {

    private var state: AuthorizationState = AuthorizationState.Unauthorized

    val isAuthorized: Boolean
        get() = when (state) {
            is AuthorizationState.Authorized -> true
            is AuthorizationState.Unauthorized -> false
        }

    val userName: String
        get() {
            val state = this.state //val enables smart casting of state
            return when (state) {
                is AuthorizationState.Authorized -> state.userName
                is AuthorizationState.Unauthorized -> "Unknown"
            }
        }

    fun loginUser(userName: String) {
        state = AuthorizationState.Authorized(userName)
    }

    fun logoutUser() {
        state = AuthorizationState.Unauthorized
    }

    override fun toString() = "User '$userName' is logged in: $isAuthorized"
}

fun main() {
    val presenter:AuthorizationPresenter = AuthorizationPresenter()
    presenter.loginUser("admin")
    println(presenter)
    presenter.logoutUser()
    println(presenter)

}