package com.ligl.testrail;
//import com.brainspace.unified.api.APIClient;
//import com.brainspace.unified.api.APIException;
//import com.brainspace.unified.reporting.testrail.Reporter;
import com.ligl.base.pages.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailManager {
    public static int testRailPass=Constants.testRailStatus_Pass;
    public static int testRailFail=Constants.testRailStatus_Fail;

    public static void addResultsForTestCase(String testCaseId, int result, String comment) throws APIException, IOException {
        String testRunId= Constants.testRail_RunId;
        APIClient client=  new APIClient(Constants.testRailEngineURL);
        client.setUser(Constants.testRail_UserName);
        client.setPassword(Constants.testRail_Password);
        Map<String, Object> data=new HashMap<String, Object>();
        data.put("status_id", result);
        data.put("comment","this is executed through automation "+ comment);
        client.sendPost("add_result_for_case/" + testRunId +"/" + testCaseId, data);
    }
}
