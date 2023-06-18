package com.project.assignment.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.project.assignment.network.GenericApiRequestArrayType
import com.project.assignment.model.BaseResponseArrayType
import com.project.assignment.network.api.RetroHelper

class UserListRepository(): GenericApiRequestArrayType<Any>() {

@RequiresApi(Build.VERSION_CODES.M)
suspend fun getUserList(): BaseResponseArrayType<ArrayList<Any>> {
    return apiRequest<Any> {
        RetroHelper.ApiManager.apiClient.userList()
    }
}

}