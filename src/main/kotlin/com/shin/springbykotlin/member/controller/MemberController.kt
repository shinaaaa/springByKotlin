package com.shin.springbykotlin.member.controller

import com.shin.springbykotlin.member.model.Member
import com.shin.springbykotlin.member.service.MemberService
import com.shin.springbykotlin.response.ResponseFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController {

    @Autowired
    lateinit var memberService: MemberService

    @PostMapping("/join")
    fun join(member: Member): ResponseFormat {
        return ResponseFormat
            .Builder()
            .setStatus(HttpStatus.OK)
            .setData(memberService.join(member))
            .build()
    }

    @PostMapping("/findById")
    fun findByMemberId(memberId: String): ResponseFormat {
        return ResponseFormat
            .Builder()
            .setStatus(HttpStatus.OK)
            .setData(memberService.findByMemberId(memberId))
            .build()
    }

    @PostMapping("/delete")
    fun delete(memberId: String, password: String): ResponseFormat {
        return ResponseFormat
            .Builder()
            .setStatus(HttpStatus.OK)
            .setData(memberService.delete(memberId, password))
            .build()
    }

    @PostMapping("/changePassword")
    fun changePassword(memberId: String, perPassword: String, postPassword: String): ResponseFormat {
        return ResponseFormat
            .Builder()
            .setStatus(HttpStatus.OK)
            .setData(memberService.changePassword(memberId, perPassword, postPassword))
            .build()
    }
}