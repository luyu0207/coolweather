package com.coolweather.app.activity;


import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.coolweather.app.R;
import com.coolweather.app.model.County;

public class WeatherActivity extends Activity {
	private TextView text1,text3,text4,text5,text7,text8;
	private County county;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather_layout);
		init();
		county = (County) getIntent().getBundleExtra("list_bundle").getSerializable("list");
		
		text1.setText(county.getCountyName());
		SimpleDateFormat   formatter  =   new SimpleDateFormat("yyyy年MM月dd日");    
		Date curDate =   new Date();//获取当前时间     
		String    str    =    formatter.format(curDate);     
		text3.setText(str);
		text4.setText(county.getStateDetailed());
		text5.setText(county.getTemp1());
		text7.setText(county.getTemp2());
		text8.setText(county.getWindState());
	}
	private void init(){
		text1 =(TextView) findViewById(R.id.city_name);
		text3 =(TextView) findViewById(R.id.current_date);
		text4 =(TextView) findViewById(R.id.weather_desp);
		text5 =(TextView) findViewById(R.id.temp1);
		text7 =(TextView) findViewById(R.id.temp2);
		text8 =(TextView) findViewById(R.id.windState);
	}
}
