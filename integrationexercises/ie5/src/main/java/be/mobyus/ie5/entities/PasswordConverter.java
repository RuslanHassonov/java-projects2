package be.mobyus.ie5.entities;

import org.springframework.util.Base64Utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@Converter(autoApply = true)
public class PasswordConverter implements AttributeConverter<String, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(String s) {
        try {
            return Base64Utils.encode(s.getBytes(s));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String convertToEntityAttribute(byte[] columnData) {
        return Arrays.toString(Base64Utils.decode(columnData));
    }
}
