package com.coutech.financeirosystem.entities

import javax.persistence.Column
import javax.persistence.Embeddable


@Embeddable
data class Address(
    @Column(name = "CEP", nullable = false)
    var zipcode: String = "",
    @Column(name = "RUA", nullable = false)
    var street: String = ""
)
