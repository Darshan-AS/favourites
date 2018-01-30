package com.example.android.favourites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Darshan AS on 13-12-2017.
 */

public class TvShowsFragment extends Fragment {

    public TvShowsFragment () {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        final ArrayList<Item> tvShows = new ArrayList<>();

        tvShows.add(new Item("Sherlock", "Dr. Watson, a former army doctor, finds himself sharing a flat with Sherlock Holmes, an eccentric individual with a knack for solving crimes. Together, they take on the most unusual cases.", R.drawable.sherlock, "https://www.youtube.com/watch?v=Nj7ZSUkTTVI"));
        tvShows.add(new Item("Death Note", "The story follows Light Yagami, a high school student who discovers a supernatural notebook from a Shinigami named Ryuk that grants its user the ability to kill anyone whose name and face he knows. The series centers around Light's attempts to create and rule a world \"cleansed of evil\" as \"God\" using the notebook, and the efforts of a detective known as L to stop him.", R.drawable.death_note, "https://www.youtube.com/watch?v=Amag3NrjBc0"));
        tvShows.add(new Item("The Big Bang Theory", "The lives of socially awkward physicists Leonard Hofstadter and Sheldon Cooper take a wild turn when the beautiful and free-spirited Penny moves in next door.", R.drawable.the_big_bang_theory, "https://www.youtube.com/watch?v=WBb3fojgW0Q"));
        tvShows.add(new Item("Code Geass", "The Holy Empire of Britannia conquered the country known as Japan and now call it Area 11. Its residents lost their rights to self-govern and are now called Elevens. The Empire uses powerfully destructive robotic weapons called Knightmares to ensure control, but someone is about to stand up against it. Lelouch, the black prince, has endless ambition and uses the power of the Geass to build a world based on his ideals. Suzaku Kururugi, the white knight, aspires to justice and strives to live an honest and fair life.", R.drawable.code_geass, "https://www.youtube.com/watch?v=8ShufKkeKoQ"));
        tvShows.add(new Item("F.R.I.E.N.D.S", "Take a look at some of the best episodes of 'Friends', the story of six friends living in Manhattan, who experience comfort and companionship with each other as they indulge in many adventures.", R.drawable.friends, "https://www.youtube.com/watch?v=ekYGfU0XIx0"));
        tvShows.add(new Item("The Flash", "Barry Allen, a forensic scientist with the Central City police force, is struck by lightning in a freak accident. When he wakes up after nine months, he discovers that he can achieve great speeds.", R.drawable.the_flash, "https://www.youtube.com/watch?v=Yj0l7iGKh8g"));

        ItemAdapter adapter = new ItemAdapter(getContext(), tvShows);

        ListView listView = rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        return rootView;

    }
}
