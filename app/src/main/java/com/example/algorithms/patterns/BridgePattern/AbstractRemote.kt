package BridgePattern

abstract class AbstractRemote {
    lateinit var tv: AbstractTV
    lateinit var tvFactory: TVFactory

    fun on(): Unit {
        tv.on()
    }

    fun off(): Unit {
        tv.off()
    }

    fun putNewChannel(channel: Int): Unit {
        tv.tuneChannel(channel)
    }

    fun showCurrentChannel(): Int {
        return tv.getChannel()
    }

    fun setNewTv(type: String) {
        try {
            tv = tvFactory.createTV(type)
        } catch (e: Exception) {
            throw e
        }
    }
}