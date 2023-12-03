package bridge.util

import java.text.DecimalFormat

class Parser {
    fun intToCashString(num: Long): String {
        val dec = DecimalFormat("#,###원")
        return dec.format(num)
    }

    fun intToMinusCashString(num: Long): String {
        val dec = DecimalFormat("-#,###원")
        return dec.format(num)
    }

    fun caseToPercent(total: Long, success: Long, decimalPoint: Int) {
        val dec = DecimalFormat("%.${decimalPoint}f")
        TODO()
    }
}