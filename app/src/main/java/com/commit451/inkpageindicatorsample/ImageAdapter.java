package com.commit451.inkpageindicatorsample;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Simple PagerAdapter that shows images
 */
public class ImageAdapter extends PagerAdapter {

    private List<String> data = new ArrayList<>();

    ImageAdapter(Collection<String> images) {
        setData(images);
    }

    public void setData(Collection<String> data) {
        if (data != null && !data.isEmpty()) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        View v = LayoutInflater.from(collection.getContext()).inflate(R.layout.item_image, collection, false);
        ImageView imageView = v.findViewById(R.id.imageView);
        Glide.with(collection.getContext())
                .load(data.get(position))
                .into(imageView);

        collection.addView(v, 0);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    public void add(String image) {
        this.data.add(image);
        notifyDataSetChanged();
    }

    public void removeLast() {
        if (!data.isEmpty()) {
            int index = data.size() - 1;
            data.remove(index);
            notifyDataSetChanged();
        }
    }
}