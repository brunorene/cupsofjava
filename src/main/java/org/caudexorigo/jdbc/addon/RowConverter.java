/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.caudexorigo.jdbc.addon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import org.caudexorigo.text.StringBuilderWriter;

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
            try (StringBuilderWriter out = new StringBuilderWriter())
            {
                try (PrintWriter writer = new PrintWriter(out))
                {
                    e.printStackTrace(writer);
                    out.flush();
                    throw new RuntimeException(out.toString());
                }
            }
            catch (IOException e1)
            {
                throw new RuntimeException(e1);
            }

        }
    }

    protected abstract T transform(ResultSet rs) throws Throwable;

}
