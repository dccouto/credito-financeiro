package com.coutech.financeirosystem.exceptions

import java.time.LocalDateTime

data class ExceptionDetails(
    val title: String,
    val timeStamp: LocalDateTime,
    val statusCode: Int,
    val exception: String,
    val details: MutableMap<String, String?>

)
