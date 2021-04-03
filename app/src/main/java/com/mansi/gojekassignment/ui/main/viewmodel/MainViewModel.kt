package com.mansi.gojekassignment.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mansi.gojekassignment.data.models.StackQuestionListResponse
import com.mansi.gojekassignment.data.repository.MainRepository
import com.mansi.gojekassignment.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository): ViewModel(){

   private val questions = MutableLiveData<Resource<StackQuestionListResponse>>()
   private val compositeDisposable = CompositeDisposable()
    init{
        fetchQuestionList()
    }

    private fun fetchQuestionList() {
        questions.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getQuestionList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                    {questionsList -> questions.postValue(Resource.success(questionsList))},{
                        throwable -> questions.postValue(Resource.error("Something went wrong",null))
                    }
                )
        )

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

  fun getQuestions() : LiveData<Resource<StackQuestionListResponse>>{
      return questions
  }
}