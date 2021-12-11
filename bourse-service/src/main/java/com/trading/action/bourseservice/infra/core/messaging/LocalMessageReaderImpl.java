package com.trading.action.bourseservice.infra.core.messaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@Component
public class LocalMessageReaderImpl implements  LocalMessageReader {
    @Value("${local.language}")
    private String language;

    @Value("${local.country}")
    private String country;

    @Value("${local.bundel}")
    private String bundel;

    private Locale locale;
    private ResourceBundle resourceBundle;

    public String getMessage(String code) {
        locale = new Locale(language, country);
        resourceBundle = createUtf8PropertyResourceBundle(PropertyResourceBundle.getBundle(bundel, locale));
        String message = null;
        if (resourceBundle != null) {
            message = resourceBundle.getString(code).trim();
        }
        return message == null ? code : message;
    }

    private  ResourceBundle createUtf8PropertyResourceBundle(
            final ResourceBundle bundle) {
        if (!(bundle instanceof PropertyResourceBundle)) {
            return bundle;
        }
        return new Utf8PropertyResourceBundle((PropertyResourceBundle) bundle);
    }

    private static class Utf8PropertyResourceBundle extends ResourceBundle {

        private final PropertyResourceBundle bundle;

        private Utf8PropertyResourceBundle(final PropertyResourceBundle bundle) {
            this.bundle = bundle;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Enumeration getKeys() {
            return bundle.getKeys();
        }

        @Override
        protected Object handleGetObject(final String key) {
            final String value = bundle.getString(key);
            if (value == null)
                return null;
            try {
                return new String(value.getBytes("ISO-8859-1"), "UTF-8");
            } catch (final UnsupportedEncodingException e) {
                throw new RuntimeException("Encoding not supported", e);
            }
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBundel() {
        return bundel;
    }

    public void setBundel(String bundel) {
        this.bundel = bundel;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }
}

