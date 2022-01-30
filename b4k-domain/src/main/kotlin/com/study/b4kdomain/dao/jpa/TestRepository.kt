package com.study.b4kdomain.dao.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<Test, Long>{

  fun findByTestCol1(testCol1: String) : List<Test>
}