package com.devinshine.listviewanimdemo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	List<String> list;
	Context context;
	LayoutInflater inflater;
	public CustomAdapter(Context context,List<String>list) {
		this.list = list;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.list_item, null);
			holder.tv = (TextView)convertView.findViewById(R.id.tv);
			holder.ll = (LinearLayout)convertView.findViewById(R.id.ll);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		holder.tv.setText(list.get(position));
		ScaleAnimation sa = new ScaleAnimation(0.5f, 1, 0.5f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(500);
		holder.ll.setAnimation(sa);
		return convertView;
	}

	class ViewHolder{
		TextView tv;
		LinearLayout ll;
	}
}
