class Screen(
    private val title: String,
    private val menu: Menu
) {

    private var itemList: MutableList<Pair<String, () -> Unit>> = ArrayList()

    init {
        this.updateItemList()
    }

    private val inputValidationRegex: Regex = Regex("[0-9]|[1-9][0-9]+")
    private val invalidInputMessage: String = "Ошибка"

    private fun updateItemList() {
        this.itemList = this.menu.getMenu()
        this.itemList.add(Pair("Выход", {}))
    }

    private fun printScreen() {
        println(this.title)

        var itemNumber: Int = 0
        this.updateItemList()

        for (item in this.itemList) {
            ++itemNumber
            println("$itemNumber. ${item.first}")
        }
    }

    private fun handleCommand(command: String): Boolean {
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
        while (!isExitEntered) {
            this.printScreen()
            println()
            print("> ")
            isExitEntered = this.handleCommand(readln())
        }
    }
}