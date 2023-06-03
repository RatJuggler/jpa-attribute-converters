package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SecretConverter implements AttributeConverter<String, String> {

  private static final Logger log = LoggerFactory.getLogger(SecretConverter.class);

  @Override
  public String convertToDatabaseColumn(String attribute) {
    String decodedSecret = attribute;
    String encodedSecret = Base64.getEncoder().encodeToString(decodedSecret.getBytes());
    log.info("convertToDatabaseColumn: Secret encoded: {} -> {}", decodedSecret, encodedSecret);
    return encodedSecret;
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    String encodedSecret = dbData;
    byte[] decodedBytes = Base64.getDecoder().decode(encodedSecret);
    String decodedSecret = new String(decodedBytes);
    log.info("convertToEntityAttribute: Secret decoded: {} -> {}", encodedSecret, decodedSecret);
    return decodedSecret;
  }
}
