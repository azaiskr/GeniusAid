package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class StatusBansosResponse(

	@field:SerializedName("result")
	val result: ResultStatus? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class StatusListItem(

	@field:SerializedName("submission_id")
	val submissionId: Any? = null,

	@field:SerializedName("logo_url")
	val logoUrl: String? = null,

	@field:SerializedName("bansos_name")
	val bansosName: String? = null,

	@field:SerializedName("status")
	val status: Any? = null,

	@field:SerializedName("periode")
	val periode: Any? = null
)

data class ResultStatus(

	@field:SerializedName("status_list")
	val statusList: List<StatusListItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("age")
	val age: Int? = null
)
