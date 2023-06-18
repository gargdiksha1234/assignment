package com.project.assignment.model.response

import com.project.assignment.model.response.Address
import com.project.assignment.model.response.Company

data class UserListResponseItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
):java.io.Serializable