import com.ligl.base.TestBase;
import com.ligl.base.pages.Constants;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.db.DataBaseUtil;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DB_002 extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "DataBase")
    public void DB_002(Hashtable<String, String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            //SQL Connection
            //Select DB
            //Emp/U&R/Case(Query and Cloumn)
            //Data Compase

             DataBaseUtil page = new DataBaseUtil();
                    page.dataBaseConnection("enityDB");
                    page.executeSQL_Query(Constants.EmailTracker_Emp_query);
                    page.validatingEmailsInDB();
                    page.validateEmpData(data.get("CustodianName"), data.get("Email") );
                    page.closeTheDBConnection();


                    page.dataBaseConnection("masterBD");
                    page.executeSQL_Query(Constants.EmailTracker_UserCreation_query);
                    page.validatingEmailsInDB();
                    page.validateUseRolesData();
                    page.closeTheDBConnection();

        } catch (Exception ex) {
            session.log_Error("DB Failed");
            throw new Exception("DB Failed", ex);
        } finally {
            session.end();

        }
    }
}

