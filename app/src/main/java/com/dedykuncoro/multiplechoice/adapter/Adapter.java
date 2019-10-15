package com.dedykuncoro.multiplechoice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dedykuncoro.multiplechoice.R;
import com.dedykuncoro.multiplechoice.data.Data;

import java.util.ArrayList;

/**
 * Created by Kuncoro on 20/03/2016.
 */
public class Adapter extends BaseAdapter {

    private Context activity;
    private ArrayList<Data> data;
    private static LayoutInflater inflater = null;
    private View vi;
    private ViewHolder viewHolder;

    public Adapter(Context context, ArrayList<Data> items) {
        this.activity = context;
        this.data = items;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        vi = view;
        final int pos = position;
        Data items = data.get(pos);

        if(view == null) {
            vi = inflater.inflate(R.layout.list_row, null);
            viewHolder = new ViewHolder();
            viewHolder.checkBox = (CheckBox) vi.findViewById(R.id.cb);
            viewHolder.menu = (TextView) vi.findViewById(R.id.nama_menu);
            vi.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
            viewHolder.menu.setText(items.getMenu());
        }

        if(items.isCheckbox()){
            viewHolder.checkBox.setChecked(true);
        } else {
            viewHolder.checkBox.setChecked(false);
        }

        return vi;
    }

    public ArrayList<Data> getAllData(){
        return data;
    }

    public void setCheckBox(int position){
        Data items = data.get(position);
        items.setCheckbox(!items.isCheckbox());
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView menu;
        CheckBox checkBox;
    }
}
