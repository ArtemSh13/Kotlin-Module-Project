/**
 * Storage is a class to store archives.
 */
class Storage(
    private val archives: MutableList<Archive>
) : Menu {
    private val firstMenuCommand: String = "Создать архив"

    private fun createArchive(): Archive {
        val name: String = InputProcessor.readUntilNotEmptyInput(
            welcomePhrase = "Введите название архива: > ",
            errorMessage = "Ошибка. Название архива не может быть пустой строкой"
        )
        return Archive(name, ArrayList())
    }

    private fun addArchive(archive: Archive) {
        this.archives.add(archive)
        println("~ Архив \"${archive.name}\" успешно создан ~")
    }

    override fun getMenu(): MutableList<Pair<String, () -> Unit>> {
        val result: MutableList<Pair<String, () -> Unit>> = ArrayList()

        result.add(
            Pair(
                this.firstMenuCommand,
                { this.addArchive(this.createArchive()) })
        )

        for (archive in this.archives) {
            result.add(Pair("Открыть архив \"${archive.name}\"", { archive.printArchive() }))
        }
        return result
    }
}