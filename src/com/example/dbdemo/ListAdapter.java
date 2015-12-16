package com.example.dbdemo;

import java.util.List;

import org.litepal.crud.DataSupport;

import com.example.db.User;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button; 
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<Data>{
	private String TAG="ListAdapter--->>";
	private int resourceId;
    private List<Data> data;
    private Data dataSingle;
    ViewHolder viewHolder;
    
    private OnDataChange onDataI;
	public ListAdapter(Context context, int textViewResourceId,
			List<Data> objects) {
		
		super(context, textViewResourceId, objects);
		
		resourceId = textViewResourceId;
		this.data=objects;
	}
	
	@Override
	public Data getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	public void setOnDataChange(OnDataChange onDataI)
	{
		this.onDataI=onDataI;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) { 
		dataSingle=getItem(position);
		
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.textDataOne = (TextView) convertView.findViewById(R.id.textDataOne);
			viewHolder.textDataTwo = (TextView) convertView.findViewById(R.id.textDataTwo);
			viewHolder.textDataThree = (TextView) convertView.findViewById(R.id.textDataThree);
			viewHolder.btnEdit=(Button)convertView.findViewById(R.id.btnEdit);
			viewHolder.btnDelete=(Button)convertView.findViewById(R.id.btnDelete);
			convertView.setTag(viewHolder); 
		} else { 
			viewHolder = (ViewHolder) convertView.getTag(); 
		} 
		
		 
		viewHolder.textDataOne.setText(dataSingle.getDataOne());
		viewHolder.textDataTwo.setText(dataSingle.getDataTwo());
		viewHolder.textDataThree.setText(dataSingle.getDataThree());
		
		viewHolder.btnDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Log.i(TAG, data.get(position).getDataOne());
			   
			   List<User> allNews = DataSupport.findAll(User.class);
			   
			   DataSupport.deleteAll(User.class, "Name=?",allNews.get(position).getName());
			   
			   
			   onDataI.onDataChange(allNews);
			   
			}
		});
		
		viewHolder.btnEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(TAG, data.get(position).getDataTwo());
			}
		});
		return convertView;
	}
	
	class ViewHolder {
		
		TextView textDataOne;
		
		TextView textDataTwo;
		
		TextView textDataThree;
		
		Button btnEdit;
		Button btnDelete;
		
	}
	
	public interface OnDataChange {
		void onDataChange(List<User> allNews);
	}
	

	
}
