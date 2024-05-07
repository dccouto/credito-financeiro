package com.coutech.financeirosystem.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(e: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails> {
        val erros: MutableMap<String, String?> = HashMap()
        e.bindingResult.allErrors.stream().forEach { erro: ObjectError ->
            val fieldName: String = (erro as FieldError).field
            val messageError: String? = erro.defaultMessage
            erros[fieldName] = messageError

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExceptionDetails(
            title = "Ocorreu um erro",
            timeStamp = LocalDateTime.now(),
            statusCode = HttpStatus.BAD_REQUEST.value(),
            exception = e.javaClass.toString(),
            details = erros
            ) )
    }
}