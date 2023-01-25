package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;

public class DashboardPage extends LiglBaseSessionPage {



    public ILiglPage validateAdminRole() throws Exception {
        try {
            if (getCurrentDriver().getCurrentUrl().contains("Case Insights | Vertical")) {
                log_Pass("Dashboard page is loaded default for Admin Role");
            }
            return new DashboardPage();
        } catch (Exception ex) {
            log_Error("validateAdminRole Failed");
            throw new Exception("NormalLoginTest_001 Failed", ex);
        }
    }
}
