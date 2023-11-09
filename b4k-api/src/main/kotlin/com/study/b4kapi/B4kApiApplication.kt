package com.study.b4kapi

import com.study.b4kapi.configuration.ApiConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(ApiConfiguration::class)
@SpringBootApplication
class B4kApiApplication

fun main(args: Array<String>) {
  runApplication<B4kApiApplication>(*args)
}
