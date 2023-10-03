package com.ktxdevelopment.siratimustakim.data.local.services

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import com.ktxdevelopment.siratimustakim.domain.model.util.destringify
import com.ktxdevelopment.siratimustakim.domain.model.util.stringify
import com.ktxdevelopment.siratimustakim.shared.sqldelight.PostDatabase
import comktxdevelopmentsiratimustakim.database.GetAllPosts
import comktxdevelopmentsiratimustakim.database.GetAllPostsPaginated
import comktxdevelopmentsiratimustakim.database.PostEntity
import comktxdevelopmentsiratimustakim.database.SearchPost
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PostLocalService(db: PostDatabase) {

    private val queries = db.postQueries

    suspend fun getPostById(id: String): Flow<Resource<Post>> = flow {
        val res = queries.getPostById(id)
            .executeAsOneOrNull()
        emit(Resource.Success(res.toPost()))
    }

    suspend fun getAllPostsPaginated(page: Int, limit: Int = 20): Flow<Resource<List<PostLit>>> =
        flow {
            val res = queries.getAllPostsPaginated(page.toLong(), limit.toLong())
                .executeAsList()
                .map { it.toPostLit() }
            emit(Resource.Success(res))
        }

    suspend fun getAllPosts(): Flow<Resource<List<PostLit>>> = flow {
        val res = queries.getAllPosts()
            .executeAsList()
            .map { it.toPostLit() }
        emit(Resource.Success(res))
    }

    suspend fun searchInPosts(query: String): Flow<Resource<List<PostLit>>> = flow {
        val res = queries.searchPost(query)
            .executeAsList()
            .map { it.toPostLit() }
        emit(Resource.Success(res))
    }

    suspend fun insertPost(post: Post): Flow<Resource<Nothing?>> = flow {
        queries.insertPost(
            id = post.id!!,
            title = post.title!!,
            subtitle = post.subtitle!!,
            tags = post.tags?.stringify(),
            category = post.category?.stringify(),
            content = post.content!!,
            author = post.author.stringify()!!,
            date = post.date!!,  //todo
            reference = post.references.stringify()
        )
        emit(Resource.Success(null))
    }

    fun deletePostById(id: String): Flow<Resource<Nothing?>> = flow {
        queries.deletePost(id = id)
        emit(Resource.Success(null))
    }

    fun isPostSaved(id: String): Flow<Resource<Boolean>> = flow {
        val result = queries.isPostSaved(id = id).executeAsOne()
        emit(Resource.Success(result))
    }
}

private fun GetAllPostsPaginated.toPostLit(): PostLit {
    return PostLit(id = id, title = title, subtitle = subtitle)
}

private fun GetAllPosts.toPostLit(): PostLit {
    return PostLit(id = id, title = title, subtitle = subtitle)
}

private fun SearchPost.toPostLit(): PostLit {
    return PostLit(id = id, title = title, subtitle = subtitle)
}


private fun PostEntity?.toPost(): Post {
    this!!
    return Post(id, title, subtitle, tags.destringify(), category.destringify(), content, author.destringify(), date, reference.destringify(), viewed)
}
