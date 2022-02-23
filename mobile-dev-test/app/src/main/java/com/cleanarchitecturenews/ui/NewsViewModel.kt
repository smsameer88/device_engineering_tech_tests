package com.cleanarchitecturenews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cleanarchitecturenews.mappers.toUiModel
import com.cleanarchitecturenews.models.ArticleUiModel
import com.cleanarchitecturenews.models.CommentsUiModel
import com.cleanarchitecturenews.models.LikesUiModel
import com.cleanarchitecturenews.models.NewsUiModel
import com.cleanarchitecturenews.utils.Loading
import com.cleanarchitecturenews.utils.Success
import com.cleanarchitecturenews.utils.UiViewModel
import com.domain.usecases.GetAllNewsUseCase
import com.domain.usecases.GetCommentsUseCase
import com.domain.usecases.GetLikesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getAllNewsUseCase: GetAllNewsUseCase,
    private val getLikesUseCase: GetLikesUseCase,
    private val getCommentsUseCase: GetCommentsUseCase
) : UiViewModel() {

    private var _articleList = MutableLiveData<List<ArticleUiModel>>()

    val articleList: LiveData<List<ArticleUiModel>>
        get() = _articleList

    private var _newsList = MutableLiveData<NewsUiModel>()
    val newList: LiveData<NewsUiModel>
        get() = _newsList

    private var _likesList = MutableLiveData<LikesUiModel>()
    val likesList: LiveData<LikesUiModel>
        get() = _likesList

    private var _commentsList = MutableLiveData<CommentsUiModel>()
    val commentsList: LiveData<CommentsUiModel>
        get() = _commentsList

    var author: String = ""
    var url: String = ""

    fun getAllCoins() {
        _uiState.value = Loading
        viewModelScope.launch(exceptionHandler) {
            getAllNewsUseCase().collect {
                _newsList.value = it?.toUiModel()
                _articleList.value = it?.toUiModel()?.articles!!
                _uiState.value = Success
            }
        }
    }

    fun getLikes(url: String) {
        _uiState.value = Loading
        viewModelScope.launch(exceptionHandler) {
            getLikesUseCase.invoke(url).collect {
                _likesList.value = it?.toUiModel()
                _uiState.value = Success
            }
        }
    }

    fun getComments(url: String) {
        _uiState.value = Loading
        viewModelScope.launch(exceptionHandler) {
            getCommentsUseCase.invoke(url).collect {
                _commentsList.value = it?.toUiModel()
                _uiState.value = Success
            }
        }
    }
}
