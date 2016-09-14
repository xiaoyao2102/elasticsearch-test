package com.caiex.service.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.caiex.dto.Player;
import com.caiex.service.ElasticSearchService;

public class ElasticSearchServiceImpl implements ElasticSearchService {
	
	
	TransportClient transportClient;

	public ElasticSearchServiceImpl() {
		transportClient = TransportClient.builder().build()
				.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.175.102", 9300)));
	}

	@Override
	public void insert(Player player) {
		try {
			transportClient.prepareIndex("players", "players", player.hashCode() + "").setSource(player.toJSON()).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Player player) {
		transportClient.prepareDelete("players", "players", player.hashCode() + "").get();
	}

	@Override
	public void deleteIndex(String index) {
		transportClient.admin().indices().delete(new DeleteIndexRequest(index));
	}

	@Override
	public List<Player> findBy(Player player) {
		return null;
	}

}
