package com.example.android.favourites;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Darshan AS on 13-12-2017.
 */

public class MusicFragment extends Fragment {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private ListView listView;

    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.setVolume(0.1f, 0.1f);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.setVolume(1.0f, 1.0f);
                mediaPlayer.start();
            }

        }
    };
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Item> songs = new ArrayList<>();

        songs.add(new Item("Let Me Love You", R.drawable.let_me_love_you, R.raw.let_me_love_you, "https://www.youtube.com/watch?v=euCqAq6BRa4"));
        songs.add(new Item("Something Just Like This", R.drawable.something_just_like_this, R.raw.something_just_like_this, "https://www.youtube.com/watch?v=FM7MFYoylVs"));
        songs.add(new Item("Carnival of Rust", R.drawable.carnival_of_rust, R.raw.carnival_of_rust, "https://www.youtube.com/watch?v=MKk1u5RMTn4"));
        songs.add(new Item("Heathens", R.drawable.heathens, R.raw.heathens, "https://www.youtube.com/watch?v=UprcpdwuwCg"));


        final ItemAdapter adapter = new ItemAdapter(getContext(), songs);

        listView = rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Item song = songs.get(position - listView.getHeaderViewsCount());

                int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer = MediaPlayer.create(getContext(), song.getAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletionListener);

                    if (listView.getHeaderViewsCount() == 0)
                        showMusicControl(container);
                }
            }
        });

        return rootView;
    }

    private void showMusicControl(ViewGroup container) {
        View musicControl = LayoutInflater.from(getContext()).inflate(R.layout.music_control, container , false);
        listView.addHeaderView(musicControl);

        ImageButton pause = musicControl.findViewById(R.id.pause);
        ImageButton play = musicControl.findViewById(R.id.play);

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
    }
}
