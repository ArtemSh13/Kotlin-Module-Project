class Storage(
    private val name: String,
    private val archives: MutableList<Archive>
) {
    private val firstMenuCommand: String = "Создать архив"

    fun getStorageMenu(): MutableList<Pair<String, () -> Unit>> {
        val result: MutableList<Pair<String, () -> Unit>> = ArrayList()

        result.add(
            Pair(
                this.firstMenuCommand,
                { println("Вызвана команда ${this.firstMenuCommand}") })
        )

        for (archive in this.archives) {
            result.add(Pair(archive.name, { println("Открыт архив ${archive.name}") }))
        }
        return result
    }
}