package Lab1

fun main() {
    println("--- 1. SET & LIST ---")
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println("Original List: $numbers")
    println("Set (unique): $setOfNumbers")

    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)
    println("Intersect: ${set1.intersect(set2)}") // Kết quả: [3]
    println("Union: ${set1.union(set2)}")         // Kết quả: [1, 2, 3, 4, 5]

    println("\n--- 2. MAPS ---")
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    // Cách 1: forEach
    print("ForEach: ")
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()

    // Cách 2: map & joinToString
    val formattedString = peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ")
    println("Joined String: $formattedString")

    // Filter Map
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println("Filtered Names (<4 chars): $filteredNames")

    println("\n--- 3. CHAIN OPERATIONS (Filter, Shuffle, Sort) ---")
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled() // Xáo trộn ngẫu nhiên
        .take(2)    // Lấy 2 phần tử đầu
        .sorted()   // Sắp xếp lại
    println("Processed words: $filteredWords")

    println("\n--- 4. LAMBDA ---")
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println("Triple of 5 is: ${triple(5)}")

    println("\n--- 5. NULL SAFETY (ELVIS OPERATOR) ---")
    var quantity: Int? = null
    println("Quantity is null, default to: ${quantity ?: 0}") // In ra 0
    quantity = 4
    println("Quantity is 4, result: ${quantity ?: 0}")       // In ra 4

    println("\n--- 6. CLASS & COMPANION OBJECT ---")
    println("Accessing Constant: ${DetailActivity.LETTER}")

    val game = GameLogic()
    println("Current Scrambled Word: ${game.currentScrambledWord}")

    // Test lateinit
    game.initializeWord()
    game.printWord()
}

// Class mô phỏng logic Properties và Lateinit
class GameLogic {
    // Backing property
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord

    // Lateinit var
    private lateinit var currentWord: String // Cần khởi tạo trước khi dùng

    fun initializeWord() {
        currentWord = "InitializationComplete"
    }

    fun printWord() {
        if (::currentWord.isInitialized) {
            println("Lateinit word: $currentWord")
        }
    }
}

// Class mô phỏng Companion Object
class DetailActivity {
    companion object {
        const val LETTER = "letter"
    }
}