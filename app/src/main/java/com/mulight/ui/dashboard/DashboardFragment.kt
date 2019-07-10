package com.mulight.ui.dashboard


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import com.mulight.R
import com.mulight.repo.DBRepository
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {
    private var viewModel: DashboardViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
    }

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

    override fun onResume() {
        super.onResume()
        getAllPhotos()
    }

    private fun getAllPhotos() {
        viewModel?.getAllPhotos()?.observe(this, Observer { images ->
            images.forEach {
                Log.d("img__" , it.toString())
            }
          //  img.setImageDrawable(Drawable.createFromPath(images[0].address));
        })
    }
}


