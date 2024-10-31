class Screen(title: String,
             itemList: MutableList<Any>) {

    private val title: String = title
    private val itemList = itemList.toMutableList()
    init {
        this.itemList.add("Выход")
    }

    private val inputValidationRegex: Regex = Regex("[0-9]|[1-9][0-9]+")
    private val invalidInputMessage: String = "Ошибка"

    fun printScreen() {
        println(this.title)

        var itemNumber: Int = 0

        for (item in this.itemList) {
            ++itemNumber
            println("$itemNumber. $item")
        }
    }

    private fun handleCommand(command: String) : Boolean {
        if (!command.matches(this.inputValidationRegex)) {
            println(this.invalidInputMessage)
        } else {
            when (command.toInt()) {
                this.itemList.size -> return true
                else -> println(itemList[command.toInt() - 1])
            }

        }
        return false
    }

    fun startSession() {
        var isExitEntered = false
        println()
        while (!isExitEntered) {
            print("> ")
            val userInput: String = readln()
            isExitEntered = this.handleCommand(userInput)
        }
    }
}