package com.omniumlab.gotpedia.domain.interactor

import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import kotlinx.coroutines.*

class GetBookListInteractor(private val dispatcher: CoroutineDispatcher, private val booksRepository: BooksRepository) {

    fun execute(
        success: (List<Book>) -> Unit,
        error: () -> Unit
    ) {
        val deferred = GlobalScope.async { booksRepository.obtain() }
        GlobalScope.launch(dispatcher) {
            val books = deferred.await()
            if (books.isEmpty()) {
                error()
            } else {
                success(books)
            }
        }
    }
}