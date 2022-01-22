package com.shin.springbykotlin.member.service

import com.shin.springbykotlin.member.model.Member

interface MemberService {
    fun join(member: Member)
    fun findByMemberId(memderId: String): Member?
}