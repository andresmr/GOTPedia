package com.omniumlab.gotpedia.domain.repository

import com.omniumlab.gotpedia.domain.entity.Book

interface BooksRepositoryListener {
    fun onComplete(books: List<Book>)
    fun onError()
}