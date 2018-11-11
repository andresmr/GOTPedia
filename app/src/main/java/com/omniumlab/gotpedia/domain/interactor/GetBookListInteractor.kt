package com.omniumlab.gotpedia.domain.interactor

import com.omniumlab.gotpedia.data.RepositoryImpl
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.repository.BooksRepositoryListener

class GetBookListInteractor {

    private val booksRepository: BooksRepository = RepositoryImpl()

    fun execute(callback: Callback) {
        booksRepository.obtain(object : BooksRepositoryListener {
            override fun onComplete(books: List<Book>) {
                callback.onSuccess(books)
            }

            override fun onError() {
                callback.onError()
            }
        })
    }

    interface Callback {
        fun onSuccess(books: List<Book>)
        fun onError()
    }
}