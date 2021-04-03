package com.mansi.gojekassignment.data.repository

import com.mansi.gojekassignment.data.api.ApiHelper
import com.mansi.gojekassignment.data.models.StackQuestionListResponse
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {
    fun getQuestionList() : Single<StackQuestionListResponse> {
        return apiHelper.getQuestionList()
    }

}