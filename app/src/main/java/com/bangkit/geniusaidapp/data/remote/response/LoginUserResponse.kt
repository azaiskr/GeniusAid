package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginUserResponse(

	@field:SerializedName("result")
	val result: LoginResult? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class LoginResult(

	@field:SerializedName("payload")
	val payload: Payload?,

	@field:SerializedName("token")
	val token: String? = null
)

data class Payload(

	@field:SerializedName("nik")
	val nik: String? = null,

	@field:SerializedName("birth_date")
	val birthDate: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("role")
	val role: String? = null
)
