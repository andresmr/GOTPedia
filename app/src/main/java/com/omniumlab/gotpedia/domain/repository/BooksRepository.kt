package com.omniumlab.gotpedia.domain.repository

import com.omniumlab.gotpedia.domain.entity.Book

interface BooksRepository {
    suspend fun obtain() : List<Book>
}