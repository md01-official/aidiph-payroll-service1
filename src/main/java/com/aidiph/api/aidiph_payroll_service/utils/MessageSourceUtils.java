package com.aidiph.api.aidiph_payroll_service.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;

import java.util.Locale;

@Slf4j
public class MessageSourceUtils {
    private static MessageSource messageSource;
    private static String EMPTY_STRING = "";

    public static void setMessageSource(MessageSource messageSource) {
        MessageSourceUtils.messageSource = messageSource;
    }

    public static String getMessage(String key, Object[] parameters, Locale locale) {
        try {
            return messageSource.getMessage(key, parameters, locale);
        } catch (Throwable throwable) {
            log.error("Message not found : {}", key);
            return EMPTY_STRING;
        }
    }

    public static String getMessage(String key, Object[] parameters) {
        return getMessage(key, parameters, Locale.ENGLISH);
    }

    public static String getMessage(String key) {
        return getMessage(key, null, Locale.ENGLISH);
    }
}
