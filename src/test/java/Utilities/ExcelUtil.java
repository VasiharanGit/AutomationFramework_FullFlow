package Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    static String excelPath =
            "src/test/java/testData/Testdata.xlsx";

    static XSSFWorkbook workbook;

    static XSSFSheet sheet;

    public static String getCellData(
            int rowNum,
            int colNum) {

        String value = "";

        try {

            FileInputStream fis =
                    new FileInputStream(excelPath);

            workbook =
                    new XSSFWorkbook(fis);

            sheet =
                    workbook.getSheet("Sheet1");

            XSSFRow row =
                    sheet.getRow(rowNum);

            XSSFCell cell =
                    row.getCell(colNum);

            value =
                    cell.getStringCellValue();

            workbook.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return value;
    }
    public static int getRowCount() {

        int rowCount = 0;

        try {

            FileInputStream fis =
                    new FileInputStream(excelPath);

            workbook =
                    new XSSFWorkbook(fis);

            sheet =
                    workbook.getSheet("Sheet1");

            rowCount =
                    sheet.getPhysicalNumberOfRows();

            workbook.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return rowCount;
    }
    public static int getColCount() {

        int colCount = 0;

        try {

            FileInputStream fis =
                    new FileInputStream(excelPath);

            workbook =
                    new XSSFWorkbook(fis);

            sheet =
                    workbook.getSheet("Sheet1");

            colCount =
                    sheet.getRow(0).getPhysicalNumberOfCells();

            workbook.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return colCount;
    }
}