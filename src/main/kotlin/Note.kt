/**
 * Note is a class to store text according to requirements of the Ya.Practicum exercise.
 */
data class Note(
    val name: String,
    val content: String
) {
    private val divider: String = "==========Конец заметки==========\n"

    fun printNote() {
        println("===> Заметка \"${this.name}\" : ")
        println(this.content)
        println(this.divider)
    }
}