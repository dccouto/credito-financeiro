package com.coutech.financeirosystem.dtos

import com.coutech.financeirosystem.entities.Credit
import com.coutech.financeirosystem.entities.Customer
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.Future
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class CreditDto(
    @field:NotNull
    val creditValue: BigDecimal,
    @field:Future
    val dayFirstOfInstallment: LocalDate,
    @field:Positive
    val numberOfInstallments: Int,
    @field:NotNull
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )


}
