


package com.shirish.performanceMonitor.common.config;

import java.util.Properties;

import com.shirish.performanceMonitor.common.AFCLogger;
import com.shirish.performanceMonitor.common.constants.AFCApplicationConstants;

/**
 * 
 * @author shirish
 * @Oct 24, 2015
 *
 */
public class AFSystemConfig {

    private static final AFCLogger log           = AFCLogger.getLogger( AFSystemConfig.class );
    private Properties             props;

    /*
     * PROD, UAT, DEV
     */
    private String                 appENV;

    /*
     * PROD, UAT1, DEV1
     */
    private String                 appSubEnv;

    private static AFSystemConfig  instance;

    private boolean                isInitialized = false;


    private AFSystemConfig() {

    }

    public void init() {

        props = System.getProperties();

        appENV = props.getProperty( AFCApplicationConstants.APP_ENV_MAPPING );
        appSubEnv = props.getProperty( AFCApplicationConstants.APP_SUB_ENV_MAPPING );

        if ( AFCApplicationConstants.PROD.equalsIgnoreCase( appENV ) ) {
            //appENV = AFCApplicationConstants.PROD;
            appSubEnv = AFCApplicationConstants.PROD;
        }

        //log.info("point to ServiceFor:" + serviceFor);
        log.info( "point to appENV:" + appENV );
        log.info( "point to appSubEnv:" + appSubEnv );

    }

    public static AFSystemConfig getInstance() {

        if ( instance == null || !instance.isInitialized() ) {

            synchronized ( AFSystemConfig.class ) {

                if ( instance == null || !instance.isInitialized() ) {
                    instance = new AFSystemConfig();

                    try {
                        instance.init();
                        instance.setInitialized( true );
                    }
                    catch ( Exception e ) {
                        //we cannot operate at this point
                        log.error( "Error in initializing configuration", e );
                        throw new RuntimeException( "FATAL_INTERNAL_ISSUE", e );
                    }

                }

            }

        }

        return instance;
    }

    /**
     * @return DEV1, DEV3, UAT1, UAT3, PROD etc
     */
    public String getAppToEnv() {

        return appSubEnv;

    }

    /**
     * @return DEV, UAT, PROD etc
     */
    public String getAppEnv() {

        return appENV;
    }

    public boolean isInitialized() {

        return isInitialized;
    }

    public void setInitialized( boolean isInitialized ) {

        this.isInitialized = isInitialized;
    }

}
