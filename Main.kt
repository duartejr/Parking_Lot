package parking

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val parking = mutableMapOf<Int, String>()

    for (i in 1..20) {
        parking[i] = "vague"
    }

    var action: String = ""
    var rg: String = ""
    var color: String = ""
    var spot: Int = 0
    var p = 2

    while (true) {
        val command = scanner.nextLine().split(" ")
        action = command[0]

        if (action == "exit") break

        when (action) {
            "park" -> {
                rg = command[1]
                color = command[2].toLowerCase().capitalize()

                if (parking.containsValue("vague")) {
                    for ( (k, v) in parking) {
                        if (v == "vague") {
                            parking[k] = color
                            println("$color car parked on the spot $k.")
                            break
                        }
                    }
                } else println("Sorry, parking lot is full.")
            }
            "leave" -> {
                spot = command[1].toInt()
                if (parking.getValue(spot) == "vague") {
                    println("There is no car in the spot $spot.")
                } else {
                    parking[spot] = "vague"
                    println("Spot $spot is free.")
                }
            }
        }
    }
}
