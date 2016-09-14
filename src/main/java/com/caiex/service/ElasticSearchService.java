package com.caiex.service;

import java.util.List;

import com.caiex.dto.Player;

public interface ElasticSearchService {
	
	public void insert(Player player);
	
	public void delete(Player player);
	
	public void deleteIndex(String index);

	public List<Player> findBy(Player player);
}
