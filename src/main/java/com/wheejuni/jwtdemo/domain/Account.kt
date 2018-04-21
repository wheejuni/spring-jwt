package com.wheejuni.jwtdemo.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
internal data class Account(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long? = null) {

    companion object {
        //TODO(Write Logic for dto -> model)
    }


}