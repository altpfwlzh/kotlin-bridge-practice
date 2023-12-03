package bridge.model

class Bridge(private val bridge: List<String>) {

    init {
        require(bridge.size in MIN_CNT..MAX_CNT) {throw (IllegalArgumentException(OUT_OF_RANGE))}
    }

    companion object {
        const val MIN_CNT = 3
        const val MAX_CNT = 20
        const val OUT_OF_RANGE = "다리 길이는 $MIN_CNT ~ $MAX_CNT 사이여야 합니다."
    }
}