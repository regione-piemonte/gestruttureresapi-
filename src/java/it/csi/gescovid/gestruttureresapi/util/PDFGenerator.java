/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.CovidrsaTRendicontazione;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.custom.ModelFascia;
import it.csi.gescovid.gestruttureresapi.business.be.impl.mapper.dto.extended.CovidrsaRStrutturaWelfareExt;

public class PDFGenerator {

    private static char checkBox_checked = '\u00FE';
    private static char checkBox_unchecked = '\u00A8';
    private static char EURO = '\u20AC';
    private static char APOSTROFO = '\u2019';
    private static char ACCENTO = '\u2019';
    private static char APICIDOPPISX = '\u201C';
    private static char APICIDOPPIDX = '\u201D';
    private static char SPECIALBAR = '\u2013';
    private static char POINT = '\u2022';

    private static Text createText(String text, Style style) {
        return createText(text, style, false);
    }

    private static Text createText(String text, Style style, boolean trimOverflow) {

        Text t = new Text("").addStyle(style);
        if (text != null && !text.isEmpty()) {
            t = new Text(text).addStyle(style);
        }

        if (trimOverflow && text != null && text.length() > 15) {
            // t.addStyle(new Style().setFontSize(7));
            // TODO
        }

        return t;
    }

    private static Cell createCell(int rowSpan, int colSpan) {
        return new Cell(rowSpan, colSpan).setPadding(0).setMargin(0).setBorder(Border.NO_BORDER);
    }

    public static void printDichiarazioneSostitutivaDiCertificazione(CovidrsaRStrutturaWelfareExt sw,
            Document doc) throws IOException {
        if (sw == null) {
            return;
        }
        // GENERAL SETTINGS
        Style regularStyle = getStyle(StandardFonts.TIMES_ROMAN, 12, 1);
        Style regularStyle8 = getStyle(StandardFonts.TIMES_ROMAN, 9, 1);
        Style regularStyle9 = getStyle(StandardFonts.TIMES_ROMAN, 9, 1);
        Style regularStyle11 = getStyle(StandardFonts.TIMES_ROMAN, 11, 1);
        Style regularStyle12 = getStyle(StandardFonts.TIMES_ROMAN, 11, 1);
        Style regularItalicStyle11 = getStyle(StandardFonts.TIMES_ITALIC, 11, 1);
        Style regularBoldStyleBlue = getStyle(StandardFonts.TIMES_BOLD, 12, 1, 68, 114, 196);
        Style boldStyleHead = getStyle(StandardFonts.TIMES_BOLD, 14, 1);
        Style boldItalicStyleHeadBlue = getStyle(StandardFonts.TIMES_BOLDITALIC, 14, 1, 68, 114, 196);
        Style wingDingFontForCheckBox = new Style()
                .setFont(PdfFontFactory.createFont("wingding.ttf", "Identity-H", true))
                .setFontSize(14)
                .setPadding(1).setFontColor(new DeviceRgb(68, 114, 196));
        Style regularStyleSubString6 = new Style().setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN))
                .setFontSize(6)
                .setPadding(1);

        Integer width = 6;
        Table tableForFooter = createTable(width);
        setCell(getSingleList("DICHIARAZIONE SOSTITUTIVA DI CERTIFICAZIONE", boldStyleHead),
                TextAlignment.CENTER, null, 10, tableForFooter, width);
        setCell(getSingleList("(Art. 46 DPR n. 445 del 28 dicembre 2000)", regularStyle),
                TextAlignment.CENTER, tableForFooter, width);
        setCell(getSingleList("DICHIARAZIONE SOSTITUTIVA DI ATTO DI NOTORIETA'", boldStyleHead),
                TextAlignment.CENTER, tableForFooter, width);
        setCell(getSingleList("(Art. 47 DPR n. 445 del 28 dicembre 2000)", regularStyle),
                TextAlignment.CENTER, tableForFooter, width);
        setCell(getSingleList(
                String.valueOf(APICIDOPPISX) + "SOSTEGNO ALL" + String.valueOf(APOSTROFO)
                        + "INSERIMENTO DI PERSONE NON AUTOSUFFICIENTI IN STRUTTURE RESIDENZIALI A CARATTERE SOCIO-SANITARIO O SOCIO-ASSISTENZIALE"
                        + String.valueOf(APICIDOPPIDX),
                regularBoldStyleBlue), TextAlignment.CENTER, 10, 10, 20, 20, tableForFooter, width);
        setCell(getSingleList("DOMANDA DI PARTECIPAZIONE", boldStyleHead), TextAlignment.CENTER, 10, 10, tableForFooter,
                width);
        setCell(getSingleList(
                "Il/la sottoscritto/a " + defIFNull(
                        getTextConcat(sw.getRapLegCognome(), " ", sw.getRapLegNome()),
                        "________________________________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "nato/a a "
                        + defIFNull(
                                getComuneProvincia(sw.getRapLegComuneNascita(),
                                        sw.getRapLegProvinciaNascita()),
                                "_______________________________________________")
                        + " il "
                        + defIFNull(format(sw.getRapLegDataNascita(), "dd/MM/yyyy"),
                                "__________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "residente a "
                        + defIFNull(
                                getComuneProvincia(sw.getRapLegComuneResidenza(),
                                        sw.getRapLegProvinciaResidenza()),
                                "______________________________________")
                        + " indirizzo " + defIFNull(sw.getRapLegIndirizzoResidenza(),
                                "_________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "domiciliato (in caso di domicilio diverso da residenza) a "
                        + defIFNull(
                                getComuneProvincia(sw.getRapLegComuneDomicilio(),
                                        sw.getRapLegProvinciaDomicilio()),
                                "__________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "indirizzo "
                        + defIFNull(sw.getRapLegIndirizzoDomicilio(),
                                "_______________________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "codice fiscale "
                        + defIFNull(sw.getRapLegCodiceFiscale(),
                                "_______________________________________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "Tel. cell. "
                        + defIFNull(sw.getRapLegCellulare(),
                                "__________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "Mail "
                        + defIFNull(sw.getRapLegEmail(),
                                "_______________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "IN QUALITA" + String.valueOf(ACCENTO) + " DI:", regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);

        setCell(Arrays.asList(
                createText(String.valueOf(sw.getTitEffCodiceFiscale() == null ? checkBox_checked : checkBox_unchecked),
                        wingDingFontForCheckBox),
                createText(" legale rappresentante e titolare effettivo;", regularStyle11)),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);

        setCell(Arrays.asList(
                createText(String.valueOf(sw.getTitEffCodiceFiscale() == null ? checkBox_unchecked : checkBox_checked),
                        wingDingFontForCheckBox),
                createText(" legale rappresentante non coincidente con il titolare effettivo", regularStyle11),
                createText("1", regularStyleSubString6).setTextRise(6)),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);

        setCell(getSingleList(
                "(in questo caso indicare dati anagrafici del titolare effettivo:", regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "nome e cognome " + defIFNull(
                        getTextConcat(sw.getTitEffNome(), " ", sw.getTitEffCognome()),
                        "___________________________________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "nato/a a "
                        + defIFNull(
                                getComuneProvincia(sw.getTitEffComuneNascita(),
                                        sw.getTitEffProvinciaNascita()),
                                "_______________________________________________")
                        + " il "
                        + defIFNull(format(sw.getTitEffDataNascita(), "dd/MM/yyyy"),
                                "_________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "residente a "
                        + defIFNull(
                                getComuneProvincia(sw.getTitEffComuneResidenza(),
                                        sw.getTitEffProvinciaResidenza()),
                                "______________________________________")
                        + " indirizzo " + defIFNull(sw.getTitEffIndirizzoResidenza(),
                                "_________________________")
                        + ")",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);

        setCell(getSingleList(
                "codice fiscale "
                        + defIFNull(sw.getTitEffCodiceFiscale(),
                                "_______________________________________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);

        setCell(getSingleList(
                "dell" + String.valueOf(APOSTROFO) + "Ente gestore", regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(defIFNull(sw.getEntGestRagioneSociale(),
                "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("denominazione",
                regularStyle9),
                TextAlignment.CENTER, null, 0, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                defIFNull(
                        getTextConcat(sw.getEntGestIndirizzo(), " ",
                                getComuneProvincia(sw.getEntGestComune(), sw.getEntGestProvincia())),
                        "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("indirizzo",
                regularStyle9),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(defIFNull(sw.getEntGestCfPiva(),
                "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("c.f. / P. IVA",
                regularStyle9),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "della struttura residenziale socio-assistenziale", regularStyle11),
                TextAlignment.JUSTIFIED, null, 20, 10, 10, tableForFooter, width);
        setCell(getSingleList(defIFNull(sw.getStrResNome(),
                "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("denominazione",
                regularStyle9),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(defIFNull(sw.getStrResTipologia(),
                "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("tipologia",
                regularStyle9),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                defIFNull(
                        getTextConcat(sw.getStrResIndirizzo(), " ",
                                getComuneProvincia(sw.getStrResComune(), sw.getStrResProvincia())),
                        "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("indirizzo",
                regularStyle9),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        lineSeparator(boldStyleHead, tableForFooter, width);

        setCell(getSingleList("presenta domanda di partecipazione alla misura", boldStyleHead),
                TextAlignment.CENTER, 10, null, tableForFooter,
                width);
        setCell(getSingleList(
                String.valueOf(APICIDOPPISX) + "SOSTEGNO ALL" + String.valueOf(APOSTROFO)
                        + "INSERIMENTO DI PERSONE NON AUTOSUFFICIENTI IN STRUTTURE RESIDENZIALI A CARATTERE SOCIO-SANITARIO O SOCIO-ASSISTENZIALE"
                        + String.valueOf(APICIDOPPIDX),
                boldStyleHead),
                TextAlignment.CENTER, null, null, tableForFooter,
                width);
        setCell(getSingleList(String.valueOf(APICIDOPPISX) + "BUONO RESIDENZIALITA" + String.valueOf(ACCENTO) + ""
                + String.valueOf(APICIDOPPIDX), boldStyleHead),
                TextAlignment.CENTER, null, 10, tableForFooter,
                width);

        setFooterCell(Arrays.asList(
                createText(
                        "1  Secondo il D.Lgs. n. 90 del 25 maggio 2017, emanato in attuazione della Direttiva UE 2015/849 e parte della normativa antiriciclaggio, il Titolare Effettivo � la persona fisica che realizza un"
                                + String.valueOf(APOSTROFO) + "operazione o un" + String.valueOf(APOSTROFO)
                                + "attivit� oppure, nel caso di entit� giuridica, chi come persona fisica, in ultima istanza, la possiede o controlla o ne � beneficiaria. ",
                        regularStyle8)),
                TextAlignment.LEFT, null, 20, 10, 10, tableForFooter, width);
        doc.add(tableForFooter);

        Table table = createTable(width);

        setFooterCell(Arrays.asList(
                createText(
                        "2 Per i destinatari non ancora inseriti in struttura al momento della presentazione della domanda, i 24 mesi di validit� del Buono decorrono dalla data di conferma dell"
                                + String.valueOf(APOSTROFO)
                                + "assegnazione del Buono (in prima battuta concesso in forma condizionata) da parte della Regione Piemonte, a fronte dell"
                                + String.valueOf(APOSTROFO)
                                + "effettiva finalizzazione dell" + String.valueOf(APOSTROFO)
                                + "inserimento entro il termine di 30 giorni.",
                        regularStyle8)),
                TextAlignment.LEFT, null, 20, 10, 10, table, width);
        setFooterCell(Arrays.asList(
                createText(
                        "3 A tale scopo, la struttura sar� tenuta - in sede di prima rendicontazione attraverso la piattaforma telematica dedicata � a produrre una copia dalla fattura emessa nel mese precedente a quello di inizio validit� del Buono. Come esplicitato al par. 7, lett. I), all"
                                + String.valueOf(APOSTROFO)
                                + "atto dell" + String.valueOf(APOSTROFO)
                                + "assegnazione del Buono da parte della Regione Piemonte non � soltanto il destinatario ad esserne informato � attraverso apposita comunicazione � ma anche la struttura presso la quale questi � inserito.",
                        regularStyle8)),
                TextAlignment.LEFT, null, null, 10, 10, table, width);

        setCell(getSingleList(
                "A tal fine,", regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        setCell(getSingleList(
                "consapevole delle sanzioni penali richiamate dall" + String.valueOf(APOSTROFO)
                        + "art. 76 del D.P.R. 445/2000",
                regularItalicStyle11),
                TextAlignment.CENTER, null, null, 10, 10, table, width);
        setCell(getSingleList(
                "nel caso di dichiarazioni non veritiere e falsit� in atti con riferimento a quanto dichiarato",
                regularItalicStyle11),
                TextAlignment.CENTER, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        setCell(getSingleList("DICHIARA DI:", boldStyleHead),
                TextAlignment.CENTER, 10, 10, table,
                width);

        setCell(getSingleList("A)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, table,
                width);
        setCell(getSingleList(
                "prendere atto delle condizioni e delle modalit� di fruizione del " + String.valueOf(APICIDOPPISX)
                        + "Buono residenzialit�" + String.valueOf(APICIDOPPIDX) + " indicate nell"
                        + String.valueOf(APOSTROFO) + "Avviso pubblico pubblicato sul sito della Regione Piemonte.",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        lineSeparator(regularStyle11, table, width);

        setCell(getSingleList("B)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, table,
                width);
        setCell(getSingleList(
                "aderire alla misura valida per l" + String.valueOf(APICIDOPPISX) + "intero periodo di percezione del "
                        + String.valueOf(APICIDOPPISX) + "Buono" + String.valueOf(APICIDOPPIDX)
                        + " da parte dei propri utenti;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        lineSeparator(regularStyle11, table, width);

        setCell(getSingleList("C)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, table,
                width);
        setCell(Arrays.asList(
                createText(
                        "applicare nei confronti degli utenti della struttura destinatari del "
                                + String.valueOf(APICIDOPPISX) + "Buono" + String.valueOf(APICIDOPPIDX)
                                + "una riduzione della quota sociale (di cui si compone, insieme alla quota sanitaria, la retta mensile) per un importo pari a 600 euro e per un massimo di 24 mesi, con decorrenza dal primo mese successivo a quello in cui l"
                                + String.valueOf(APOSTROFO)
                                + "utente (e la struttura) ha ricevuto comunicazione di assegnazione del Buono",
                        regularStyle11),
                createText("2", regularStyleSubString6).setTextRise(6),
                createText(
                        ". Di tale riduzione la struttura dovr� fornire evidenza nella fatturazione emessa, attraverso l�indicazione in causale della dicitura "
                                + String.valueOf(APICIDOPPISX) + "Valore Buono residenzialit� regionale FSE+: - "
                                + String.valueOf(EURO) + " 600,00" + String.valueOf(APICIDOPPIDX) + ";",
                        regularStyle11)),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        lineSeparator(regularStyle11, table, width);

        setCell(getSingleList("D)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, table,
                width);
        setCell(Arrays.asList(
                createText(
                        "mantenere inalterata la tariffa mensile applicata nei confronti dei soggetti gi� utenti della struttura al momento della presentazione della domanda di concessione del contributo e divenuti assegnatari del Buono Residenzialit�, a parit� di servizi offerti e di intensit� assistenziale, applicando al proprio ospite divenuto assegnatario del Buono la tariffa mensile applicata nell"
                                + String.valueOf(APOSTROFO)
                                + "ultima fattura emessa nel mese precedente a quello di inizio validit� del Buono",
                        regularStyle11),
                createText("3", regularStyleSubString6).setTextRise(6),
                createText(
                        " (tariffa comunque non eccedente i limiti previsti dalla D.G.R. n. 85-6287 del 2 agosto 2013, come aggiornata dalla D.G.R. 7 Settembre 2022, n. 1-5575), alla quale per 24 mesi dovr� apportare una riduzione d�importo pari a 600 euro;",
                        regularStyle11)),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        lineSeparator(regularStyle11, table, width);

        setCell(getSingleList("E)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, table,
                width);
        setCell(getSingleList(
                "applicare la seguente tariffa mensile in favore di nuovi utenti destinatari del "
                        + String.valueOf(APICIDOPPISX) + "Buono" + String.valueOf(APICIDOPPIDX)
                        + ", comprensiva del valore del voucher, differenziata per fasce di intensit� assistenziale (non eccedente i limiti previsti dalla D.G.R. n. 85-6287 del 2 agosto 2013, come aggiornata dalla D.G.R. 7 Settembre 2022, n. 1-5575):",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        com.itextpdf.layout.element.List list = new com.itextpdf.layout.element.List();
        // Adding contents to the list
        BigDecimal bassa = null;
        BigDecimal media = null;
        BigDecimal alta = null;
        if (sw.getFascia() != null) {
            for (ModelFascia fasce : sw.getFascia()) {
                if (fasce.getWelfareFasciaCod().equals("1")) {
                    bassa = fasce.getTariffaMensileMassima();
                } else if (fasce.getWelfareFasciaCod().equals("2")) {
                    media = fasce.getTariffaMensileMassima();
                } else if (fasce.getWelfareFasciaCod().equals("3")) {
                    alta = fasce.getTariffaMensileMassima();
                }
            }
        }

        list.add(new ListItem("bassa / medio-bassa:           " + defIFNull(bassa,
                "_______________") + " " + String.valueOf(EURO)));
        list.add(new ListItem("media / media-alta:            " + defIFNull(media,
                "_______________") + " " + String.valueOf(EURO)));
        list.add(new ListItem("alta / alta incrementale:      " + defIFNull(alta,
                "_______________") + " " + String.valueOf(EURO)));
        list.addStyle(regularStyle11);
        setCell(list,
                TextAlignment.JUSTIFIED, null, null, 20, 10, table, width);
        setCell(getSingleList(
                "e di prendere atto che:",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        setCell(getSingleList(
                "- tale tariffa viene indicata sul sito " + String.valueOf(APICIDOPPISX)
                        + "Scelta sociale" + String.valueOf(APICIDOPPIDX)
                        + "� e resa visibile agli interessati, per ragioni di trasparenza e di tutela della concorrenza tra le strutture;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        setCell(getSingleList(
                "- modifiche alle tariffe iniziali potranno essere apportate nel corso dei 24 mesi di percezione del Buono esclusivamente per effetto di una variazione del livello d"
                        + String.valueOf(APOSTROFO)
                        + "intensit� assistenziale, di adeguamenti delle tariffe da parte della Regione Piemonte o in ragione dell"
                        + String.valueOf(APOSTROFO)
                        + "erogazione di servizi ulteriori rispetto a quelli inizialmente richiesti dall"
                        + String.valueOf(APOSTROFO) + "utente;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);

        lineSeparator(regularStyle11, table, width);
        lineSeparator(regularStyle11, table, width);

        setCell(getSingleList("F)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, table,
                width);
        setCell(getSingleList(
                "trasmettere trimestralmente, attraverso il portale telematico dedicato, la documentazione giustificativa comprovante l"
                        + String.valueOf(APOSTROFO)
                        + "applicazione del Buono - sulla base della delega iniziale rilasciata dal richiedente in fase di presentazione della domanda.",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        lineSeparator(regularStyle11, table, width);

        setCell(getSingleList("G)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, table,
                width);
        setCell(getSingleList(
                "accettare che:",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        setCell(getSingleList(
                "- l" + String.valueOf(APOSTROFO)
                        + "erogazione periodica del Buono venga effettuata da parte di Finpiemonte S.p.A   su base trimestrale a seguito della verifica e della validazione da parte di Finpiemonte della rendicontazione presentata;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        setCell(getSingleList(
                "- la mancata validazione della rendicontazione da parte di Finpiemonte S.p.A., dovuta all"
                        + String.valueOf(APOSTROFO)
                        + "incompletezza o all" + String.valueOf(APOSTROFO)
                        + "inadeguatezza della documentazione prodotta (cui la struttura non abbia posto rimedio entro i termini previsti) o all"
                        + String.valueOf(APOSTROFO)
                        + "individuazione di dati tariffari difformi rispetto a quanto dichiarato dalla struttura al momento dell"
                        + String.valueOf(APOSTROFO)
                        + "adesione alla misura determina la mancata erogazione del controvalore economico del Buono, senza possibilit� di rivalsa sul destinatario;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        lineSeparator(regularStyle11, table, width);

        setCell(getSingleList("H)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, table,
                width);
        setCell(getSingleList(
                "comunicare tempestivamente i seguenti cambiamenti che dovessero prodursi in capo al destinatario (cause di inammissibilit� alla fruizione del buono):",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        setCell(getSingleList(
                "- ammissione alla percezione di un contributo incompatibile con il Buono Residenzialit�: nel caso, per esempio, in cui un proprio ospite � residente in struttura in regime privatistico e assegnatario del Buono Residenzialit� � venga ammesso a beneficiare del convenzionamento con il Sistema Sanitario Regionale, la struttura � tenuta a comunicarlo tempestivamente alla Regione Piemonte;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        setCell(getSingleList(
                "- cessazione definitiva dell" + String.valueOf(APOSTROFO) + "inserimento presso la struttura;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        setCell(getSingleList(
                "nonch� ogni altro cambiamento che dovesse prodursi in merito alla rappresentanza legale ed alla titolarit� effettiva della struttura;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
        lineSeparator(regularStyle11, table, width);
        lineSeparator(regularStyle11, table, width);
        doc.add(table);

        Table tableForFooter2 = createTable(width);

        setCell(getSingleList("I)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter2,
                width);
        setCell(getSingleList(
                "comunicare settimanalmente i dati relativi alla struttura richiesti tramite la piattaforma informatica regionale "
                        + String.valueOf(APICIDOPPISX) + "COVID-19 " + String.valueOf(SPECIALBAR) + " Gestione RSA"
                        + String.valueOf(APICIDOPPIDX) + " in misura non inferiore al 75% nelle ultime otto settimane;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);

        setCell(getSingleList("J)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter2,
                width);
        setCell(getSingleList(
                "rispettare gli obblighi informativi e di comunicazione previsti dagli artt. 49 e 50 del Regolamento UE 2021/1060 e, in particolare: informare il pubblico sul sostegno ottenuto dai fondi pubblicando sul proprio sito web, ove esista, sugli account dei social media, su ogni altra iniziativa di promozione nonch� sulle fatture emesse la dicitura \"Il Buono Residenzialit� � reso possibile grazie al sostegno del Fondo Sociale Europeo Plus della Regione Piemonte\"",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        setCell(getSingleList("K)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter2,
                width);
        setCell(getSingleList(
                "acconsentire ai controlli sugli aspetti amministrativi, finanziari, tecnici e fisici delle operazioni saranno, incluse verifiche in loco/in itinere, nel rispetto di quanto previsto dalle vigenti "
                        + String.valueOf(APICIDOPPISX) + "Linee guida per la gestione e il controllo delle operazioni"
                        + String.valueOf(APICIDOPPIDX) + " finanziate dal POR FSE + Regione-Piemonte 2021-2027;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter2, width);

        lineSeparator(regularStyle11, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        setCell(getSingleList("L)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter2,
                width);
        setCell(getSingleList(
                "conservare, per un periodo di 10 anni, i documenti giustificativi sotto forma di originali o di copie autenticate, o su supporti per i dati comunemente accettati, comprese le versioni elettroniche di documenti originali o i documenti esistenti esclusivamente in versione elettronica. Tale documentazione dovr� essere esibita in sede di controllo in itinere o successivo eseguito dal personale abilitato incaricato dalla Regione Piemonte;",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        setCell(getSingleList("M)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter2,
                width);

        setCell(Arrays.asList(createText(
                "utilizzare in ogni documento/strumento/materiale/prodotto di comunicazione il blocco dei loghi obbligatori, secondo apposite Linee guida definite dal Responsabile nazionale per la comunicazione del Fondo FSE+ nazionale e dalla Regione Piemonte",
                regularStyle11),
                createText("4", regularStyleSubString6).setTextRise(6),
                createText(".", regularStyle11)),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        setCell(getSingleList("N)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter2,
                width);
        setCell(getSingleList(
                "apporre sul proprio sito istituzionale e sugli altri strumenti di comunicazione a disposizione la seguente dicitura: "
                        + String.valueOf(APICIDOPPISX) + "la struttura aderisce alla misura regionale "
                        + String.valueOf(APICIDOPPISX) + "buono residenzialit�" + String.valueOf(APICIDOPPIDX)
                        + " finanziata con fondi FSE Plus 21-27" + String.valueOf(APICIDOPPIDX) + ";",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        setCell(getSingleList("O)", boldStyleHead),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter2,
                width);
        setCell(getSingleList(
                "rispettare i contratti collettivi nazionali di lavoro sottoscritti dalle parti datoriali e sindacali maggiormente rappresentative a livello nazionale dei lavoratori dipendenti o prestatori d�opera e delle leggi che regolamentano i rapporti di lavoro.",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        lineSeparator(regularStyle11, tableForFooter2, width);
        setCell(getSingleList(
                "Nel caso di mancato rispetto di uno degli impegni presi sopra indicati � prevista la sospensione dall"
                        + String.valueOf(APOSTROFO) + "elenco delle strutture partecipanti; tale sospensione comporta l"
                        + String.valueOf(APOSTROFO)
                        + "impossibilit� di utilizzare i " + String.valueOf(APICIDOPPISX)
                        + "buoni" + String.valueOf(APICIDOPPIDX)
                        + " in favore di ulteriori destinatari ospiti delle strutture per una durata prevista da un minimo di due mesi fino ad un massimo coincidente con la durata complessiva.",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter2, width);

        doc.add(tableForFooter2);
        Table tableForFooter3 = createTable(width);
        setCell(getSingleList(
                "Sono fatte salve eventuali, ulteriori conseguenze in caso di accertamento di gravi inadempimenti.",
                regularStyle12),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        setCell(getSingleList(
                "Documento firmato digitalmente",
                regularStyle11),
                TextAlignment.RIGHT, null, null, 10, 30, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);
        lineSeparator(regularStyle11, tableForFooter3, width);

        setFooterCell(Arrays.asList(
                createText(
                        "4 Il blocco dei loghi gi� composto pu� essere scaricato dal sito regionale, nella sezione dedicata alla Programmazione FSE+ 2021-2027, all"
                                + String.valueOf(APOSTROFO)
                                + "indirizzo: https://www.regione.piemonte.it/loghi/loghi.shtml. In caso di mancato rispetto degli obblighi sono previste sanzioni in capo ai soggetti inadempienti, come stabilito dal comma 3 dell"
                                + String.valueOf(APOSTROFO) + "art. 50.",
                        regularStyle8)),
                TextAlignment.LEFT, null, 100, 10, 10, tableForFooter3, width);
        tableForFooter3.setSkipLastFooter(false);
        doc.add(tableForFooter3);

        doc.add(new AreaBreak());

        Table table2 = createTable(width);
        setCell(getSingleList(
                "Informativa sul trattamento dei dati personali rilasciata ai sensi dell" + String.valueOf(APOSTROFO)
                        + "art. 13 G.D.P.R. 2016/679.",
                boldItalicStyleHeadBlue),
                TextAlignment.CENTER, null, 10, table2, width);
        setCell(getSingleList(
                "La informiamo che i dati personali forniti alla Regione Piemonte e riferiti ai legali rappresentanti delle Strutture e/o ai loro incaricati saranno trattati secondo quanto previsto dal "
                        + String.valueOf(APICIDOPPISX)
                        + "Regolamento UE 2016/679 relativo alla protezione delle persone fisiche con riguardo al trattamento dei dati personali, nonch� alla libera circolazione di tali dati"
                        + String.valueOf(APICIDOPPIDX)
                        + " e che abroga la direttiva 95/46/CE (regolamento Generale sulla Protezione dei dati, di seguito GDPR).",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        setCell(getSingleList(
                "La informiamo, inoltre, che:",
                regularStyle11),
                TextAlignment.JUSTIFIED, 20, 20, 10, 10, table2, width, true);
        com.itextpdf.layout.element.List list2 = new com.itextpdf.layout.element.List();
        // Adding contents to the list
        list2.add(new ListItem(
                "I dati personali a Lei riferiti verranno raccolti e trattati nel rispetto dei principi di correttezza, liceit� e tutela della riservatezza, con modalit� informatiche ed esclusivamente per finalit� di trattamento dei dati personali dichiarati nella domanda e comunicati agli uffici regionali o alle amministrazioni individuate come competenti a valutarla. Il trattamento � finalizzato all"
                        + String.valueOf(APOSTROFO)
                        + "espletamento delle funzioni istituzionali definite dal Regolamento (UE) 2021/1057 del Parlamento europeo e del Consiglio del 24 giugno 2021 che ha istituito il Fondo sociale europeo Plus, dalla D.G.R. n. 2-4852 del 08.4.2022 di approvazione della proposta di Programma Regionale Fondo Sociale Europeo Plus della Regione Piemonte 2021-2027, dalla Decisione di esecuzione della Commissione Europea C(2022)5299 del 18.7.2022 di approvazione del programma "
                        + String.valueOf(APICIDOPPISX)
                        + "PR Piemonte FSE+ 2021/2027 e dalla D.G.R. n. 4-5458 del 03.8.2022 di recepimento del Programma FSE+ 2021/2027 della Regione Piemonte, approvato dalla Commissione Europea con la succitata Decisione."));
        list2.add(new ListItem(
                "I dati acquisiti a seguito della presente informativa saranno utilizzati esclusivamente per l"
                        + String.valueOf(APOSTROFO)
                        + "adesione alla misura da parte delle Strutture secondo le modalit� previste dall"
                        + String.valueOf(APOSTROFO)
                        + "avviso pubblico in oggetto. Tali dati potranno essere dati anagrafici, identificativi, economici, sociali, e verranno trattati in modalit� manuale e/o digitale."));
        list2.add(new ListItem(
                "Il conferimento dei Suoi dati ed il relativo trattamento sono obbligatori in relazione alle finalit� sopra descritte; ne consegue che l"
                        + String.valueOf(APOSTROFO) + "eventuale rifiuto a fornirli impedir� l"
                        + String.valueOf(APOSTROFO) + "erogazione del servizio richiesto."));

        list2.addStyle(regularStyle11);
        list2.setListSymbol(String.valueOf(POINT));
        setCell(list2,
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        com.itextpdf.layout.element.List list3 = new com.itextpdf.layout.element.List();

        ListItem subListItem = new ListItem(
                "I dati di contatto del Responsabile della protezione dati (D.P.O.) sono: dpo@regione.piemonte.it;");
        Paragraph subParagraph = new Paragraph().setTextAlignment(TextAlignment.JUSTIFIED).add(
                "Titolare del trattamento dei dati personali � la Giunta regionale. Per la misura in oggetto sono delegati al trattamento dei dati:");
        subListItem.add(subParagraph);
        com.itextpdf.layout.element.List subList = new com.itextpdf.layout.element.List();
        subList.add(new ListItem(
                "il Dirigente " + String.valueOf(APICIDOPPISX) + "pro tempore" + String.valueOf(APICIDOPPIDX)
                        + " della Settore A1420B - Politiche per le pari opportunit�, diritti ed inclusione, progettazione ed innovazione sociale della Direzione Sanit� e Welfare;"));
        subList.add(new ListItem("il Direttore " + String.valueOf(APICIDOPPISX) + "pro tempore"
                + String.valueOf(APICIDOPPIDX) + " della Direzione A15 Istruzione Formazione e Lavoro."));
        subList.addStyle(regularStyle11);
        subListItem.add(subList);
        list3.add(subListItem);

        ListItem subListItem2 = new ListItem("Il Responsabile (esterno) del trattamento �:");
        com.itextpdf.layout.element.List subList2 = new com.itextpdf.layout.element.List();
        subList2.add(new ListItem(
                "il Consorzio per il Sistema Informativo Piemonte (CSI), ente strumentale della Regione Piemonte, pec: protocollo@cert.csi.i"));
        subList2.add(new ListItem("Finpiemonte S.P.A., Organismo Intermedio " + String.valueOf(SPECIALBAR)
                + " P.E.C.: finpiemonte@legalmail.it;"));
        subList2.add(new ListItem(
                "Enti gestori delle funzioni socio-assistenziali " + String.valueOf(SPECIALBAR)
                        + " indirizzi diversi (https://www.regione.piemonte.it/web/sites/default/files/media/documenti/202210/ Pubblicazione_2022_Servizi_Sociali_APPENDICE_1_INDIRIZZARIO.pdf)"));
        subList2.addStyle(regularStyle11);
        subListItem2.add(subList2);
        list3.add(subListItem2);
        list3.addStyle(regularStyle11);
        list3.setListSymbol(String.valueOf(POINT));
        setCell(list3,
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        com.itextpdf.layout.element.List list4 = new com.itextpdf.layout.element.List();

        list4.add(new ListItem(
                "I dati personali saranno trattati esclusivamente da soggetti incaricati e Responsabili (esterni) individuati dal Titolare o da soggetti incaricati individuati dal Responsabile (esterno), autorizzati ed istruiti in tal senso, adottando tutte le misure tecniche ed organizzative adeguate per tutelare i diritti, le libert� e i legittimi interessi che Le sono riconosciuti per legge in qualit� di Interessato."));
        list4.add(new ListItem(
                "I Suoi dati, resi anonimi, potranno essere utilizzati anche per finalit� statistiche (D. Lgs. 281/1999 e s.m.i.);"));
        list4.add(new ListItem(
                "I Suoi dati personali sono conservati per un periodo di 15 anni a partire dalla chiusura delle attivit� connesse con l"
                        + String.valueOf(APOSTROFO) + "Avviso pubblico, come previsto dal piano di fascicolazione dell"
                        + String.valueOf(APOSTROFO) + "Ente."));
        list4.add(new ListItem(
                "I Suoi dati personali non saranno in alcun modo oggetto di trasferimento in un Paese terzo extraeuropeo, n� di comunicazione a terzi fuori dai casi previsti dalla normativa in vigore, n� di processi decisionali automatizzati compresa la profilazione."));

        list4.addStyle(regularStyle11);
        list4.setListSymbol(String.valueOf(POINT));
        setCell(list4,
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        com.itextpdf.layout.element.List list5 = new com.itextpdf.layout.element.List();

        list5.add(new ListItem(
                "Salve le ipotesi di pubblicazione sul sito istituzionale in adempimento degli obblighi di pubblicit� legale e trasparenza, i suoi dati personali non saranno soggetti a diffusione."));

        ListItem subListItem3 = new ListItem("I suoi dati personali potranno essere comunicati a:");
        com.itextpdf.layout.element.List subList3 = new com.itextpdf.layout.element.List();
        subList3.add(new ListItem(
                "Altre Direzioni/Settori della Regione Piemonte per gli adempimenti di legge o per lo svolgimento delle attivit� istituzionali di competenza;"));
        subList3.add(new ListItem("Autorit� di Audit e Autorit� Contabile del Programma FSE+ della Regione Piemonte;"));
        subList3.add(new ListItem(
                "Soggetti/autorit� nei confronti dei quali la comunicazione e/o l" + String.valueOf(APOSTROFO)
                        + "eventuale diffusione sia prevista da disposizione di legge, da regolamenti o dalla normativa comunitaria;"));
        subList3.add(new ListItem(
                "Soggetti pubblici e organi di controllo in attuazione delle proprie funzioni previste per legge e per lo svolgimento delle loro funzioni istituzionali quali Commissione europea ed altri Enti e/o autorit� con finalit� ispettive, contabile-amministrative e di verifica;"));
        subList3.add(new ListItem(
                "Soggetti privati richiedenti l" + String.valueOf(APOSTROFO)
                        + "accesso documentale (art. 22 ss. L. 241/1990) o l" + String.valueOf(APOSTROFO)
                        + "accesso civico (art. 5 D.Lgs. 33/2013), nei limiti e con le modalit� previste dalla legge."));
        subList3.addStyle(regularStyle11);
        subListItem3.add(subList3);
        list5.add(subListItem3);

        list5.addStyle(regularStyle11);
        list5.setListSymbol(String.valueOf(POINT));
        setCell(list5,
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        setCell(getSingleList(
                "Ai sensi dell" + String.valueOf(APOSTROFO)
                        + "articolo 74, paragrafo 1, lettera c) del Regolamento (UE) 2021/1060 i dati contenuti nelle banche dati a disposizione della Commissione Europea saranno utilizzati attraverso l"
                        + String.valueOf(APOSTROFO) + "applicativo informatico ARACHNE, fornito all"
                        + String.valueOf(APOSTROFO) + "Autorit� di Gestione dalla Commissione Europea, per l"
                        + String.valueOf(APOSTROFO) + "individuazione degli indicatori di rischio di frode.",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        lineSeparator(regularStyle11, table2, width);
        lineSeparator(regularStyle11, table2, width);
        setCell(getSingleList(
                "Diritti dell" + String.valueOf(APOSTROFO) + "interessato:",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        setCell(getSingleList(
                "In ogni momento, Lei potr� esercitare, ai sensi degli articoli dal 15 al 22 del Regolamento UE n. 2016/679, il diritto di a) chiedere la conferma dell"
                        + String.valueOf(APOSTROFO)
                        + "esistenza o meno di propri dati personali e la loro messa a disposizione in forma intellegibile; ottenere le indicazioni circa le finalit� del trattamento, le categorie dei dati personali, i destinatari o le categorie di destinatari a cui i dati personali sono stati o saranno comunicati e, quando possibile, il periodo di conservazione; ottenere l"
                        + String.valueOf(APOSTROFO)
                        + "aggiornamento, la rettifica, la cancellazione dei dati, la trasformazione in forma anonima, la limitazione o il blocco dei dati trattati in violazione di legge; ottenere l"
                        + String.valueOf(APOSTROFO)
                        + "integrazione dei dati se vi � interesse; opporsi per motivi legittimi al trattamento stesso.",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        setCell(getSingleList(
                "Ha inoltre il diritto di proporre reclamo, esercitabile ricorrendo al Titolare o ai delegati al trattamento ovvero al Responsabile Protezione Dati (D.P.O. della Regione Piemonte: dpo@regione.piemonte.it, Piazza Castello 165, 10121 Torino.).",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        setCell(getSingleList(
                "In ultima istanza, oltre alle tutele previste in sede amministrativa o giurisdizionale, � ammesso comunque il reclamo all"
                        + String.valueOf(APOSTROFO)
                        + "Autorit� Garante per la protezione dei dati personali (garante@gpdp.it), nel caso si ritenga che il trattamento avvenga in violazione del Regolamento citato (art. 77 del Regolamento).",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table2, width);
        doc.add(table2);
    }

    public static void printDichiarazioneRendicontazione(CovidrsaRStrutturaWelfareExt sw, CovidrsaTRendicontazione rend,
            Soggetto soggetto,
            Document doc) throws IOException {
        if (sw == null) {
            return;
        }
        // GENERAL SETTINGS
        Style regularStyle8 = getStyle(StandardFonts.TIMES_ROMAN, 9, 1);
        Style regularStyle9 = getStyle(StandardFonts.TIMES_ROMAN, 9, 1);
        Style regularStyle11 = getStyle(StandardFonts.TIMES_ROMAN, 11, 1);
        Style boldStyleHead = getStyle(StandardFonts.TIMES_BOLD, 14, 1);

        Integer width = 6;
        Table tableForFooter = createTable(width);
        setCell(getSingleList("DICHIARAZIONE RENDICONTAZIONE", boldStyleHead),
                TextAlignment.CENTER, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "Il/la sottoscritto/a " + defIFNull(
                        getTextConcat(sw.getRapLegCognome(), " ", sw.getRapLegNome()),
                        "________________________________________________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "nato/a a "
                        + defIFNull(
                                getComuneProvincia(sw.getRapLegComuneNascita(),
                                        sw.getRapLegProvinciaNascita()),
                                "_______________________________________________")
                        + " il "
                        + defIFNull(format(sw.getRapLegDataNascita(), "dd/MM/yyyy"),
                                "__________________________"),
                regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, tableForFooter, width);

        setCell(getSingleList(
                "IN QUALITA" + String.valueOf(ACCENTO) + " DI:", regularStyle11),
                TextAlignment.CENTER, 10, 10, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "Legale rappresentante dell" + String.valueOf(ACCENTO) + "Ente/societ�", regularStyle11),
                TextAlignment.JUSTIFIED, null, 10, 10, 10, tableForFooter, width);
        setCell(getSingleList(defIFNull(sw.getEntGestRagioneSociale(),
                "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("denominazione",
                regularStyle9),
                TextAlignment.CENTER, null, 0, 10, 10, tableForFooter, width);
        setCell(getSingleList(defIFNull(sw.getEntGestCfPiva(),
                "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("c.f. / P. IVA",
                regularStyle9),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(
                "Gestore della struttura residenziale socio-assistenziale / socio-sanitaria", regularStyle11),
                TextAlignment.JUSTIFIED, null, 20, 10, 10, tableForFooter, width);
        setCell(getSingleList(defIFNull(sw.getStrResNome(),
                "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("denominazione",
                regularStyle9),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList(defIFNull(sw.getStrResTipologia(),
                "_______________________________________________________________________________________"),
                regularStyle11),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("tipologia",
                regularStyle9),
                TextAlignment.CENTER, null, null, 10, 10, tableForFooter, width);
        lineSeparator(boldStyleHead, tableForFooter, width);

        setCell(getSingleList("Consapevole delle sanzioni penali, nel caso di dichiarazioni non "
                + "veritiere e falsit� negli atti, richiamate dagli artt. 46, 47, 71, 75, 76 del D.P.R. 445 del 28/12/2000.",
                regularStyle8),
                TextAlignment.LEFT, 10, null, tableForFooter,
                width);

        setCell(getSingleList("DICHIARA",
                boldStyleHead),
                TextAlignment.CENTER, null, 10, tableForFooter,
                width);
        lineSeparator(boldStyleHead, tableForFooter, width);
        com.itextpdf.layout.element.List list3 = new com.itextpdf.layout.element.List();

        SimpleDateFormat month = new SimpleDateFormat("MMMM", Locale.ITALY);
        Calendar cal = Calendar.getInstance();
        cal.setTime(rend.getDataRendicontazione());

        ListItem subListItem3 = new ListItem(" Che " + soggetto.getNome() + " "
                + soggetto.getCognome() + " destinatario di " + String.valueOf(APICIDOPPISX)
                + "buono residenzialit�" + String.valueOf(APICIDOPPIDX)
                + " risulta essere stato ospite della struttura nel periodo dal 1 al " + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + " " + month.format(rend.getDataRendicontazione()) +" con la seguente movimentazione:");
        com.itextpdf.layout.element.List subList3 = new com.itextpdf.layout.element.List();
        subList3.add(new ListItem(
                "Uscita per l�ospedale �  il giorno 7 Luglio e Rientro il 12 Luglio."));
        
        subList3.addStyle(regularStyle11);
        subList3.setListSymbol(String.valueOf(""));
        subListItem3.add(subList3);
        list3.add(subListItem3);
        list3.add(new ListItem(
                " Che permangono i requisiti per il percepimento del " + String.valueOf(APICIDOPPISX) + "buono"
                        + String.valueOf(APICIDOPPIDX) + " per il periodo indicato."));

        list3.addStyle(regularStyle11);
        list3.setListSymbol(String.valueOf("- "));
        
        setCell(list3,
                TextAlignment.JUSTIFIED, null, 10, 10, 10, tableForFooter, width);

        setCell(getSingleList(
                "Inoltre", regularStyle11),
                TextAlignment.JUSTIFIED, null, 10, 10, 10, tableForFooter, width);
        setCell(getSingleList("DICHIARA",
                boldStyleHead),
                TextAlignment.CENTER, null, null, tableForFooter,
                width);
        lineSeparator(boldStyleHead, tableForFooter, width);
        com.itextpdf.layout.element.List list4 = new com.itextpdf.layout.element.List();

        list4.add(new ListItem(
                "Di avere applicato il controvalore economico del " + String.valueOf(APICIDOPPISX) + "buono"
                        + String.valueOf(APICIDOPPIDX) + " pari a " + String.valueOf(EURO)
                        + " 600,00 per il periodo indicato."));
        list4.add(new ListItem(
                "Di avere allegato sulla procedura telematica la documentazione attestante l"
                        + String.valueOf(APOSTROFO)
                        + "applicazione di tale controvalore � che la documentazione allegata risulta conforme all"
                        + String.valueOf(APOSTROFO) + "originale conservato presso i propri uffici."));
        list4.add(new ListItem(
                "Di avere rispettato le condizioni e le modalit� di fruizione del " + String.valueOf(APICIDOPPISX)
                        + "Buono residenzialit�" + String.valueOf(APICIDOPPIDX) + "."));

        list4.addStyle(regularStyle11);
        list4.setListSymbol(String.valueOf("- "));
        setCell(list4,
                TextAlignment.JUSTIFIED, null, 10, 10, 10, tableForFooter, width);

        setCell(getSingleList("CHIEDE",
                boldStyleHead),
                TextAlignment.CENTER, null, 10, tableForFooter,
                width);
        SimpleDateFormat monthDate = new SimpleDateFormat("MMMM yyyy", Locale.ITALY);
        setCell(getSingleList(
                "La liquidazione dell" + String.valueOf(APOSTROFO) + "importo di " + String.valueOf(EURO)
                        + " 600,00 con riferimento al mese di " + monthDate.format(rend.getDataRendicontazione()) + ".",
                regularStyle11),
                TextAlignment.JUSTIFIED, null, 20, 10, 10, tableForFooter, width);

        setCell(getSingleList(
                "IL LEGALE RAPPRESENTANTE", regularStyle11),
                TextAlignment.LEFT, null, 20, 10, 10, tableForFooter, width);
        setCell(getSingleList("____________________________",
                regularStyle11),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter, width);
        setCell(getSingleList("  (Firmato digitalmente)",
                regularStyle11),
                TextAlignment.LEFT, null, null, 10, 10, tableForFooter, width);
        doc.add(tableForFooter);

    }

    /**
     * @param regularStyle11
     * @param table
     * @param width
     */
    private static void lineSeparator(Style regularStyle11, Table table, Integer width) {
        setCell(getSingleList(
                "", regularStyle11),
                TextAlignment.JUSTIFIED, null, null, 10, 10, table, width);
    }

    /**
     * @param boldStyleHead
     * @param value
     * @return
     */
    private static java.util.List<Text> getSingleList(String value, Style boldStyleHead) {
        return Arrays.asList(createText(value, boldStyleHead));
    }

    private static String getTextConcat(String text1, String divisor, String text2) {
        if (text1 != null && text2 != null) {
            return text1 + divisor + text2;
        }
        return null;
    }

    private static String getComuneProvincia(String comune, String provincia) {
        if (comune != null && provincia != null) {
            return comune + " (" + provincia + ")";
        }
        return null;
    }

    private static String format(Date rapLegDataNascita, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        if (rapLegDataNascita != null) {
            return formatter.format(rapLegDataNascita);
        }
        return null;
    }

    private static String defIFNull(String value, String defaultValue) {
        return value != null ? value : defaultValue;
    }

    private static String defIFNull(BigDecimal value, String defaultValue) {
        return value != null ? String.valueOf(value) : defaultValue;
    }

    /**
     * @return
     * @throws IOException
     */
    private static Style getStyle(String font, Integer size, Integer padding) throws IOException {
        return new Style().setFont(PdfFontFactory.createFont(font))
                .setFontSize(size)
                .setPadding(padding);
    }

    private static Style getStyle(String font, Integer size, Integer padding, int r, int g, int b) throws IOException {
        return new Style().setFont(PdfFontFactory.createFont(font))
                .setFontSize(size)
                .setPadding(padding).setFontColor(new DeviceRgb(r, g, b));
    }

    /**
     * @param text
     * @param textAllignment
     * @param paddingBottom
     * @param paddingTop
     * @param table
     */
    private static void setCell(List<Text> text, TextAlignment textAllignment,
            Table table, Integer width) {
        setCell(text, textAllignment, null, null, null, null,
                table, width);
    }

    private static void setCell(List<Text> text, TextAlignment textAllignment, Integer paddingBottom,
            Integer paddingTop,
            Table table, Integer width) {
        setCell(text, textAllignment, paddingBottom, paddingTop, null, null,
                table, width);
    }

    private static void setCell(com.itextpdf.layout.element.List list, TextAlignment textAllignment,
            Integer paddingBottom,
            Integer paddingTop, Integer paddingLeft, Integer paddingRight, Table table, Integer width) {
        Cell cell1;
        Paragraph add = new Paragraph().setTextAlignment(textAllignment).add(list);

        cell1 = createCell(1, width)
                .add(add);
        if (paddingTop != null)
            cell1.setPaddingTop(paddingTop);
        if (paddingBottom != null)
            cell1.setPaddingBottom(paddingBottom);
        if (paddingLeft != null)
            cell1.setPaddingLeft(paddingLeft);
        if (paddingRight != null)
            cell1.setPaddingRight(paddingRight);
        table.addCell(cell1);

    }

    private static void setCell(List<Text> text, TextAlignment textAllignment, Integer paddingBottom,
            Integer paddingTop, Integer paddingLeft,
            Integer paddingRight,
            Table table, Integer width, Boolean keepitNext) {
        Cell cell1;
        Paragraph add = new Paragraph().setTextAlignment(textAllignment);
        for (Text t : text) {
            add.add(t);
        }
        cell1 = createCell(1, width)
                .add(add);
        if (paddingTop != null)
            cell1.setPaddingTop(paddingTop);
        if (paddingBottom != null)
            cell1.setPaddingBottom(paddingBottom);
        if (paddingLeft != null)
            cell1.setPaddingLeft(paddingLeft);
        if (paddingRight != null)
            cell1.setPaddingRight(paddingRight);
        table.addCell(cell1).setKeepWithNext(keepitNext);
    }

    private static void setCell(List<Text> text, TextAlignment textAllignment, Integer paddingBottom,
            Integer paddingTop, Integer paddingLeft,
            Integer paddingRight,
            Table table, Integer width) {
        Cell cell1;
        Paragraph add = new Paragraph().setTextAlignment(textAllignment);
        for (Text t : text) {
            add.add(t);
        }
        cell1 = createCell(1, width)
                .add(add);
        if (paddingTop != null)
            cell1.setPaddingTop(paddingTop);
        if (paddingBottom != null)
            cell1.setPaddingBottom(paddingBottom);
        if (paddingLeft != null)
            cell1.setPaddingLeft(paddingLeft);
        if (paddingRight != null)
            cell1.setPaddingRight(paddingRight);
        table.addCell(cell1);
    }

    private static void setFooterCell(List<Text> text, TextAlignment textAllignment, Integer paddingBottom,
            Integer paddingTop, Integer paddingLeft,
            Integer paddingRight,
            Table table, Integer width) {
        Cell cell1;
        Paragraph add = new Paragraph().setTextAlignment(textAllignment);
        for (Text t : text) {
            add.add(t);
        }
        cell1 = createCell(1, width)
                .add(add);
        if (paddingTop != null)
            cell1.setPaddingTop(paddingTop);
        if (paddingBottom != null)
            cell1.setPaddingBottom(paddingBottom);
        if (paddingLeft != null)
            cell1.setPaddingLeft(paddingLeft);
        if (paddingRight != null)
            cell1.setPaddingRight(paddingRight);
        table.setSkipLastFooter(true);
        table.addFooterCell(cell1);
    }

    /**
     * @param divisionTable
     * @return
     */
    private static Table createTable(int divisionTable) {
        Table table = new Table(UnitValue.createPercentArray(divisionTable)).useAllAvailableWidth();
        table.setHorizontalAlignment(HorizontalAlignment.LEFT);
        table.setPadding(10);
        table.setMargin(3);
        table.setBorder(Border.NO_BORDER);
        return table;
    }
}
