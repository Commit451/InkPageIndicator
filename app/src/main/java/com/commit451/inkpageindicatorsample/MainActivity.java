package com.commit451.inkpageindicatorsample;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.commit451.inkpageindicator.InkPageIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "https://orig05.deviantart.net/af34/f/2014/316/c/4/material_wallpaper_set_two_4_by_rafly_nxs-d865g0t.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.image_view_pager);
        ArrayList<String> images = new ArrayList<>();
        images.add(IMAGE_URL);
        images.add("https://static1.squarespace.com/static/51609147e4b0715db61d32b6/521b97cee4b05f031fd12dde/5519e33de4b06a1002802805/1431718693701/?format=1500w");
        images.add("https://phandroid.s3.amazonaws.com/wp-content/uploads/2014/12/Ultimate-Material-Lollipop-Collection-407.png");
        final ImageAdapter adapter = new ImageAdapter(images);
        viewPager.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_remove:
                        adapter.removeLast();
                        return true;
                    case R.id.action_add:
                        adapter.add(IMAGE_URL);
                        return true;
                }
                return false;
            }
        });


        InkPageIndicator inkPageIndicator = findViewById(R.id.ink_pager_indicator);
        inkPageIndicator.setViewPager(viewPager);
    }
}
