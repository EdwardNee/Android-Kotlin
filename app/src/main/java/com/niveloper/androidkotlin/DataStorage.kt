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
                98,
                97,
                arrayOf(
                    ActorData("Robert Downey Jr.", 1, R.drawable.r_d_jr),
                    ActorData("Chris Evans", 2, R.drawable.movie_c_evans),
                    ActorData("Mark Ruffalo", 3, R.drawable.mark_rufallo),
                    ActorData("Chris Hemsworth", 4, R.drawable.c_hemsworth),
                )
            ),

            MovieData(
                "Black Window",
                3,
                R.drawable.bwindow_movie,
                R.drawable.bg_fragment,
                13,
                "At birth the Black Widow (aka Natasha Romanova) is given to the KGB, which grooms her to become its ultimate operative. When the U.S.S.R. breaks up, the government tries to kill her as the action moves to present-day New York, where she is a freelance operative.",
                false,
                4,
                "Action, Adventure, Sci-Fi",
                38,
                102,
                arrayOf(
                    ActorData("Robert Downey Jr.", 1, R.drawable.r_d_jr),
                    ActorData("Chris Evans", 2, R.drawable.movie_c_evans),
                    ActorData("Mark Ruffalo", 3, R.drawable.mark_rufallo),
                    ActorData("Chris Hemsworth", 4, R.drawable.c_hemsworth),
                )
            ),

            MovieData(
                "Wonder Woman 1984",
                4,
                R.drawable.wwoman_movie,
                R.drawable.bg_fragment,
                13,
                "A secret agent embarks on a dangerous, time-bending mission to prevent the start of World War III.",
                false,
                5,
                "Action, Adventure, Fantasy",
                74,
                120,
                arrayOf(
                    ActorData("Robert Downey Jr.", 1, R.drawable.r_d_jr),
                    ActorData("Chris Evans", 2, R.drawable.movie_c_evans),
                    ActorData("Mark Ruffalo", 3, R.drawable.mark_rufallo),
                    ActorData("Chris Hemsworth", 4, R.drawable.c_hemsworth),
                )
            )
        )
}