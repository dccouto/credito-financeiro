package com.coutech.financeirosystem.service

import com.coutech.financeirosystem.entities.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}