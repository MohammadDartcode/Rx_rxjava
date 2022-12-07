package com.example.rxjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjava.R;
import com.example.rxjava.model.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    Context context;
    List<Post> data;

    public PostAdapter(Context context, List<Post> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_posts , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //Post post = data.get(position);

        Picasso.get().load(data.get(position).getLink_img_proflie()).into(holder.img_profile);
        Picasso.get().load(data.get(position).getLink_img_post()).into(holder.img_post);

        holder.name.setText(data.get(position).getName());
        holder.txt_comment.setText(data.get(position).getComments());
        holder.description.setText(data.get(position).getDescription());
        holder.txt_location.setText(data.get(position).getLocation());
        holder.txt_favorite.setText(data.get(position).getFavorite());

    }

    @Override
    public int getItemCount() {
        return data.size() ;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {


        TextView name , description , txt_location , txt_favorite , txt_comment ;
        CircleImageView img_profile;
        ImageView img_post;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            txt_location = itemView.findViewById(R.id.txt_location);
            txt_favorite = itemView.findViewById(R.id.txt_favorite);
            txt_comment = itemView.findViewById(R.id.txt_comment);
            img_post = itemView.findViewById(R.id.img_post);
            img_profile = itemView.findViewById(R.id.img_profile);

        }
    }
}

