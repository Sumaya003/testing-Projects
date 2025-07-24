package MiniProjectAlerts;

import java.io.IOException;

import org.testng.annotations.Test;

public class alerts extends MultiBrowser {

    @Test
    public void testAlerts() throws InterruptedException, IOException {
        alertsPage alertsPage = new alertsPage(driver);
        alertsPage.navigateToAlertsPage();

        alertsPage.handleAlertWithOK();
        alertsPage.handleAlertWithCancel();

        String filepath = System.getProperty("user.dir") + "\\testdata\\alertdata.xlsx";
        String xlsheet = "Sheet1";
        int rowCount = ExcelUtils.getRowCount(filepath, xlsheet);

        for (int i = 1; i <= rowCount; i++) {
            String inputName = ExcelUtils.getCellData(filepath, xlsheet, i, 0);
            String exptdOutput = ExcelUtils.getCellData(filepath, xlsheet, i, 1);
            alertsPage.handleAlertWithTextbox(inputName, exptdOutput, filepath, xlsheet, i);
        }
    }
}
