package Lab1

import kotlin.math.PI

fun main() {
    // --- PHẦN 1: THỰC HÀNH VỚI CLASS (DWELLING) ---
    println("--- Testing Classes ---")

    // Tạo một SquareCabin (Cabin vuông)
    val squareCabin = SquareCabin(residents = 6, length = 50.0)

    // Sử dụng 'with' để gọi nhiều hàm trên cùng một đối tượng (như đoạn code bạn gửi)
    with(squareCabin) {
        println("\n--- Square Cabin ---")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor Area: ${floorArea()}")
    }

    // Tạo một RoundHut (Lều tròn)
    val roundHut = RoundHut(residents = 3, radius = 10.0)
    with(roundHut) {
        println("\n--- Round Hut ---")
        println("Material: ${buildingMaterial}")
        println("Floor Area: ${String.format("%.2f", floorArea())}") // Làm tròn số
    }

    // Tạo RoundTower (Tháp tròn - để minh họa logic 'super.floorArea() * floors')
    val roundTower = RoundTower(residents = 4, radius = 15.5, floors = 2)
    with(roundTower) {
        println("\n--- Round Tower ---")
        println("Material: ${buildingMaterial}")
        println("Floor Area: ${String.format("%.2f", floorArea())}")
    }

    // --- PHẦN 2: THỰC HÀNH DANH SÁCH (LIST) VÀ VÒNG LẶP (LOOP) ---
    println("\n--- Testing Lists & Loops ---")

    // List không thay đổi (Immutable List)
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("List size: ${numbers.size}")
    println("First element: ${numbers[0]}")

    // Đảo ngược danh sách
    val colors = listOf("red", "blue", "green")
    println("Reversed colors: ${colors.reversed()}")

    // List có thể thay đổi (Mutable List)
    val entrees = mutableListOf<String>()
    entrees.add("spaghetti")
    entrees.add("ravioli")
    entrees[0] = "lasagna" // Thay thế phần tử
    entrees.remove("lasagna") // Xóa phần tử
    println("Entrees: $entrees")

    // Vòng lặp For
    println("Looping through numbers:")
    for (element in numbers) {
        print("$element ")
    }
    println()

    // Vòng lặp While
    println("While loop:")
    var index = 0
    while (index < colors.size) {
        println(colors[index])
        index++
    }

    // --- PHẦN 3: XỬ LÝ CHUỖI VÀ TOÁN TỬ ---
    println("\n--- String Templates & Math ---")
    val name = "Android"
    println("Length of name: ${name.length}")

    val number = 10
    val groups = 5
    println("${number * groups} people") // 50 people

    // Gọi hàm vararg
    addToppings("Cheese", "Pepperoni", "Mushrooms")
}

// --- ĐỊNH NGHĨA CÁC CLASS ---

/**
 * Lớp trừu tượng Dwelling (Nhà ở)
 */
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double
}

/**
 * Lớp SquareCabin kế thừa từ Dwelling
 */
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }
}

/**
 * Lớp RoundHut kế thừa từ Dwelling
 * Open để cho phép RoundTower kế thừa lại
 */
open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

/**
 * Lớp RoundTower kế thừa từ RoundHut
 * Class này minh họa đoạn code: return super.floorArea() * floors
 */
class RoundTower(residents: Int, radius: Double, val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

// --- CÁC HÀM KHÁC ---

// Sửa lỗi cú pháp: bỏ 'val' trong tham số vararg
fun addToppings(vararg toppings: String) {
    print("Toppings added: ")
    for (topping in toppings) {
        print("$topping, ")
    }
    println()
}

/* * Ghi chú về Android Code:
 * Dòng `val stringInTextField = binding.costOfService.text.toString()`
 * và `package com.example.affirmations.model`
 * thuộc về dự án Android App cụ thể, không thể chạy trong file console đơn lẻ này.
 */