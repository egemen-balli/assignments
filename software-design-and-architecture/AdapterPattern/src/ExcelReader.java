//Egemen BALLI 4 Dec 2023
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader implements Service{
    @Override
    public String readDataFile(String filePath) throws IOException{
        String st = "";
        FileInputStream fis = new FileInputStream(new File("student.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        for(Row row: sheet)
        {
            for(Cell cell: row)
            {
                switch(formulaEvaluator.evaluateInCell(cell).getCellType())
                {
                    case NUMERIC:
                        st+=cell.getNumericCellValue()+ "\t\t";
                        break;
                    case STRING:
                        st+=cell.getStringCellValue()+ "\t\t";
                        break;
                }
            }
            st+="\n";
        }
        return st;
    }
}
