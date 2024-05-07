package com.coutech.financeirosystem.dtos

import com.coutech.financeirosystem.entities.Address
import com.coutech.financeirosystem.entities.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class CustomerDto(
    @field:NotBlank(message = "Campo obrigatório")
    val firstName: String,
    @field:NotBlank(message = "Campo obrigatório")
    val lastName: String,
    @field:CPF(message = "Campo obrigatório")
    val cpf: String,
    @field:NotBlank(message = "Campo obrigatório")
    val income: BigDecimal,
    @field:Email(message = "Campo obrigatório")
    val email: String,
    @field:NotBlank(message = "Campo obrigatório")
    val password: String,
    @field:NotBlank(message = "Campo obrigatório")
    val zipCode: String,
    @field:NotBlank(message = "Campo obrigatório")
    val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
