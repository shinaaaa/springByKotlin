package com.shin.springbykotlin.member.service

import com.shin.springbykotlin.member.model.Member

class MemberServiceImpl : MemberService {
    private val members = ArrayList<Member>()

    override fun join(member: Member): String {

        if (members.contains(member)) return "이미 등록된 사용자입니다."

        members.add(member)
        return member.name
    }
}