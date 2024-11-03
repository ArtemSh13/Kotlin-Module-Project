/**
 * Archive is a class to store notes according to requirements of the Ya.Practicum exercise.
 */
class Archive(
    val name: String,
    private val notes: MutableList<Note>
) : Menu {
    private val firstMenuCommand: String = "Создать заметку"

    private fun createNote(): Note {
        val name: String = InputProcessor.readUntilNotEmptyInput(
            welcomePhrase = "Введите название заметки: > ",
            errorMessage = "Ошибка. Название заметки не может быть пустой строкой"
        )
        val content: String = InputProcessor.readUntilNotEmptyInput(
            welcomePhrase = "Введите текст заметки:\n",
            errorMessage = "Ошибка. Заметка не может быть пустой строкой"
        )

        return Note(name, content)
    }

    private fun addNote(note: Note) {
        this.notes.add(note)
        println("~ Заметка \"${note.name}\" добавлена в архив \"${this.name}\" ~")
    }

    override fun getMenu(): MutableList<Pair<String, () -> Unit>> {
        val result: MutableList<Pair<String, () -> Unit>> = ArrayList()

        result.add(
            Pair(
                this.firstMenuCommand,
                { this.addNote(this.createNote()) })
        )

        for (note in this.notes) {
            result.add(Pair("Открыть заметку \"${note.name}\"", { note.printNote() }))
        }
        return result
    }

    fun printArchive() {
        val screen = Screen("==> Архив \"${this.name}\"", this)
        screen.startSession()
    }
}