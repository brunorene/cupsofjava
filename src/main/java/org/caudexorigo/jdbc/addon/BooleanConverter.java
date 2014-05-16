/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.caudexorigo.jdbc.addon;

import java.sql.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooleanConverter extends RowConverter<Boolean>
{

	private final static Logger log = LoggerFactory.getLogger(BooleanConverter.class);
	private final String field;

	public BooleanConverter(String field)
	{
		this.field = field;
	}

	@Override
	protected Boolean transform(ResultSet rs) throws Throwable
	{
		return rs.getBoolean(field);
	}
}
