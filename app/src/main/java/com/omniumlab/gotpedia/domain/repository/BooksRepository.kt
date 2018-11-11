package com.omniumlab.gotpedia.domain.repository

interface BooksRepository {
    fun obtain(listener: BooksRepositoryListener)
}