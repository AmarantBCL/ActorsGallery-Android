package com.example.android.actorsgallery;

import static com.example.android.actorsgallery.DetailsActivity.DESC_TAG;
import static com.example.android.actorsgallery.DetailsActivity.NAME_TAG;
import static com.example.android.actorsgallery.DetailsActivity.PHOTO_TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ActorAdapter adapter = new ActorAdapter(this, DataUtils.generateActors(), (actor, i) -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra(NAME_TAG, actor.getName());
            intent.putExtra(DESC_TAG, actor.getDesc());
            intent.putExtra(PHOTO_TAG, actor.getThumbnail());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        }
        CustomItemDecoration decorator = new CustomItemDecoration(4);
        recyclerView.addItemDecoration(decorator);

    }
}