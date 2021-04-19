data class Data(
    val id: String,
    val image: String,
    val likes: Int,
    val link: String,
    val owner: Owner,
    val publishDate: String,
    val tags: List<String>,
    val text: String
)