package com.study.b4kapi.configuration

import com.study.b4kdomain.configuration.DomainConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(DomainConfiguration::class)
class ApiConfiguration