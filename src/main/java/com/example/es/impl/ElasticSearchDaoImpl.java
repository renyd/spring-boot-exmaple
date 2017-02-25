package com.example.es.impl;

import com.example.es.ElasticSearchDao;
import com.google.gson.Gson;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by Domg on 2016/11/27.
 */
@Service
public class ElasticSearchDaoImpl implements ElasticSearchDao {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchDaoImpl.class);

    private Gson gson = new Gson();

    @Resource
    private JestClient client;

    @Override
    public SearchResult search(Map<String, Object> params) throws IOException {
        SearchResult result = null;
        SearchSourceBuilder builder = new SearchSourceBuilder();
        Set<String> keys = params.keySet();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        for (String key : keys) {
            boolQueryBuilder.must(QueryBuilders.matchPhraseQuery(key, params.get(key)));
        }
        builder.from(0).size(20).query(boolQueryBuilder).sort("first_name", SortOrder.ASC);
        Search search = new Search.Builder(builder.toString()).addIndex("company").addType("employee").build();
        logger.info(search.getData(gson));
        return client.execute(search);
    }
}

