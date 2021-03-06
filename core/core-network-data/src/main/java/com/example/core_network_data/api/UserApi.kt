package com.example.core_network_data.api

import com.example.core_model.data.api.user.*
import com.example.core_network_data.common.ConstantsUrl.AUTHORIZATION
import com.example.core_network_data.common.ConstantsUrl.GET_USER
import com.example.core_network_data.common.ConstantsUrl.REGISTRATION
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST(AUTHORIZATION)
    suspend fun authorization(
        @Body authorization: Authorization
    ): Response<AuthorizationResponse>

    @POST(REGISTRATION)
    suspend fun registration(
        @Body registration: Registration
    ):Response<RegistrationResult?>

    @GET(GET_USER)
    suspend fun getUser():Response<User>
}