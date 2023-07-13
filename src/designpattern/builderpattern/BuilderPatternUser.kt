package designpattern.builderpattern

import kotlin.random.Random

/*
The builder pattern is a creational design pattern that separates the construction of a complex object from its representation.
This pattern allows you to create objects step-by-step, without having to know the exact details of the object's final structure.

The builder pattern is often used when an object has a lot of optional parameters or when the order in which
the parameters are set is important. The builder pattern can also be used to create immutable objects, as the
builder can be used to create the object in a single step, without leaving the object in an inconsistent state.*/

fun main(){

    val testObject : BuilderPatternUser = BuilderPatternUser.Builder("Satyajit")
        .setAge(30)
        .setHeight(176)
        .setWeight(70)
        .build()

    println("details are $testObject")
}


class BuilderPatternUser private constructor(
    userId: Int,
    userName: String,
    userAge: Int,
    userHeight: Int,
    userWeight: Int
) {


    data class Builder(private val userName: String) {

        private var userAge: Int? = null
        private var userHeight: Int? = null
        private var userWeight: Int? = null

        fun setAge(age: Int) = apply { userAge = age }

        fun setHeight(height: Int) = apply { userHeight = height }

        fun setWeight(weight: Int) = apply { userWeight = weight }

        fun build(): BuilderPatternUser {

            return BuilderPatternUser(
                userId = getRandomId(),
                userName = userName,
                userAge = userAge ?: 18,
                userHeight = userHeight ?: 170,
                userWeight = userWeight ?: 80
            )
        }

        private fun getRandomId(): Int {
            return Random.nextInt(0, 1000)
        }


    }


}