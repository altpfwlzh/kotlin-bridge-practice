package bridge

import bridge.model.BridgeGame
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BridgeGameTest {

    @Test
    fun `다리를 건널 수 있는지 반환 문자 확인`() {
        val bridgeChar: String = "U"
        val movingChar: String = "D"
        val result = BridgeGame().calculateMovingChar(1, bridgeChar, movingChar)
        Assertions.assertEquals(result, "X")
    }
}