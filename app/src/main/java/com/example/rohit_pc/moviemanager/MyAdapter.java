package com.example.rohit_pc.moviemanager;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.io.Serializable;
import java.util.List;




public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {
List<com.example.rohit_pc.moviemanager.Movie> data;
Context context;
    private List<Movie> movies;
public MyAdapter(Context context, List<com.example.rohit_pc.moviemanager.Movie> data){
    this.data=data;
    this.context= context;
}



    @Override
    public MyAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.my_card_view,parent,false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapterViewHolder holder, int position) {
        com.example.rohit_pc.moviemanager.Movie movie= data.get(position);
        holder.textTitle.setText(movie.getTitle());
        holder.Last_Name.setText(movie.getOverview());
        Picasso.get().load(movie.getPosterPath()).into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Context getContext() {
        return context;
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
    ImageView imgIcon;
    TextView textTitle;
    TextView Last_Name;

        public MyAdapterViewHolder(View itemview){
            super(itemview);
            imgIcon=(ImageView) itemview.findViewById(R.id.imgIcon);
            textTitle=(TextView) itemview.findViewById(R.id.textTitle);
            Last_Name=(TextView)itemview.findViewById(R.id.Last_Name);
            itemview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            try {
                Intent in = new Intent(getContext(), ScrollingActivity.class);
                in.putExtra("Overview",Last_Name.getText().toString());
                in.putExtra("Title",textTitle.getText().toString());
                getContext().startActivity(in);
            }
            catch (Exception e){
                e.getMessage();
            }

        }
    }
}


