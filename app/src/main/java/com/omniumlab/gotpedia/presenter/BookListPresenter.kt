package com.omniumlab.gotpedia.presenter

import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.interactor.GetBookListInteractor
import com.omniumlab.gotpedia.domain.interactor.GetCharactersPOVByBookInteractor

class BookListPresenter(private val view: View) {

    private val getBookListInteractor = GetBookListInteractor()
    private val getCharactersPOVByBookInteractor = GetCharactersPOVByBookInteractor()

    init {
        view.showLoading()
        val books = getBookListInteractor.execute()
        view.showBookList(books)
        view.hideLoading()
    }

    fun onBookClick(bookTitle: String) {
        getCharactersPOVByBookInteractor.execute(bookTitle).let {
            view.showPOVCharacters(bookTitle, it.toString())
        }
    }

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showBookList(books: List<Book>)
        fun showPOVCharacters(bookTitle: String, characters: String)
    }
}