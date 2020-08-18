package example.myapp.decor

const val v1 = "sdf"
fun main() {
    makeDecoration()
//    println(Direction.EAST.name)
//    println(Direction.EAST.degrees)
//    println(Direction.EAST.ordinal)
}

fun makeDecoration() {
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

    val (_, _, diver) = d5
//    println(rocks)
//    println(wood)
    println(diver)

//    val decoration1 = Decoration("granite")
//    println(decoration1)
//
//    val decoration2 = Decoration("slate")
//    println(decoration2)
//
//    val decoration3 = Decoration("slate")
//    println(decoration3)
//
//    println(decoration1.equals(decoration2))
//    println(decoration3.equals(decoration2))
}

data class Decoration2(val rocks: String, val wood: String, val diver: String) {
}

data class Decoration(val rocks: String) {
    val v2 = MyClass.C.v1
}

enum class Color(val color: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

class MyClass {
    companion object C {
        const val v1 = "v1"
    }
}
