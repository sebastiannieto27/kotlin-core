package com.core.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

import javax.validation.constraints.NotBlank

@Entity(name = "user")
data class User(
        @Id @GeneratedValue(strategy = GenerationType.Identity)
        val id : Long =0,
        @get: NotBlank val name : String = "",
        @get: NotBlank val lastName : String = "") {



}