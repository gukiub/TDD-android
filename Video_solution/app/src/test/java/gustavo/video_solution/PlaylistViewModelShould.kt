package gustavo.video_solution

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.br.gustavo.outsideintdd.utils.MainCoroutineScopeRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify

import org.junit.Rule
import org.junit.Test
import petros.efthymiou.groovy.utils.getValueForTest

class PlaylistViewModelShould {

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository: PlaylistRepository = mock()
    private val viewModel: PlayListViewModel = PlayListViewModel(repository)

    @Test
    fun getPlaylistsFromRepository() {
        viewModel.playlists.getValueForTest()

        verify(repository, times(1)).getPlaylists()
    }
}