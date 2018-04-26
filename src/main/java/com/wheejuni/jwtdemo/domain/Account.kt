package com.wheejuni.jwtdemo.domain

import javax.persistence.*

@Entity
@Table(name = "ACCOUNT")
internal data class Account(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,

        @Column(name = "ACCOUNT_USERNAME")
        val username: String? = null,

        @Column(name = "ACCOUNT_LOGINID")
        val userId: String? = null,

        @Column(name = "ACCOUNT_PASSWORD")
        val password: String? = null,

        @Column(name = "ACCOUNT_ROLE")
        @Enumerated(value = EnumType.STRING)
        var userRole: UserRole? = null,

        @Column(name = "ACCOUNT_SOCIAL_ID")
        var socialId: Long? = null,

        @Column(name = "ACCOUNT_SOCIAL_PROFILEPIC")
        var profileHref: String? = null)