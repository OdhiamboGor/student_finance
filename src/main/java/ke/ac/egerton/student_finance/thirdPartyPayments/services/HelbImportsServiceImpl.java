package ke.ac.egerton.student_finance.thirdPartyPayments.services;

import ke.ac.egerton.student_finance.thirdPartyPayments.models.HelbImports;
import ke.ac.egerton.student_finance.thirdPartyPayments.repositories.HelbImportsRepository;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;

@Service
@Transactional
public class HelbImportsServiceImpl implements HelbImportsService{

    @Autowired
    private HelbImportsRepository helbImportsRepository;

    @Override
    public boolean uploadHelb(MultipartFile file) {
        boolean isFlag = false;
        String extension  = FilenameUtils.getExtension(file.getOriginalFilename());
        if(extension.equalsIgnoreCase("xls")){
            isFlag = readDataFromExcel(file);
        }else if(extension.equalsIgnoreCase("xlsx")){
            isFlag = readDataFromExcel(file);
        }
        return false;
    }

    private boolean readDataFromExcel(MultipartFile file) {
        Workbook workbook =getWorkBook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while(rows.hasNext()){
            Row row = rows.next();
            HelbImports helbImports = new HelbImports();
            if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING){
                helbImports.setRefNo(row.getCell(0).getStringCellValue());
            }
            if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING){
                helbImports.setFirstName(row.getCell(1).getStringCellValue());
            }
            if (row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING){
                helbImports.setLastName(row.getCell(2).getStringCellValue());
            }
            if (row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING){
                helbImports.setIdNumber(row.getCell(3).getStringCellValue());
            }
            if (row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING){
                helbImports.setStudentNo(row.getCell(4).getStringCellValue());
            }
            if (row.getCell(5).getCellType()== Cell.CELL_TYPE_STRING){
                helbImports.setStudentNo(row.getCell(5).getStringCellValue());

            }else if(row.getCell(5).getCellType() == Cell.CELL_TYPE_NUMERIC){
                helbImports.setAmount((int) row.getCell(5).getNumericCellValue());
            }
        }
        return true;
    }

    private Workbook getWorkBook(MultipartFile file) {
        Workbook workbook = null;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        try{
            if (extension.equalsIgnoreCase("xlsx")){
                workbook = new XSSFWorkbook(file.getInputStream());
            }else if (extension.equalsIgnoreCase("xls")){
                workbook = new HSSFWorkbook(file.getInputStream());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return workbook;
    }
}
