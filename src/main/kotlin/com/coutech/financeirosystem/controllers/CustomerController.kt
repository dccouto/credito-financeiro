package com.coutech.financeirosystem.controllers

import com.coutech.financeirosystem.dtos.CustomerDto
import com.coutech.financeirosystem.entities.Customer
import com.coutech.financeirosystem.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(name = "customer")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    fun createCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<Customer> {
        TODO("Realizar o save")
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerDto.toEntity()))
    }

    fun getCustomerById(id: Long) : ResponseEntity<CustomerDto>{
        return ResponseEntity.status(HttpStatus.OK).build()

    }
}