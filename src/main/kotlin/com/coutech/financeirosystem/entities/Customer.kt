package com.coutech.financeirosystem.entities

import javax.persistence.*


@Entity
@Table(name = "Cliente")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_CLIENTE")
    val id: Long? = null,

    @Column(name = "NOME", nullable = false)
    var firstName: String = "",

    @Column(name = "SOBRENOME", nullable = false)
    var lastName: String = "",

    @Column(name = "CPF", nullable = false, unique = true)
    val cpf: String,

    @Column(name = "EMAIL", nullable = false, unique = true)
    var email: String = "",

    @Column(name = "SENHA", nullable = false)
    var password: String = "",

    @Embedded
    @Column(nullable = false)
    var address: Address = Address(),

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE], mappedBy = "customer")
    var credits: List<Credit> = mutableListOf()


)
