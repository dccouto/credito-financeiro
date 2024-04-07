package com.coutech.financeirosystem.repositories

import com.coutech.financeirosystem.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository

interface CreditRepository : JpaRepository<Credit, Long> {
}