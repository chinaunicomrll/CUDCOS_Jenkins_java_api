package com.cudcos.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cudcos.util.CacheDcosUrlConfig;
import com.cudcos.util.CallRestUtil;
import com.cudcos.util.CallResult;

/**
 * Created by jiajie313 on 06/12/2017.
 */

@Service
public class JenkinsUrlService {

   
    
    
    public CallResult sendJenkinsBuildRequest(String _body) {
        CallResult callResult = null;
        //Date currentDatatime = new Date();
        String JenkinsBuildTestURL = "http://localhost:8888/job/cudcos_admin/build";
        //String dcosUniverseURI = CacheDcosUrlConfig.dcosUniverseUri + "/describe?_timestamp=" + currentDatatime.getTime();

        try {
            callResult = CallRestUtil.callSendJenkinsRequestNoBody(
            		JenkinsBuildTestURL,
                    HttpMethod.POST,
                    null,null,null,null
                   // _body,
                   // "application/vnd.dcos.package.describe-response+json;charset=utf-8;version=v1",
                   // "application/vnd.dcos.package.describe-request+json;charset=UTF-8;version=v1"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("This is a test of Jenkins build！！！！"+_body);
        return callResult;
    }
    
    public CallResult  sendJenkinsJsonRequest(String _body) {
        CallResult callResult = null;
        //Date currentDatatime = new Date();
        String JenkinsLastSuccessfulBuildURL = "http://localhost:8888/job/cudcos_admin/lastSuccessfulBuild/api/json";
        
        try {
            callResult = CallRestUtil.callSendJenkinsRequestBody(
            		JenkinsLastSuccessfulBuildURL,
                    HttpMethod.POST,
                    null,null,null,null
                   // _body,
                   // "application/vnd.dcos.package.describe-response+json;charset=utf-8;version=v1",
                   // "application/vnd.dcos.package.describe-request+json;charset=UTF-8;version=v1"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("LastSuccessfulBuild Detail is！"+_body);
        return callResult;
    }
    
    public CallResult  getJenkinslastBuild(String _body) {
        CallResult callResult = null;
        //Date currentDatatime = new Date();
        String JenkinsLastSuccessfulBuildURL = "http://localhost:8888/job/cudcos_admin/lastSuccessfulBuild/api/json";
       
        try {
            callResult = CallRestUtil.callSendJenkinsRequestBody(
            		JenkinsLastSuccessfulBuildURL,
                    HttpMethod.POST,
                    null,null,null,null
                   // _body,
                   // "application/vnd.dcos.package.describe-response+json;charset=utf-8;version=v1",
                   // "application/vnd.dcos.package.describe-request+json;charset=UTF-8;version=v1"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("LastSuccessfulBuild Detail is！"+_body);
        return callResult;
    }
   
    
    
    
   
}