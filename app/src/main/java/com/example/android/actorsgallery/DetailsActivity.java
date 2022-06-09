package com.example.android.actorsgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    public static final String NAME_TAG = "NAME_TAG";
    public static final String DESC_TAG = "DESC_TAG";
    public static final String PHOTO_TAG = "PHOTO_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString(NAME_TAG);
        String desc = bundle.getString(DESC_TAG);
        Uri photo = (Uri) bundle.get(PHOTO_TAG);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView descView = findViewById(R.id.tv_desc);
        ImageView photoView = findViewById(R.id.img_bigphoto);
        descView.setText(desc);
        Glide.with(this).load(photo).into(photoView);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}