package parking

import java.util.*
val scanner = Scanner(System.`in`)
var parking = mutableMapOf<Int, Spot>()

fun main() {
    var action: String = ""
    var rg: String = ""
    var color: String = ""
    var spot: Int = 0

    while (true) {

        val command = scanner.nextLine().split(" ")
        action = command[0]

        if (action == "exit") break
        if (action != "create" && parking.isEmpty()) {
            println("Sorry, parking lot is not created.")
            continue
        }

        when (action) {
            "create" -> {
                val len = command[1].toInt()
                create(len)
            }
            "park" -> {
                if (parking.isNotEmpty()) {
                    rg = command[1]
                    color = command[2].toLowerCase().capitalize()
                    park(rg, color)
                }
            }
            "leave" -> {
                if (parking.isNotEmpty()) {
                    spot = command[1].toInt()
                    leave(spot)
                }
            }
            "status" -> status()
            "reg_by_color" -> regColor(command[1])
            "spot_by_color" -> spotColor(command[1])
            "spot_by_reg" -> spotReg(command[1])
        }
    }
}


class Spot(var rg: String, var color: String)


fun create(len: Int) {
    parking = mutableMapOf<Int, Spot>()

    for (i in 1..len) {
        parking[i] = Spot("null", "null")
    }
    println("Created a parking lot with $len spots.")
}


fun park(rg: String, color: String) {
    for ((k, v) in parking) {
        if (v.rg == "null") {
            parking[k] = Spot(rg, color)
            println("$color car parked on the spot $k.")
            return
        }
    }
    println("Sorry, parking lot is full.")
    return
}


fun leave(spot: Int) {
    if (parking.getValue(spot).rg == "null") {
        println("There is no car in the spot $spot.")
    } else {
        parking[spot] = Spot("null", "null")
        println("Spot $spot is free.")
    }
}


fun status() {
    var isEmpty = true
    for ((k, v) in parking) {
        if (v.rg != "null") {
            println("$k ${v.rg} ${v.color}")
            isEmpty = false
        }
    }
    if (isEmpty) println("Parking lot is empty.")
}


fun regColor(color: String) {
    var out = ""
    var isColor = false
    for ((k, v) in parking) {
        if (v.color == color.toLowerCase().capitalize()) {
            out += v.rg + ", "
            isColor = true
        }
    }
    if (isColor) println(out.removeSuffix(", "))
    else println("No cars with color $color were found.")
}


fun spotColor(color: String) {
    var out = ""
    var isColor = false
    for ((k, v) in parking) {
        if (v.color == color.toLowerCase().capitalize()) {
            out += k.toString() + ", "
            isColor = true
        }
    }
    if (isColor) println(out.removeSuffix(", "))
    else println("No cars with color $color were found.")
}


fun spotReg (reg: String) {
    var out = ""
    var isReg = false
    for ((k, v) in parking) {
        if (v.rg == reg) {
            out += "$k, "
            isReg = true
        }
    }
    if (isReg) println(out.removeSuffix(", "))
    else println("No cars with registration number $reg were found.")
}