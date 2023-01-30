package gustavo.video_solution.playlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import gustavo.video_solution.R
import kotlinx.android.synthetic.main.fragment_playlist.*
import kotlinx.android.synthetic.main.fragment_playlist.view.*
import javax.inject.Inject

@AndroidEntryPoint
class PlaylistFragment : Fragment() {

    lateinit var viewModel: PlayListViewModel

    @Inject
    lateinit var viewModelFactory: PlaylistViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)

        setupViewModel()

        viewModel.loader.observe(viewLifecycleOwner) { loading ->
            when(loading) {
                true -> loader.visibility = View.VISIBLE
            }
        }

        viewModel.playlists.observe(viewLifecycleOwner) { playlists ->
            if(playlists.getOrNull() != null) {
                setupList(view.playlists_list, playlists.getOrNull()!!)
            } else {
                setupList(view.playlists_list, mockJsonIfHasNoData())
            }
        }

        return view
    }

    private fun mockJsonIfHasNoData(): List<Playlist> {
        return listOf(
            Playlist("1","Hard Rock Café","rock",0),
            Playlist("2","Chilled House","house",0),
            Playlist("3","US TOP 40 HITS","mixed",0),
            Playlist("4","90's Rock","rock",0),
            Playlist("5","Purple Jazz","jazz",0),
            Playlist("6","90's flashback","pop",0),
            Playlist("7","Machine Funk","electro",0),
            Playlist("8","Let's Groove","mixed",0),
            Playlist("9","Feel The Beat","electro",0),
            Playlist("10","Best Songs 2020","mixed",0),
        )
    }

    private fun setupList(
        view: View?,
        playlists: List<Playlist>
    ) {
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)

            adapter = MyPlaylistRecyclerViewAdapter(playlists)
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[PlayListViewModel::class.java]
    }

    companion object {
        @JvmStatic
        fun newInstance() = PlaylistFragment().apply {}
    }
}