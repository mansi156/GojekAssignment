package com.mansi.gojekassignment.data.models

import com.google.gson.annotations.SerializedName

data class StackQuestionListResponse(
    @SerializedName("items")
    val items : List<Items>,
    @SerializedName("has_more")
    val hasMore : Boolean,
    @SerializedName("quota_max")
    val quotaMax : Int,
    @SerializedName("quota_remaining")
    val quotaRemaining : Int

)