package com.example.android.actorsgallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ViewHolder> {
    private List<Actor> actors;
    private Context context;
    private LayoutInflater inflater;
    private OnActorClickListener listener;

    public interface OnActorClickListener {
        void onActorClick(Actor actor, int position);
    }

    public ActorAdapter(Context context, List<Actor> actors, OnActorClickListener listener) {
        this.actors = actors;
        this.context = context;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ActorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Actor actor = actors.get(position);
        Glide.with(context).load(actor.getThumbnail()).into(holder.pictureView);
        holder.itemView.setOnClickListener(v -> listener.onActorClick(actor, position));
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView pictureView;

        ViewHolder(View view) {
            super(view);
            pictureView = view.findViewById(R.id.img_photo);
        }
    }
}
