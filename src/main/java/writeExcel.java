import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class writeExcel {

    public void writeExcel2(List<XMLModel> Tools, String excelFilePath) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowCount = 0;

        for (XMLModel aExcel : Tools) {
            Row row = sheet.createRow(++rowCount);
            writeLine(aExcel, row);

        }
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }


            }
    private void writeLine(XMLModel aExcel, Row row) {

        Cell cell = row.createCell(1);
        cell.setCellValue(aExcel.getSize());

        cell = row.createCell(2);
        cell.setCellValue(aExcel.getTool());

        cell = row.createCell(3);
        cell.setCellValue(aExcel.getType2());
    }
}