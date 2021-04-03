package com.mansi.gojekassignment.data.api

import com.mansi.gojekassignment.data.models.StackQuestionListResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService{
    override fun getQuestionList(): Single<StackQuestionListResponse> {
        return Rx2AndroidNetworking
            .get("https://api.stackexchange.com/2.2/")
            .build().getObjectSingle(StackQuestionListResponse::class.java)
    }
}