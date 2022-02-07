package com.study.b4kdomain.service.sample.service

import com.study.b4kdomain.service.sample.dto.*
import org.springframework.stereotype.Service

@Service
private class SampleService {

//  fun makePerson(makePersonAction: (Person) -> Unit): Person {
//    val person = Person()
//    makePersonAction(person)
//    return person
//  }

  fun makePerson(
    makePersonAction: Person.() -> Unit
  ): Person {
    val person = Person()
    person.makePersonAction()
    return person
  }

  fun sample() {
    println(makePerson {
      age = 10
      name = "kotlin"
    })
  }

}