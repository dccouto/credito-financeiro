package com.coutech.financeirosystem.repositories

import com.coutech.financeirosystem.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}