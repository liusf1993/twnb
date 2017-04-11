package pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Thinkpad on 2017/4/11.
 */
public class Test {
    /**
     * 参考地址 http://rensanning.iteye.com/blog/1538689
     *  http://www.jb51.net/article/85810.htm
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        fileChannelCopy(new File("/Users/liusifan/Desktop/test.pdf"),
                new File("/Users/liusifan/Desktop/testout.pdf"));
    PdfReader reader = new PdfReader("/Users/liusifan/Desktop/test.pdf");
    PdfStamper stamper = new PdfStamper(reader,
            new FileOutputStream("/Users/liusifan/Desktop/testout.pdf"));
    PdfContentByte overContent = stamper.getOverContent(1);

    //添加文字
    Font font = createChineseFont(18);
    overContent.beginText();
    overContent.setFontAndSize(font.getBaseFont(), font.getSize());
    overContent.setTextMatrix(200, 200);
    overContent.showTextAligned(Element.ALIGN_CENTER, "需要添加的文字", 580, 530, 0);
    overContent.endText();

    //添加图片
    PdfDictionary pdfDictionary = reader.getPageN(1);
    PdfObject pdfObject = pdfDictionary.get(new PdfName("MediaBox"));
    PdfArray pdfArray = (PdfArray) pdfObject;
    Image image = Image.getInstance("/Users/liusifan/Desktop/1.jpg");
    image.setAbsolutePosition(100, 100);
    overContent.addImage(image);

    //添加一个红圈
    overContent.setRGBColorStroke(0xFF, 0x00, 0x00);
    overContent.setLineWidth(5f);
    overContent.ellipse(250, 450, 350, 550);
    overContent.stroke();
    stamper.close();
    /*    int fontSize=12;
        Font chineseFont=createChineseFont(fontSize);
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("/Users/liusifan/Desktop/test.pdf"));
        Paragraph p=new Paragraph("你好,需要帮忙吗",chineseFont);
        document.open();
        document.add(p);
        document.newPage();
        PdfPTable table=new PdfPTable(12);
        document.add(p);
        document.close();*/
    /*    PdfReader pdfReader=new PdfReader("/Users/liusifan/Desktop/test.pdf");

        pdfReader.getAcroFields();
        PdfStamper stamp = new PdfStamper(pdfReader, new FileOutputStream("/Users/liusifan/Desktop/testout.pdf"));
*/

    }

    private static void fileChannelCopy(File sources, File dest) {
        try {
            FileInputStream inputStream = new FileInputStream(sources);
            FileOutputStream outputStream = new FileOutputStream(dest);
            FileChannel fileChannepn = inputStream.getChannel();//得到对应的文件通道
            FileChannel fileChannelout = outputStream.getChannel();//得到对应的文件通道
            fileChannepn.transferTo(0, fileChannepn.size(), fileChannelout);//连接两个通道，并且从in通道读取，然后写入out通道

            inputStream.close();
            fileChannepn.close();
            outputStream.close();
            fileChannelout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建中文字体
     *
     * @param fontSize 字体大小
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    private static Font createChineseFont(int fontSize) throws IOException, DocumentException {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        return new Font(bfChinese, fontSize, Font.NORMAL);
    }
}
