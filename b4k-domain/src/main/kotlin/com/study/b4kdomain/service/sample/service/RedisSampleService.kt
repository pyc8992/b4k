package com.study.b4kdomain.service.sample.service

import com.study.b4kdomain.dao.jpa.entity.Member
import com.study.b4kdomain.dao.jpa.entity.MemberRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RedisSampleService(
  private val memberRepository: MemberRepository
) {

  @Transactional
  fun save(username: String, age: Int) {
    val newMember = Member(
      username = username,
      age = age
    )

    memberRepository.save(newMember)
  }

  @Transactional(readOnly = true)
  @Cacheable(key = "#memberId", cacheNames = ["member"])
  fun find(memberId: Long): Member {
    return memberRepository.findById(memberId)
      .orElse(null)
  }
}
