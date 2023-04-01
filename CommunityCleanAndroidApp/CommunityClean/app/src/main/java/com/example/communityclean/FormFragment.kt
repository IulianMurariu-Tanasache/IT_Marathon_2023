package com.example.communityclean

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.location.Location
import android.os.Bundle
import android.util.Base64
import android.util.JsonWriter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.communityclean.databinding.FragmentFormBinding
import com.example.communityclean.dtos.Contacts
import com.example.communityclean.dtos.GeoTag
import com.example.communityclean.dtos.ReportDto
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class FormFragment : Fragment() {

    private var _binding: FragmentFormBinding? = null

    private val binding get() = _binding!!

    private val args: FormFragmentArgs by navArgs()

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var base64Image: String

    private val categoryList = listOf("dangerous", "lost", "garbage", "other")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormBinding.inflate(inflater, container, false)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSubmit.setOnClickListener{
            sendFormData()
        }

        base64Image = args.objectPhoto
        val imageBytes = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        binding.imageView.setImageBitmap(decodedImage)


        val spinnerAdapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_list_item_1, categoryList)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = spinnerAdapter

        binding.checkBox.setOnClickListener{
            if(binding.checkBox.isChecked) {
                setStatusContactFormFields(false)
                binding.editTextEmail.error = ""
                binding.editTextPhone.error = ""
                binding.editTextFirstName.error = ""
                binding.editTextLastName.error = ""

            }
            else {
                setStatusContactFormFields(true)
            }
        }
    }

    private fun sendFormData() {
        val hasErrors = validateFormFields()
        if (hasErrors) {
            return
        }

        val contacts = if (binding.checkBox.isChecked) {
            null
        } else {
            Contacts(
                binding.editTextEmail.text.toString(),
                binding.editTextPhone.text.toString(),
                binding.editTextFirstName.text.toString(),
                binding.editTextLastName.text.toString()
            )
        }

        if(ContextCompat.checkSelfPermission(this.requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this.requireActivity(),
                FormFragment.REQUIRED_PERMISSIONS,
                FormFragment.REQUEST_CODE_PERMISSIONS
            )
            return
        }

        val cts = CancellationTokenSource()
        fusedLocationClient.getCurrentLocation(100, cts.token)
            .addOnSuccessListener { location: Location ->
                Log.d("CAM", location.toString())

                val category = binding.spinner.selectedItemPosition
                val comments = binding.editTextComments.text.toString()

                val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS")
                val currentTimestamp = LocalDateTime.now().format(formatter)

                val reportDto = ReportDto(
                    base64Image, category, comments, contacts,
                    GeoTag(location.latitude, location.longitude),
                    currentTimestamp
                )

                Log.d("CAM", reportDto.toString())



                // todo: send http request with form data
            }
            .addOnFailureListener {
                Log.e("CAM", "nu avem locatie")
                // todo: show error message
            }
    }



    private fun validateFormFields(): Boolean {
        var hasErrors = false

        if (binding.spinner.selectedItemPosition >= categoryList.size-1 &&
            binding.editTextComments.text.isBlank()) {
            binding.editTextComments.error = getString(R.string.form_fragment_error_info)
            hasErrors = true
        }

        if (binding.editTextEmail.text.isBlank() && !binding.checkBox.isChecked) {
            binding.editTextEmail.error = getString(R.string.form_fragment_error_info)
            hasErrors = true
        }

        if (binding.editTextPhone.text.isBlank() && !binding.checkBox.isChecked) {
            binding.editTextPhone.error = getString(R.string.form_fragment_error_info)
            hasErrors = true
        }

        if (binding.editTextFirstName.text.isBlank() && !binding.checkBox.isChecked) {
            binding.editTextFirstName.error = getString(R.string.form_fragment_error_info)
            hasErrors = true
        }

        if (binding.editTextLastName.text.isBlank() && !binding.checkBox.isChecked) {
            binding.editTextLastName.error = getString(R.string.form_fragment_error_info)
            hasErrors = true
        }

        return hasErrors
    }

    private fun setStatusContactFormFields(status: Boolean) {
        binding.editTextEmail.isEnabled = status
        binding.editTextPhone.isEnabled = status
        binding.editTextFirstName.isEnabled = status
        binding.editTextLastName.isEnabled = status
    }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 11
        private val REQUIRED_PERMISSIONS =
            mutableListOf (
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ).toTypedArray()
    }
}