package com.example.dbdemo;

import java.util.ArrayList;
import java.util.List;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import com.example.db.User;
import com.example.dbdemo.ListAdapter.OnDataChange;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	String TAG="DBDemo--->>";
	public static int IndexSave=0;
	
	private List<Data> dataList = new ArrayList<Data>();
    private Button btnAdd=null;
	private ListView listView=null; 
	ListAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 
		  btnAdd=(Button)findViewById(R.id.btnAdd);
		
		 adapter=new ListAdapter(MainActivity.this, R.layout.list_item, dataList);
		 
		 //适配器增加回调接口，如果数据有更新则重新刷新Listview。
		 adapter.setOnDataChange(new OnDataChange() {
			
			@Override
			public void onDataChange(List<User> allNews) {
				// TODO Auto-generated method stub

				initDatas(); 
				listView.setAdapter(adapter);
			}
		});
		 
		listView=(ListView)findViewById(R.id.listView); 
		 
		SQLiteDatabase db = Connector.getDatabase();
		 
	 
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "you click ="+position);
				IndexSave=position;
			}
		});
		
	
		btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent().setClass(MainActivity.this, AddDataActivity.class);
				startActivity(i);
			}
		});
		
	}

	
	
	public void initDatas()
	{
 
	
		dataList.clear();
		List<User> allNews = DataSupport.findAll(User.class);
		Log.i(TAG, "size"+allNews.size());
		for(int i=0;i<allNews.size();i++)
		{
			Data d=new Data("Name="+allNews.get(i).getName(), 
					"----Phone="+allNews.get(i).getPhoneNum()+"", "three");
			dataList.add(d);
		} 
		
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		initDatas(); 
		listView.setAdapter(adapter);
	}
}
