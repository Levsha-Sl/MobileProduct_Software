package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.ViewHolder> {

    // final - запрет на изменение
    private List<DummyContent.DummyItem> items;

    //объявил элемент?
    RViewAdapter(List<DummyContent.DummyItem> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.idView.setText(items.get(position).id);
        holder.contentView.setText(items.get(position).content);
        holder.itemView.setTag(items.get(position));
        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //обявил класс Держатель просмотра
    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idView;
        final TextView contentView;

        //элементы контента?
        ViewHolder(View view) {
            super(view);
            idView = view.findViewById(R.id.id_text);
            contentView = view.findViewById(R.id.content);
        }
    }

    final private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
            Context context = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.ARG_ITEM_ID, item.id);
            context.startActivity(intent);
        }
    };
}
