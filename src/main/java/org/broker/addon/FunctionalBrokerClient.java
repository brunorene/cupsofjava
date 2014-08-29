/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.broker.addon;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.com.broker.client.BrokerClient;
import pt.com.broker.client.HostInfo;
import pt.com.broker.types.NetProtocolType;
import pt.com.broker.types.NetSubscribe;

public class FunctionalBrokerClient extends BrokerClient
{

	private final static Logger log = LoggerFactory.getLogger(FunctionalBrokerClient.class);

	public FunctionalBrokerClient(String host, int portNumber) throws Throwable
	{
		super(host, portNumber);
	}

	public FunctionalBrokerClient(String host, int portNumber, int retriest) throws Throwable
	{
		super(host, portNumber, retriest);
	}

	public FunctionalBrokerClient(String host, int portNumber, int retries, int connectTimeout, int readTimeout) throws Throwable
	{
		super(host, portNumber, retries, connectTimeout, readTimeout);
	}

	public FunctionalBrokerClient(String host, int portNumber, String appName, int connectTimeout, int readTimeout) throws Throwable
	{
		super(host, portNumber, appName, connectTimeout, readTimeout);
	}

	public FunctionalBrokerClient(String host, int portNumber, String appName) throws Throwable
	{
		super(host, portNumber, appName);
	}

	public FunctionalBrokerClient(String host, int portNumber, String appName, NetProtocolType ptype, int connectTimeout, int readTimeout) throws Throwable
	{
		super(host, portNumber, appName, ptype, connectTimeout, readTimeout);
	}

	public FunctionalBrokerClient(String host, int portNumber, String appName, NetProtocolType ptype) throws Throwable
	{
		super(host, portNumber, appName, ptype);
	}

	public FunctionalBrokerClient(Collection<HostInfo> hosts) throws Throwable
	{
		super(hosts);
	}

	public FunctionalBrokerClient(Collection<HostInfo> hosts, String appName) throws Throwable
	{
		super(hosts, appName);
	}

	public FunctionalBrokerClient(Collection<HostInfo> hosts, String appName, NetProtocolType ptype) throws Throwable
	{
		super(hosts, appName, ptype);
	}

	public void addAsyncConsumer(NetSubscribe subscribe, FunctionalBrokerListener listener) throws Throwable
	{
		super.addAsyncConsumer(subscribe, listener);
	}
}
