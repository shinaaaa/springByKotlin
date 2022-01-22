package com.shin.springbykotlin.member.service

import com.shin.springbykotlin.member.model.Member
import com.shin.springbykotlin.member.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberServiceImpl : MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Transactional(readOnly = false)
    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findByMemberId(memderId: String): Member? {
        return memberRepository.findByMemberId(memderId)
    }

}