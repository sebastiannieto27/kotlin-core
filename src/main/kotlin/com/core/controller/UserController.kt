package com.core.controller

import com.core.entity.User
import com.core.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class UserController (@Autowired private val userRepository: UserRepository
){
    // get all users
    @GetMapping("/users")
    fun getAllUsers() : List<User> = userRepository.findAll()

    //creates a user
    @PostMapping("/users")
    fun createUser(@Valid @RequestBody user : User) : User = userRepository.save(user)

    //updates a user
    @PutMapping("/users/{userId}")
    fun updateUser(@PathVariable userId : Long, @Valid @RequestBody updatedUser: User)
        : ResponseEntity<User> = userRepository.findById(userId).map{
        val newUser = it.copy(name = updatedUser.name, lastName = updatedUser.lastName)
        ResponseEntity.ok().body(userRepository.save(newUser))
    }.orElse(ResponseEntity.notFound().build())

    //deletes a user
    @DeleteMapping("/users/{userId}")
    fun deleteUser(@PathVariable userId : Long) : ResponseEntity<Void> =
            userRepository.findById(userId).map{
                userRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

}