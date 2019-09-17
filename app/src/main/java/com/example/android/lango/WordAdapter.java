package com.example.android.lango;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int colorID;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);

        this.colorID = colorID;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null, false);
        }

        Word currentWord = getItem(position);
        TextView EnglishTextView = (TextView) listItemView.findViewById(R.id.english_textView);
        EnglishTextView.setText(currentWord.getEnglishTranslation());
        TextView DefaultTextView = (TextView) listItemView.findViewById(R.id.default_textView);
        DefaultTextView.setText(currentWord.getDefaultTranslation());
        ImageView image = (ImageView) listItemView.findViewById(R.id.img);
        if (currentWord.getImageID() == 0)
        {
            image.setVisibility(View.GONE);
        }
        else {
            image.setImageResource(currentWord.getImageID());
        }
        View text = listItemView.findViewById(R.id.textContainer);
        int x = ContextCompat.getColor(getContext(), colorID);
        text.setBackgroundColor(x);
        return listItemView;
    }

}
