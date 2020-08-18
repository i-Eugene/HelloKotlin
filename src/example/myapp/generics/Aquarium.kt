package example.myapp.generics

open class WaterSupply(var needsProcessing: Boolean) {

}

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)
class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
//    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = waterSupply is R
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
    }
}

inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun genericsExample() {
    val aquarium = Aquarium(TapWater())
    println(aquarium.waterSupply.isOfType<TapWater>())
    println(aquarium.hasWaterSupplyOfType<TapWater>())
    isWaterClean(aquarium)
    val cleaner = TapWaterCleaner()
    aquarium.addWater(cleaner)
//    val aquarium = Aquarium(TapWater())
//    addItemTo(aquarium)
//    val aquarium = Aquarium("String")
//    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
//    aquarium.waterSupply.addChemicalCleaners()
//    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
//    println(aquarium.waterSupply)
}

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

fun main() {
    genericsExample()
}