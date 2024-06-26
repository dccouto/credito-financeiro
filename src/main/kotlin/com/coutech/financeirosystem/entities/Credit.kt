package com.coutech.financeirosystem.entities

import com.coutech.financeirosystem.enums.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Credito")
data class Credit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_CREDITO")
    val id: Long? = null,

    @Column(name = "CREDIT_CODE", nullable = false, unique = true)
    val creditCode: UUID = UUID.randomUUID(),

    @Column(name = "VALOR", nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,

    @Column(name = "PRIMEIRA_PARCELA", nullable = false)
    val dayFirstInstallment: LocalDate,

    @Column(name = "NUM_PARCELA", nullable = false)
    val numberOfInstallment: Int = 0,

    @Column(name = "STATUS", nullable = false)
    @Enumerated
    val status: Status = Status.IN_PROGRESS,

    @ManyToOne
    @JoinColumn(name = "FK_CLIENTE")
    var customer: Customer? = null

)
