package com.study.b4kdomain.dao.jpa.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Team(
  @Id @GeneratedValue
  val id: Long? = null,
  var name: String,
  @OneToMany(mappedBy = "team")
  var members: MutableList<Member> = mutableListOf()
) {
}