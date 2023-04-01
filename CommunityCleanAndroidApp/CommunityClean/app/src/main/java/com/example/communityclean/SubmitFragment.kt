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

        binding.textViewReport.text = args.reportObject
        binding.textViewReport.movementMethod = ScrollingMovementMethod()
    }

    private fun returnToHome(){
        findNavController().navigate(R.id.action_submitFragment_to_HomeFragment)
    }
}