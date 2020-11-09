@file:Suppress("unused")

package day_1_kotlin.langeng.assignments

import day_1_kotlin.langeng.solutions.Bicycle

// Workshop #5 - inheritance, abstract, interface

// Don't touch! Given:
// Declare a contract for a transport ability.
interface Driveable {
    fun drive()
}

// Declare a transport class which describes passenger transport of all types.
// Give this transport an ability to drive.
abstract class Transport(protected var passengersCount: Int) : Driveable

// Create a Bicycle transport which can carry a single person.
class Bicycle : Transport(1) {
    override fun drive() {
        println("Ride a bicycle.")
    }
}


/* Exercise area */

// TODO 1: Create a new interface that will be appropriate for new classes below.
// ? By convention, names of Classes and Interfaces start with an upper case letter and use the camel case.
// Example: "SomeLongClassName".
interface Engine {
    fun numberGears(): Int
    fun setGear(gear: Int)

}

// TODO 2: Write your own class Bus and some Car.
//  Instead of writing it from scratch, extend it from the Transport class and your new interface.
// ? Class can extends only one other class, but implements many interfaces, i.e.:
// class Kitty(): Cat, Cuteable, Sleepable, Furryable {}

class Bus(passengersCount: Int) : Transport(passengersCount), Engine {
    override fun drive() {
        (1..numberGears()).forEach {
            println("Passenger:${word(it)}")
        }
    }

    fun word(count: Int): String {
        var word = ""
        repeat(count * passengersCount / numberGears()) {
            word += "A"
        }
        return word
    }

    override fun numberGears() = 4

    override fun setGear(gear: Int) {
        if (gear <= numberGears()) println("GearBox in ${gear} position")
        when (gear) {
            1 -> Thread.sleep(100)
            2 -> Thread.sleep(100)
            3 -> Thread.sleep(200)
            4 -> Thread.sleep(100)
        }
    }

}

//class Car ...
class Car(passengersCount: Int) : Transport(passengersCount), Engine {
    override fun drive() {
        (1..numberGears()).forEach {
            println("Passenger:${word(it)}")
        }
    }

    fun word(count: Int): String {
        var word = ""
        repeat(count * passengersCount / numberGears()) {
            word += "Yes!! "
        }
        return word
    }

    override fun numberGears() = 5

    override fun setGear(gear: Int) {
        if (gear <= numberGears()) println("GearBox in ${gear} position")
        when (gear) {
            1 -> Thread.sleep(50)
            2 -> Thread.sleep(50)
            3 -> Thread.sleep(100)
            4 -> Thread.sleep(40)
            4 -> Thread.sleep(300)
        }
    }

}
// TODO 3: Test your transport in appropriate sections

object VehiclesTest {

    // You can run the main function to test the code
    @JvmStatic
    fun main(args: Array<String>) {
        testBus()
        testCar()
        testBicycle()
    }

    private fun testBus() {
        println("Testing how bus drives...")
      val bus = Bus(34)
        bus.drive()
    }

    private fun testCar() {
        println("Testing how car drives...")
        val car = Car(2)
        car.drive()
    }

    private fun testBicycle() {
        println("Testing how bicycle drives...")
        val bicycle = Bicycle()
        bicycle.drive()
    }


    /* Exercise bonus area */

    // TODO 4: Test bus abilities as separate features.
    private fun testBusParts() {
        println("Testing bus's feature 1...")


        println("Testing bus's feature 2...")

    }
}