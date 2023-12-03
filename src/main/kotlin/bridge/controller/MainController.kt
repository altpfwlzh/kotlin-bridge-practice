package bridge.controller

import bridge.misc.ExceptionHandler
import bridge.model.Bridge
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
        exceptionHandler.inputUntilSuccess { receiveBridgeLength() }

    }

    private fun printHello() = outputView.printHello()

    private fun receiveBridgeLength() {
        outputView.printBridgeLength()
        Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.inputInt()))
    }
}