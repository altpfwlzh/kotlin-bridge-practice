package bridge.model

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 *
 * 필드(인스턴스 변수)를 변경할 수 없다.
 * 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val bridge: MutableList<String> = mutableListOf<String>()

        repeat(size) {
            bridge.add(convertNumberByRule(bridgeNumberGenerator.generate()))
        }

        return bridge
    }

    private fun convertNumberByRule(num: Int): String {
        if(num == BridgeGame.MOVING_DOWN_NUM) return BridgeGame.MOVING_DOWN_CHAR
        return BridgeGame.MOVING_UP_CHAR
    }
}
