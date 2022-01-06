package com.shin.springbykotlin

import com.shin.springbykotlin.member.service.MemberService
import com.shin.springbykotlin.member.service.MemberServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun memberService(): MemberService {
        return MemberServiceImpl()
    }

}