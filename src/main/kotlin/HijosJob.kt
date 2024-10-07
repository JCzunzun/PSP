import kotlinx.coroutines.*

fun main() {
    println("INICIO")
    runBlocking{
        val job = launch {
            val jobHijo =
                launch {
                    repeat(3)
                    {
                        println("Hijo - repetición #$it : ¡Estoy activo!")
                        delay(1000)
                    }
                    println("Hijo : Estoy acabando.")
                }
            delay(100)
            while (jobHijo.isActive) {
                println("Hijo : ¡Estoy activo!")
                delay(1000)
            }
            println("Launch :: Estoy acabando.")
        }
        delay(200)
        while (job.isActive) {
            println("RunBlocking : Job está activo")
            delay(1000)
        }
        if (job.isCancelled) {
            println("RunBlocking : Job está cancelado")
        }
        if (job.isCompleted) {
            println("RunBlocking : Job está completado")
        }
    }
    println ("FIN")
}