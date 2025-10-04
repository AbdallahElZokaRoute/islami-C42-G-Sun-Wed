package com.route.islamic42gsunwed.fragments.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.route.islamic42gsunwed.databinding.FragmentRadioBinding
import com.route.islamic42gsunwed.fragments.radio.api.RadioViewModel

class RadioFragment : Fragment() {
    private lateinit var binding: FragmentRadioBinding
    private lateinit var adapter: RadioAdapter
    val viewModel: RadioViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RadioAdapter(
            mutableListOf(),
            onPlayClick = { radio, _ ->
                viewModel.pausePlayRadio(radio.url)
                },
            onMuteClick = { radio, _ ->
                viewModel.pausePlayMute(radio.url)
            }
        )
        binding.radioRecyclerView.adapter = adapter
        viewModel.radiosList.observe(viewLifecycleOwner) { radios ->
            adapter.setNewList(radios)
        }
        viewModel.currentUrl.observe(viewLifecycleOwner) { url ->
            val playing = viewModel.valid.value == true
            adapter.updatePlayState(url, playing)
        }
        viewModel.valid.observe(viewLifecycleOwner) { playing ->
            val url = viewModel.currentUrl.value
            adapter.updatePlayState(url, playing)
        }
        viewModel.mutedItems.observe(viewLifecycleOwner) { mutedSet ->
            adapter.updateAllMuteStates(mutedSet)
        }
        viewModel.radioError.observe(viewLifecycleOwner) { msg ->
            if (!msg.isNullOrEmpty()) {
                Toast.makeText(requireContext(),"The server is currently unavailable", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.loadRadio()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.mediaPlayer?.stop()
        viewModel.mediaPlayer?.release()
        viewModel.mediaPlayer = null
    }
}