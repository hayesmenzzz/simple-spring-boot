package com.seamount.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.seamount.dao.model.City;

@Mapper
public interface CityDao {
	
	public String colums = "id,name,pid,first_letter,pinyin";
	
	@Select("select "+ colums +" FROM city where id = #{id}")
	@ResultMap(value="com.seamount.dao.CityDao.CityMap")
	public City queryById(int id);
}
