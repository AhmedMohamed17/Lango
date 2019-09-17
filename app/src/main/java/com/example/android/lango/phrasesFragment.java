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


public class phrasesFragment extends Fragment {
    private MediaPlayer mediaPlayer;

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer = null;
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        final ArrayList<Word> words = new ArrayList<Word>();

        //LinearLayout rootView = findViewById(R.id.rootView);
        words.add(new Word(R.raw.wherego, "Where are you going?", "إلى أين تذهب؟"));
        words.add(new Word(R.raw.whatname, "What is your name?", "ما اسمك؟"));
        words.add(new Word(R.raw.myname, "My name is...", "اسمي هو..."));
        words.add(new Word(R.raw.howfeel, "How are you feeling?", "كيف تشعر؟"));
        words.add(new Word(R.raw.fellgood, "I’m feeling good.", "أشعر أنني بحالة جيدة."));
        words.add(new Word(R.raw.rcoming, "Are you coming?", "هل انت قادم؟"));
        words.add(new Word(R.raw.yeacomming, "Yes, I’m coming.", "نعم ، أنا قادم."));
        words.add(new Word(R.raw.imcoming, "I’m coming.", "أنا قادم."));
        words.add(new Word(R.raw.ltsgo, "Let’s go.", "لنذهب."));
        words.add(new Word(R.raw.comeehere, "Come here.", "تعال الى هنا."));

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_phrases);
        ListView listView = (ListView)view. findViewById(R.id.list);
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
