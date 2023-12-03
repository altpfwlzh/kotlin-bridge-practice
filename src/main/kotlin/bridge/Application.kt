package bridge

import bridge.controller.MainController
import bridge.misc.ExceptionHandler
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    runCatching {
        val mainController = MainController(InputView(), OutputView(), ExceptionHandler())
        mainController.run()
    }.onFailure {
        ExceptionHandler().printError(it.message)
    }
}
