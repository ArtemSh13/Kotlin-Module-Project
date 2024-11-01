data class Archive(
    val name: String,
    private val notes: MutableList<Note>
) {
    private val firstMenuCommand: String = "Создать заметку"

    fun getArchiveMenu(): MutableList<Pair<String, () -> Unit>> {
        val result: MutableList<Pair<String, () -> Unit>> = ArrayList()

        result.add(
            Pair(
                this.firstMenuCommand,
                { println("Вызвана команда ${this.firstMenuCommand}") })
        )

        for (note in this.notes) {
            result.add(Pair(note.name, { println("Открыта заметка ${note.name}") }))
        }
        return result
    }
}