package functions;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import utilities.SeleniumHelpers;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFunction {
    protected WebDriver driver;
    protected SeleniumHelpers selenium;

    public ExcelFunction(WebDriver driver, SeleniumHelpers selenium){
        this.driver = driver;
        this.selenium = selenium;
    }

    /**
     * Get excel data
     *
     * @return excel data
     */
    public String getExcelData(String fileName) throws IOException, InterruptedException {
        selenium.hardWait(5);
        FileInputStream file = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(1);
        String data =sheet.getRow(0).getCell(0).getStringCellValue();
        return data;
    }
}
