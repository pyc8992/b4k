package com.study.b4kdomain.service

import com.study.b4kdomain.dao.jpa.TestRepository
import org.springframework.stereotype.Service

@Service
class HelloService(
  private val testRepository: TestRepository
) {

  fun hello() = "Hello"

  fun helloMysql(testCol1: String): List<TestDto> {
    return testRepository.findByTestCol1(testCol1).map{
      TestDto(it.id, it.testCol1, it.testCol2)
    }
  }
}

data class TestDto(
  val id: Long?,
  val testCol1: String,
  val testCol2: String
)