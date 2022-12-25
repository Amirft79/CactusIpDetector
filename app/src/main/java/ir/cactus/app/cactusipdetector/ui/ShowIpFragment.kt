package ir.cactus.app.cactusipdetector.ui

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.cactus.app.cactusipdetector.R
import ir.cactus.app.cactusipdetector.databinding.FragmentShowIpBinding
import ir.cactus.app.cactusipdetector.utils.NetworkHelper
import ir.cactus.app.cactusipdetector.utils.ShowSnack
import java.util.Formatter


class ShowIpFragment : Fragment() {

    private var _binding:FragmentShowIpBinding?=null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentShowIpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showIp()


    }

    private fun showIp(){
        binding.btnShowIp.setOnClickListener {
            if (NetworkHelper.isNetworkConnected(requireContext())){
                val context=requireContext().applicationContext
                val vm=context.getSystemService(Context.WIFI_SERVICE)as WifiManager
                binding.tvIp.text=android.text.format.Formatter.formatIpAddress(vm.connectionInfo.ipAddress)
            }
            else{
                binding.tvIp.text="0.0.0.0"
                requireContext().ShowSnack(binding.root,"you dont have internet connection",3000)
            }

        }



    }


}