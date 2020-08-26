package com.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KotlinCoreApplication

fun main(args: Array<String>) {
	runApplication<KotlinCoreApplication>(*args)
}
