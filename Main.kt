import kotlin.random.Random

fun main(args: Array<String>) {
    var running = true
    while (running) {
        // Menu
        val choices = arrayOf("rock", "paper", "scissors")
        println("Choices:")
        for (i in choices.indices) {
            println("(${i + 1}) ${choices[i]}")
        }

        // Player (you)
        print("Enter no. (1 to 3 only): ")
        val playerIndex = readln().toInt()
        if (playerIndex < 1 || playerIndex > 3) {
            println("Invalid choice. Please try again.\n")
            continue
        }
        val playerChoice = choices[playerIndex-1]
        println("\nYou chose: $playerChoice")

        // Enemy
        val enemyChoice = choices[Random.nextInt(0, choices.size)]
        println("Enemy chose: $enemyChoice\n")

        // Handle result
        if (playerChoice == enemyChoice) {
            println("Draw")
        } else {
            var win = false
            if (playerChoice == "rock" && enemyChoice == "scissors") {
                win = true
            } else if (playerChoice == "paper" && enemyChoice == "rock") {
                win = true
            } else if (playerChoice == "scissors" && enemyChoice == "paper") {
                win = true
            }
            println("You ${if (win) "won" else "lost"}!")
        }
        println()

        // Play again
        while (true) {
            print("Play again? (y/n): ")
            when (readln().lowercase()) {
                "y" -> {
                    println("Goodluck!\n")
                    break
                }
                "n" -> {
                    println("Thank you for playing!")
                    running = false
                    break
                }
                else -> println("Invalid choice. Please try again.\n")
            }
        }
    }
}
