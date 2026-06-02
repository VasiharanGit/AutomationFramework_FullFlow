package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import Listeners.FrameworkListener;
import Utilities.ExcelUtil;
import factory.DriverFactory;
@Listeners(FrameworkListener.class)
public class GoogleTest extends BaseClass {

    @Test
    public void verifyTitle() {

    	logger.info(
    	        "Title : "
    	        + DriverFactory.getDriver().getTitle());
        System.out.println(
                "Thread : "
                + Thread.currentThread().getId());
    }

    @Test
    public void verifyCurrentUrl() {

        System.out.println("URL : " + DriverFactory.getDriver().getCurrentUrl());
        System.out.println(
                "Thread : "
                + Thread.currentThread().getId());
    }

    @Test
    public void verifyPageSource() {

        System.out.println("Page Source Retrieved");
        System.out.println(
                "Thread : "
                + Thread.currentThread().getId());
    }
    @Test
    public void verifyFailure() {

        Assert.assertEquals(
        		DriverFactory.getDriver().getTitle(),
                "Google");
        System.out.println(
                "Thread : "
                + Thread.currentThread().getId());
    }
    @Test(dataProvider = "googleData")
    public void verifyDataProvider(String searchText) {

        System.out.println(
                "Data : " + searchText);
        System.out.println(
                "Thread : "
                + Thread.currentThread().getId());
    }
    @DataProvider(name = "googleData")
    public Object[][] getData() {

        int rows = ExcelUtil.getRowCount();
        int cols = ExcelUtil.getColCount();

        Object[][] data =
                new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] =
                        ExcelUtil.getCellData(i, j);
            }
        }

        return data;
    }
}