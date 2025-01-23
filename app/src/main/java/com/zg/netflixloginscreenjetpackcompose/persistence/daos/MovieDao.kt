package com.zg.netflixloginscreenjetpackcompose.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE continueWatching = 1")
    fun getMoviesForContinueWatching() : Flow<List<Movie>>

    @Query("SELECT * FROM movies WHERE id = :movieId LIMIT 1")
    fun observeSingleMovie(movieId : Int) : Flow<Movie?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>) : List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSingleMovie(movie: Movie)

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()
}