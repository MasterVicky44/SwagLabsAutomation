package com.swagLabs.report;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger logger = LogManager.getLogger(Log.class);

    private Log() {}

    static Logger getLogger() {
        return logger;
    }

}
