package bridge.controller

import bridge.misc.ExceptionHandler
import bridge.model.BridgeGame
import bridge.model.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

class MainController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val exceptionHandler: ExceptionHandler,
) {
    private val bridgeGame = BridgeGame()

    fun run() {
        printHello()
        val bridge: List<String> = exceptionHandler.inputUntilSuccess { receiveBridgeLength() }

        repeat(bridge.size) {
            moveStep(bridge)
            if(!canMove(bridge[it])) return
        }
    }

    private fun printHello() = outputView.printHello()

    private fun receiveBridgeLength(): List<String> {
        outputView.printBridgeLength()
        return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize())
    }

    private fun moveStep(bridge: List<String>) {
        exceptionHandler.inputUntilSuccess { receiveMovingChar() }
        val movingRoute: List<String> = bridgeGame.movingRoute

        outputView.printMap(bridge, movingRoute)
    }

    private fun canMove(bridge: String): Boolean {
        return bridgeGame.isMovingValid(bridge, bridgeGame.movingRoute.last())
    }

    private fun receiveMovingChar() {
        outputView.printSpaceToMove()
        bridgeGame.move(inputView.readMoving())
    }
}