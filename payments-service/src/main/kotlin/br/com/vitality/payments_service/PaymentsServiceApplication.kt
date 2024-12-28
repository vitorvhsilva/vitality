package br.com.vitality.payments_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaymentsServiceApplication

fun main(args: Array<String>) {
	runApplication<PaymentsServiceApplication>(*args)
}
