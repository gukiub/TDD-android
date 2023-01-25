package gustavo.video_solution

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayListViewModel(
    private val repository: PlaylistRepository
): ViewModel() {
    val playlists = MutableLiveData<Result<List<Playlist>>>()

    init {
        repository.getPlaylists()
    }
}
