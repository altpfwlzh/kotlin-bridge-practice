package bridge

import bridge.model.BridgeMaker
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BridgeTest {

    @ValueSource(ints = [-1, 32, 29])
    @ParameterizedTest
    fun `다리 길이가 예외 테스트`(int: Int) {
        assertThrows<IllegalArgumentException> {
            BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(int)
        }
    }
}