package dispaching.excel.writer.grabarczyk.tomasz;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class WriteToExcel extends Variables {
    void writeToExcel() {
        final String FILE_NAME = "C:\\Users\\A702387\\Desktop\\Primordial Java Projects\\DispatchingDeskExcelFiller\\DDExcelFiller.xlsx";

        try {
            FileInputStream inputStream = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Object[][] bookData = {
                    {},
            };

            int rowCount = sheet.getLastRowNum();

            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);

                int columnCount = -1;

                Cell cell;

                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    cell.setCellValue((String) field);
                    cell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);
                }
            }

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("Excel completed");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
