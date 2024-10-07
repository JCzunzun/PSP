import kotlinx.coroutines.*


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("INICIO")
    runBlocking {
        val job =
            launch {
                repeat(3)
                {
                    println("Launch - repetición #$it : ¡Estoy activo!")
                    delay (1000)
                }
                println ("Launch : Estoy acabando.")
            }
        delay (100)
        while (job.isActive) {
            println("RunBlocking : Job está activo")
            delay (1000)
        }
        println ("RunBlocking : Job NO está activo")
    }
    println ("FIN")
}