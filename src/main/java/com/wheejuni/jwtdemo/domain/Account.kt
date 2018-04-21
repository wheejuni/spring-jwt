package com.wheejuni.jwtdemo.domain

import javax.persistence.*

@Entity
@Table(name = "ACCOUNT")
internal data class Account(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private val id: Long? = null,

        @Column(name = "ACCOUNT_USERNAME")
        private val username: String? = null,

        @Column(name = "ACCOUNT_LOGINID")
        val userId: String? = null,

        @Column(name = "ACCOUNT_PASSWORD")
        val password: String? = null,

        @Column(name = "ACCOUNT_ROLE")
        @Enumerated(value = EnumType.STRING)
        val userRole: UserRole? = null,

        @Column(name = "ACCOUNT_SOCIAL_ID")
        private val socialId: Long? = null,

        @Column(name = "ACCOUNT_SOCIAL_PROFILEPIC")
        private val profileHref: String? = null)