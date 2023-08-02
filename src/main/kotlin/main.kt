package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    var lastPost = 0

    fun clear() {
        posts = emptyArray()
        lastPost = 0
    }

    fun add(post: Post): Post {
        posts += post
        lastPost += 1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var status: Boolean = false
        for ((index, postId) in posts.withIndex()) {
            status = postId.id == post.id
            if (status) {
                posts[index] = post.copy()
                println("new Post ${posts[index]}")
                break
            }
        }
        return status
    }

    fun getPosts(): Array<Post> {
        return posts
    }
}

class CopyRight(
    val id: Int,
    val link: String = "source",
    val name: String = "Name",
    val type: String = "Type"
)

class Likes(
    var count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = false,
    val canPublish: Boolean = false
)

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Long = 0L,
    val text: String = "text",
    val friendsOnly: Boolean = true,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val copyright: CopyRight,
    val likes: Likes
)

fun main() {
    for (i in 0..10) {
        val copy = CopyRight(i)
        val like = Likes(i + 10)
        WallService.add(Post(WallService.lastPost, likes = like, copyright = copy))
    }
//    for (post in WallService.getPosts()) {
//        println(post)
//    }

    val copy = CopyRight(5)
    val like = Likes(10)
    val post1 = Post(17, ownerId = 17, createdBy = 45, likes = like, copyright = copy)
    checkPost(post1)
    val post2 = Post(7, ownerId = 7, createdBy = 45, likes = like, copyright = copy)
    checkPost(post2)
}

fun checkPost(post: Post) {
    when (WallService.update(post)) {
        true -> {
            println("Post successful updated! \n${post}")
        }

        false -> {
            println("Post not found!")
        }
    }
}

