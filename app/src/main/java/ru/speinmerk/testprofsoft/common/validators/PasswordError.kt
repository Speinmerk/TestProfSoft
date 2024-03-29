package ru.speinmerk.testprofsoft.common.validators

enum class PasswordError(
    val message: String
) {
    LENGTH("Введите не менее 6 символов"),
    NOT_NUMBER("Добавьте цифры"),
    NOT_SMALL_CHAR("Добавьте строчные буквы"),
    NOT_BIG_CHAR("Добавьте заглавные буквы");

    override fun toString(): String {
        return message
    }
}