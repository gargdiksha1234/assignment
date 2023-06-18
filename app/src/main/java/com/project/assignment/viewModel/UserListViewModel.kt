package com.project.assignment.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson

import com.project.assignment.model.response.UserListResponse
import com.project.assignment.repository.UserListRepository
import kotlinx.coroutines.launch

class UserListViewModel() : ViewModel() {
    var listingResponse = MutableLiveData<UserListResponse>()
    var listingStatusCode = MutableLiveData<Int>()
    var listingStatus = MutableLiveData<Boolean>()

    private val mRepo by lazy { UserListRepository() }

    @RequiresApi(Build.VERSION_CODES.M)
    fun userList() {
        viewModelScope.launch {
            val apiResponse = mRepo.getUserList()
            listingStatus.value = apiResponse.status
            listingStatusCode.value = apiResponse.statusCode


            listingResponse.value = Gson().fromJson(
                Gson().toJson(apiResponse.arrayData),
                UserListResponse::class.java

            )
        }
    }
}

