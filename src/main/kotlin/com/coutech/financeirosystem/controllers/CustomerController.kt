package com.coutech.financeirosystem.controllers

import com.coutech.financeirosystem.dtos.CustomerDto
import com.coutech.financeirosystem.dtos.CustomerUpdateDto
import com.coutech.financeirosystem.dtos.CustomerView
import com.coutech.financeirosystem.entities.Customer
import com.coutech.financeirosystem.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    fun createCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<CustomerView> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CustomerView(customerService.save(customerDto.toEntity())))
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable(name = "id") id: Long): ResponseEntity<CustomerView> {
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerService.findById(id)))

    }

    @DeleteMapping("/{id}")
    fun deleteCustomerById(@PathVariable(name = "id") id: Long): ResponseEntity<CustomerView> {
        customerService.delete(id)
        return ResponseEntity.noContent().build()

    }

    @PatchMapping("/{id}")
    fun updateCustomer(
        @PathVariable id: Long,
        @RequestBody customerUpdateDto: CustomerUpdateDto
    ): ResponseEntity<CustomerView> {
        val costumer = customerService.findById(id)
        val entityToUpdate: Customer = customerUpdateDto.toEntity(costumer)
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerView(customerService.save(entityToUpdate)))
    }
}