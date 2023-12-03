package bridge.controller

import bridge.misc.ExceptionHandler
import bridge.model.Bridge
import bridge.model.BridgeGame
import bridge.model.BridgeMaker
import bridge.model.BridgeRandomNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

class MainController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val exceptionHandler: ExceptionHandler,
) {
    fun run() {
        printHello()
        val bridge: Bridge = exceptionHandler.inputUntilSuccess { receiveBridgeLength() }
    }

    private fun printHello() = outputView.printHello()

    private fun receiveBridgeLength(): Bridge {
        outputView.printBridgeLength()
        return Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize()))
    }

    private fun moveStep() {
        exceptionHandler.inputUntilSuccess { receiveMovingChar() }
    }

    private fun receiveMovingChar() {
        outputView.printSpaceToMove()
        BridgeGame().move(inputView.readMoving())
    }
}