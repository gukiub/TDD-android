package gustavo.video_solution.playlist

import androidx.lifecycle.*
import kotlinx.coroutines.flow.onEach

class PlayListViewModel(
    private val repository: PlaylistRepository
): ViewModel() {

    val loader = MutableLiveData<Boolean>()

    val playlists = liveData {
        loader.postValue(true)

        emitSource(repository.getPlaylists()
            .onEach {
                loader.postValue(false)
            }
            .asLiveData())
    }
}
