import kotlinx.coroutines.*

fun main() = runBlocking<Unit>{
    fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

    log("Started main coroutine")

    val v1 = async(CoroutineName("v1coroutine")) {
        delay(500)
        log("Computing v1")
        252
    }

    val v2 = async(CoroutineName("v2coroutine")) {
        delay(1000)
        log("Computing v2")
        6
    }

    log("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}