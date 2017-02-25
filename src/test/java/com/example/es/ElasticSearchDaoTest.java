package com.example.es;

import com.example.Application;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Domg on 2016/11/27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ElasticSearchDaoTest {


    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchDaoTest.class);

    @Autowired
    private ElasticSearchDao elasticSearchDao;

    @Test
    public void searchTest() throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("last_name", "fir");
        params.put("age", 35);
        SearchResult search = elasticSearchDao.search(params);
        logger.info(search.getJsonString());
    }
}
