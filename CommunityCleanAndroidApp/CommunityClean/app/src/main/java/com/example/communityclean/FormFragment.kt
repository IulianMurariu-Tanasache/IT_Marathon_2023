package com.example.communityclean

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.navigation.fragment.navArgs
import com.example.communityclean.databinding.FragmentFormBinding
import com.example.communityclean.databinding.FragmentHomeBinding
import com.example.communityclean.dtos.Contacts
import com.example.communityclean.dtos.ReportDto

class FormFragment : Fragment() {

    private var _binding: FragmentFormBinding? = null

    private val binding get() = _binding!!

    private val args: FormFragmentArgs by navArgs()


    private val categoryList = listOf("dangerous", "lost", "garbage", "other")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSubmit.setOnClickListener{
            sendFormData()
        }

        val base64Image = args.objectPhoto
        val imageBytes = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        binding.imageView.setImageBitmap(decodedImage)


        val spinnerAdapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_list_item_1, categoryList)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = spinnerAdapter

        binding.checkBox.setOnClickListener{
            if(binding.checkBox.isChecked) {
                setStatusContactFormFields(false)
            }
            else {
                setStatusContactFormFields(true)
            }
        }
    }

    private fun sendFormData() {

        if (binding.spinner.selectedItemPosition >= categoryList.size-1 &&
            binding.editTextComments.text.isBlank()) {
            binding.editTextComments.error = getString(R.string.form_fragment_error_info)
        }


//        val contacts = Contacts()
//        val reportDto = ReportDto()

        // todo: send http request with form data
    }

    private fun setStatusContactFormFields(status: Boolean) {
        binding.editTextEmail.isEnabled = status
        binding.editTextPhone.isEnabled = status
        binding.editTextFirstName.isEnabled = status
        binding.editTextLastName.isEnabled = status
    }
}