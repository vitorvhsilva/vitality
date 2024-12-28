package br.com.vitality.payments_service.api.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}