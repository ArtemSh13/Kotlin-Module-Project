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