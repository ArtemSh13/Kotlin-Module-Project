/**
 * readUntilNotEmptyInput is a function to separate user input checking from other logic and reuse code.
 */

fun readUntilNotEmptyInput(welcomePhrase: String, errorMessage: String): String {
    var input = ""
    while (true) {
        print(welcomePhrase)
        input = readln()
        if (input.isEmpty() || input.isBlank()) {
            println(errorMessage)
        } else {
            break
        }
    }
    return input
}