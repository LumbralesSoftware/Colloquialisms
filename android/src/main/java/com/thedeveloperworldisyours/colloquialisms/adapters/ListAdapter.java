package com.thedeveloperworldisyours.colloquialisms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thedeveloperworldisyours.colloquialisms.R;
import com.thedeveloperworldisyours.colloquialisms.models.Sentence;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 25/5/15.
 */
public class ListAdapter extends ArrayAdapter<Sentence> {
    private final Context mContext;
    private final List<Sentence> mValues;

    static class ViewHolder {
        public TextView textENG;
        public TextView textEs;
    }

    public ListAdapter(Context context, List<Sentence> list) {
        super(context, R.layout.row_list, list);
        this.mContext = context;
        this.mValues = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.row_list, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textENG = (TextView) rowView.findViewById(R.id.row_list_textView_eng);
            viewHolder.textEs = (TextView) rowView.findViewById(R.id.row_list_textView_es);



            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();

        holder.textENG.setText(mValues.get(position).getSentenceOrigin());
        holder.textEs.setText(mValues.get(position).getSentenceDestination());

        return rowView;
    }

}
