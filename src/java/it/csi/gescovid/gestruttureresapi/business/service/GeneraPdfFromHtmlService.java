/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.business.service;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.io.source.ByteArrayOutputStream;

@Service
public class GeneraPdfFromHtmlService {
    
    public ByteArrayInputStream generaPdfFromHtml(String html) throws FileNotFoundException, IOException {
        
        Document document = Jsoup.parse(html, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream() ){
            ITextRenderer renderer = new ITextRenderer();
            org.xhtmlrenderer.layout.SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            renderer.setDocumentFromString(document.html());
            renderer.layout();
            renderer.createPDF(outputStream);
            
            return new ByteArrayInputStream(outputStream.toByteArray());

        }
        

    }

}
