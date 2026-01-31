package com.example.remedjadu.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remedjadu.R
import com.example.remedjadu.viewmodel.BukuViewModel
import com.example.remedjadu.viewmodel.provider.PenyediaViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditBukuScreen(
    bukuId: Int,
    navigateBack: () -> Unit,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    viewModel: BukuViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    Scaffold(
        topBar = {
            BukuTopAppBar(
                title = stringResource(R.string.edit_buku),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        EntryBukuBody(
            viewModel = viewModel,
            onSaveClick = {
                scope.launch {
                    viewModel.saveBuku()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .padding(dimensionResource(id = R.dimen.padding_large))
        )
    }
}
