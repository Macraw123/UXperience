package com.example.cheat2;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class ListAdapter extends ArrayAdapter<ModelData> {

    private Context mContext;
    private ArrayList<ModelData> moviesList = new ArrayList<>();

    public ListAdapter(@NonNull Context context, ArrayList<ModelData> arrayList) {
        super(context, 0, arrayList);
        mContext = context;
        moviesList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        ModelData currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView numbersImage = currentItemView.findViewById(R.id.imageList);
        assert currentNumberPosition != null;
        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.text_headline);
        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = currentItemView.findViewById(R.id.text_subhead);


        numbersImage.setImageResource(currentNumberPosition.getIcon());
        textView1.setText(currentNumberPosition.getTitle());
        textView2.setText(currentNumberPosition.getDescription());

        // then return the recyclable view
        return currentItemView;
    }
}
