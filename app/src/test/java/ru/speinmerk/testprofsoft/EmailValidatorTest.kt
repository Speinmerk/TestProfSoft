package ru.speinmerk.testprofsoft

import org.junit.Assert
import org.junit.Test
import ru.speinmerk.testprofsoft.common.validators.EmailValidator

class EmailValidatorTest {
    private val validArray = arrayOf("test@test.com", "1@1.ru")
    private val notValidArray = arrayOf("11.ru", "1@1.", "@1.r", "1@.r")

    @Test
    fun check() {
        validArray.forEach {
            val isValid = EmailValidator.check(it)
            Assert.assertTrue(isValid)
        }
        notValidArray.forEach {
            val isValid = EmailValidator.check(it)
            Assert.assertFalse(isValid)
        }
    }

    @Test
    fun getError() {
        validArray.forEach {
            val error = EmailValidator.getError(it)
            Assert.assertNull(error)
        }
        notValidArray.forEach {
            val error = EmailValidator.getError(it)
            Assert.assertNotNull(error)
        }
    }
}