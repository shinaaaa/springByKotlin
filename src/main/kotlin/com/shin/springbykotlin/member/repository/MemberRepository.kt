package com.shin.springbykotlin.member.repository

import com.shin.springbykotlin.member.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    @Query("select m from Member m where m.memberId = :memberId")
    fun findByMemberId(memberId: String): Member?
}