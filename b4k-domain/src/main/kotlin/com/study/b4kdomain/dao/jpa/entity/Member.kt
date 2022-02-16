package com.study.b4kdomain.dao.jpa.entity

import javax.persistence.*

@Entity
class Member(
  @Id @GeneratedValue
  val id: Long? = null,
  var username: String,
  var age: Int,
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  var team: Team
) {
  init {
    changeTeam(team)
  }

  fun changeTeam(team: Team) {
    this.team = team
    team.members.add(this)
  }
}