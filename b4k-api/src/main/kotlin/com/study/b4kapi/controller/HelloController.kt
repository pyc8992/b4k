package com.study.b4kapi.controller

import com.study.b4kdomain.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
  private val helloService: HelloService
){

  @GetMapping("/hello")
  fun hello(testCol1: String) = helloService.helloMysql(testCol1)
}