package com.shin.springbykotlin.member.controller

import com.shin.springbykotlin.AppConfig
import com.shin.springbykotlin.member.model.Member
import com.shin.springbykotlin.member.service.MemberService
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @PostMapping("/join")
    fun join(member: Member): String {
        val memberService = ac.getBean("memberService", MemberService::class.java)

        return memberService.join(member)
    }
}