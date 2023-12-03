package bridge.view

import bridge.util.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator: InputValidator = InputValidator()

    fun readBridgeSize(): Int {
        val input: String = Console.readLine().trim()
        validator.checkInt(input, INVALID_BRIDGE_LENGTH)
        return input.toInt()
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

    companion object {
        const val INVALID_BRIDGE_LENGTH = "유효하지 않은 다리 길이입니다. "
    }
}