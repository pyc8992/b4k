package com.study.b4kdomain

import com.querydsl.jpa.impl.JPAQueryFactory
import com.study.b4kdomain.dao.jpa.Hello
import com.study.b4kdomain.dao.jpa.QHello
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
class B4kDomainApplicationTests {

  @Autowired
  lateinit var em: EntityManager

  @Test
  fun contextLoads() {
    val hello = Hello()

    val query = JPAQueryFactory(em)
    val qHello = QHello("h")

    val fetchOne = query.selectFrom(qHello)
      .fetchOne()

  }

}
