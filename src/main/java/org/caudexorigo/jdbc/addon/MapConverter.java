/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.caudexorigo.jdbc.addon;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author brsantos
 */
public class MapConverter<T> extends RowConverter<Map<String, T>>
{

	private final static Logger log = LoggerFactory.getLogger(MapConverter.class);
	private Class<T> colClass;

	public MapConverter(Class<T> colClass)
	{
		this.colClass = colClass;
	}

	@Override
	protected Map<String, T> transform(ResultSet rs) throws Throwable
	{
		ResultSetMetaData metadata = rs.getMetaData();
		Map<String, T> map = new HashMap<>();
		for (int i = 1; i <= metadata.getColumnCount(); i++)
		{
			map.put(metadata.getColumnName(i), rs.getObject(i, colClass));
		}
		return map;
	}
}
