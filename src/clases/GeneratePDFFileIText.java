package clases;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class GeneratePDFFileIText {
	// Fonts definitions (Definici�n de fuentes).
	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

	private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
	private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public void createPDFCandidatos(File pdfNewFile, ArrayList<Candidato> candidatos) {

		// Creamos el documento e indicamos el nombre del fichero.
		try {
			Document document = new Document();
			try {

				PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

			} catch (FileNotFoundException fileNotFoundException) {
				System.out.println("(No se encontrado el fichero para generar el pdf)" + fileNotFoundException);
			}
			BDController controladorBD = new BDController();
			document.open();
			
			// Anadimos los metadatos del PDF
			document.addTitle("Listado de Candidatos");
			document.addSubject("Partido Humano (usando iText)");
			document.addKeywords("Java, PDF, iText");
			document.addAuthor("Jaime Casanueva");
			document.addCreator("Jaime Casanueva");

			// First page
			// Primera pagina 
			Chunk chunk = new Chunk("Partido Humano Candidatos", chapterFont);
			chunk.setBackground(BaseColor.WHITE);
			// Creamos el primer capitulo
			Chapter chapter = new Chapter(new Paragraph(chunk), 1);
			chapter.setNumberDepth(0);
			chapter.add(new Paragraph("Listado de Candidatos", paragraphFont));
			// A�adimos la imagen de la portada del documento
			Image image;
			
			
//����������������������������������������������������������������������������������������������������������������������������������������������������
//����������������������������������������������������������������������������������������������������������������������������������������������������
//			Aqui tienes que cambiar la ruta temporal del proyecto
			String Rutatemporalproyecto = "C:/Users/ivand/IdeaProjects/Ph/out/artifacts/Ph_war_exploded/";
			String Rutaproyecto=System.getProperty("user.dir");


			try {
				image = Image.getInstance("C:/Users/ivand/IdeaProjects/Ph/web/img/phe.jpg");
				//casa			image = Image.getInstance("C:/Users/pcmi/eclipse-workspace/BBDDJSPFIFA/WebContent/images/banner.jpg");
				image.setAbsolutePosition(-50, 100);
				image.setWidthPercentage(150);
				
				chapter.add(image);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  



			document.add(chapter);

			// Segunda pagina - Algunos elementos
			Chapter chapSecond = new Chapter(new Paragraph(new Anchor("Listado de Candidatos")),2);
			Paragraph paragraphS = new Paragraph("Partido humano", subcategoryFont);

			DottedLineSeparator dottedline = new DottedLineSeparator();
			dottedline.setOffset(-2);
			dottedline.setGap(2f);
			

			Section paragraphMoreS = chapSecond.addSection(paragraphS);
			
			// Usamos varios elementos para a�adir titulo y subtitulo
			Anchor anchor = new Anchor("", categoryFont);
			anchor.setName("");            
			Chapter chapTitle = new Chapter(new Paragraph(anchor), 1);
			Paragraph paragraph = new Paragraph("", subcategoryFont);
			Section paragraphMore = chapTitle.addSection(paragraph);
			
			Integer numColumns = 4;
			Integer numRows = candidatos.size();
			// Creamos la tabla.
			PdfPTable table = new PdfPTable(numColumns); 

			// Ahora llenamos la tabla del PDF
			PdfPCell columnHeader;
			//Rellenamos las cabeceras de la tabla).                
			//for (int column = 0; column < numColumns; column++) {
			columnHeader = new PdfPCell(new Phrase("Nombre"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(columnHeader);

			columnHeader = new PdfPCell(new Phrase("Apellidos"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(columnHeader);
			//         
			columnHeader = new PdfPCell(new Phrase("Municipio"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(columnHeader);

			columnHeader = new PdfPCell(new Phrase("Provincia"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(columnHeader);



			//}
			table.setHeaderRows(1);
			//Rellenamos las filas de la tabla.                



			Image fotoLiga;

			for (int row = 0; row < numRows; row++) {
				

				try {
					//fotoLiga = Image.getInstance("C:\\Users\\jcasanueva\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BBDDJSPFIFA\\images\\ligas\\"  + equipos.get(row).getCod_equipo() + ".png");
					fotoLiga = Image.getInstance(Rutatemporalproyecto+"admin-manager/assets/images/candidatos/" + candidatos.get(row).getCod()+ ".png");
					table.addCell(fotoLiga);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				table.addCell(candidatos.get(row).getNombre());
				table.addCell(candidatos.get(row).getMunicipio());
				table.addCell(candidatos.get(row).getProvincia());



			}
			// A�adimos la tabla)
			paragraphMore.add(table);
			// A�adimos el elemento con la tabla).
			document.add(chapTitle);

			document.close();
			System.out.println("Se ha generado la hoja PDF!");
		} catch (DocumentException documentException) {
			System.out.println("Se ha producido un error al generar un documento: " + documentException);
		}



	}



}
