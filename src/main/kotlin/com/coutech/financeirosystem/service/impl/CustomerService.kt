package com.coutech.financeirosystem.service.impl

import com.coutech.financeirosystem.entities.Customer
import com.coutech.financeirosystem.repositories.CustomerRepository
import com.coutech.financeirosystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val repository: CustomerRepository) : ICustomerService {

    override fun save(customer: Customer): Customer {
        return this.repository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.repository.findById(id).orElseThrow {
        throw RuntimeException("Id $id não encontrado")
    }
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}