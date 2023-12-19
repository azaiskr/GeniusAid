package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class SubmissionAnswerResponse(

	@field:SerializedName("error")
	val error: String? = null,

	@field:SerializedName("issues")
	val issues: List<IssuesItem?>? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class IssuesItem(

	@field:SerializedName("path")
	val path: List<String?>? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("expected")
	val expected: String? = null,

	@field:SerializedName("received")
	val received: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)
