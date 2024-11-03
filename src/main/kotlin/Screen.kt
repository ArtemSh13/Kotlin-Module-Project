class Screen(
    private val title: String,
    private val menu: Menu
) {

    private var itemList: MutableList<Pair<String, () -> Unit>> = ArrayList()

    init {
        this.updateItemList()
    }

    private val commandValidationRegex: Regex = Regex("[0-9]|[1-9][0-9]+")
    private val invalidCommandMessage: String = "Ошибка. Введите номер пункта меню"

    private fun isCommandValid(command: String) : Boolean {
        return (command.matches(this.commandValidationRegex)
                && command.toInt() >= 1
                && command.toInt() <= this.itemList.size)
    }

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
        if (!this.isCommandValid(command)) {
            println(this.invalidCommandMessage)
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