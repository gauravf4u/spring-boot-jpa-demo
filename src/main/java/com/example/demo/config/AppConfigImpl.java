package com.example.demo.config;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class AppConfigImpl {

  private  Properties properties;

  private Properties loadProperties(){
    if (properties == null) {
      properties = new Properties();
      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("fip-application.properties");
      try {
        properties.load(inputStream);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      properties.putAll(System.getProperties());
    }
    return  properties;
  }

  private String getDSPProperty(int index, String key){
    String value = properties.getProperty(
        String.format("dsp.%d.%s", index,
                      key.substring("dsp.".length(), key.length())));

    if (value == null && index > 0) {
      return getDSPProperty(0, key);
    }

    return value;
  }

  public List<DBInfo> findConfiguredDataSources(){
    loadProperties();
    List<DBInfo> dbInfoList = new ArrayList<>();
     for(int index = 1; index<4; index++) {
       String client     = getDSPProperty(index, "dsp.client");
         DBInfo datasource = new DBInfo();
         datasource.setClientName(client);
         datasource.setDbDriver(getDSPProperty(index, "dsp.dbDriver"));
         datasource.setDbPassword(getDSPProperty(index, "dsp.dbPassword"));
         datasource.setUserName(getDSPProperty(index, "dsp.dbUser"));
         datasource.setPoolSize(getDSPProperty(index, "dsp.InitialPoolSize"));
         datasource.setLoginUrl(getDSPProperty(index, "dsp.loginURL"));
         datasource.setUrl(getDSPProperty(index, "dsp.dbURL"));
         datasource.setClawDB(getDSPProperty(index, "dsp.client").equals("FIP_CLAW"));
         datasource.setCommonDB(getDSPProperty(index, "dsp.client").equals("COMMONS"));
         dbInfoList.add(datasource);
     }
     return dbInfoList;
  }

}
