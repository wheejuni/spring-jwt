package com.wheejuni.jwtdemo.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class FormLoginDto(

        @field:JsonProperty("userid")
        val id: String? = null,

        @field:JsonProperty("password")
        val password: String? = null
)