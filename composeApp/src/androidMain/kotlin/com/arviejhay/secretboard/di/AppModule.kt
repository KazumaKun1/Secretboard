package com.arviejhay.secretboard.di

import com.arviejhay.secretboard.ViewModel.BoardViewModel
import com.arviejhay.secretboard.data.repository.PostRepository
import com.arviejhay.secretboard.data.usecase.GetPostsForDataUseCase
import com.arviejhay.secretboard.data.usecase.SubmitPostUseCase
import com.arviejhay.secretboard.domain.api.Impl.PostApiServiceImpl
import com.arviejhay.secretboard.domain.api.PostApiService
import com.arviejhay.secretboard.domain.repositoryImpl.PostRepositoryImpl

import org.koin.dsl.module

val appModule = module {
    single<PostApiService> { PostApiServiceImpl() }
    single<PostRepository> { PostRepositoryImpl(get()) }
    single { GetPostsForDataUseCase(get()) }
    single { SubmitPostUseCase(get()) }
    factory { BoardViewModel(get(), get()) }
}