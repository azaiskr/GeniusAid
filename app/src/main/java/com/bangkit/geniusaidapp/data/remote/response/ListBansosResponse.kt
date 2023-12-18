package com.bangkit.geniusaidapp.data.remote.response

import com.bangkit.geniusaidapp.model.ProfileBansos
import com.google.gson.annotations.SerializedName

data class ListBansosResponse(

	@field:SerializedName("result")
	val result: List<ResultItemBansos?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ResultItemBansos(

	@field:SerializedName("logo_url")
	val logoUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("alias")
	val alias: String? = null,

	@field:SerializedName("total_penerima")
	val totalPenerima: Int? = null,

	@field:SerializedName("total_periode")
	val totalPeriode: Int? = null
){
	fun toItemBansos(): ProfileBansos {
		return ProfileBansos(
			logoUrl = logoUrl ?: "",
			name = name ?: "",
			description = description ?: "",
			alias = alias ?: "",
			totalPenerima = totalPenerima ?: 0,
			totalPeriode  = totalPeriode ?: 0
		)
	}
}


