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

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dev.atick.compose.data.home.HomeData
import dev.atick.core.ui.utils.StatefulComposable

/**
 * Composable function that represents the home screen.
 *
 * @param homeViewModel The view model for the home screen.
 */
@Composable
internal fun HomeRoute(
    onShowLoadingDialog: (Boolean) -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val homeState by homeViewModel.homeUiState.collectAsState()

    StatefulComposable(
        state = homeState,
        onShowLoadingDialog = onShowLoadingDialog,
        onShowSnackbar = onShowSnackbar,
    ) { homeData ->
        HomeScreen(homeData = homeData)
    }
}

@Preview
@Composable
private fun HomeScreen(homeData: HomeData = HomeData()) {
    Text(text = homeData.name)
}
