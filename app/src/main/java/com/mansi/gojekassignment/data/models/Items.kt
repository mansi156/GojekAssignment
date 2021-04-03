package com.mansi.gojekassignment.data.models

import com.google.gson.annotations.SerializedName

data class Items (
    @SerializedName("answer_count")
    val answerCount : Int,
    @SerializedName("content_license")
    val contentLicense : String,
    @SerializedName("creation_date")
    val creationDate : Long,
    @SerializedName("is_answered")
    val isAnswered : Boolean,
    @SerializedName("last_activity_date")
    val lastActivityDate : Long,
    @SerializedName("link")
    val link : String,
    @SerializedName("question_id")
    val questionId : Int,
    @SerializedName("score")
    val score : Int,
    @SerializedName("title")
    val title : String,
    @SerializedName("view_count")
    val view_count : Int,
    @SerializedName("tags")
    val tags : List<String>,
    @SerializedName("owner")
    val owner : Owner

)