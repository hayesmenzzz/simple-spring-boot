package com.seamount.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seamount.dao.CityDao;
import com.seamount.dao.model.City;
import com.seamount.dao.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao cityDao;
	
	@Override
	public City getById(int id) {
		return cityDao.queryById(id);
	}

}
