package com.blogspot.shudiptotrafder.androidaio.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blogspot.shudiptotrafder.androidaio.R;

import java.util.ArrayList;

/**
 * AndroidAIO
 * com.blogspot.shudiptotrafder.androidaio.main
 * Created by Shudipto Trafder on 1/2/2017 at 10:22 PM.
 * Don't modify without permission of Shudipto Trafder
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    //Array list
    private ArrayList<SubjectList> objects;
    //context
    private Context context;

    //click listener
    private ItemClickListener clickListener;


    //interface
    public interface ItemClickListener{
        void itemClick(int id);
    }

    //view holder class
    class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;

        private MainViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.main_card_tv);

            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.itemClick(getAdapterPosition());
        }
    }

    //constructor
    public MainAdapter(ArrayList<SubjectList> objects, Context context,
                       ItemClickListener clickListener) {
        this.objects = objects;
        this.context = context;
        this.clickListener = clickListener;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_card_view, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, int position) {

        final SubjectList list = objects.get(position);

        final String string = list.getSubName();

        holder.textView.setText(string);

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

}
