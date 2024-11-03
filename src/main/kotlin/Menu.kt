interface Menu {
    fun getMenu(): MutableList<Pair<String, () -> Unit>>
}