package ru.speinmerk.testprofsoft

import org.junit.Assert
import org.junit.Test
import ru.speinmerk.testprofsoft.common.validators.PasswordError
import ru.speinmerk.testprofsoft.common.validators.PasswordValidator

class PasswordValidatorTest {
    private val validArray = arrayOf("123qwA", "A123qw", "qwA123")
    private val notValidArray = arrayOf("123qwq", "A12312", "qwAqwe", "123123", "123", "qwe", "QWE")

    @Test
    fun check() {
        validArray.forEach {
            val isValid = PasswordValidator.check(it)
            Assert.assertTrue(isValid)
        }
        notValidArray.forEach {
            val isValid = PasswordValidator.check(it)
            Assert.assertFalse(isValid)
        }
    }

    @Test
    fun getError() {
        validArray.forEach {
            val error = PasswordValidator.getError(it)
            Assert.assertNull(error)
        }
        notValidArray.forEach {
            val error = PasswordValidator.getError(it)
            Assert.assertNotNull(error)
        }
        var error = PasswordValidator.getError("123")
        Assert.assertEquals(PasswordError.LENGTH, error)
        error = PasswordValidator.getError("qweqwq")
        Assert.assertEquals(PasswordError.NOT_NUMBER, error)
        error = PasswordValidator.getError("1weqwq")
        Assert.assertEquals(PasswordError.NOT_BIG_CHAR, error)
        error = PasswordValidator.getError("1ASDAD")
        Assert.assertEquals(PasswordError.NOT_SMALL_CHAR, error)
    }
}