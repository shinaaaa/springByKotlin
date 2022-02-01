package com.shin.springbykotlin.member.model

import javax.persistence.*

@Entity
data class Member(
    @Column(name = "memberId", nullable = false)
    val memberId: String,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "password", nullable = false)
    var password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

}
