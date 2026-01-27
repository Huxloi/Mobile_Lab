package Lab1
// Nếu file của bạn nằm trong package Lab1 thì giữ dòng này, không thì xóa đi
// package Lab1

fun main() {
    // 1. In văn bản
    println("Hello, world!")
    println("This is the text to print!")

    // 2. Biến
    val age = 5
    val name = "Rover"
    println("You are already $age!")
    println("You are already $age days old, $name!")

    // 3. Gọi hàm printHello
    printHello()

    // 4. Dòng kẻ phân cách ngắn
    println("===========")

    // 5. Tung xúc xắc lần 1
    // Trong hình ghi: "Lab1.Dice rolled: 3"
    val myFirstDice = Dice(6)
    // Lưu ý: Kết quả là ngẫu nhiên, có thể ra số khác 3
    println("Lab1.Dice rolled: ${myFirstDice.roll()}")

    // 6. Câu lệnh điều kiện if/else
    val num = 4
    if (num > 4) {
        println("The variable is greater than 4")
    } else if (num == 4) {
        println("The variable is equal to 4")
    } else {
        println("The variable is less than 4")
    }

    // 7. Câu lệnh when
    // Để ra kết quả giống hình ("Unfortunately, you rolled a 3"), ta giả định rollResult = 3
    val rollResult = 3
    when (rollResult) {
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3") // Dòng này khớp với hình
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }

    // 8. Dòng kẻ phân cách dài
    println("====================")

    // 9. Vòng lặp (In hình đáy bánh kem)
    printCakeBottom(age, 3)

    // 10. Tung xúc xắc lần 2
    // Trong hình ghi: "Lab1.Dice from class: 4"
    println("Lab1.Dice from class: ${myFirstDice.roll()}")
}

// --- Các hàm hỗ trợ (giữ nguyên logic cũ) ---

fun printHello() {
    println("Hello Kotlin")
}

fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) { // 5 + 2 = 7 ký tự @
            print("@")
        }
        println()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}