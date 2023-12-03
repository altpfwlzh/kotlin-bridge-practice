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

    fun readMoving(): String {
        val input: String = Console.readLine().trim()
        validator.checkString(input)
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    companion object {
        const val INVALID_BRIDGE_LENGTH = "유효하지 않은 다리 길이입니다. "
    }
}