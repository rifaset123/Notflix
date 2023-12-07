package com.example.uaspraktikummobile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.uaspraktikummobile.databinding.ActivitySignInBinding
import com.example.uaspraktikummobile.databinding.FragmentSignInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bindFragmentSignIn: FragmentSignInBinding
    private val db = FirebaseFirestore.getInstance()
    private lateinit var UsernameEdit: TextInputEditText
    private lateinit var PasswordEdit: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindFragmentSignIn = FragmentSignInBinding.inflate(inflater, container, false)
        return bindFragmentSignIn.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEdit = bindFragmentSignIn.EditUsernameSignIn
        val passwordEdit = bindFragmentSignIn.EditPasswordSignIn

        bindFragmentSignIn.ButtonSignIn.setOnClickListener() {
            val usr = usernameEdit.text.toString()
            val pw = passwordEdit.text.toString()

            if (usr.isEmpty() || pw.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                // Assume "users" is the collection in your Firestore database
                db.collection("users")
                    .whereEqualTo("username", usr)
                    .whereEqualTo("password", pw)
                    .get()
                    .addOnSuccessListener { task ->
                        if (!task.isEmpty) {
                            // User exists and password matches
                            val intentAdmin = Intent(requireContext(), MainActivityAdmin::class.java)
                            startActivity(intentAdmin)
                            Toast.makeText(requireContext(), "Sign In Successfully.", Toast.LENGTH_SHORT).show()
                            requireActivity().finish()
                        } else {
                            // User does not exist or password doesn't match
                            Toast.makeText(requireContext(), "Sign In Failed, Password doesn't match in our system", Toast.LENGTH_SHORT).show()
                        }
                    }.addOnFailureListener {
                        // Handle failure
                        Toast.makeText(requireContext(), "Error accessing the database", Toast.LENGTH_SHORT).show()
                    }
            }
        }
        bindFragmentSignIn.txtSignUp.setOnClickListener {
            // Assuming viewPager is your ViewPager instance
            val viewPager = requireActivity().findViewById<ViewPager>(R.id.viewPagerLogin)

            // Assuming signUpTabIndex is the index of your SignUp tab in the ViewPager
            val signUpTabIndex = 1 // Change this to the correct index

            viewPager.currentItem = signUpTabIndex
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}