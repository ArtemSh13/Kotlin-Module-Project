import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val storage = Storage(
        prepareTestData(
            archiveCount = 2,
            notesPerArchive = 2
        )
    )

    val mainScreen = Screen("=> Архивы", storage)
    mainScreen.startSession()
}

/**
 * The prepareTestData() function is needed only to a reviewer can check the project faster.
 * It doesn't affect this program efficiency.
 */
fun prepareTestData(archiveCount: Int, notesPerArchive: Int): MutableList<Archive> {
    val archiveList = ArrayList<Archive>()
    var noteIndex = 0

    for (i in 0 until archiveCount) {
        val notes = ArrayList<Note>()
        for (j in 1..notesPerArchive) {
            notes.add(Note("Заметка $noteIndex", "Текст заметки $noteIndex"))
            ++noteIndex
        }
        archiveList.add(Archive("Архив $i", notes))
    }

    return archiveList
}