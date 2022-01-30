package com.shin.springbykotlin.member.service

import com.shin.springbykotlin.member.model.Member
import com.shin.springbykotlin.member.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.regex.Pattern

@Service
@Transactional(readOnly = true)
class MemberServiceImpl : MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Transactional(readOnly = false)
    override fun join(member: Member): String? {
        if (!validateById(member.memberId)) return null
        if (!validateByPassword(member.password)) return null

        return memberRepository.save(member).memberId
    }

    override fun findByMemberId(memberId: String): Member? {
        return memberRepository.findByMemberId(memberId)
    }

    fun validateById(memberId: String): Boolean {
        return findByMemberId(memberId) == null
    }

    fun validateByPassword(password: String): Boolean {
        val pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$")
        val matcher = pattern.matcher(password)
        return matcher.find()
    }
}