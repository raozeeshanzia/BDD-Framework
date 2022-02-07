package webLocators;

public class DashboardPageElement {
    public static final String addNewUserBtn = "//a[contains(text(),'Add New User')]";
    public static final String UserList = "//table[@id='ContentPlaceHolder1_gridmaster']/tbody/tr";
    public static final String SQAUserManagementLink = "//li/a/p[text()='SQ User Management']";
    public static final String SQOfficerLocationLink="//li/a/p[text()='SQ Officer Location']";
    public static final String SQOfficerJourneyLink= "//li/a/p[text()='SQ Officer Journey']";
    public static final String journeySummaryReportLink = "//li/a/p[contains(text(),'Journey Summary Report')]";
    public static final String  journeyDetailReportLink = "//li/a/p[contains(text(),'Journey Detail Report')]";
    public static final String LogoutBtn = "//a[contains(text(),'Logout')]";

    //Add user page elements
    public static final String userIDField = "//label[contains(text(),'User ID:')]//following::input[1]";
    public static final String nameField = "//label[contains(text(),'Name :')]//following::input[1]";
    public static final String emailField = "//label[contains(text(),'Email :')]//following::input[1]";
    public static final String selectRole = "//label[contains(text(),'Role: ')]//following::select[1]";
    public static final String selectReportingManager = "//label[contains(text(),'Reporting Manager: ')]//following::select[1]";
    public static final String selectStatus = "";
    public static final String saveBtn = "//input[contains(@value,'Save')]";
    public static final String cancelBtn = "//input[contains(@value,'Cancel')]";
    public static final String verifyUser = "//a[contains(text(),'Verify User')]";


}
