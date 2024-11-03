data class Archive (
    val name: String,
    private val notes: MutableList<Note>
) : Menu {
    private val firstMenuCommand: String = "Создать заметку"

    private fun createNote() : Note {
        val nameInputError: String = "Ошибка. Название заметки не может быть пустой строкой"
        val contentInputError: String = "Ошибка. Заметка не может быть пустой строкой"
        var name: String = ""
        var content: String = ""

        while (true) {
            print("Введите название заметки: > ")
            name = readln()
            if (name.isEmpty()) {
                println(nameInputError)
            } else {
                break
            }
        }
        while (true) {
            println("Введите текст заметки:")
            content = readln()
            if (name.isEmpty()) {
                println(contentInputError)
            } else {
                break
            }
        }

        return Note(name, content)
    }

    fun addNote(note: Note) {
        this.notes.add(note)
        println("Заметка \"${note.name}\" добавлена в архив \"${this.name}\"")
    }

    override fun getMenu(): MutableList<Pair<String, () -> Unit>> {
        val result: MutableList<Pair<String, () -> Unit>> = ArrayList()

        result.add(
            Pair(
                this.firstMenuCommand,
                { this.addNote(this.createNote()) })
        )

        for (note in this.notes) {
            result.add(Pair("Открыть заметку \"${note.name}\"", { note.printNote() } ))
        }
        return result
    }

    fun printArchive() {
        val screen = Screen("Архив \"${this.name}\"", this)
        screen.startSession()
    }
}