/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.caudexorigo.cassandra;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.caudexorigo.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * Cassandra query pagination When building the statement remember that a ' LIMIT ?' String will be appended in the end and arguments should be before keys
 * second on the bind call
 *
 */

public class CassandraPagination
{

	private static final Logger log = LoggerFactory.getLogger(CassandraPagination.class);
	private final Object[] bindArguments;
	private final Session cassandra;
	private final PreparedStatement statement;

	public CassandraPagination(Session cassandra, String statement, List<Object> keys, List<Object> arguments)
	{
		this(cassandra, statement, keys.toArray(), arguments.toArray());
	}

	public CassandraPagination(Session cassandra, String statement, Object[] keys, Object[] arguments)
	{
		this.bindArguments = ArrayUtils.addAll(arguments, keys);
		this.cassandra = cassandra;
		this.statement = cassandra.prepare(statement + " LIMIT ?");
	}

	public List<Row> getPageWithOffset(int offset, int limit)
	{
		Iterator<Row> rows = cassandra.execute(statement.bind(ArrayUtils.addAll(bindArguments, Arrays.asList(limit + offset).toArray()))).iterator();
		int index = 0;
		List<Row> result = new LinkedList<>();
		while (rows.hasNext())
		{
			if (index > offset)
			{
				result.add(rows.next());
			}
			else
			{
				rows.next();
			}
			index++;
		}
		return result;
	}
}
