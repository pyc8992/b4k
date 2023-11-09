package com.study.b4kapi.controller

import com.study.b4kdomain.service.HelloService
import com.study.b4kdomain.service.sample.service.RedisSampleService
import com.study.b4kdomain.service.sample.service.SampleService
import org.springframework.web.bind.annotation.*

@RestController
class HelloController(
  private val helloService: HelloService,
  private val sampleService: SampleService,
  private val redisSampleService: RedisSampleService
){

  @GetMapping("/hello")
  fun hello(testCol1: String) = helloService.helloMysql(testCol1)

  @GetMapping("/sample")
  fun sample() = sampleService.kotlinDataClassStudy()

  @PostMapping("/save")
  fun find(@RequestBody user: UserInfo) = redisSampleService.save(user.username, user.age)

  @GetMapping("/cache-test")
  fun find(@RequestParam("id") id: Long) = redisSampleService.find(id)
}

data class UserInfo(
  val username: String,
  val age: Int
)
