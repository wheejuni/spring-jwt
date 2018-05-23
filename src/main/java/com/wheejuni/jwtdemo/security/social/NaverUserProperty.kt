package com.wheejuni.jwtdemo.security.social

import com.fasterxml.jackson.annotation.JsonProperty

data class NaverUserProperty(

        @field:JsonProperty("resultcode")
        val resultcode: String? = null,

        @field:JsonProperty("message")
        val message: String? = null,

        @field:JsonProperty("response")
        private val properties: MutableMap<String, String>? = null): SocialUserProperty {

    override fun getUserId(): String {
        return properties!!["id"]!!
    }

    override fun getUserNickname(): String {
        return properties!!["nickname"]!!
    }

    override fun getProfileHref(): String {
        return properties!!["profile_image"]!!
    }

    override fun getEmail(): String {
        return properties!!["email"]!!
    }

}