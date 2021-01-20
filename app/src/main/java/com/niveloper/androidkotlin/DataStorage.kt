package com.niveloper.androidkotlin

import android.widget.ImageView

class DataStorage {
    fun getListOfMovies(): Array<MovieData> =
        arrayOf(
            MovieData(
                "Avengers: End Game",
                1,
                R.drawable.orig,
                R.drawable.bg_fragment,
                13,
                "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
                false,
                4,
                "Action, Adventure, Fantasy",
                125,
                137,
                arrayOf(
                    ActorData("Robert Downey Jr.", 1, R.drawable.r_d_jr),
                    ActorData("Chris Evans", 2, R.drawable.movie_c_evans),
                    ActorData("Mark Ruffalo", 3, R.drawable.mark_rufallo),
                    ActorData("Chris Hemsworth", 4, R.drawable.c_hemsworth),
                )
            ),

            MovieData(
                "Ternet",
                2,
                R.drawable.ternet_movie,
                R.drawable.bg_fragment,
                16,
                "A secret agent embarks on a dangerous, time-bending mission to prevent the start of World War III.",
                true,
                5,
                "Action, Sci-Fi, Thriller",
                125,
                97,
                arrayOf(
                    ActorData("Robert Downey Jr.", 1, R.drawable.r_d_jr),
                    ActorData("Chris Evans", 2, R.drawable.movie_c_evans),
                    ActorData("Mark Ruffalo", 3, R.drawable.mark_rufallo),
                    ActorData("Chris Hemsworth", 4, R.drawable.c_hemsworth),
                )
            )
        )
}