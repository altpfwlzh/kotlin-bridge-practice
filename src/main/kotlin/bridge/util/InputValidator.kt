package bridge.util

import bridge.constants.ErrorMessage
import java.text.SimpleDateFormat
import java.time.LocalDate

class InputValidator {
    private val errorMessage: ErrorMessage = ErrorMessage

    fun checkString(input: String, error: String = "") {
        checkEmpty(input, error)
    }

    fun checkInt(input: String, error: String = "") {
        checkEmpty(input, error)
        checkTypeInt(input, error)
    }

    private fun checkEmpty(input: String, error: String) {
        require(input.isNotEmpty()) { throw IllegalArgumentException(error + errorMessage.INPUT_EMPTY) }
    }

    private fun checkTypeInt(input: String, error: String) {
        require(input.chars().allMatch { Character.isDigit(it) }) {
            throw IllegalArgumentException(error + errorMessage.INPUT_TYPE_NOT_INT)
        }
    }
}