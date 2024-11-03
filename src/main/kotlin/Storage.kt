class Storage(
    private val name: String,
    private val archives: MutableList<Archive>
) {
    private val firstMenuCommand: String = "Создать архив"

    private fun createArchive() : Archive {
        val nameInputError: String = "Ошибка. Название архива не может быть пустой строкой"
        var name: String

        while (true) {
            print("Введите название архива: > ")
            name = readln()
            if (name.isEmpty()) {
                println(nameInputError)
            } else {
                break
            }
        }

        return Archive(name, ArrayList())
    }

    private fun addArchive(archive: Archive) {
        this.archives.add(archive)
        println("Архив \"${archive.name}\" успешно создан")
    }

    fun getStorageMenu(): MutableList<Pair<String, () -> Unit>> {
        val result: MutableList<Pair<String, () -> Unit>> = ArrayList()

        result.add(
            Pair(
                this.firstMenuCommand,
                { this.addArchive(this.createArchive()) })
        )

        for (archive in this.archives) {
            result.add(Pair(archive.name, { archive.printArchive() }))
        }
        return result
    }
}