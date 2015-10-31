package com.lemuelinchrist.android.hymns.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lemuelinchrist.android.hymns.history.HistoryRecord;


/**
 * Created by lemuelcantos on 31/10/15.
 */
public abstract class SearchAdapter extends RecyclerView.Adapter<IndexViewHolder> {

    protected final Context context;
    protected final int layout;

    public SearchAdapter(Context context, int layout) {
        this.context=context;
        this.layout=layout;

    }

    @Override
    public IndexViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout, viewGroup, false);


        IndexViewHolder vh = new IndexViewHolder(rowView);
        return vh;
    }

    @Override
    public void onBindViewHolder(final IndexViewHolder holder, int position) {

        provisionHolder(holder,position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent data = new Intent();
                data.setData(Uri.parse(holder.hymnNo));
                Activity currentActivity = (Activity) context;
                currentActivity.setResult(currentActivity.RESULT_OK, data);
                currentActivity.finish();
            }
        });


    }

    protected abstract void provisionHolder(IndexViewHolder holder, int position);


}
