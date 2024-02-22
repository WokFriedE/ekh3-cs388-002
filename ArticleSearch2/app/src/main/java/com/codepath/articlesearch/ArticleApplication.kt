package com.codepath.articlesearch

import android.app.Application

class ArticleApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) } // lazy is create till use
    // only wanna create this once so make it the base class
    // makes the instance of database
}