package com.codepath.articlesearch

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article_table")
    fun getAll(): Flow<List<ArticleEntity>>
    //creates async data stream, getall listen to any database changes

    @Insert
    fun insertAll(articles: List<ArticleEntity>)

    @Query("DELETE FROM article_table")
    fun deleteAll()
}
