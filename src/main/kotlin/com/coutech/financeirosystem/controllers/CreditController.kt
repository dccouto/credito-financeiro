package com.coutech.financeirosystem.controllers

import com.coutech.financeirosystem.dtos.CreditDto
import com.coutech.financeirosystem.dtos.CreditView
import com.coutech.financeirosystem.entities.Credit
import com.coutech.financeirosystem.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors
import javax.validation.Valid

@RestController
@RequestMapping("credit")
class CreditController(private val creditService: CreditService) {

    @PostMapping
    fun createCredit(@Valid @RequestBody creditDto: CreditDto): ResponseEntity<Credit> {
        val creditEntity: Credit = creditDto.toEntity();
        return ResponseEntity.status(HttpStatus.CREATED).body(creditService.save(creditEntity))
    }

    @GetMapping("/customer/{id}")
    fun findAllByCustomerId(@PathVariable(name = "id") customerId: Long): ResponseEntity<List<CreditView>> {
        val creditViews = this.creditService.findAllByCustomer(customerId)
            .stream()
            .map { credit: Credit -> CreditView(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.CREATED).body(creditViews)

    }

    @GetMapping("/credit-code/{code}")
    fun findByCreditCode(
        @RequestParam(name = "customerId") customerId: Long,
        @PathVariable(name = "code") creditCode: UUID,
    ): ResponseEntity<CreditView> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(CreditView(creditService.findByCreditCode(customerId, creditCode)))
    }
}