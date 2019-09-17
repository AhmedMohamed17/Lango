package com.example.android.lango;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colorFragment extends Fragment {


    private MediaPlayer mediaPlayer;
    private void releaseMediaPlayer(){ if (mediaPlayer != null) {
        mediaPlayer.reset();
        mediaPlayer = null;
    }}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_color, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red","احمر",R.drawable.color_red,R.raw.red));
        words.add(new Word("green","اخضر",R.drawable.color_green,R.raw.green));
        words.add(new Word("brown","بني",R.drawable.color_brown,R.raw.brown));
        words.add(new Word("gray","رمادي",R.drawable.color_gray,R.raw.gray));
        words.add(new Word("black","اسود",R.drawable.color_black,R.raw.black));
        words.add(new Word("white","ابيض",R.drawable.color_white,R.raw.white));
        words.add(new Word("yellow","اصفر",R.drawable.color_mustard_yellow,R.raw.yellow));
        words.add(new Word("light brown","كاكي",R.drawable.color_dusty_yellow,R.raw.khaki));
        //LinearLayout rootView = findViewById(R.id.rootView);
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words , R.color.category_colors );
        ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                mediaPlayer=MediaPlayer.create(getActivity(),words.get(i).getAudio());
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
