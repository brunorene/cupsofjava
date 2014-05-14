/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.caudexorigo.jdbc.addon;

import java.sql.ResultSet;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateConverter extends RowConverter<Date>
{

	private final static Logger log = LoggerFactory.getLogger(DateConverter.class);
	private final String field;

	public DateConverter(String field)
	{
		this.field = field;
	}

	@Override
	protected Date transform(ResultSet rs) throws Throwable
	{
		return rs.getDate(field);
	}
}
