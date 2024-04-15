package com.coutech.financeirosystem.service.impl

import com.coutech.financeirosystem.entities.Credit
import com.coutech.financeirosystem.repositories.CreditRepository
import com.coutech.financeirosystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val repository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {


    override fun save(credit: Credit): Credit {
//        Pode ser feito dessa forma, onde irá fazer uma busca e adiciona-lá no custumer de credit
//        credit.apply {
//            customer = customerRepository.findById(credit.customer?.id!!).get()
//        }

        customerService.findById(credit.customer?.id!!)
        return repository.save(credit)
    }

    override fun findById(id: Long): Credit {
        return repository.findById(id).orElseThrow {
            throw RuntimeException("Credit não encontrado.")
        }
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return repository.findAllByCustomerId(customerId);

    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        return repository.findByCustomerIdAndCreditCode(customerId, creditCode)
            ?: throw RuntimeException("Credit code não encontrado");
    }
}