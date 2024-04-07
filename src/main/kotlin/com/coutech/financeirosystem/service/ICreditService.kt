package com.coutech.financeirosystem.service

import com.coutech.financeirosystem.entities.Credit
import org.aspectj.apache.bcel.classfile.Code
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findById(id: Long): Credit

    fun findAllByCustomer(customerId: Long) : List<Credit>

    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}