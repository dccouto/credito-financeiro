package com.coutech.financeirosystem.controllers

import com.coutech.financeirosystem.entities.Customer
import com.coutech.financeirosystem.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(name = "customer")
class CustomerController(customerService: CustomerService) {

    fun createCustomer(): ResponseEntity<Customer> {
        TODO("Realizar o save")
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}