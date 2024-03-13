package dev.ayer.loginapp.core.repository

import dev.ayer.loginapp.entity.User

interface LoginRepository {
    suspend fun login(userName: String, password: String): User
}