package com.example.es;

import io.searchbox.core.SearchResult;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Domg on 2016/11/27.
 */
public interface ElasticsearchDao {

    public SearchResult search(Map<String, Object> params) throws IOException;
}
