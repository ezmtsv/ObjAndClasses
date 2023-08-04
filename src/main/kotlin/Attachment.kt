package ru.netology

import java.net.URL

abstract class Attachment {
    abstract val typeAttach: TypeAttachment
}

open class TypeAttachment {
    data class Audio(
        val type: String = "AUDIO",
        val id: Int = 0,
        val ownerId: Int = 0,
        val artist: String = "Artist",
        val title: String = "Title Document",
        val duration: Int = 0,
        val url: URL?,
        val lyricsId: Int = 0,
        val albumId: Int = 0,
        val genreId: Int = 0,
        val date: Int = 0,
        val noSearch: Boolean = true,
        val isHq: Boolean = true
    ) : TypeAttachment()

    data class Video(
        val type: String = "VIDEO",
        val id: Int = 0,
        val ownerId: Int = 0,
        val title: String = "Title Document",
        val description: String = "Video description",
        val duration: Int = 0,
        val link: String = "link Video",
        val image: URL?,
        val imageMedium: String = "imageMedium",
        val date: Int = 0,
        val player: String = "Video player"
    ) : TypeAttachment()

    data class Photo(
        val type: String = "PHOTO",
        val id: Int = 0,
        val ownerId: Int = 0,
        val photo130: URL?,
        val photo_604: URL?
    ) : TypeAttachment()

    data class Document(
        val type: String = "DOC",
        val id: Int = 0,
        val ownerId: Int = 0,
        val title: String = "Title Document",
        val size: Int = 0,
        val ext: String = "ext",
        val url: URL?,
        val date: Int = 0,
        val typeDoc: Int = 0
    ) : TypeAttachment()

    data class Graffiti(
        val type: String = "GRAFFITI",
        val id: Int = 0,
        val ownerId: Int = 0,
        val photo_130: URL?,
        val photo_604: URL?
    ) : TypeAttachment()
}

data class PhotoAttachment(
    val photo: TypeAttachment.Photo
): Attachment() {
    override val typeAttach: TypeAttachment = photo
}

data class AudioAttachment(
    val audio: TypeAttachment.Audio
): Attachment() {
    override val typeAttach: TypeAttachment = audio
}

data class VideoAttachment(
    val video: TypeAttachment.Video
): Attachment() {
    override val typeAttach: TypeAttachment = video
}

data class DocumentAttachment(
    val doc: TypeAttachment.Document
): Attachment() {
    override val typeAttach: TypeAttachment = doc
}

data class GraffitiAttachment(
    val graffiti: TypeAttachment.Graffiti
): Attachment() {
    override val typeAttach: TypeAttachment = graffiti
}