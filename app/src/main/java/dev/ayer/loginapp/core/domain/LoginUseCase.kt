package dev.ayer.loginapp.core.domain

import dev.ayer.loginapp.entity.User

interface LoginUseCase {
    suspend operator fun invoke(userName: String, password: String) : User?
}