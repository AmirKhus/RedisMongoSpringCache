package com.example.redismongospringcache.parser.parser;

import com.example.redismongospringcache.model.CurrencyRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CurrencyRateParserXml implements CurrencyRateParser {
    @Override
    public List<CurrencyRate> parse(String ratesAsString) {
        List<CurrencyRate> currencies = new ArrayList<>();
        try {
            try (StringReader reader = new StringReader(ratesAsString)) {
                InputSource source = new InputSource(reader);
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = builder.parse(source);
                NodeList list = document.getElementsByTagName("Valute");
                Element element;
                for (int valuteIdx = 0; valuteIdx < list.getLength(); valuteIdx++) {
                    element = (Element) list.item(valuteIdx);
                    var currency = CurrencyRate.builder()
                            .id(element.getAttributes().item(0).getNodeValue())
                            .numCode(Integer.parseInt(element.getElementsByTagName("NumCode").item(0).getTextContent()))
                            .charCode(element.getElementsByTagName("CharCode").item(0).getTextContent())
                            .nominal(Integer.parseInt(element.getElementsByTagName("Nominal").item(0).getTextContent()))
                            .name(element.getElementsByTagName("Name").item(0).getTextContent())
                            .value(Double.parseDouble(element.getElementsByTagName("Value").item(0).getTextContent().replaceAll(",", ".")))
                            .valueRate(Double.parseDouble(element.getElementsByTagName("VunitRate").item(0).getTextContent().replaceAll(",", ".")))
                            .build();
                    currencies.add(currency);
                }
            }
        } catch (Exception ex) {
            log.error("xml parsing error, xml:{}", ratesAsString, ex);
            throw new CurrencyRateParsingException(ex);
        }
        return currencies;
    }
}