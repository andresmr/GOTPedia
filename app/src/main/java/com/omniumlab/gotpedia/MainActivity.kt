package com.omniumlab.gotpedia

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        progressBar.visibility = VISIBLE
        loadBooks()
    }

    private fun loadBooks() {
        val adapter = BookListAdapter(books) {
            val characters = charactersByBook[it.title]
            alert(characters.toString()) {
                title = it.title
            }.show()
        }
        recyclerView.adapter = adapter
        progressBar.visibility = GONE
    }
}