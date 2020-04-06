package parking

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val parking = mutableMapOf<Int, String>()
    parking[1] = "Red"
    var action: String = ""
    var rg: String = ""
    var color: String = ""
    var spot: Int = 0
    var p = 2
    val command = scanner.nextLine().split(" ")
    action = command[0]
    
    when (action) {
        "park" -> {
            rg = command[1]
            color = command[2].toLowerCase().capitalize()
            parking[p] = color
            println("$color car parked on the spot $p.")
            p++
        }
        "leave" -> {
            spot = command[1].toInt()
            if (parking.containsKey(spot)) {
                println("Spot $spot is free.")
            } else {
                println("There is no car in the spot $spot.")
            }
        }
    }

}
