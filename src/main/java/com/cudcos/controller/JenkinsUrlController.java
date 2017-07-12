package com.cudcos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cudcos.service.JenkinsUrlService;
import com.cudcos.util.CallResult;

@RestController
@RequestMapping("/jenkins")
public class JenkinsUrlController {

	private static final Logger logger = LoggerFactory.getLogger(JenkinsUrlController.class);

    @Autowired
    private JenkinsUrlService jenkinsUrlService;
    
    @RequestMapping(value="/job/buildTest", produces="application/json", method= RequestMethod.POST)
    public CallResult getJenkinsResult(@RequestBody(required=false) String _body) {
        logger.info(" send build request. request body: " + _body);
        System.out.println(_body);
   //     CallResult retDetail = dcosUniverseService.getJenkinsJobResult(_body)(_body);
       CallResult sendBuildRequestAction = jenkinsUrlService.sendJenkinsBuildRequest(_body);
       CallResult retDetail = jenkinsUrlService.getJenkinslastBuild(_body);
       logger.info(" build response. response body: " + retDetail.toString());
       
        return retDetail;
        
    }
    
    
    @RequestMapping(value="/job/getLastBuildJson", produces="application/json", method= RequestMethod.POST)
    public CallResult getJenkinsJsonResult(@RequestBody(required=false) String _body) {
        logger.info(" requesting jenkins build info: " + _body);
        System.out.println(_body);
   //     CallResult retDetail = dcosUniverseService.getJenkinsJobResult(_body)(_body);
       CallResult retDetail = jenkinsUrlService.sendJenkinsJsonRequest(_body);
       logger.info(" requested jenkins build info is: " + retDetail.toString());
        return retDetail;
        
    }

}
