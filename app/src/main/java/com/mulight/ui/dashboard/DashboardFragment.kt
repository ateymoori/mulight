package com.mulight.ui.dashboard


import android.Manifest
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.mulight.R
import com.mulight.ui.container.ContainerActivity
import com.mulight.utils.bases.permissionGranted
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        take.setOnClickListener {
            findNavController(it).navigate(R.id.action_dashboardFragment_to_takePhotoFragment)
        }
    }


}


