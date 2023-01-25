package gustavo.video_solution.playlist

import androidx.lifecycle.*

class PlayListViewModel(
    private val repository: PlaylistRepository
): ViewModel() {
    val playlists = liveData {
        emitSource(repository.getPlaylists().asLiveData())
    }
}
