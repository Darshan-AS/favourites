package com.example.android.favourites;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Darshan AS on 13-12-2017.
 */

public class MoviesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        final ArrayList<Item> movies = new ArrayList<>();

        movies.add(new Item("Batman Begins", "After witnessing his parents' death, Bruce learns the art of fighting to confront injustice. When he returns to Gotham as Batman, he must stop a secret society that intends to destroy the city.", R.drawable.batman_begins, "https://www.youtube.com/watch?v=4UkZ_KmOr1c"));
        movies.add(new Item("The Dark Knight", "After Gordon, Dent and Batman begin an assault on Gotham's organised crime, the mobs hire the Joker, a psychopathic criminal mastermind, who wants to bring all the heroes down to his level.", R.drawable.the_dark_knight, "https://www.youtube.com/watch?v=kmJLuwP3MbY"));
        movies.add(new Item("The Dark Knight Rises", "Bane, an imposing terrorist, attacks Gotham City and disrupts its eight-year-long period of peace. This forces Bruce Wayne to come out of hiding and don the cape and cowl of Batman again.", R.drawable.the_dark_knight_rises, "https://www.youtube.com/watch?v=GokKUqLcvD8"));
        movies.add(new Item("Predestination", "An agent is tasked to travel back in time to prevent a bomb attack in New York in 1975.", R.drawable.predestination, "https://www.youtube.com/watch?v=-FcK_UiVV40"));
        movies.add(new Item("Interstellar", "In the future, Earth is slowly becoming uninhabitable. Ex-NASA pilot Cooper, along with a team of researchers, is sent on a planet exploration mission to report which planet can sustain life.", R.drawable.interstellar, "https://www.youtube.com/watch?v=egkvnEYewMs"));
        movies.add(new Item("Tommorowland", "Frank, a former inventor, and Casey, a curious teenager, embark on a dangerous mission to unravel the secrets of Tomorrowland, an unexplored dimension in time and space.", R.drawable.tommorowland, "https://www.youtube.com/watch?v=aDfUQVsQHW4"));

        ItemAdapter adapter = new ItemAdapter(getContext(), movies);

        ListView listView = rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        return rootView;
    }
}
