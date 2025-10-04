/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import domain.Kupac;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author Saki
 */
public class PDFGenerator {

    public static File generateOtpremnicaPdf(Otpremnica otpremnica) throws Exception {
        String nazivFajla = "Otpremnica_" + otpremnica.getId() + ".pdf";
        File file = new File(nazivFajla);
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        BaseFont baseFont = BaseFont.createFont("font/Amiko-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        Font headingFont = new Font(baseFont, 16, Font.BOLD);
        Font boldFont = new Font(baseFont, 12, Font.BOLD);
        Font normalFont = new Font(baseFont, 12, Font.NORMAL);

        document.add(new Paragraph("CVEĆARA MADEIRA", headingFont));
        document.add(new Paragraph("PIB: 12345678", normalFont));
        document.add(new Paragraph("Telefon: +381 11 555 333", normalFont));
        document.add(new Paragraph("Adresa: Vojvode Stepe 203, Beograd, 11000", normalFont));
        document.add(new Paragraph("Email: info@cvecaramadeira.rs", normalFont));
        document.add(Chunk.NEWLINE);

        java.net.URL imageUrl = PDFGenerator.class.getResource("logo.png");
        if (imageUrl == null) {
            throw new RuntimeException("Logo nije pronađen!");
        }
        Image logo = Image.getInstance(imageUrl);
        logo.scaleToFit(100, 100);
        Rectangle page = document.getPageSize();

        float paddingTop = 50f;
        float paddingRight = 50f;
        float x = page.getRight() - logo.getScaledWidth() - paddingRight;
        float y = page.getTop() - logo.getScaledHeight() - paddingTop;

        logo.setAbsolutePosition(x, y);
        document.add(logo);
        document.add(logo);

        Paragraph heading = new Paragraph("Otpremnica br. " + otpremnica.getId(), headingFont);
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);
        document.add(new Paragraph("Datum: " + otpremnica.getDatumIzdavanja(), normalFont));
        document.add(Chunk.NEWLINE);

        Kupac kupac = otpremnica.getKupac();
        document.add(new Paragraph("Podaci o kupcu:", boldFont));
        document.add(new Paragraph("Ime i prezime: " + kupac.getIme() + " " + kupac.getPrezime(), normalFont));
        if (kupac.getNaziv() != null && !kupac.getNaziv().isEmpty() && kupac.getPib() > 0) {
            document.add(new Paragraph("Naziv firme: " + kupac.getNaziv(), normalFont));
            document.add(new Paragraph("PIB: " + kupac.getPib(), normalFont));
        }
        if (kupac.getTelefon() != null && !kupac.getTelefon().isEmpty()) {
            document.add(new Paragraph("Telefon: " + kupac.getTelefon(), normalFont));
        }
        if (kupac.getMesto() != null) {
            document.add(new Paragraph("Adresa: "
                    + kupac.getMesto().getUlica() + ", "
                    + kupac.getMesto().getPostanskiBroj() + " "
                    + kupac.getMesto().getGrad(), normalFont));
        }
        if (kupac.getEmail() != null && !kupac.getEmail().isEmpty()) {
            document.add(new Paragraph("Email: " + kupac.getEmail(), normalFont));
        }

        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 3, 4, 3, 3, 3, 3, 4});

        addTableHeader(table, "Rb", baseFont);
        addTableHeader(table, "Količina", baseFont);
        addTableHeader(table, "Naziv aranžmana", baseFont);
        addTableHeader(table, "Cena bez PDV-a(RSD)", baseFont);
        addTableHeader(table, "Cena sa PDV-om(RSD)", baseFont);
        addTableHeader(table, "Iznos bez PDV-a(RSD)", baseFont);
        addTableHeader(table, "Iznos sa PDV-om(RSD)", baseFont);
        addTableHeader(table, "Napomena", baseFont);
        if (otpremnica.getStavkeOtpremnice() != null && !otpremnica.getStavkeOtpremnice().isEmpty()) {
            for (StavkaOtpremnice stavka : otpremnica.getStavkeOtpremnice()) {
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stavka.getRb()), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stavka.getKolicina()), normalFont)));
                table.addCell(new PdfPCell(new Phrase(stavka.getAranzman().getNaziv(), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stavka.getCenaBezPDV()), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stavka.getCenaSaPDV()), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stavka.getIznosBezPDV()), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stavka.getIznosSaPDV()), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(stavka.getNapomena()), normalFont)));
            }
        } else {
            System.out.println("Otpremnica nema stavke");
        }
        document.add(table);
        document.add(Chunk.NEWLINE);

        document.add(new Paragraph("Ukupan iznos bez PDV-a: " + otpremnica.getUkupanIznosBezPDv() + " RSD", normalFont));
        document.add(new Paragraph("Ukupan iznos sa PDV-om: " + otpremnica.getUkupanIznosSaPDV() + " RSD", boldFont));
        document.add(Chunk.NEWLINE);

        PdfPTable footerTable = new PdfPTable(2);
        footerTable.setWidthPercentage(100);
        footerTable.setSpacingBefore(30f); 
        footerTable.setWidths(new float[]{1, 1}); 

        PdfPCell leftCell = new PdfPCell();
        leftCell.setBorder(Rectangle.NO_BORDER);

        Paragraph companySignature = new Paragraph("Potpis izdavaoca:", normalFont);
        leftCell.addElement(companySignature);

        java.net.URL signatureURL = PDFGenerator.class.getResource("signature.png");
        if (signatureURL != null) {
            Image signatureImage = Image.getInstance(signatureURL);
            signatureImage.scaleToFit(156, 80); 
            signatureImage.setIndentationLeft(30f);
            leftCell.addElement(signatureImage);
        } else {
            leftCell.addElement(new Paragraph("[Slika potpisa nije pronađena]", normalFont));
        }

        footerTable.addCell(leftCell);
        PdfPCell rightCell = new PdfPCell();
        rightCell.setBorder(Rectangle.NO_BORDER);
        rightCell.setPaddingTop(20f);
        Paragraph signatureLine = new Paragraph("_________________________", normalFont);
        signatureLine.setAlignment(Element.ALIGN_CENTER);
        rightCell.addElement(signatureLine);
        Paragraph buyerSignature = new Paragraph("Potpis kupca", normalFont);
        buyerSignature.setAlignment(Element.ALIGN_CENTER);
        rightCell.addElement(buyerSignature);

        footerTable.addCell(rightCell);

        document.add(footerTable);
        document.add(Chunk.NEWLINE);

        Paragraph thankYou = new Paragraph("Hvala na ukazanom poverenju!", boldFont);
        thankYou.setAlignment(Element.ALIGN_CENTER);
        document.add(thankYou);

        document.close();
        return file;
    }

    private static void addTableHeader(PdfPTable table, String headerTitle, BaseFont baseFont) {
        Font headerFont = new Font(baseFont, 12, Font.BOLD);
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.setPhrase(new Phrase(headerTitle, headerFont));
        table.addCell(header);
    }

}
