package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeathreOpenHelper extends SQLiteOpenHelper{
/**
 * Province表建表语句
 */
 public static final String CREATE_PROVINCE="create table Province ("
		 +"id integer primary key autoincrement,"
		 +"province_name text,"
		 +"province_code text)";
/**
 * City表建表语句
 */
 public static final String CREATE_CITY="create table City ("
		 +"id integer primary key autoincrement,"
		 +"city_name text,"
		 +"city_code text,"
		 +"province_code text)";
/**
 * Country表建表语句	
 */
 public static final String CRETA_COUNTRY="create table County ("
		 +"id integer primary key autoincrement,"
		 +"country_name text,"
		 +"country_code text,"
		 +"state_detail text,"
		 +"temp1 text,"
		 +"temp2 text,"
		 +"windState text,"
		 +"city_code text)";
	
	
	/**
	 * 
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public CoolWeathreOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CRETA_COUNTRY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
