package ru.speinmerk.testprofsoft.common.validators

object EmailValidator {
    private const val EMAIL_REGEX = "^[a-zA-Z0-9.!#\$%&'*+=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*\\.+.+"

    fun check(email: String): Boolean {
        return EMAIL_REGEX.toRegex().matches(email)
    }

    fun getError(email: String): EmailError? {
        return if (check(email)) null else EmailError.NOT_CORRECT
    }
}