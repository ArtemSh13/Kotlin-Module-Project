data class Note(
    val name: String,
    val content: String
) {
    private val divider: String = "==========Конец заметки==========\n"

    fun printNote() {
        println("Заметка \"${this.name}\" : ")
        println(this.content)
        println(this.divider)
    }
}