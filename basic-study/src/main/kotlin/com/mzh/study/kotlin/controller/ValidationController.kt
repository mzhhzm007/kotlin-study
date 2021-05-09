package com.mzh.study.kotlin.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotBlank

/**
 * kotlin use bean validation
 * 1. specify jvm param
 * reference: https://stackoverflow.com/questions/52345291/bean-validation-not-working-with-kotlin-jsr-380
 * http://www.kotlincn.net/docs/reference/using-gradle.html
 * 2. use annotation correctly
 * refrence: https://stackoverflow.com/questions/35847763/kotlin-data-class-bean-validation-jsr-303
 * https://kotlinlang.org/docs/annotations.html#annotation-use-site-targets
 */
@RestController
class ValidationController {

    @PostMapping("/users")
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<String> {
        return ResponseEntity.ok(user.toString())
    }

    @PostMapping("/roles")
    fun createRole(@Valid @RequestBody role: Role): ResponseEntity<String> {
        return ResponseEntity.ok(role.toString())
    }

    @PostMapping("/students")
    fun createStudent(@Valid @RequestBody student: Student): ResponseEntity<String> {
        return ResponseEntity.ok(student.toString())
    }

}

class User {
    @NotBlank
    val name: String? = null
}

class Role(
    @field:NotBlank
    val name: String
)

data class Student(
    @field:NotBlank
    val name: String
)