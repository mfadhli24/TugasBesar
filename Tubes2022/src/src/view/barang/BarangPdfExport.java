/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view.barang;

import be.quodlibet.boxable.*;
import be.quodlibet.boxable.line.LineStyle;
import src.model.Barang;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author FDL
 */
public class BarangPdfExport {
    public void export(List<Barang> barangList) throws IOException {
        String outputFileName = System.getProperty("user.dir")
                + File.separator + "pdf" + File.separator + "Daftar_Barang_" + UUID.randomUUID()
                + ".pdf";
        // Buat objek untuk setting font menggunakan helvetica
        PDFont fontPlain = PDType1Font.HELVETICA;
        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
        // Buat dokumen baru lalu buat halaman baru pada dokumen dengan ukuran A4
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        // Buat object yang dapat menampung aliran byte untuk konten

        PDPageContentStream cos = new PDPageContentStream(document, page);
        //Setting margin
        float margin = 50;
        // menentukan posisi awal y, mengurangi tinggi halaman dengan margin atas dan bawah
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        // lebar tabel disetting agar memenuhi lebar halaman
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        boolean drawContent = true;
        float bottomMargin = 70;
        //posisi y tabel adalah di atas
        BaseTable table = new BaseTable(yStartNewPage, yStartNewPage,
                bottomMargin, tableWidth, margin, document, page, true,
                drawContent);
        // buat baris baru dengan tinggi 50
        Row<PDPage> headerRow = table.createRow(50);
        // buat sel untuk judul dengan lebar 100
        Cell<PDPage> cell = headerRow.createCell(100, "Daftar Barang");
        cell.setAlign(HorizontalAlignment.CENTER);
        cell.setFont(fontBold);
        cell.setFontSize(20);
        // vertical alignment diset middle agar posisi teks di tengah
        cell.setValign(VerticalAlignment.MIDDLE);
        // setting gaya border, warna dan lebar
        cell.setTopBorderStyle(new LineStyle(Color.BLACK, 10));
        table.addHeaderRow(headerRow);
        Row<PDPage> row = table.createRow(20);
        cell = row.createCell(10, "No");
        cell.setAlign(HorizontalAlignment.CENTER);
        cell.setFontSize(15);
        cell = row.createCell(35, "Nama");
        cell.setAlign(HorizontalAlignment.CENTER);
        cell.setFontSize(15);
        cell = row.createCell(25, "Harga");
        cell.setAlign(HorizontalAlignment.CENTER);
        cell.setFontSize(15);
        cell = row.createCell(30, "Kategori");
        cell.setAlign(HorizontalAlignment.CENTER);
        cell.setFontSize(15);
        cell.setFont(fontPlain);
        int no = 1;
        for (Barang barang : barangList) {
            row = table.createRow(20);
            cell = row.createCell(10, String.valueOf(no));
            cell.setFontSize(15);
            cell.setAlign(HorizontalAlignment.RIGHT);
            cell = row.createCell(35, barang.getNama());
            cell.setFontSize(15);
            cell = row.createCell(25, barang.getHarga());
            cell.setFontSize(15);
            cell = row.createCell(30, barang.getKategori().getNamaKategori());
            cell.setFontSize(15);
            no++;
        }
            table.draw();
            // tutup aliran konten
            cos.close();
            // Simpan file hasil export
            document.save(outputFileName);
            document.close();
            File file = new File(outputFileName);
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) 
                desktop.open(file);
            

        
    }
}