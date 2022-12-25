package ir.cactus.app.cactusipdetector.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.cactus.app.cactusipdetector.R
import ir.cactus.app.cactusipdetector.databinding.FragmentHistoryBinding
import ir.cactus.app.cactusipdetector.repository.DataBaseHandler
import ir.cactus.app.cactusipdetector.utils.ShowSnack


class HistoryFragment : Fragment() {

    private var _binding:FragmentHistoryBinding?=null
    private val binding get() = _binding!!

    private lateinit var db:DataBaseHandler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData()
    }

    private fun showData(){
        db= DataBaseHandler(requireContext())
        binding.showListIp.setOnClickListener {
            requireContext().ShowSnack(binding.root,db.showIp().get(0).Ip_Address.toString(),4000)
        }
    }

}