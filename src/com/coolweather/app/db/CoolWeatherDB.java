package com.coolweather.app.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

public class CoolWeatherDB {

	/**
	 *数据库名
	 */
	public static final String DB_NAME="cool_weather";
	/**
	 * 数据库版本
	 */
	public static final int VERSION=1;
	
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;
	/**
	 * 构造方法
	 * @param context
	 */
	private CoolWeatherDB(Context context){
		CoolWeathreOpenHelper dbHelper = new CoolWeathreOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	/**
	 * 获取CoolWeatherDB的实例
	 */
	public synchronized static CoolWeatherDB getInstance(Context context){
		if(coolWeatherDB==null){
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	
	/**
	 * 将Province实例存储到数据库
	 */
	public void saveProvince(Province province){
		if(province!=null){
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}	
	}
	/**
	 * 从数据库读取全国所有的省份信息
	 */
	public List<Province> loadProvinces(){
		List<Province> list  = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));				
				list.add(province);
			}while(cursor.moveToNext());
		}
		return list;
	}
	/**
	 * 将City实例存储到数据库
	 */
	public void saveCity(City city){
		if(city!=null){
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_code",city.getProvinceCode());
			
			db.insert("City", null, values);
		}
	}
	/**
	 * 从数据库读取某省下面所有城市信息
	 */
	public List<City> loadCitiers(String provinceCode){
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, "province_code=?", new String[]{provinceCode}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setProvinceCode(provinceCode);
				list.add(city);
			}while(cursor.moveToNext());
		}
		return list;
	}
	/**
	 * 将County实例存储到数据库
	 */
	public void saveCounty(County county){
		if(county!=null){
			ContentValues values = new ContentValues();
			values.put("country_name", county.getCountyName());
			values.put("country_code", county.getCountyCode());
			values.put("city_code", county.getCityCode());
			values.put("state_detail", county.getStateDetailed());
			values.put("temp1", county.getTemp1());
			values.put("temp2", county.getTemp2());
			values.put("windState", county.getWindState());
			db.insert("County", null, values);
		}
	}
	/**
	 * 从数据库读取某城市下所有的县信息
	 */
	public List<County> loadCounties(String cityCode){
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.query("County", null, "city_code=?", new String[]{cityCode}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				County county = new County();
				county.setId(cursor.getInt(cursor.getColumnIndex("id")));
				county.setCountyName(cursor.getString(cursor.getColumnIndex("country_name")));
				county.setCountyCode(cursor.getString(cursor.getColumnIndex("country_code")));
				county.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				county.setStateDetailed(cursor.getString(cursor.getColumnIndex("state_detail")));
				county.setTemp1(cursor.getString(cursor.getColumnIndex("temp1")));
				county.setTemp2(cursor.getString(cursor.getColumnIndex("temp2")));
				county.setWindState(cursor.getString(cursor.getColumnIndex("windState")));
				list.add(county);
			}while(cursor.moveToNext());
		}
		return list;
	}
}
