package com.example.remedjadu.view.route

import com.example.remedjadu.R

object DestinasiEditBuku : DestinasiNavigasi {
    override val route = "edit_buku"
    override val titleRes = R.string.edit_buku

    const val bukuIdArg = "bukuId"
    val routeWithArgs = "$route/{$bukuIdArg}"
}
