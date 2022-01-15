package com.shin.springbykotlin.member.controller

import com.shin.springbykotlin.member.model.Member
import com.shin.springbykotlin.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/member")
class MemberController {

    @Autowired
    lateinit var memberService: MemberService

    @PostMapping("/join")
    fun join(member: Member) {
        return memberService.join(member)
    }

    @PostMapping("/findById")
    fun findByMemberId(memberId: String): Member {
        return memberService.findByMemberId(memberId)
    }
}