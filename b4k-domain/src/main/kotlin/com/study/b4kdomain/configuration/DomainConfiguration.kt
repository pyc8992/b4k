package com.study.b4kdomain.configuration

import com.study.b4kdomain.configuration.datasource.jpa.JpaDataSourceConfiguration
import com.study.b4kdomain.configuration.redis.RedisConfiguration
import com.study.b4kdomain.service.Service
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
  JpaDataSourceConfiguration::class,
  RedisConfiguration::class
)
@ComponentScan(basePackageClasses = [Service::class])
class DomainConfiguration
