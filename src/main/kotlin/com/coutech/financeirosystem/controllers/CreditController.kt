package com.coutech.financeirosystem.controllers

import com.coutech.financeirosystem.entities.Credit
import com.coutech.financeirosystem.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(name = "credit")
class CreditController(creditService: CreditService) {

    fun createCredit(): ResponseEntity<Credit> {
        TODO("Realizar o save")
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}