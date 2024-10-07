import kotlinx.coroutines.*


fun main() {
    println("INICIO")
    runBlocking {
        val job = launch {
            repeat(10){
                println("Launch - repeticion #$it : ¡Estoy activo!")
                delay(1000)
            }
            println("Launch: Estoy Acabando")
        }
        delay(2500)
        while (job.isActive){
            println("RunBlocking: job esta activo")
            delay(1000)
            println("RunBlocking: Cancelando el job")
            job.cancel()
        }
        if(job.isCancelled){
            println("RunBlocking: job esta cancelado")

        }
        delay(1000)
        if(job.isCompleted){
            println("RunBlocking: job esta completo")
        }

    }
    println("FIN")
}