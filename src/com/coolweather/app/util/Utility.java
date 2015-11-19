package com.coolweather.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

public class Utility {
	private static ArrayList<Province> listp;
	private static ArrayList<City> listc;
	private static ArrayList<County> listco;
	/**
	 * 解析和处理服务器返回的省级数据
	 */
	public synchronized static boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB,InputStream response){
		if(response!=null){			
			try {
				SAXProvinceContentHandler contentHandler = new SAXProvinceContentHandler();			
				SAXParserFactory factory = SAXParserFactory.newInstance();		
				SAXParser parser = factory.newSAXParser();
				parser.parse(response, contentHandler);
				listp = contentHandler.getProvinces();
				for(Province province:listp){
					coolWeatherDB.saveProvince(province);
				}
				return true;
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return false;		
	}
	/**
	 * 解析和处理市级数据
	 */
	public synchronized static boolean handleCityResponse(CoolWeatherDB coolWeatherDB,InputStream response){
		if(response!=null){			
			try {
				SAXCityContentHandler contentHandler = new SAXCityContentHandler();			
				SAXParserFactory factory = SAXParserFactory.newInstance();		
				SAXParser parser = factory.newSAXParser();
				parser.parse(response, contentHandler);
				listc = contentHandler.getCities();
				for(City city:listc){
					coolWeatherDB.saveCity(city);
				}
				return true;
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return false;	
	}
	/**
	 * 解析和处理县级数据
	 */
	public synchronized static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB,InputStream response){
		if(response!=null){			
			try {
				SAXCountyContentHandler contentHandler = new SAXCountyContentHandler();			
				SAXParserFactory factory = SAXParserFactory.newInstance();		
				SAXParser parser = factory.newSAXParser();
				parser.parse(response, contentHandler);
				listco = contentHandler.getCounties();
				for(County county:listco){
					coolWeatherDB.saveCounty(county);
				}
				return true;
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return false;	
	}
}
