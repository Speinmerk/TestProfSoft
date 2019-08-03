package ru.speinmerk.testprofsoft.common.validators

object EmailValidator {
    fun check(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun getError(email: String): String? {
        return if (check(email)) null else EmailError.NOT_CORRECT.message
    }
}