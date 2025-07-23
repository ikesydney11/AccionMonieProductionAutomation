package Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerClass {

    public static class Log {
        public static Logger getLogger(Class<?> clazz) {
            return LoggerFactory.getLogger(clazz);
        }
    }

}
