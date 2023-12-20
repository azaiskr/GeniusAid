package com.bangkit.geniusaidapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class PostSubmissionResponse(

	@field:SerializedName("result")
	val result: ResultSub? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class ResultSub(

	@field:SerializedName("submission_id")
	val submissionId: Int? = null,

	@field:SerializedName("nik")
	val nik: String? = null,

	@field:SerializedName("bansos_event_id")
	val bansosEventId: Int? = null,

	@field:SerializedName("bansos_name")
	val bansosName: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
