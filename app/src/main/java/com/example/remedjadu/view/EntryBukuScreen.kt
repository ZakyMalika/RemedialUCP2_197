package com.example.remedjadu.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remedjadu.R
import com.example.remedjadu.view.route.DestinasiEntryBuku
import com.example.remedjadu.viewmodel.BukuViewModel
import com.example.remedjadu.viewmodel.provider.PenyediaViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryBukuScreen(
    navigateBack: () -> Unit,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    viewModel: BukuViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    Scaffold(
        topBar = {
            BukuTopAppBar(
                title = stringResource(DestinasiEntryBuku.titleRes),
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

@Composable
fun EntryBukuBody(
    viewModel: BukuViewModel,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiStateBuku

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = uiState.detailBuku.judul,
            onValueChange = {
                viewModel.updateUiState(uiState.detailBuku.copy(judul = it))
            },
            label = { Text(stringResource(R.string.judul_buku)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.detailBuku.kategoriId.toString(),
            onValueChange = {
                viewModel.updateUiState(
                    uiState.detailBuku.copy(
                        kategoriId = it.toIntOrNull() ?: 0
                    )
                )
            },
            label = { Text(stringResource(R.string.kategori_buku)) },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onSaveClick,
            enabled = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.simpan))
        }
    }
}
