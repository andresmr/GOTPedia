package com.omniumlab.gotpedia.presenter

import com.nhaarman.mockitokotlin2.*
import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.interactor.GetBookListInteractor
import org.junit.Before
import org.junit.Test

class BookListPresenterTest {

    private val view: BookListPresenter.View = mock()
    private val getBookListInteractor: GetBookListInteractor = mock()
    private lateinit var presenter: BookListPresenter

    private val success = argumentCaptor<(List<Book>) -> Unit>()
    private val error = argumentCaptor<(String) -> Unit>()

    @Before
    fun setUp() {
        presenter = BookListPresenter(view, getBookListInteractor)
    }

    @Test
    fun `should retrieve books`() {
        presenter.loadBooks()

        verify(getBookListInteractor).execute(success.capture(), any())
        success.lastValue.invoke(emptyList())

        verify(view).showBookList(any())
    }

    @Test
    fun `should return an error`() {
        presenter.loadBooks()

        verify(getBookListInteractor).execute(any(), error.capture())
        error.lastValue.invoke(any())

        verify(view, never()).showBookList(any())
    }
}