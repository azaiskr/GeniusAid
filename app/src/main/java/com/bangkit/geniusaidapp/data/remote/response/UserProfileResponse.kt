package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserProfileResponse(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("message")
	val message: String? = null
) {
	fun copyWithUpdatedResult(result: Result? = this.result, message: String? = this.message): UserProfileResponse {
		return copy(result = result, message = message)
	}
}

data class Result(

	@field:SerializedName("desa")
	val desa: String? = null,

	@field:SerializedName("birth_date")
	val birthDate: String? = null,

	@field:SerializedName("kec")
	val kec: String? = null,

	@field:SerializedName("kab")
	val kab: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null,

	@field:SerializedName("kewarganegaraan")
	val kewarganegaraan: String? = null,

	@field:SerializedName("nik")
	val nik: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("no_kk")
	val noKk: String? = null,

	@field:SerializedName("prov")
	val prov: String? = null,

	@field:SerializedName("profile_pic_url")
	val profilePicUrl: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
