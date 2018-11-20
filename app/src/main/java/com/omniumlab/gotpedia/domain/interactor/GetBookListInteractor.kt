package com.omniumlab.gotpedia.domain.interactor

import com.omniumlab.gotpedia.data.RepositoryImpl
import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import kotlinx.coroutines.*

class GetBookListInteractor {

    private val booksRepository: BooksRepository = RepositoryImpl()

    fun execute(
        success: (List<Book>) -> Unit,
        error: () -> Unit
    ) {
        val deferred = GlobalScope.async { booksRepository.obtain() }
        GlobalScope.launch(Dispatchers.Main) {
            val books = deferred.await()
            if (books.isEmpty()) {
                error()
            } else {
                success(books)
            }
        }
    }
}