package ir.cactus.app.cactusipdetector.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.cactus.app.cactusipdetector.R
import ir.cactus.app.cactusipdetector.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private var _binding:FragmentHistoryBinding?=null
    private val binding get() = _binding!!


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

}