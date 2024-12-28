package br.com.vitality.payments_service.api.dto.output

import java.time.LocalDateTime

data class ErrorDTO(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val error: String,
    val message: String?
)
