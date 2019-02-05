package com.omniumlab.gotpedia.domain.interactor

import com.nhaarman.mockitokotlin2.*
import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetBookListInteractorTest {

    private val booksRepository: BooksRepository = mock()
    private lateinit var interactor: GetBookListInteractor

    private val lambda1: (List<Book>) -> Unit = mock {
        on { invoke(any()) } doReturn Unit
    }

    private val lambda2: () -> Unit = mock {
        on { invoke() } doReturn Unit
    }

    @Before
    fun setUp() {
        interactor = GetBookListInteractor(Dispatchers.Unconfined, booksRepository)
    }

    @Test
    fun `should load books`() = runBlocking {
        whenever(booksRepository.obtain()).thenReturn(getBooks())
        interactor.execute(lambda1, lambda2)
        verify(lambda1).invoke(getBooks())
        verify(lambda2, never()).invoke()

    }

    @Test
    fun `should not load books`() = runBlocking {
        whenever(booksRepository.obtain()).thenReturn(emptyList())
        interactor.execute(lambda1, lambda2)
        verify(lambda1, never()).invoke(emptyList())
        verify(lambda2).invoke()
    }

    private fun getBooks() = listOf(Book("trit", "ISBN", 3))
}