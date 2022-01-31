package com.shin.springbykotlin.member.service

import com.shin.springbykotlin.member.model.Member

interface MemberService {
    fun join(member: Member): String?
    fun findByMemberId(memberId: String): Member?
    fun delete(memberId : String, password : String): Boolean
}