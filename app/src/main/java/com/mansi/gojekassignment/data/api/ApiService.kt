package com.mansi.gojekassignment.data.api

import com.mansi.gojekassignment.data.models.StackQuestionListResponse
import io.reactivex.Single

interface ApiService {

    fun getQuestionList() : Single<StackQuestionListResponse>
}