package vn.edu.tdc.demokotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class homefragment : Fragment() {
    private lateinit var imghaisan: ImageView
    private lateinit var imgbogavit: ImageView
    private lateinit var imgdouong: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.homefragment, container, false)

        // Initialize ImageViews
        imghaisan = view.findViewById(R.id.imageView4)
        imgbogavit = view.findViewById(R.id.imageView6)
        imgdouong = view.findViewById(R.id.imageView5)

        // Set OnClickListeners
//        imgdouong.setOnClickListener {
//            val douongFragment = dsdouong()
//            loadFragment(douongFragment)
//        }
//
//        imghaisan.setOnClickListener {
//            val haisanFragment = dshaisan()
//            loadFragment(haisanFragment)
//        }
//
//        imgbogavit.setOnClickListener {
//            val bogavitFragment = dsbogavit()
//            loadFragment(bogavitFragment)
//        }

        return view
    }

    private fun loadFragment(fragment: Fragment) {
        // Load the fragment into the container
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}