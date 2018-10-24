package com.bugscript.room_livedata

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.bugscript.room_livedata.model.NoteEntity
import com.bugscript.room_livedata.utilities.SampleData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var notesData : List<NoteEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initRecyclerView()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        notesData = SampleData.getNotes()
        for(e : NoteEntity in notesData){
            Log.e("FOR","${e.id} has ${e.text}")
        }
    }

    private fun initRecyclerView() {
        mRecyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_introduce -> true
            R.id.action_takeAway -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
