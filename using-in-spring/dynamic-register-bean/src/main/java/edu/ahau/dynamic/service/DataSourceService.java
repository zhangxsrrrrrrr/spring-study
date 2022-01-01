package edu.ahau.dynamic.service;

import edu.ahau.dynamic.anno.RefreshBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-12-28 22:29
 */
@Service
@RefreshBean
public class DataSourceService {

    @Autowired
    Map<String, DataSource> dataSourceMap;

    public void printDataSources() {
        dataSourceMap.forEach((s, dataSource) -> {
            System.out.println(dataSource);
        });
    }
}
