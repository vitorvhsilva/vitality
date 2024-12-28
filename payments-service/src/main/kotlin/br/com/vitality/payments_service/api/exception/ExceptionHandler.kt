package br.com.vitality.payments_service.api.exception

import br.com.vitality.payments_service.api.dto.output.ErrorDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorDTO> {
        val error = ErrorDTO(error = HttpStatus.BAD_REQUEST.name, message = e.message)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }
}