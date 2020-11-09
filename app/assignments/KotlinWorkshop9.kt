@file:Suppress("unused")

package day_1_kotlin.langeng.assignments

// workshop #9 - generics
/*
 * Класс программиста, который может учить и забывать концепты на определенном языке.
 */

fun main() {
    val p = Programmer<Kotlin>()

    //TODO: uncomment all
    p.learn(Kotlin("basics"))

    p.learn(Kotlin("generics"))
    p.learn(Kotlin("coroutines"))

    println(p.howManyConceptsDoIKnow())
    // should be equal to 3

    println(p.lastConcept())
    //should be Kotlin(element=coroutines)

    p.forget(Kotlin("generics"))
    println(p.howManyConceptsDoIKnow())
    // should be equal to 2
}


class Programmer<T : Language> {

    private val list = mutableListOf<T>()
    fun howManyConceptsDoIKnow(): Int = list.size


    fun lastConcept(): T = list.last()
    fun learn(item: T) {
        list.add(item)
    }

    fun forget(item: T) {
        list.remove(item)
    }
}

interface Language {
    val element: String
}

data class JavaLanguage(override val element: String) : Language
data class Kotlin(override val element: String) : Language
data class Swift(override val element: String) : Language
data class C_Sharp(override val element: String) : Language
