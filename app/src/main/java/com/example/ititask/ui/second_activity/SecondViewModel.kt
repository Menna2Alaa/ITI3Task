package com.example.ititask.ui.second_activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ititask.model.body.Comments
import com.example.ititask.model.body.Post
import com.example.ititask.repo.GetCommentsRepo
import com.example.ititask.repo.GetPostsRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel : ViewModel() {
    var postsData: MutableLiveData<Response<ArrayList<Post>>> = MutableLiveData()
    private val
            repo = GetPostsRepo()

    var commentsData: MutableLiveData<Response<ArrayList<Comments>>> = MutableLiveData()
    val repo2 = GetCommentsRepo()

    fun showPosts(userId: Int) {
        viewModelScope.launch {
            postsData.postValue(repo.getPosts(userId))
        }
    }

    fun showComments(postId: Int) {
        viewModelScope.launch {
            commentsData.postValue(repo2.getComments(postId))
        }
    }
}

