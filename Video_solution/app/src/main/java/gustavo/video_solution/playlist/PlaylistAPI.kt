package gustavo.video_solution.playlist

import retrofit2.http.GET

interface PlaylistAPI {
    @GET("playlists")
    suspend fun fetchAllPlaylists() : List<Playlist>

}
