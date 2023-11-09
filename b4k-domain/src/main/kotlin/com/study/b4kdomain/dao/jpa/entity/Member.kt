package com.study.b4kdomain.dao.jpa.entity

import java.io.Serializable
import javax.persistence.*

@Entity
class Member(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  var username: String,
  var age: Int,
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  var team: Team? = null
): Serializable {
//  init {
//    changeTeam(team)
//  }

  fun changeTeam(team: Team) {
    this.team = team
    team.members.add(this)
  }
}
