package com.example.gscindoorposition

class DataResponse {

    private var userId: Int = 0
    private var id: Int = 0
    private lateinit var title: String

    fun getUserId(): Int {
        return userId
    }

    fun getId(): Int {
        return id
    }

    fun getTitle(): String? {
        return title
    }

    override fun toString(): String {
        return "DataResponse(userId=$userId, id=$id, title='$title')"
    }

}