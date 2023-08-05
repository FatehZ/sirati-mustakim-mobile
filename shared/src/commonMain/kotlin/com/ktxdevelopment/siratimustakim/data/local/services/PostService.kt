package com.ktxdevelopment.siratimustakim.data.local.services

import com.ktxdevelopment.siratimustakim.data.remote.ktor.KtorApi
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.stringify
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class PostService(db: PostDatabase) {

    private val queries = db.postQueries

    suspend fun getPostById(id: String): Post =
        queries.getPostById(id)
            .executeAsOneOrNull()?.toPost()

    suspend fun getAllPostsPaginated(page: Int, limit: Int = 20): List<PostLit> =
        queries.getAllPostsPaginated(page, limit)
            .executeAsList()
            .map { it.toPostLit() }

    suspend fun getAllPosts(): List<PostLit> = queries.getAllPosts()
        .executeAsList()
        .map { it.toPostLit() }

    suspend fun searchInPosts(query: String): List<PostLit> = queries.search(query)
        .executeAsList()
        .map { it.toPostLit() }


    suspend fun insertPost(post: Post) = queries.insertPost(
        id = post.id,
        title = post.title,
        subtitle = post.subtitle,
        tags = post.tags?.stringify(),
        category = post.category?.stringify(),
        content = post.content,
        author = post.author.stringify(),
        date = post.date,  //todo
        reference = post.references.stringify()
    )

    fun deletePostById(id: String) {
        queries.deletePost(id = id)
    }
}