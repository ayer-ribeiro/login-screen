package dev.ayer.loginapp.domain

import dev.ayer.loginapp.core.domain.LoginUseCase
import dev.ayer.loginapp.core.exceptions.ForbiddenException
import dev.ayer.loginapp.data.LoginRepositoryImpl
import dev.ayer.loginapp.entity.User

class LoginUseCaseImpl: LoginUseCase {
    val repository = LoginRepositoryImpl()
    override suspend fun invoke(userName: String, password: String): User? {
        return try {
            return repository.login(userName, password)
        } catch (e: ForbiddenException) {
            null
        }
    }
}