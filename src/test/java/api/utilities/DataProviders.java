package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "//testdata//Userdata.xlsx";

		int rowCount = ExcelUtils.getRowCount(path, "Sheet1");
		int cellCount = ExcelUtils.getCellCount(path, "Sheet1", 1);
		String[][] apidata = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				apidata[i - 1][j] = ExcelUtils.getCelldata(path, "Sheet1", i, j);

			}
		}

		return apidata;

	}

	@DataProvider(name = "UserNames")
	public String[] getUsernames() throws IOException {

		String path = System.getProperty("user.dir") + "//testdata//Userdata.xlsx";

		int rowCount = ExcelUtils.getRowCount(path, "Sheet1");
		String[] apidata = new String[rowCount];

		for (int i = 1; i <= rowCount; i++) {

			apidata[i - 1] = ExcelUtils.getCelldata(path, "Sheet1", i, 1);

		}

		return apidata;
	}

}
