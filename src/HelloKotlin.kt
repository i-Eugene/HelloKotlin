import kotlin.random.Random

fun main(args: Array<String>) {
//    helloKotlin(args)
    feedFish()
//    swim()
//    swim("slow")
//    swim(speed = "turtle-like")
//    filter()
}

fun filter() {
    val decoration = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    val eager = decoration.asSequence().filter { it.startsWith("p") }
//    eager.iterator().forEach { println(it) }
//    println(eager.toList())

    val lazyMap = decoration.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
}

fun helloKotlin(args: Array<String>) {
    val isUnit = println("Hello, Kotlin ${args[0]}")
    println(isUnit.toString())
}

fun feedFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("should change water ${shouldChangeWater(day, 30)}")
}

fun shouldChangeWater(day: String, temperature: Int = 20, dirty: Int = 20): Boolean {
    println("${updateDirty(dirty, waterFilter)}")
    return when {
        day == "Sunday" -> true
        temperature > 30 -> true
        isDirty(dirty) -> true
        else -> false
    }
}

val waterFilter = { dirty: Int -> dirty / 2 }

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty).inc()
}

fun isDirty(dirty: Int) = dirty > 30

fun fishFood(day: String): String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
//        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
//        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
//        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
        else -> food = "nothing"
    }
    return food
}

fun randomDay(): String {
    val weekDay = arrayOf("Monday", "Tuesday", "Wednesday", "ThursDay", "Friday", "Saturday", "Sunday")
    return weekDay[Random.nextInt(from = 0, until = weekDay.size)]
}

fun swim(speed: String = "fast") {
    println("Swimming $speed")
}