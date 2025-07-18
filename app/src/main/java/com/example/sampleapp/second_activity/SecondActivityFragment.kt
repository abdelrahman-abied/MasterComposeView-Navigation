package com.example.sampleapp.second_activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.example.sampleapp.databinding.ActivityFragmentSecondBinding
import com.example.sampleapp.third_activity.MainActivityCompose

/**
 * A simple [androidx.fragment.app.Fragment] subclass as the second destination in the navigation.
 */
class SecondActivityFragment : Fragment() {

    private var _binding: ActivityFragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ActivityFragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMoveToCompose.apply {

            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                Button(onClick = {
                    val intent = Intent(requireContext(), MainActivityCompose::class.java)
                    startActivity(intent)
                }) {
                    Text(text = "Move to Compose")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}