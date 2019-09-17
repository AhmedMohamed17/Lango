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


public class familyFragment extends Fragment {
    MediaPlayer mediaPlayer;
    private void releaseMediaPlayer(){ if (mediaPlayer != null) {
        mediaPlayer.reset();
        mediaPlayer = null;
    }}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "اب", R.drawable.family_father,R.raw.father));
        words.add(new Word("mother", "ام", R.drawable.family_mother,R.raw.mother));
        words.add(new Word("son", "ابن", R.drawable.family_son,R.raw.son));
        words.add(new Word("daughter", "ابنة", R.drawable.family_daughter,R.raw.daughter));
        words.add(new Word("older brother", "الاخ الاكبر", R.drawable.family_older_brother,R.raw.olderbrother));
        words.add(new Word("younger brother", "الاخ الاصغر", R.drawable.family_younger_brother,R.raw.youngerbrother));
        words.add(new Word("older sister", "الاخت الكبري", R.drawable.family_older_sister,R.raw.oldersister));
        words.add(new Word("younger sister", "الاخت الصغري", R.drawable.family_younger_sister,R.raw.youngersister));
        words.add(new Word("grandmother", "جدة", R.drawable.family_grandmother,R.raw.grandmother));
        words.add(new Word("grandfather", "جد", R.drawable.family_grandfather,R.raw.granfather));

        //LinearLayout rootView = findViewById(R.id.rootView);
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), words, R.color.category_family);
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
