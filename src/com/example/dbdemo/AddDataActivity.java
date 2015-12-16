package com.example.dbdemo;

import java.util.List;

import org.litepal.crud.DataSupport;

import com.example.db.User;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddDataActivity extends Activity{
	
	private String TAG="AddDataActivity-->>";
	private EditText editName;
	private EditText editPhone;
	private Button btnSave;
	private Button btnExit;
	private String userName;
	private String userPhone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.add_data);
		
		editName=(EditText)findViewById(R.id.editName);
		editPhone=(EditText)findViewById(R.id.editPhone);
		
		btnSave=(Button)findViewById(R.id.btnSave);
		btnExit=(Button)findViewById(R.id.btnEdit);
		
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				userName=editName.getText().toString();
				userPhone=editPhone.getText().toString();
				if(userName.length()>0&&userPhone.length()>0)
				{
				User userOne=new User();
				userOne.setName(userName);
				userOne.setNumber(Integer.parseInt(userPhone));
				userOne.setPhoneNum(Integer.parseInt(userPhone));
				userOne.save();
				}
				
			}
		});
		
		
		
	}

}
