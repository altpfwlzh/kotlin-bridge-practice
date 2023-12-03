package bridge.view

import bridge.constants.ErrorMessage
import bridge.constants.Strings
import bridge.model.BridgeGame

/**
 * 메서드의 이름은 변경 불가능, 인자와 반환 타입 변경 가능.
 */

class OutputView() {
    private val strings: Strings = Strings
    private val errorMessage: ErrorMessage = ErrorMessage

    fun printHello() = println(strings.OUTPUT_HELLO)

    fun printBridgeLength() = println(strings.INPUT_BRIDGE_LENGTH)

    fun printSpaceToMove() = println(strings.INPUT_SPACE_TO_MOVE)

    fun printMap(bridge: List<String>, movingRoute: List<String>) {
        repeat(BridgeGame.BRIDGE_SIZE) { locate ->
            print(BridgeGame.BRIDGE_PRINT_START)
            repeat(movingRoute.size) {
                print(BridgeGame().calculateMovingChar(locate, bridge[it], movingRoute[it]))
                if(it != movingRoute.lastIndex) print(BridgeGame.BRIDGE_PRINT_SEPARATOR)
            }
            println(BridgeGame.BRIDGE_PRINT_END)
        }
    }

    fun printRestartOrQuit() = println(strings.INPUT_RESTART_OR_QUIT)

    fun printResult() {
        //게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
        printGameResult()
        printGameSuccessOrFail()
        printGameTryCount()
    }

    private fun printGameResult() = println(strings.OUTPUT_GAME_RESULT)
    private fun printGameSuccessOrFail() = println(strings.OUTPUT_GAME_SUCCESS_OR_FAIL)
    private fun printGameTryCount() = println(strings.OUTPUT_GAME_TRY_COUNT)
}