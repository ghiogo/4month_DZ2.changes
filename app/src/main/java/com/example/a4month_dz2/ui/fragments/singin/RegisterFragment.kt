package com.example.a4month_dz2.ui.fragments.singin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.a4month_dz2.R
import com.example.a4month_dz2.databinding.FragmentRegisterBinding
import com.example.a4month_dz2.utils.PreferenceHelper
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//class RegisterFragment : Fragment() {

//    private lateinit var binding: FragmentRegisterBinding
//    private var auth: FirebaseAuth = Firebase.auth
//
//    private var storedVerificationId: String? = ""
//    private var code: String? = ""
//    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding= FragmentRegisterBinding.inflate(inflater, container, false)
//        auth = Firebase.auth
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupListener()
//        init()
//        registration()
//    }
//
//    private fun registration() {
//        PreferenceHelper.singIn = true
//    }
//
//    private fun init() {
//        PreferenceHelper.unit(requireContext())
//    }
//
//    private fun setupListener() = with(binding) {
//        btnNumber.setOnClickListener {
//            if (etNumber.text.isEmpty()) {
//                if(btnNumber.text.isEmpty()){
//                    etNumber.error = "Заполните поле"
//                }
//            } else {
//                startPhoneNumberVerification(etNumber.text.toString())
//            }
//            btnCode.isVisible = true
//        }
//        btnCode.setOnClickListener {
//            if (etKod.text.isEmpty() || etNumber.text.isEmpty()) {
//                if (etKod.text.isEmpty()){
//                    etKod.error = "Заполните поле"
//                    if (etNumber.text.isEmpty()){
//                        etNumber.error = "Заполните поле"
//                    }
//                }
//            } else {
//                verifyPhoneNumberWithCode(storedVerificationId.toString(),
//                    etNumber.text.toString())
//            }
//
//        }
//    }
//
//    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
//        auth?.signInWithCredential(credential)
//            ?.addOnCompleteListener(requireActivity()) { task ->
//                if (task.isSuccessful) {
//                   // findNavController().navigate(R.id.action_registerFragment_to_noteAppFragment)
//                } else {
//                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
//                        Toast.makeText(requireContext(), "Registration is not", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//                }
//            }
//    }
//
//    private fun verifyPhoneNumberWithCode(verificationId: String, code: String) {
//        val credential = PhoneAuthProvider.getCredential(verificationId, code)
//        signInWithPhoneAuthCredential(credential)
//    }
//
//    private fun startPhoneNumberVerification(phoneNumber: String) {
//        val options = PhoneAuthOptions.newBuilder(auth!!)
//            .setPhoneNumber(phoneNumber)     //Phone number to verify
//            .setTimeout(60L, java.util.concurrent.TimeUnit.SECONDS)   //Timeout unit
//            .setActivity(requireActivity())      //Activity (for callback binding)
//            .setCallbacks(callback)       //OnVerificationStateChangedCallbacks
//            .build()
//        PhoneAuthProvider.verifyPhoneNumber(options)
//    }
//    private var callback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
//            signInWithPhoneAuthCredential(credential)
//        }
//
//        override fun onVerificationFailed(p0: FirebaseException) {
//            Log.e("tag", "error")
//        }
//
//        override fun onCodeSent(
//            verificationId: String,
//            token: PhoneAuthProvider.ForceResendingToken,
//        ) {
//            storedVerificationId = verificationId
//            resendToken = token
//        }
//    }
//}