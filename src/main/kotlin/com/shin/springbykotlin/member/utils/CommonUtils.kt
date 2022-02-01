package com.shin.springbykotlin.member.utils

import java.util.*
import java.util.regex.Pattern
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class CommonUtils {

    companion object {

        fun validateByPassword(password: String): Boolean {
            val pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$")
            val matcher = pattern.matcher(password)
            return matcher.find()
        }

        fun String.encryptPassword(): String {
            val secretKeySpec = SecretKeySpec("asdasdasdasdasdasdasdasasdasdasd".toByteArray(), "AES")
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
            val pw = cipher.doFinal(this.toByteArray())
            return Base64.getEncoder().encodeToString(pw)
        }

        fun String.decryptPassword(): String {
            val secretKeySpec = SecretKeySpec("asdasdasdasdasdasdasdasasdasdasd".toByteArray(), "AES")
            val pw = Base64.getDecoder().decode(this)
            val cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
            val output = cipher.doFinal(pw)
            return String(output)
        }
    }
}