package com.example.MyToDo.views.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.MyToDo.R
import com.example.MyToDo.data.Action
import kotlinx.android.synthetic.main.fragment_todo.*

class TodoFragment : Fragment() {

    lateinit var actions: List<Action>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actions = arguments?.getParcelableArrayList(actionParams) ?: listOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_todo, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todoList.layoutManager = LinearLayoutManager(activity)
        todoList.adapter = TodoListAdapter(actions, requireContext())
    }

    fun updateAdapterData(actions: ArrayList<Action>) {
        todoList.visibility = View.VISIBLE
        txtEmpty.visibility = View.GONE
        todoList.adapter.also {
            (it as? TodoListAdapter)?.let { todoListAdapter ->
                todoListAdapter.data = actions
            }
        }
    }

    companion object {

        const val actionParams = "Params:Actions"
        const val todoFragmentTag = "Tag:TodoFragment"

        @JvmStatic
        fun newInstance(actions: ArrayList<Action>) = TodoFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(actionParams, actions)
            }
        }
    }
}
