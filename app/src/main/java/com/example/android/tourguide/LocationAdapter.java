package com.example.android.tourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by Matt on 7/12/2016.
 */
public class LocationAdapter extends ArrayAdapter<Location> {

    private int colorResId;

    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorResId) {
        super(context, 0, locations);
        this.colorResId = colorResId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location locations = getItem(position);
        View container = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResId);
        container.setBackgroundColor(color);

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(locations.getName());
        TextView subname = (TextView) listItemView.findViewById(R.id.subname);
        subname.setText(locations.getSubname());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        if(locations.hasImage()){
            image.setImageResource(locations.getImageResourceId());
        } else {
            image.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
