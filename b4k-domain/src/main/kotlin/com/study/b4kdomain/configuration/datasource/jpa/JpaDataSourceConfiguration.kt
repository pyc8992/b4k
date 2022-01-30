package com.study.b4kdomain.configuration.datasource.jpa

import com.study.b4kdomain.dao.jpa.JpaDao
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import java.util.*
import javax.sql.DataSource

@Configuration
@EntityScan(basePackageClasses = [JpaDao::class])
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactory",
  transactionManagerRef = "transactionManager",
  basePackageClasses = [JpaDao::class]
)
@PropertySource("classpath:application-\${spring.profiles.active}.yml")
class JpaDataSourceConfiguration {
  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource.hikari")
  fun dataSource(): DataSource {
    val dataSource = DataSourceBuilder.create().type(HikariDataSource::class.java).build()

    // UTF-8
    dataSource.connectionInitSql = "SET NAMES utf8mb4"

    return dataSource
  }

  @Primary
  @Bean
  fun entityManagerFactory(@Qualifier("dataSource") dataSource: DataSource): LocalContainerEntityManagerFactoryBean {
    val factory = LocalContainerEntityManagerFactoryBean()
    factory.setPackagesToScan(JpaDao::class.java.`package`.name)
    factory.dataSource = dataSource
    factory.persistenceUnitName = "test"
    factory.jpaVendorAdapter = HibernateJpaVendorAdapter()
    return factory
  }

  @Primary
  @Bean
  fun transactionManager(@Qualifier("entityManagerFactory") entityManagerFactory: LocalContainerEntityManagerFactoryBean
  ): PlatformTransactionManager {
    return JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.`object`)!!)
  }

}