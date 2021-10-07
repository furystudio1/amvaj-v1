package com.agntic.waves.Music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.agntic.waves.R;

import java.util.List;

/**
 * Sample adapter implementation extending from AsymmetricGridViewAdapter<DemoItem> This is the
 * easiest way to get started.
 */
public class DefaultListAdapter extends ArrayAdapter<DemoItem> implements DemoAdapter {

  private final LayoutInflater layoutInflater;

  public DefaultListAdapter(Context context, List<DemoItem> items) {
    super(context, 0, items);
    layoutInflater = LayoutInflater.from(context);
  }

  public DefaultListAdapter(Context context) {
    super(context, 0);
    layoutInflater = LayoutInflater.from(context);
  }

  @Override
  public View getView(int position, View convertView, @NonNull ViewGroup parent) {
    View v;

    DemoItem item = getItem(position);
    boolean isRegular = getItemViewType(position) == 0;

    if (convertView == null) {
      v = layoutInflater.inflate(
          isRegular ? R.layout.musiccatitem : R.layout.musiccatitem, parent, false);
    } else {
      v = convertView;
    }

    TextView textView;
    if (isRegular) {
      textView = (TextView) v.findViewById(R.id.txt_cat_item_music);
    } else {
      textView = (TextView) v.findViewById(R.id.txt_cat_item_music);
    }

    textView.setText(String.valueOf(item.getPosition()));

    return v;
  }

  @Override public int getViewTypeCount() {
    return 2;
  }

  @Override public int getItemViewType(int position) {
    return position % 2 == 0 ? 1 : 0;
  }

  public void appendItems(List<DemoItem> newItems) {
    addAll(newItems);
    notifyDataSetChanged();
  }

  public void setItems(List<DemoItem> moreItems) {
    clear();
    appendItems(moreItems);
  }
}