package dev.bhuvan.composebasic.di

import dev.bhuvan.composebasic.network.ApiProvider
import dev.bhuvan.composebasic.repository.MarsImageRepository
import dev.bhuvan.composebasic.ui.login.LoginViewModel
import dev.bhuvan.composebasic.ui.mars.MarsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object AppModule {

    private val viewModelModules = module {
        viewModel { LoginViewModel() }
        viewModel { MarsViewModel(get()) }
    }

    private val repoModules = module {
        single { MarsImageRepository(get()) }
    }

    private val commonModules = module {
        single { ApiProvider.client }
    }

    fun appModules() = viewModelModules + repoModules + commonModules
}