import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class PdfResumeGenerator {

    private String name;
    private String title;
    private String email;
    private String phone;
    private String about;
    private String education;
    private String skills;
    private String imagePath;
    private String[] experiences;
    private String[] projects;

    // Encapsulation (Kapsülleme) ilkesine uygun constructor
    public PdfResumeGenerator(String name, String title, String email, String phone,
                              String about, String education, String skills,
                              String imagePath, String[] experiences, String[] projects) {
        this.name = name;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.education = education;
        this.skills = skills;
        this.imagePath = imagePath;
        this.experiences = experiences;
        this.projects = projects;
    }

    public void generatePdf(String outputPath) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream content = new PDPageContentStream(document, page)) {

                // 1. Profil Fotoğrafı Ekleme
                File imgFile = new File(imagePath);
                if (!imgFile.exists()) {
                    imgFile = new File("profile.png");
                }

                if (imgFile.exists()) {
                    try {
                        PDImageXObject pdImage = PDImageXObject.createFromFileByExtension(imgFile, document);
                        content.drawImage(pdImage, 430, 640, 100, 100);
                    } catch (Exception e) {
                        System.err.println("Fotograf yuklenemedi: " + e.getMessage());
                    }
                }

                // 2. Kişisel Bilgiler & Başlık
                content.beginText();
                content.setFont(PDType1Font.HELVETICA_BOLD, 20);
                content.newLineAtOffset(50, 730);
                content.showText(name);
                content.endText();

                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 11);
                content.newLineAtOffset(50, 710);
                content.showText(title);
                content.newLineAtOffset(0, -15);
                content.showText("E-posta: " + email + " | Tel: " + phone);
                content.endText();

                // Çizgi
                content.moveTo(50, 630);
                content.lineTo(550, 630);
                content.stroke();

                int yPos = 610;

                // 3. Hakkımda (About)
                yPos = drawSectionHeader(content, "HAKKIMDA", yPos);
                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 10);
                content.newLineAtOffset(50, yPos);
                content.showText(about);
                content.endText();
                yPos -= 25;

                // 4. Eğitim (Education)
                yPos = drawSectionHeader(content, "EGITIM", yPos);
                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 10);
                content.newLineAtOffset(50, yPos);
                content.showText(education);
                content.endText();
                yPos -= 25;

                // 5. Teknik Beceriler (Skills)
                yPos = drawSectionHeader(content, "TEKNIK BECERILER", yPos);
                content.beginText();
                content.setFont(PDType1Font.HELVETICA, 10);
                content.newLineAtOffset(50, yPos);
                content.showText(skills);
                content.endText();
                yPos -= 25;

                // 6. İş Deneyimleri (Experiences)
                yPos = drawSectionHeader(content, "IS DENEYIMLERI", yPos);
                for (String exp : experiences) {
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA, 9);
                    content.newLineAtOffset(50, yPos);
                    content.showText("- " + exp);
                    content.endText();
                    yPos -= 20;
                }
                yPos -= 5;

                // 7. Projeler (Projects)
                yPos = drawSectionHeader(content, "PROJELER", yPos);
                for (String proj : projects) {
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA, 9);
                    content.newLineAtOffset(50, yPos);
                    content.showText("- " + proj);
                    content.endText();
                    yPos -= 20;
                }
            }

            document.save(outputPath);
            System.out.println("CV PDF basariyla olusturuldu: " + outputPath);
        }
    }

    // Başlık çizmek için yardımcı metot
    private int drawSectionHeader(PDPageContentStream content, String title, int yPos) throws IOException {
        content.beginText();
        content.setFont(PDType1Font.HELVETICA_BOLD, 12);
        content.newLineAtOffset(50, yPos);
        content.showText(title);
        content.endText();
        return yPos - 15;
    }
}