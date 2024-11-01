data class Archive (
    private val name: String,
    private val notes: MutableList<Note>
) {

    fun getArchiveMenu(): MutableList<Pair<String, () -> Unit >> {
        val result: MutableList<Pair<String, () -> Unit >> = ArrayList()

        result.add(Pair("Создать архив", {println("Вызвана команда Создать архив")}))

        for (note in notes) {
            result.add(Pair(note.name, {println("Открыта заметка ${note.name}")}))
        }
        return result
    }
}