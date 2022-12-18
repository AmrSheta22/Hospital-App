package com.example.mobiledevproj;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class writtenmedslist extends ArrayAdapter<writtenmeds> {
private Activity context;
private List<writtenmeds> medsList;

    public writtenmedslist(Activity context, List<writtenmeds>medsList) {
        super(context, R.layout.list_layout, medsList);
        this.context = context;
        this.medsList = medsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);

        TextView textViewName = listViewItem.findViewById(R.id.billitem1);
        TextView textViewprice = listViewItem.findViewById(R.id.price1);

        writtenmeds writtenmed = medsList.get(position);

        textViewName.setText(writtenmed.getMedName());
        //textViewprice.setText(writtenmed.getMedPrice());


        return listViewItem;
    }
}
