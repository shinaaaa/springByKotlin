package com.shin.springbykotlin.response

import org.springframework.http.HttpStatus

class ResponseFormat(val status: Int, val data: Any?) {
    class Builder {
        private lateinit var status: HttpStatus
        private var data: Any? = null

        fun setStatus(status: HttpStatus): Builder {
            this.status = status
            return this
        }


        fun setData(data: Any?): Builder {
            this.data = data

            if (data == null)
                this.status = HttpStatus.NOT_FOUND

            return this
        }

        fun build() = ResponseFormat(status.value(), data)
    }
}

