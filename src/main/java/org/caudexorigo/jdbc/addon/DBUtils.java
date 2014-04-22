/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.caudexorigo.jdbc.addon;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author brsantos
 */
public class DBUtils
{

	private static final Logger log = LoggerFactory.getLogger(DBUtils.class);

	public static Set<Integer> getSetFromSQLArray(Array a) throws SQLException
	{
		Set<Integer> s = new HashSet<>();
		if (a != null)
		{
			s.addAll(Arrays.asList((Integer[]) a.getArray()));
		}
		return s;
	}
}
