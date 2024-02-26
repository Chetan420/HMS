package com.hospitalmanagementsytem.qa.util;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil extends TestBase {
    private String path;
    public static long IMPLICITLY_WAIT=10;
    public static long PAGELOAD_TIMEOUT=10;
    public Workbook workbook;
    public TestUtil(String path){
        this.path=path;
    }
    public void switchToFrameIndex(int index){
        driver.switchTo().frame(index);
    }
    public void switchToFrameString(String value){
        driver.switchTo().frame(value);
    }
    public void switchToFrameWebElement(String element){
        driver.switchTo().frame(element);
    }
    public static String takeScreenShot() {
        String dateName=new SimpleDateFormat("yyyy.MM.dd.hh:mm.ss").format(new Date());
        TakesScreenshot ts=(TakesScreenshot) driver;
        File srcFile=ts.getScreenshotAs(OutputType.FILE);
        String destPath="C:\\Users\\cheta\\IdeaProjects\\HospitalManagementSystem\\errorShots"+"HMS-"+dateName+".jpg";
        File target=new File(destPath);
        try {
            FileHandler.copy(srcFile,target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destPath;
    }
    public Object[][] getCellData(String sheetName){
        try{
            FileInputStream file=new FileInputStream(path);
            workbook= WorkbookFactory.create(file);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Sheet sheet=workbook.getSheet(sheetName);
        int lastRow=sheet.getLastRowNum();
        int lastCell=sheet.getRow(0).getLastCellNum();
        Object[][] cellData=new Object[lastRow][lastCell];
        for(int i=0;i<=lastRow;i++){
            for(int j=0;i<=lastCell;i++){
                cellData[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return cellData;
    }
}
