# Java PDF Resume Generator

Bu proje, **Java 21** ve **Apache PDFBox** kütüphanesi kullanılarak Nesne Yönelimli Programlama (OOP) prensiplerine uygun biçimde geliştirilmiş bir PDF Özgeçmiş (CV) oluşturma uygulamasıdır.

## 📌 Proje Mimarisi ve Tasarım Prensipleri
Hocanın ders yönergelerine uygun olarak:
- **Ayrıştırılmış Mimari:** PDF üretme mantığı `main` metodunda değil, bağımsız ve modüler bir servis sınıfında (`PdfResumeGenerator.java`) kurgulanmıştır.
- **Kapsülleme (Encapsulation):** Nitelikler `private` erişim düzenleyicisi ile korunmuş, nesne durumları constructor (yapıcı metot) aracılığıyla ilklendirilmiştir.
- **Görsel Desteği:** Profil fotoğrafı PDFBox grafik akışları (`PDPageContentStream`) üzerinden koordinat bazlı eklenmektedir.

## 🛠️ Teknolojiler ve Kütüphaneler
- **Programlama Dili:** Java 21
- **Derleme & Bağımlılık Yönetimi:** Apache Maven
- **PDF Kütüphanesi:** Apache PDFBox (`2.0.30`)

## 🧱 Kullanılan Nesneler ve Seçim Nedenleri
1. **`PDDocument`:** PDF belgesinin bellekteki ana temsilcisidir. Belge yaşam döngüsünü (`create`, `save`, `close`) yönetir.
2. **`PDPage`:** Belgeye eklenen sayfaları temsil eder.
3. **`PDPageContentStream`:** Metin, çizgi ve görselleri sayfa üzerine çizen akış nesnesidir.
4. **`PDImageXObject`:** Profil fotoğrafını dosyadan okuyup PDF formatına dönüştürür.

## 🚀 Projeyi Çalıştırma

1. Repoyu bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/KULLANICI_ADINIZ/JavaPdfResume.git](https://github.com/KULLANICI_ADINIZ/JavaPdfResume.git)