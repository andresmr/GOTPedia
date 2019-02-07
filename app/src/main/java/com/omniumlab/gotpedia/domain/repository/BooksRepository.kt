package com.omniumlab.gotpedia.domain.repository

import com.omniumlab.gotpedia.domain.entity.Result
import com.omniumlab.gotpedia.domain.entity.Book

interface BooksRepository {

    suspend fun obtain(): Result<List<Book>>
}