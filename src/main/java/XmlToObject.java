import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



public class XmlToObject {


    public static void main(String[] args) {
        try {

            System.out.println("Mit keresel ? :");

            File file = new File("valami.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Question que = (Question) jaxbUnmarshaller.unmarshal(file);

            Scanner stringScanner = new Scanner(System.in);
            String Search = stringScanner.next();

            List<XMLModel> list = que.getAnswers();
            List<XMLModel> xyp = new ArrayList<>();
            for (XMLModel ans : list) {
                if (Objects.equals(ans.getType2(), Search)) {
                    System.out.println("____________________________________________________________________");
                    System.out.println("Size: " + ans.getSize());
                    System.out.println("Tool: " + ans.getTool());
                    System.out.println("Species: " + ans.getType2());
                    System.out.println("ID: " + ans.getId());

                    xyp.add(ans);
                }
            }
            writeExcel2(xyp, Search);
        } catch (JAXBException e) {
            e.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeExcel2(List<XMLModel> Tools, String excelFilePath) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowCount = 0;

        Row row1 = sheet.createRow(rowCount++);

        Cell cell11 = row1.createCell(0);
        cell11.setCellValue(("Size(mm)"));

        Cell cell22 = row1.createCell(1);
        cell22.setCellValue(("Tool"));

        Cell cell33 = row1.createCell(2);
        cell33.setCellValue(("Type"));

        Cell cell44 = row1.createCell(3);
        cell44.setCellValue(("ID"));



        for (XMLModel x : Tools) {

            Row row = sheet.createRow(rowCount++);

                Cell cell = row.createCell(0);
                cell.setCellValue(x.getSize());

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(x.getTool());

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(x.getType2());

                Cell cell4 = row.createCell(3);
                cell4.setCellValue(x.getId());


        }
        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }
}
