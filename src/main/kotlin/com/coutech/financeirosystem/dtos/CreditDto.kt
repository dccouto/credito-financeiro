package com.coutech.financeirosystem.dtos

import com.coutech.financeirosystem.entities.Credit
import com.coutech.financeirosystem.entities.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )


}
