package pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * Created by Thinkpad on 2017/4/11.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.A4);
        Document doc = new Document();
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("C:\\Users\\Thinkpad\\Desktop\\test.pdf"));
        writer.newPage();


        document.open();
        document.close();
    }
}
