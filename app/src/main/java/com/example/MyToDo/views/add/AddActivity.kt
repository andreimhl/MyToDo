package com.example.MyToDo.views.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MyToDo.R
import com.example.MyToDo.data.Action
import com.example.MyToDo.views.todo.TodoActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity(), AddFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, AddFragment(), null)
            .commit()
    }

    override fun onFragmentInteraction(input: Action) {
        setResult(
            Activity.RESULT_OK,
            Intent(this, TodoActivity::class.java)
                .putExtra(TodoActivity.resultInput, input)
        )
        finish()
    }
}
