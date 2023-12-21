package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class PutUserProfileResponse(

	@field:SerializedName("result")
	val result: PutResult? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class PutResult(

	@field:SerializedName("nik")
	val nik: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("birth_date")
	val birthDate: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("profile_pic_url")
	val profilePicUrl: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)


data class PutUserProfileRequest(
	@SerializedName("nik")
	val nik: String? = null,
	@SerializedName("address")
	val address: String? = null,
	@SerializedName("birth_date")
	val birthDate: String? = null,
	@SerializedName("phone_number")
	val phoneNumber: String? = null,
	@SerializedName("profile_pic_url")
	val profilePicUrl: String? = null,
	@SerializedName("email")
	val email: String? = null
)

