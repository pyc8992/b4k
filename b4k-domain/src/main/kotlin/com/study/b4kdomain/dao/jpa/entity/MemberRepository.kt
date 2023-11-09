package com.study.b4kdomain.dao.jpa.entity

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>
