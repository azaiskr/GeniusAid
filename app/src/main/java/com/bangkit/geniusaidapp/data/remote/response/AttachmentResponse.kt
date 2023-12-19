package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class AttachmentResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("error")
	val error: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)
