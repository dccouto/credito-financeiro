package com.coutech.financeirosystem.dtos

import com.coutech.financeirosystem.entities.Credit
import com.coutech.financeirosystem.enums.Status
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int,
    val status: Status,
    val emailCustomer: String,
    val incomeCustomer: BigDecimal
) {

    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallment,
        status = credit.status,
        emailCustomer = credit.customer?.email.toString(),
        incomeCustomer = credit.customer!!.income
    )

}
