package com.example.dbdemo;

import java.util.ArrayList;
import java.util.List;
 

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	String TAG="DBDemo--->>";
	public static int IndexSave=0;
	
	private List<Data> dataList = new ArrayList<Data>();
 
	private ListView listView=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
		
		ListAdapter adapter=new ListAdapter(MainActivity.this, R.layout.list_item, dataList);
		
		listView=(ListView)findViewById(R.id.listView);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Log.i(TAG, "you click ="+position);
				IndexSave=position;
			}
		});
		
	}

	public void initDatas()
	{
 
		
		for(int i=0;i<10;i++)
		{
			Data d=new Data("one="+i, "two", "three");
			dataList.add(d);
		}
		
		
	}
}
