package example.myapp


interface FishAction {
    fun eat()
    fun swim() {
        println("swim")
    }
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color: String
        get() = "gold"
}

class Plecostomus(fishColor: FishColor = GoldColor) :
        FishAction by PrintingFishAction("eat elgae"),
        FishColor by fishColor {
    //    override var color: String = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
}

class Shark : FishColor, FishAction {
    override var color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}


sealed class Seal {
    class Sealion : Seal()

    class Walrus : Seal()

    fun matchSeal(seal: Seal): String {
        when (seal) {
            is Sealion -> return "sea lion"
            is Walrus -> return "walrus"
            else -> return ""
        }
    }
}