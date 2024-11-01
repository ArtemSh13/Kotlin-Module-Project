class Screen(title: String,
             itemList: MutableList<Pair<String, () -> Unit>>) {

    private val title: String = title
    private val itemList = itemList.toMutableList()
    init {
        this.itemList.add( Pair("Выход", {} ) )
    }

    private val inputValidationRegex: Regex = Regex("[0-9]|[1-9][0-9]+")
    private val invalidInputMessage: String = "Ошибка"

    fun printScreen() {
        println(this.title)

        var itemNumber: Int = 0

        for (item in this.itemList) {
            ++itemNumber
            println("$itemNumber. ${item.first}")
        }
    }

    private fun handleCommand(command: String) : Boolean {
        if (!command.matches(this.inputValidationRegex)) {
            println(this.invalidInputMessage)
        } else {
            when (command.toInt()) {
                this.itemList.size -> return true
                else -> itemList[command.toInt() - 1].second()
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