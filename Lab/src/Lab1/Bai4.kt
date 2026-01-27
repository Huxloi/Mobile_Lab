package Lab1 // Giữ lại tên package của bạn nếu cần

// Import thư viện Coroutines (sẽ hết lỗi đỏ sau khi làm Phần 1)
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.system.measureTimeMillis

// --- 1. ENUM CLASS ---
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

// --- 2. OBJECT / SINGLETON ---
object DataProviderManager {
    const val PROVIDER_NAME = "WeatherServer_v1"
    fun getStatus(): String = "Connected"
}

// --- 3. SUSPEND FUNCTIONS (Hàm tạm ngưng) ---
suspend fun getValue(): Double {
    println("...Đang tải dữ liệu (delay 1s)...")
    delay(1000L) // Giả lập chờ 1 giây
    return 50.5
}

suspend fun processValue(): Double {
    val value = getValue()
    return value * 2
}

suspend fun getRiskyValue(): Double {
    delay(500)
    throw Exception("Lỗi mất kết nối mạng!")
}

// --- 4. HÀM MAIN ---
fun main() {
    println("=== BẮT ĐẦU CHƯƠNG TRÌNH ===")

    // A. Sử dụng Enum
    val currentDirection = Direction.NORTH
    if (currentDirection == Direction.NORTH) {
        println("Đang đi về hướng Bắc")
    }

    // B. Sử dụng Object
    println("Server: ${DataProviderManager.PROVIDER_NAME} - Status: ${DataProviderManager.getStatus()}")

    // C. Coroutines (RunBlocking)
    // runBlocking giúp giữ chương trình không bị tắt ngay để chờ coroutines chạy xong
    runBlocking {

        // C1. Async/Await (Chạy song song lấy kết quả)
        println("\n--- Bắt đầu Async ---")
        val time = measureTimeMillis {
            val task1 = async { getValue() }      // Chạy ngầm vụ 1
            val task2 = async { processValue() }  // Chạy ngầm vụ 2 (song song)

            println("Kết quả 1: ${task1.await()}")
            println("Kết quả 2: ${task2.await()}")
        }
        println("Tổng thời gian chạy: $time ms")

        // C2. Job & Cancel (Hủy tác vụ)
        println("\n--- Test Cancel Job ---")
        val job = launch {
            repeat(1000) { i ->
                println("Job đang chạy lần $i...")
                delay(500L)
            }
        }
        delay(1200L) // Chờ 1.2s
        println("Gửi lệnh hủy Job...")
        job.cancelAndJoin()
        println("Job đã dừng.")

        // C3. Try-Catch (Bắt lỗi)
        println("\n--- Test Try-Catch ---")
        try {
            getRiskyValue() // Hàm này sẽ ném lỗi
        } catch (e: Exception) {
            println("Đã bắt được lỗi: ${e.message}")
        }
    }

    println("\n=== KẾT THÚC ===")
}