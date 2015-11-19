package com.coolweather.app.util;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.coolweather.app.model.Province;

public class SAXProvinceContentHandler extends DefaultHandler {
	private ArrayList<Province> provinces;
	private Province province;
	
	public ArrayList<Province> getProvinces(){
		return provinces;
	}
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		provinces = new ArrayList<Province>();
		Log.i("SAXContentHandler", "��ʼsax����");
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		Log.i("SAXContentHandler", "��ȡxml��ǩ");
		//tagName = localName;
		if(qName.equals("city")){
			province = new Province();
			
			province.setProvinceCode(attributes.getValue(1));
			province.setProvinceName(attributes.getValue(0));
		}
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		Log.i("SAXContentHandler", "����tagname��ñ�ǩ����");		
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if(localName.equals("city")){
			provinces.add(province);
		}
		//tagName = null;
	}
}
