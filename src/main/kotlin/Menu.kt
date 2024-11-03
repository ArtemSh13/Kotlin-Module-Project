/**
 * Menu is an interface to unify Screen class usage.
 */
interface Menu {
    fun getMenu(): MutableList<Pair<String, () -> Unit>>
}