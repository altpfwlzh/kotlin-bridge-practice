package bridge.view

import bridge.util.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator: InputValidator = InputValidator()

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return 0
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    fun inputString(): String {
        val input: String = Console.readLine().trim()
        validator.checkString(input)
        return input
    }

    fun inputInt(): Int {
        val input: String = Console.readLine().trim()
        validator.checkInt(input)
        return input.toInt()
    }

    fun inputVisitDate(): Int {
        val input: String = Console.readLine().trim()
        validator.checkVisitDate(input, INVALID_DATE)
        return input.toInt()
    }

    companion object {
        const val INVALID_DATE = "유효하지 않은 날짜입니다. "
    }
}