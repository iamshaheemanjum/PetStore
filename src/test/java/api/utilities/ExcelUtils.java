package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle style;
	
	 
	public static int getRowCount(String file, String sheet) throws IOException {
		

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();

		return rowCount;
	}

	public static int getCellCount(String file, String sheet, int rowNo) throws IOException {

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowNo);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();

		return cellCount;
	}

	public static String getCelldata(String file, String sheet, int rowNo, int cellNo) throws IOException {

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowNo);
		cell = row.getCell(cellNo);
		String data;

		try {

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);

		} catch (Exception e) {
			data = "";
		}

		wb.close();
		fi.close();

		return data;

	}

	public static void setCellData(String file, String sheet, int rowNo, int cellNo, String data) throws IOException {

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowNo);
		cell = row.getCell(cellNo);
		cell.setCellValue(data);
		fo = new FileOutputStream(file);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

	public static void fillGreenColor(String file, String sheet, int rowNo, int cellNo) throws IOException {

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowNo);
		cell = row.getCell(cellNo);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(file);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}
	
	public static void fillRedColor(String file, String sheet, int rowNo, int cellNo) throws IOException {

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowNo);
		cell = row.getCell(cellNo);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(file);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

}
