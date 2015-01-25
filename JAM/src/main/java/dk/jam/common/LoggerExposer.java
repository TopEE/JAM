package dk.jam.common;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 *
 * @author airhacks.com
 */
public class LoggerExposer {

    @Produces
    @Default
    public Logger expose(InjectionPoint ip) {
        String loggerName = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(loggerName);
    }

}
