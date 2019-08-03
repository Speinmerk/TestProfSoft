package ru.speinmerk.testprofsoft.common.validators

object PasswordValidator {
    private const val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zа-я])(?=.*[A-ZА-Я]).{6,}"
    private const val PASSWORD_NUMBER_REGEX = "^(?=.*[0-9]).*"
    private const val PASSWORD_SMALL_CHAR_REGEX = "^(?=.*[a-zа-я]).*"
    private const val PASSWORD_BIG_CHAR_REGEX = "^(?=.*[A-ZА-Я]).*"

    fun check(password: String): Boolean {
        return PASSWORD_REGEX.toRegex().matches(password)
    }

    fun getError(password: String): String? {
        val error = when {
            password.length < 6 -> PasswordError.LENGTH
            !PASSWORD_NUMBER_REGEX.toRegex().matches(password) -> PasswordError.NOT_NUMBER
            !PASSWORD_SMALL_CHAR_REGEX.toRegex().matches(password) -> PasswordError.NOT_SMALL_CHAR
            !PASSWORD_BIG_CHAR_REGEX.toRegex().matches(password) -> PasswordError.NOT_BIG_CHAR
            else -> null
        }
        return error?.message
    }

}