package com.project.assignment.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.assignment.R
import com.project.assignment.databinding.FragmentDetailBinding
import com.project.assignment.model.response.UserListResponseItem


@Suppress("DEPRECATION")
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("data") as UserListResponseItem
        initUi(data)
    }

    @SuppressLint("SetTextI18n")
    private fun initUi(data: UserListResponseItem) {
        binding.tvId.text =getString(R.string.id) + data.id
        binding.tvName.text = getString(R.string.name)  + data.name
        binding.tvUserName.text =getString(R.string.user_name) + data.username
        binding.tvCity.text = getString(R.string.city) + data.address.city
        binding.tvStreet.text = getString(R.string.street) + data.address.street
        binding.tvSuite.text = getString(R.string.suite) + data.address.suite
        binding.tvEmail.text = getString(R.string.email)+ data.email
        binding.tvZipcode.text = getString(R.string.zipcode) + data.address.zipcode
        binding.tvCatchPhrase.text = getString(R.string.catchPhrase) + data.company.catchPhrase
        binding.tvCompanyName.text = getString(R.string.companyName) + data.company.name
        binding.tvBs.text = getString(R.string.bs) + data.company.bs
        binding.tvPhone.text = getString(R.string.Phone) + data.phone
        binding.tvWebsite.text = getString(R.string.website) + data.website
        binding.ivGeo.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("lat", data.address.geo.lat)
            bundle.putString("long", data.address.geo.lng)
            findNavController().navigate(R.id.MapFragment, bundle)
        }

    }
    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

}