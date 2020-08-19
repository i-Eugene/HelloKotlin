package example

data class Fish(var name: String)

fun fishExamples() {
    val fish = Fish("splashy")
    fish.run { name }
    myWith(fish.name) {
        println(capitalize())
    }

    println(fish.let { it.name.capitalize() }
//            .let { it+"fish" }
//            .let { it.length }
//            .let { it+31 }
    )
    println(fish.name)

    val fish1 = Fish("splashy").apply { name = "sharky" }
    println(fish1.name)
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun runExample() {
    val runnable = object : Runnable {
        override fun run() {
            println("I am a Runnable")
        }
    }
    JavaRun.runNow(runnable)
    JavaRun.runNow { println("Passing a lambda as a Runnable") }
}

fun main() {
//    fishExamples()
    runExample()
}