package com.ligl.base;

import com.ligl.base.pages.Constants;
import com.ligl.testrail.APIException;
import com.ligl.testrail.TestRailManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ligl.session.LiglTestSession;
import com.ligl.util.Xls_Reader;

import java.io.IOException;

public class TestBase {

    public LiglTestSession session;
    public String testName = null;
    public String moduleName = null;
    public String testCaseId;
    String testDataSheet = Constants.TEST_DATA_SHEET;
    public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "//" + testDataSheet + ".xlsx");
    //public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//TestData.xlsx");

    @BeforeMethod
    public void init(ITestResult result) throws Exception {
        System.out.println("@BeforeMethod");
        testName = result.getMethod().getMethodName().toUpperCase();
        moduleName = result.getMethod().getDescription().toUpperCase();
        System.out.println(testName);
        session = new LiglTestSession();
        session.init(testName, moduleName);
    }

    @AfterMethod
    public void quit() {
        session.generateReport();
    }

    @AfterMethod
    public void updateResultsToTestRail(ITestResult result) throws APIException, IOException {
        if (session.getGlobalData("TestRailUpdate").toLowerCase().contentEquals("yes")) {
            String[] listOfTestCases = testCaseId.split("[,]");
            for (String tcId : listOfTestCases) {
                if (result.getStatus() == ITestResult.SUCCESS)
                    TestRailManager.addResultsForTestCase(tcId, TestRailManager.testRailPass, "");
                else if (result.getStatus() == ITestResult.FAILURE)
                    TestRailManager.addResultsForTestCase(tcId, TestRailManager.testRailFail, "");
            }
        }
    }
}
