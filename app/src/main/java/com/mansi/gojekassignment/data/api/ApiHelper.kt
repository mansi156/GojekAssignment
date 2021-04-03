package com.mansi.gojekassignment.data.api

class ApiHelper(private  val apiService: ApiService){

    fun getQuestionList() = apiService.getQuestionList()
}