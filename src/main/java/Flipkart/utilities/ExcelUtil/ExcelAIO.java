package Flipkart.utilities.ExcelUtil;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelAIO {
    private Workbook workbook;
    private Sheet sheet;
    private String filePath;

    public ExcelAIO(String filePath, String sheetName) throws IOException {
        this.filePath = filePath;
        FileInputStream fis = new FileInputStream(filePath);
        this.workbook = new XSSFWorkbook(fis);
        this.sheet = workbook.getSheet(sheetName);
        fis.close();
    }

    // Method to read a single cell value
    public String readCellData(int rowNumber, int colNumber) {
        Row row = sheet.getRow(rowNumber);
        if (row != null) {
            Cell cell = row.getCell(colNumber);
            if (cell != null) {
                return cell.toString();
            }
        }
        return null;
    }

    // Method to read data based on a column header
    public List<String> readColumnDataByHeader(String headerName) {
        List<String> columnData = new ArrayList<>();
        int headerColumnIndex = -1;

        // Find the column index for the given header
        Row headerRow = sheet.getRow(0); // Assuming header is in the first row
        if (headerRow != null) {
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(headerName)) {
                    headerColumnIndex = cell.getColumnIndex();
                    break;
                }
            }
        }

        // If the header was found, read the column data
        if (headerColumnIndex != -1) {
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from row 1 to skip header
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(headerColumnIndex);
                    if (cell != null) {
                        columnData.add(cell.toString());
                    }
                }
            }
        } else {
            System.out.println("Header '" + headerName + "' not found.");
        }

        return columnData;
    }

    // Method to update a single cell value and save the file
    public void updateCellData(int rowNumber, int colNumber, String newData) throws IOException {
        Row row = sheet.getRow(rowNumber);
        if (row == null) {
            row = sheet.createRow(rowNumber);
        }
        Cell cell = row.getCell(colNumber);
        if (cell == null) {
            cell = row.createCell(colNumber);
        }
        cell.setCellValue(newData);

        // Save changes to the file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
    }

    // Method to close the workbook
    public void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
