package com.caiex;

import java.net.InetSocketAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;

import com.caiex.dto.Player;
import com.caiex.service.ElasticSearchService;
import com.caiex.service.impl.ElasticSearchServiceImpl;

public class TestElasticSearch {
	
	
	public static Date date = null;
	
	private static ElasticSearchService elasticSearchService = new ElasticSearchServiceImpl();
	
	static {
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse("2016-09-16");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		TransportClient transportClient = TransportClient.builder().build()
				.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.175.102", 9300)));

//		TermQueryBuilder termQuery = QueryBuilders.termQuery("team", "Yankees");
//		MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
//		MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "Ichiro");
		
		QueryStringQueryBuilder queryBuilder = QueryBuilders.queryStringQuery("NL");
		SearchResponse searchResponse = transportClient.prepareSearch("players").setQuery(queryBuilder).get();
		System.out.println(searchResponse.getHits().totalHits());
		
		for (SearchHit searchHit : searchResponse.getHits()) {
			System.out.println(searchHit.getSourceAsString());
		}
		
		
	}
}
