package bridge.model

/**
 * 다리 건너기 게임을 관리하는 클래스
 *
 * 필드(인스턴스 변수)를 추가 가능
 * 메서드의 이름은 변경 불가능, 인자와 반환 타입은 변경 가능
 */

class BridgeGame {
    var movingRoute: MutableList<String> = mutableListOf()
        private set

    fun move(input: String) {
        require((input == MOVING_DOWN_CHAR) || (input == MOVING_UP_CHAR)) {
            throw IllegalArgumentException(INVALID_MOVING_CHAR)
        }

        movingRoute.add(input)
    }

    fun calculateMovingChar(locate: Int, bridgeChar: String, movingChar: String): String {
        val isSelectedRoute: Boolean = isSelectedRoute(locate, movingChar)
        val isMovingValid: Boolean = isMovingValid(bridgeChar, movingChar)
        if(isSelectedRoute) {
            if(isMovingValid) return MOVING_VALID_CHAR
            return MOVING_INVALID_CHAR
        }
        return " "
    }

    fun isMovingValid(bridgeRoute: String, movingRoute: String): Boolean = (bridgeRoute == movingRoute)

    private fun isSelectedRoute(locate: Int, movingRoute: String): Boolean {
        if(locate == 0 && movingRoute == MOVING_UP_CHAR) return true
        if(locate == 1 && movingRoute == MOVING_DOWN_CHAR) return true
        return false
    }

    fun retry() {}

    companion object {
        const val BRIDGE_SIZE = 2
        const val BRIDGE_PRINT_START = "["
        const val BRIDGE_PRINT_END = "]"
        const val BRIDGE_PRINT_SEPARATOR = "|"

        const val MOVING_DOWN_NUM = 0
        const val MOVING_UP_NUM = 1
        const val MOVING_DOWN_CHAR = "D"
        const val MOVING_UP_CHAR = "U"
        const val MOVING_VALID_CHAR = "O"
        const val MOVING_INVALID_CHAR = "X"

        const val INVALID_MOVING_CHAR = "유효하지 않은 이동 문자입니다."
    }
}
