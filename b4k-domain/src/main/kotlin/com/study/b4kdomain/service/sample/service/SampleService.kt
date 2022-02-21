package com.study.b4kdomain.service.sample.service

import com.study.b4kdomain.service.sample.dto.*
import org.springframework.stereotype.Service

@Service
class SampleService {

//  fun makePerson(makePersonAction: (Person) -> Unit): Person {
//    val person = Person()
//    makePersonAction(person)
//    return person
//  }

  fun makePerson(
    makePersonAction: KotlinPerson.() -> Unit
  ): KotlinPerson {
    val person = KotlinPerson()
    person.makePersonAction()
    return person
  }

  fun sample() {
    println(makePerson {
      age = 10
      name = "kotlin"
    })
  }

  fun kotlinDataClassStudy() {

    // kotlin data class
    val person1 = KotlinPerson()
    val person2 = KotlinPerson()

    // equals()
    println("person1과 person2의 equals는 같은 값인가 ? ${person1 == person2}")

    // hashCode()
    println("person1과 person2의 hascode는 같은 값인가 ? ${person1.hashCode() == person2.hashCode()}")

    // toString()
    println("person1.toString() = $person1")

    // componentN() (Destructuring)
    val (name, age) = person1
    println(name)
    println(age)

    // copy()
    val personCopy = person1.copy(name = "newName")
    println("person1 = $person1")
    println("personCopy = $personCopy")
    // 레퍼런스 비교 (data class의 copy는 깊은복사이기에 다른 주소값을 가진다)
    println("person1 === personCopy = ${person1 === personCopy}")
  }

}