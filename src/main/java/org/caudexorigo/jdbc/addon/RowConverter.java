/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.caudexorigo.jdbc.addon;

import java.sql.ResultSet;

/**
 *
 * @author brsantos
 * @param <T> row type
 */
public abstract class RowConverter<T> implements org.caudexorigo.jdbc.RowConverter<T>
{

	@Override
	public T process(ResultSet rs)
	{
		try
		{
			return transform(rs);
		}
		catch (Throwable e)
		{
			throw new RuntimeException(e);
		}
	}

	protected abstract T transform(ResultSet rs) throws Throwable;

}
