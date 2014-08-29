/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.broker.addon;

import pt.com.broker.client.messaging.BrokerListener;

/**
 *
 * @author brsantos
 */
public interface FunctionalBrokerListener extends BrokerListener
{

	@Override
	public default boolean isAutoAck()
	{
		return true;
	}
}
