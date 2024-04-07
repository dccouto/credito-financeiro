package com.coutech.financeirosystem.repositories

import com.coutech.financeirosystem.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CreditRepository : JpaRepository<Credit, Long> {

    fun findByIdAndCreditCode(id: Long, creditCode : UUID) : Credit?
     fun findAllByCustomerId(id: Long): List<Credit>
}