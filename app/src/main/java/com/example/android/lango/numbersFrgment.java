package com.example.android.lango;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class numbersFrgment extends Fragment {
    private MediaPlayer mediaPlayer;

    private void releaseMediaPlayer(){ if (mediaPlayer != null) {
        mediaPlayer.reset();
        mediaPlayer = null;


    }}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_color,container,false);



        final ArrayList<Word> words =new ArrayList<>();
        words.add(new Word("one", "واحد", R.drawable.number_one, R.raw.one));
        words.add(new Word("two", "اثنان", R.drawable.number_two, R.raw.two));
        words.add(new Word("three", "ثلاثة", R.drawable.number_three, R.raw.three));
        words.add(new Word("four", "اربعة", R.drawable.number_four, R.raw.four));
        words.add(new Word("five", "خمسة", R.drawable.number_five, R.raw.five));
        words.add(new Word("six", "ستة", R.drawable.number_six, R.raw.six));
        words.add(new Word("seven", "سبعة", R.drawable.number_seven, R.raw.seven));
        words.add(new Word("eight", "ثمانية", R.drawable.number_eight, R.raw.eight));
        words.add(new Word("nine", "تسعة", R.drawable.number_nine, R.raw.nine));
        words.add(new Word("ten", "عشرة", R.drawable.number_ten, R.raw.ten));

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
        ListView listView =  view.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(getActivity(), words.get(i).getAudio());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();

                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();


    }
}
