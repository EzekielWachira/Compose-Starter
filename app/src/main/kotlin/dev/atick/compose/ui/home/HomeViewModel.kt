/*
 * Copyright 2023 Atick Faisal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.atick.compose.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.compose.data.home.HomeData
import dev.atick.compose.repository.home.HomeRepository
import dev.atick.core.ui.utils.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model for the home screen.
 *
 * @param jetpackRepository The repository for accessing home screen data.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val jetpackRepository: HomeRepository,
) : ViewModel() {
    private val _homeUiState: MutableStateFlow<UiState<HomeData>> =
        MutableStateFlow(UiState.Loading)
    val homeUiState = _homeUiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3_000L)
            _homeUiState.update { UiState.Success(HomeData()) }
        }
    }
}
