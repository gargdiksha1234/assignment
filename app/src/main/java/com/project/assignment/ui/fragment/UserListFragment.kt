package com.project.assignment.ui.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.project.assignment.ui.adapter.DetailsAdapter
import com.project.assignment.R
import com.project.assignment.viewModel.UserListViewModel
import com.project.assignment.databinding.FragmentUserListBinding
import com.project.assignment.model.response.UserListResponse


class UserListFragment : BaseFragment() {
    private lateinit var binding: FragmentUserListBinding
    private lateinit var viewModel: UserListViewModel
    private lateinit var rvadapter: DetailsAdapter
    private lateinit var list: UserListResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        viewModel.userList()
        viewModel.listingResponse.observe(this, Observer {
            recycleradapter(it)
            list = it
        })

    }

    private fun recycleradapter(data: UserListResponse) {
        rvadapter = DetailsAdapter(data, onclick,requireContext())
        binding.rvRecycler.adapter = rvadapter

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[UserListViewModel::class.java]

    }

    val onclick: (Int) -> Unit = { uiEvent ->
        val data = list[uiEvent]
        val bundle = Bundle()
        bundle.putSerializable("data", data)

        findNavController().navigate(R.id.DetailsFragment, bundle)
    }


}