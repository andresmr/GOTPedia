package com.omniumlab.gotpedia.domain.interactor

import com.omniumlab.gotpedia.domain.entity.Result
import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import kotlinx.coroutines.*

class GetBookListInteractor(private val dispatcher: CoroutineDispatcher, private val booksRepository: BooksRepository) {

    fun execute(
        success: (List<Book>) -> Unit,
        error: (String) -> Unit
    ) {
        GlobalScope.launch(dispatcher) {
            when (val result = booksRepository.obtain()) {
                is Result.Success -> success(result.data)
                is Result.Error -> error(result.errorMessage.toString())
            }
        }
    }
}