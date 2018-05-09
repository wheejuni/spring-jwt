package com.wheejuni.jwtdemo.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import com.wheejuni.jwtdemo.domain.SocialProviders

data class SocialLoginDto(
        @field:JsonProperty("provider")
        val provider: SocialProviders? = null,

        @field:JsonProperty("token")
        val token: String? = null
)