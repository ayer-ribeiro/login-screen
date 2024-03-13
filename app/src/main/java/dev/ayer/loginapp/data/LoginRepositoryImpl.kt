package dev.ayer.loginapp.data

import dev.ayer.loginapp.core.exceptions.ForbiddenException
import dev.ayer.loginapp.core.repository.LoginRepository
import dev.ayer.loginapp.entity.User
import kotlinx.coroutines.delay

class LoginRepositoryImpl: LoginRepository {
    override suspend fun login(userName: String, password: String): User {
        delay(3000)
        if (userName == "ayer" && password == "123") {
            return User(
                userName = userName,
                token = "b07f02h8beo8fb2ep9f28ebfpe"
            )
        }

        throw ForbiddenException()
    }
}