package example

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant class Plant {
    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false
    fun trim() {}
    fun fertilize() {}
}

fun testAnnotations() {
    val classObj = Plant::class
    for (m in classObj.annotations) {
        println(m.annotationClass.simpleName)
    }
    val myAnnotationObject = classObj.findAnnotation<ImAPlant>()
    println(myAnnotationObject)
}

annotation class ImAPlant {

}

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun labels(){
    outerLoop@ for (i in 1..100){
        print("i=$i")
        for (j in 1..100){
            println("j=$j")
            if (i>10) break@outerLoop
        }
    }
}

fun main() {
//    testAnnotations()
    labels()
}