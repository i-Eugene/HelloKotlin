package example.myapp

open class Aquarium(open var width: Int = 20, open var height: Int = 40, open var length: Int = 100) {

    init {
        println("Aquarium initializing")
    }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / length * width).toInt()
        println("Constructor initializing")
    }

    init {
//        println("Volume:${width * height * length / 1000} l")
    }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water / volume * 100.0}% full)")
    }
}