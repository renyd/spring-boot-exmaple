import com.example.Application;
import com.example.es.ElasticsearchDao;
import com.example.es.impl.ElasticsearchDaoImpl;
import com.google.gson.Gson;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Domg on 2016/11/27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ElasticseachDaoTest {


    private static final Logger logger = LoggerFactory.getLogger(ElasticseachDaoTest.class);

    @Resource
    private ElasticsearchDao elasticsearchDao;

    @Test
    public void searchTest() throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("last_name", "fir");
        params.put("age", 35);
        SearchResult search = elasticsearchDao.search(params);
        logger.info(search.getJsonString());
    }
}
