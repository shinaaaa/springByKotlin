package com.shin.springbykotlin.member.service

import com.shin.springbykotlin.member.model.Member

interface MemberService {
    fun join(member: Member): String
}