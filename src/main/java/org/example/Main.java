public class Main {
    public static void main(String[] args) {
        try {
            // Detaylandırılmış 3 Hayali İş Deneyimi
            String[] experiences = {
                    "Backend Developer - ABC Tech (2025 - Halen): Java ve Spring Boot kullanarak RESTful API'ler tasarladi.",
                    "Yazilim Stajyeri - DEF Bilisim (2024 - 2025): PostgreSQL veritabani sorgulari optimizasyonu ve birim testler yazdi.",
                    "Freelance Web Gelistirici - Bionluk & Fiverr (2024): Musterilere ozel dinamik ve responsive web arayuzleri gelistirdi."
            };

            // Örnek Projeler
            String[] projects = {
                    "PDF Resume Generator: Java ve Apache PDFBox kullanarak dinamik CV olusturan OOP tabanli yazilim.",
                    "Restaurant QR Menu System: HTML, CSS ve JavaScript ile responsive dijital menu uygulamasi."
            };

            // CV Olusturucu Nesnesinin Baslatilmasi
            PdfResumeGenerator generator = new PdfResumeGenerator(
                    "Nilsu Guven",
                    "Yazilim Muhendisi Adayi / Software Engineer",
                    "nilsuguven@gmail.com",
                    "+90 535 700 1654",
                    "Yazilim gelistirme alaninda kendini gelistiren, Java ve nesne yonelimli mimarilere ilgili bir muhendis adayi.",
                    "Kirklareli Universitesi - Yazilim Muhendisligi (2025 - 2029)",
                    "Java, C, Python, JavaScript, HTML/CSS, Git, SQL, IntelliJ IDEA, Maven",
                    "profile.jpg",
                    experiences,
                    projects
            );

            // PDF Dosyasini Üret
            generator.generatePdf("Nilsu_Guven_CV.pdf");

        } catch (Exception e) {
            System.err.println("PDF uretilirken hata olustu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}