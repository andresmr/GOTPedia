package com.omniumlab.gotpedia

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        swipeRefresh.isRefreshing = true
        loadBooks()
    }

    private fun loadBooks() {
        val books = listOf(
            Book("Juego de Tronos", "123456A", 578),
            Book("Choque de Reyes", "123456B", 498),
            Book("Tormenta de espadas", "123456C", 700),
            Book("Festín de cuervos", "123456D", 987),
            Book("Baile con dragones", "123456E", 682)
        )

        val adapter = BookListAdapter(books) {
            Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
        swipeRefresh.isRefreshing = false
    }
}
