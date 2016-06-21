


package com.shirish.performanceMonitor.common;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;

/**
 * 
 * @author shirish
 * @Oct 24, 2015
 *
 */
public class AFCLogger {

    private Logger log4j;


    protected AFCLogger(Class <?> classRef) {
        LoggerContext ctx = (LoggerContext)LogManager.getContext( false );
        Configuration conf = ctx.getConfiguration();
        conf.getLoggerConfig( LogManager.ROOT_LOGGER_NAME ).setLevel( Level.DEBUG);
        ctx.updateLoggers(conf);
        
        log4j = LogManager.getLogger( classRef );
    }

    public static AFCLogger getLogger( Class <?> classRef ) {

        AFCLogger afcLogger = new AFCLogger( classRef );
        return afcLogger;

    }

    public void info( String message ) {

        log4j.info( message );
    }

    public void info( String message, Throwable throwable ) {

        log4j.info( message, throwable );
    }

    public void info( Throwable throwable ) {

        log4j.info( throwable );
    }

    public void warn( String message ) {

        log4j.warn( message );
    }

    public void warn( String message, Throwable throwable ) {

        log4j.warn( message, throwable );
    }

    public void warn( Throwable throwable ) {

        log4j.warn( throwable );
    }

    public void error( String message ) {

        log4j.error( message );
    }

    public void error( String message, Throwable throwable ) {

        log4j.error( message, throwable );
    }

    public void error( Throwable throwable ) {

        log4j.error(  throwable );
    }

    public void fatal( String message ) {

        log4j.fatal( message );
    }

    public void fatal( String message, Throwable throwable ) {

        log4j.fatal( message, throwable );
    }

    public void fatal( Throwable throwable ) {

        log4j.fatal(  throwable );
    }

    public void debug( String message ) {

        log4j.debug( message );
    }

    public void debug( String message, Throwable throwable ) {

        log4j.debug( message, throwable );
    }

    public void debug( Throwable throwable ) {

        log4j.debug(  throwable );
    }

    public boolean isDebugEnabled() {

        return log4j.isDebugEnabled();
    }

}
