/**
 * InputProcessor is an object to separate user input checking from other logic and reuse code.
 */
object InputProcessor {
    fun readUntilNotEmptyInput(welcomePhrase: String, errorMessage: String): String {
        var input = ""
        while (true) {
            print(welcomePhrase)
            input = readln()
            if (input.isEmpty()) {
                println(errorMessage)
            } else {
                break
            }
        }
        return input
    }
}