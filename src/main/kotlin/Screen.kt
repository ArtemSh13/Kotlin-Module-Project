/**
 * Screen is a class to display the command list for any Menu implementer.
 */
class Screen(
    private val title: String,
    private val menu: Menu
) {

    private var itemList: List<Pair<String, () -> Unit>> = ArrayList()

    init {
        this.updateItemList()
    }

    private val commandValidationRegex: Regex = Regex("[0-9]|[1-9][0-9]+")
    private val invalidCommandMessage: String = "Ошибка. Введите номер пункта меню"

    private fun isCommandValid(command: String): Boolean {
        return (command.matches(this.commandValidationRegex)
                && command.toInt() >= 1
                && command.toInt() <= this.itemList.size)
    }

    /**
     * The updateItemList() method actualizes the item list.
     * It's necessary e. g. when new note was added to an archive.
     */
    private fun updateItemList() {
        val tempList = this.menu.getMenu().toMutableList()
        tempList.add(Pair("Выход", {}))
        this.itemList = tempList.toList()
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

    /**
     * The handleCommand() method processes a command.
     * It returns true if the command is "Exit", else the command is executed
     * and the method returns false.
     * False is returned also if the command isn't valid.
     */
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

    /**
     * The startSession() method is a main cycle for user input.
     */
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