package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class QuestionResponse(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ResultItem(

	@field:SerializedName("question")
	val question: String? = null,

	@field:SerializedName("options")
	val options: List<OptionsItem?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class OptionsItem(

	@field:SerializedName("alias")
	val alias: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
)
