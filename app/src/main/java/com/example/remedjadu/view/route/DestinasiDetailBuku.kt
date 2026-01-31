package com.example.remedjadu.view.route

import com.example.remedjadu.R

object DestinasiDetailBuku : DestinasiNavigasi {
    override val route = "detail_buku"
    override val titleRes = R.string.detail_buku

    const val itemIdArg = "bukuId"
    val routeWithArgs = "$route/{$itemIdArg}"
}
