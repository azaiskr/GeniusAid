package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserProfileResponse(

	@field:SerializedName("result")
	val result: List<Result> = emptyList(),

	@field:SerializedName("message")
	val message: String? = null
)

data class Result(

	@field:SerializedName("nik")
	val nik: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("birth_date")
	val birthDate: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)


//
//data class UserProfileResponse(
//
//	@field:SerializedName("result")
//	val result: Result? = null,
//
//	@field:SerializedName("message")
//	val message: String? = null
//)
//
//data class Result(
//
//	@field:SerializedName("nik")
//	val nik: String? = null,
//
//	@field:SerializedName("address")
//	val address: String? = null,
//
//	@field:SerializedName("updated_at")
//	val updatedAt: String? = null,
//
//	@field:SerializedName("birth_date")
//	val birthDate: String? = null,
//
//	@field:SerializedName("name")
//	val name: String? = null,
//
//	@field:SerializedName("phone_number")
//	val phoneNumber: String? = null,
//
//	@field:SerializedName("email")
//	val email: String? = null
//)
