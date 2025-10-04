package com.route.islamic42gsunwed.fragments.radio.api

import com.google.gson.annotations.SerializedName

data class RadioResponse(

	@field:SerializedName("radios")
	val radios: List<RadiosItem>? = null ,

	@field:SerializedName("message")
	val message: String? = null,
)

data class RadiosItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("recent_date")
	val recentDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("url")
	val url: String? = null
)
