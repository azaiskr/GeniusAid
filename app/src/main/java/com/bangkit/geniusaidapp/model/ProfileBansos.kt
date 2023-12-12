package com.bangkit.geniusaidapp.model

//data class ListBansosProcess (
//    val image: Int,
//    val title: String,
//    val status: String,
//    val statusNilai: String,
//    val keterangan: String,
//    val keteranganNilai: String,
//    val priode: String,
//    val priodeNilai: String,
//
//)
//
//object dammyListBansosProcess{
//    val listBansosProcess = listOf(
//        ListBansosProcess(R.drawable.bpnt, "BPNT", "Status", "-", "Keterangan", "-", "Priode", "-"),
//        ListBansosProcess(R.drawable.pkh, "PKH", "Status", "-", "Keterangan", "-", "Priode", "-"),
//        ListBansosProcess(R.drawable.pbi_jk, "PBI-JK", "Status", "-", "Keterangan", "-", "Priode", "-")
//    )
//
//}

data class ProfileBansos(
    val id: Long,
    val nameSigkat : String,
    val name: String,
    val description: String,
    val photoUrl: Int
)

