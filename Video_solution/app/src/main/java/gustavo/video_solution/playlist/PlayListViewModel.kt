package gustavo.video_solution.playlist

import androidx.lifecycle.*

class PlayListViewModel(
    private val repository: PlaylistRepository
): ViewModel() {

    val loader = MutableLiveData<Boolean>()

    val playlists = liveData {
        loader.postValue(true)

        emitSource(repository.getPlaylists().asLiveData())
    }
}
