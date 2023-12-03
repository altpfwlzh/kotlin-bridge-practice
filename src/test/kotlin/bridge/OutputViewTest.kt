package bridge

import bridge.view.OutputView
import org.junit.jupiter.api.Test

class OutputViewTest {
    @Test
    fun `다리 출력이 제대로 되는지 확인`() {
        val bridge = listOf<String>("U", "U", "D", "D", "U")
        val movingRoute = listOf<String>("U", "D", "D", "U", "U")
        OutputView().printMap(bridge, movingRoute)
    }
}