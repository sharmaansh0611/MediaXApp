package com.example.medix.domain.useCases.user

import com.example.medix.data.authentication.Resource
import com.example.medix.domain.model.ForgotPasswordResponse
import com.example.medix.domain.repository.UserRepository

class ForgotPasswordUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(email: String) : Resource<ForgotPasswordResponse> {
        return try {
            val response = userRepository.forgotPassword(email)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }
}