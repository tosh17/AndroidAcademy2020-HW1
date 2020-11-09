@file:Suppress("MayBeConstant", "unused", "UNUSED_VARIABLE")

package day_1_kotlin.langeng.assignments

// workshop #8 - const, companion object, extension func*

/*
 * Сокращаем телефон до максимально докустимой длины maxLength
 * и пишем функцию экстеншен на лист, которая заменяет каждый i-й элемент номером телефона
 */

// TODO 1: make maxLength const that is visible only inside the Person class


// TODO 2: make companionConstant part of companion object


class Person(phoneCode: String) {

    val code = if (phoneCode.length > maxLength) phoneCode.subSequence(0, maxLength) else phoneCode

    companion object {
        private const val maxLength = 12
        val companionConstant = 12
    }

    // * * * Bonus task * * * (work on home)

    //TODO 3: make this fun as extension to a list outside the Person class

}

fun main(){
    val list = mutableListOf("1", 3, 4, "Patrick", 3.4, "123-59")

    val p = Person("45-45-45")


    // TODO: uncomment after finishing TODO 1
   // println(Person.maxLength)
    println(list)
    //TODO *: uncomment after doing function
    val newList= list.replacePlacesWithThePhoneCode(p, 4)
    println(newList)
}

private fun List<Any>.replacePlacesWithThePhoneCode(person:Person, placeNum: Int = 3): List<Any> =
     this.mapIndexed { index, any ->
         if (index % placeNum == 0) person.code
         else any}
