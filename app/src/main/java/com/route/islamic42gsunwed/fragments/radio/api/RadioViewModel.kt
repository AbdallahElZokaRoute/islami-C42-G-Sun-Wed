package com.route.islamic42gsunwed.fragments.radio.api

import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch

class RadioViewModel : ViewModel() {

    var radiosList = MutableLiveData<List<RadiosItem>>()
    var mediaPlayer: MediaPlayer? = null
    val radioError = MutableLiveData("")
    val currentUrl = MutableLiveData<String?>()
    val valid = MutableLiveData(false)
    val mutedItems = MutableLiveData<MutableSet<String>>(mutableSetOf())
    var currentPage = 1
    val pageSize = 20

    fun loadRadio() {
        viewModelScope.launch {
            try {
                val response = ApiManager.getRadioService().getRadios(currentPage,pageSize)
                if (response.isSuccessful) {
                    val radio = response.body()?.radios ?: listOf()
                    radiosList.postValue(radio)
                    currentPage++
                } else {
                    val error = response.errorBody()?.string()
                    val gson = Gson()
                    val radioResponse = gson.fromJson(error, RadioResponse::class.java)
                    radioError.value = radioResponse.message ?: "Something Went Wrong"
                }
            } catch (e: Exception){
                radioError.value = e.message ?: "Something Went Wrong"
            }
        }
    }

    fun pausePlayRadio(url: String?) {
        if(url.isNullOrEmpty()){
            return
        }

        if(currentUrl.value == url){
            if(mediaPlayer?.isPlaying == true){
                mediaPlayer?.pause()
                valid.value = false
            }else{
                applyMute(url)
                mediaPlayer?.start()
                valid.value = true
            }
        } else{
            mediaPlayer?.reset()
            mediaPlayer = MediaPlayer().apply {
                setDataSource(url)
                prepareAsync()
                setOnPreparedListener {
                    val isMuted = mutedItems.value?.contains(url) == true
                    applyMute(url)
                    start()
                    if (isMuted) {
                        mediaPlayer?.setVolume(0f, 0f)
                    }
                    valid.postValue(true)
                    currentUrl.postValue(url)
                }
                setOnCompletionListener {
                    valid.postValue(false)
                    release()
                    mediaPlayer = null
                    currentUrl.postValue(null)
                }
            }
        }
    }

    fun pausePlayMute(url: String?) {
        if (url == null) return
        val currentMuted = mutedItems.value ?: mutableSetOf()
        if (currentMuted.contains(url)) {
            currentMuted.remove(url)
        } else {
            currentMuted.add(url)
        }
        mutedItems.value = currentMuted
        applyMute(url)
    }

    private fun applyMute(url: String?) {
        if (url == currentUrl.value) {
            val isMuted = mutedItems.value?.contains(url) == true
            mediaPlayer?.setVolume(
                if (isMuted) 0f else 1f,
                if (isMuted) 0f else 1f
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
