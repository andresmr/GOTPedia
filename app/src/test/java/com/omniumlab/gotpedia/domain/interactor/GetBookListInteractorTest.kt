package com.omniumlab.gotpedia.domain.interactor

import com.nhaarman.mockitokotlin2.*
import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.entity.HttpError
import com.omniumlab.gotpedia.domain.entity.Result
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetBookListInteractorTest {

    private val booksRepository: BooksRepository = mock()
    private val book : Book = mock()
    private val repoSuccess: Result<List<Book>> = Result.Success(listOf(book))
    private val repoError: Result<List<Book>> = Result.Error(HttpError.UNKNOWN)
    private lateinit var interactor: GetBookListInteractor

    private val lambda1: (List<Book>) -> Unit = mock {
        on { invoke(any()) } doReturn Unit
    }

    private val lambda2: (String) -> Unit = mock {
        on { invoke(any()) } doReturn Unit
    }

    @Before
    fun setUp() {
        interactor = GetBookListInteractor(Dispatchers.Unconfined, booksRepository)
    }

    @Test
    fun `should load books`() = runBlocking {
        whenever(booksRepository.obtain()).thenReturn(repoSuccess)
        interactor.execute(lambda1, lambda2)
        verify(lambda1).invoke(any())
        verify(lambda2, never()).invoke(any())

    }

    @Test
    fun `should not load books`() = runBlocking {
        whenever(booksRepository.obtain()).thenReturn(repoError)
        interactor.execute(lambda1, lambda2)
        verify(lambda1, never()).invoke(any())
        verify(lambda2).invoke(any())
    }
}