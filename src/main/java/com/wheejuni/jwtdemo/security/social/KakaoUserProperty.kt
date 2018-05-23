package com.wheejuni.jwtdemo.security.social

import com.fasterxml.jackson.annotation.JsonProperty

data class KakaoUserProperty(

        @field:JsonProperty("kaccount_email")
        private val userEmail: String? = null,

        @field:JsonProperty("kaccount_email_verified")
        val verified: Boolean = false,

        @field:JsonProperty("id")
        private val userUniqueId: Long? = null,

        @field:JsonProperty("properties")
        private val userProperties: MutableMap<String, String>? = null): SocialUserProperty {

    override fun getUserId(): String {
        return userUniqueId.toString()
    }

    override fun getUserNickname(): String {
        return userProperties!!["nickname"]!!
    }

    override fun getProfileHref(): String {
        return userProperties!!["profile_image"]!!
    }

    override fun getEmail(): String {
        return userEmail!!
    }


}