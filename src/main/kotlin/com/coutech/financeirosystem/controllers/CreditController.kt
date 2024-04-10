package com.coutech.financeirosystem.controllers

import com.coutech.financeirosystem.dtos.CreditDto
import com.coutech.financeirosystem.entities.Credit
import com.coutech.financeirosystem.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(name = "credit")
class CreditController(private val creditService: CreditService) {

    @PostMapping
    fun createCredit(@RequestBody creditDto: CreditDto): ResponseEntity<Credit> {
        val creditEntity: Credit = creditDto.toEntity();
        return ResponseEntity.status(HttpStatus.CREATED).body(creditService.save(creditEntity))
    }
}