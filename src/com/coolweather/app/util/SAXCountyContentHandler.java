package com.coolweather.app.util;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

public class SAXCountyContentHandler extends DefaultHandler {
	private ArrayList<County> counties;
	private County county;
	private String lx;
	public ArrayList<County> getCounties(){
		return counties;
	}
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		counties = new ArrayList<County>();
		Log.i("SAXContentHandler", "开始sax解析");
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		Log.i("SAXContentHandler", "读取xml标签");
		//tagName = localName;
		if(qName.equals("city")){
			county = new County();
			county.setCountyName(attributes.getValue(2));
			county.setCountyCode(attributes.getValue(5));
			county.setCityCode(lx);
		}else{
			lx = qName;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		Log.i("SAXContentHandler", "根据tagname获得标签内容");		
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(localName.equals("city")){
			counties.add(county);
		}
		//tagName = null;
	}
}
