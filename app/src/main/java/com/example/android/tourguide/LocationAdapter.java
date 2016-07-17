package com.example.android.tourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
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

    static class ViewHolder {
        private View container;
        private TextView name;
        private TextView subname;
        private ImageView image;
    }

    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorResId) {
        super(context, 0, locations);
        this.colorResId = colorResId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.container = listItemView.findViewById(R.id.text_container);
            int color = ContextCompat.getColor(getContext(), colorResId);
            holder.container.setBackgroundColor(color);
            holder.name = (TextView) listItemView.findViewById(R.id.name);
            holder.subname = (TextView) listItemView.findViewById(R.id.subname);
            holder.image = (ImageView) listItemView.findViewById(R.id.image);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Location locations = getItem(position);
        holder.name.setText(locations.getName());
        holder.subname.setText(locations.getSubname());
        if(locations.hasImage()){
            holder.image.setImageResource(locations.getImageResourceId());
        } else {
            holder.image.setVisibility(View.GONE);
        }

        return listItemView;
    }

}
