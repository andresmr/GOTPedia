package com.omniumlab.gotpedia.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.omniumlab.gotpedia.R
import com.omniumlab.gotpedia.data.RepositoryImpl
import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.interactor.GetBookListInteractor
import com.omniumlab.gotpedia.presenter.BookListPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.anko.alert

class BookListView : AppCompatActivity(), BookListPresenter.View {

    private lateinit var presenter: BookListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        presenter = BookListPresenter(this, GetBookListInteractor(Dispatchers.Main, RepositoryImpl()))
        swipeToRefresh.setOnRefreshListener { presenter.loadBooks() }
        presenter.loadBooks()
    }

    override fun showLoading() {
        swipeToRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeToRefresh.isRefreshing = false
    }

    override fun showBookList(books: List<Book>) {
        val adapter = BookListAdapter(books) {
            presenter.onBookClick(it.title)
        }
        recyclerView.adapter = adapter
    }

    override fun showPOVCharacters(bookTitle: String, characters: String) {
        alert(characters) {
            title = bookTitle
        }.show()
    }
}