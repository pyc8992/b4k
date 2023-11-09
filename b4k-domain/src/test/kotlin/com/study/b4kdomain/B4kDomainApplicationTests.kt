package com.study.b4kdomain

import com.querydsl.jpa.impl.JPAQueryFactory
import com.study.b4kdomain.configuration.DomainConfiguration
import com.study.b4kdomain.configuration.datasource.jpa.JpaDataSourceConfiguration
import com.study.b4kdomain.dao.jpa.Hello
import com.study.b4kdomain.dao.jpa.QHello
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@DataJpaTest
@Import(JpaDataSourceConfiguration::class)
class B4kDomainApplicationTests(
  @Autowired
  private val em: EntityManager
) {

  @Test
  fun contextLoads() {
    val hello = Hello()

    val query = JPAQueryFactory(em)
    val qHello = QHello("h")

    val fetchOne = query.selectFrom(qHello)
      .fetchOne()

  }

}
