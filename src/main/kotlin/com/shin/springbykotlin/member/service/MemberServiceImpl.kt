package com.shin.springbykotlin.member.service

import com.shin.springbykotlin.member.model.Member
import com.shin.springbykotlin.member.repository.MemberRepository
import com.shin.springbykotlin.member.utils.CommonUtils
import com.shin.springbykotlin.member.utils.CommonUtils.Companion.encryptPassword
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberServiceImpl : MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Transactional(readOnly = false)
    override fun join(member: Member): String? {
        if (!validateById(member.memberId)) return null
        if (!CommonUtils.validateByPassword(member.password)) return null

        member.password = member.password.encryptPassword()

        return memberRepository.save(member).memberId
    }

    override fun findByMemberId(memberId: String): Member? {
        return memberRepository.findByMemberId(memberId)
    }

    override fun delete(memberId: String, password: String): Boolean {
        return memberRepository.deleteMemberByMemberIdAndPassword(memberId, password.encryptPassword()) == 1
    }

    override fun changePassword(memberId: String, prePassword: String, postPassword: String): Boolean {
        memberRepository.findByMemberIdAndPassword(memberId, prePassword.encryptPassword()) ?: return false

        return memberRepository.updateByMemberIdAndPassword(memberId, postPassword.encryptPassword()) == 1
    }

    fun validateById(memberId: String): Boolean {
        return findByMemberId(memberId) == null
    }
}