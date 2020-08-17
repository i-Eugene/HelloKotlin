package example.myapp

fun main() {
//    buildAquarium()
    makeFish()
}

fun makeFish() {
    val shark = Shark()
    val plecostomus = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("plecostomus: ${plecostomus.color}")
    plecostomus.eat()
    plecostomus.swim()
}

fun buildAquarium() {
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()
    val myTowerTank = TowerTank(diameter = 25, height = 40)
    myTowerTank.printSize()
//    var myAquarium = Aquarium()
//    myAquarium.printSize()
//    myAquarium = Aquarium(width = 25)
//    myAquarium.printSize()
//    myAquarium = Aquarium(height = 35, length = 110)
//    myAquarium.printSize()
//    myAquarium = Aquarium(width = 25, height = 35, length = 110)
//    myAquarium.printSize()
}