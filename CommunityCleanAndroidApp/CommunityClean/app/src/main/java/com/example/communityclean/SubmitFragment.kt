package com.example.communityclean

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.communityclean.databinding.FragmentSubmitBinding
import com.example.communityclean.dtos.ReportDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class SubmitFragment : Fragment() {

    private var _binding: FragmentSubmitBinding? = null

    private val binding get() = _binding!!

    private val args: SubmitFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSubmitBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonHome.setOnClickListener{
            returnToHome()
        }

        val report = Json.decodeFromString<ReportDto>(args.reportObject)
        binding.textViewReport.text = """
            |Category: ${report.category}
            |Comments: ${report.comments}
            |Contacts:
            |   First Name: ${report.contacts?.firstName}
            |   Last Name: ${report.contacts?.lastName}
            |   Email: ${report.contacts?.email}
            |   Phone: ${report.contacts?.tel}
            |GeoLocation: ${report.geoTagging.latitude}, ${report.geoTagging.longitude} 
        """.trimMargin()
        binding.textViewReport.movementMethod = ScrollingMovementMethod()
    }

    private fun returnToHome(){
        findNavController().navigate(R.id.action_submitFragment_to_HomeFragment)
    }
}