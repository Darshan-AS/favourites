package com.example.android.favourites;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Darshan AS on 13-12-2017.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, @NonNull ArrayList<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);

        final Item currentItem = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentItem.getImageResourceId());

        TextView title = listItemView.findViewById(R.id.title);
        title.setText(currentItem.getTitle());

        TextView description = listItemView.findViewById(R.id.storyline);
        if (currentItem.getInfo() != null) {
            description.setText(currentItem.getInfo());
        } else {
            description.setVisibility(View.GONE);
            title.setHeight(dpToPx(160));
        }

        ImageView play = listItemView.findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = currentItem.getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                if (intent.resolveActivity(getContext().getPackageManager()) != null)
                    getContext().startActivity(intent);
            }
        });

        return listItemView;
    }

    private int dpToPx(int dp) {
        float density = getContext().getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }
}
