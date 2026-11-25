package com.wealth.common.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoczLogger {

    private final Logger logger;

    public DoczLogger(Class<?> logClass) {
        this.logger = LoggerFactory.getLogger(logClass);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void trace(String message) {
        logger.trace(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void info(String message, String add) {
        logger.info( message+ add);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    public void trace(String message, Object... args) {
        logger.trace(message, args);
    }

    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    public void warn(String message, Object... args) {
        logger.warn(message, args);
    }

    public void error(String message, Object... args) {
        logger.error(message, args);
    }

    public Logger getLogger() {
        return logger;
    }
}
