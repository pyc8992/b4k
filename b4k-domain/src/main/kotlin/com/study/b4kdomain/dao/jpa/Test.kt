package com.study.b4kdomain.dao.jpa

import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.GenerationType.*

@Entity
@Table(name = "tests")
data class Test(
  @Id
  @GeneratedValue(strategy = IDENTITY)
  val id: Long? = null,
  var testCol1: String,
  var testCol2: String,
  var testCol3: String,
  var createdAt: LocalDateTime,
  var updatedAt: LocalDateTime
)