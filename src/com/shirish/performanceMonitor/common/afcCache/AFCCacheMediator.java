


package com.shirish.performanceMonitor.common.afcCache;


import java.util.List;

import com.shirish.performanceMonitor.common.model.AFCObjectId;
import com.shirish.performanceMonitor.common.model.businessModel.AFCBusinessModelAt;

/**
 * 
 * @author shirish
 * @Oct 24, 2015
 *
 */
public class AFCCacheMediator {

    private static final String    DEFAULT_EXPIRED_TIME = "m1440"; //=24*60, 24 hours

    private static AFCCacheMediator instance;

    private boolean                isInitialized        = false;


    public static AFCCacheMediator getInstance() {

        if ( instance == null || !instance.isInitialized() ) {
            synchronized ( AFCCacheMediator.class ) {
                if ( instance == null || !instance.isInitialized() ) {
                    instance = new AFCCacheMediator();
                    instance.setInitialized( true );
                }
            }
        }
        return instance;
    }

    public boolean isInitialized() {

        return isInitialized;
    }

    public void setInitialized( boolean isInitialized ) {

        this.isInitialized = isInitialized;
    }

    /**
     * @param objectIdKey
     * @return
     */
    public AFCBusinessModelAt getBoFromCache( String objectIdKey ) {

        // return (AFCBusinessModelAt) getObjectFromCache(objectIdKey);
        return null;

    }

    public void cacheBOList( List <AFCBusinessModelAt> buzObjList, String inExpiredTime ) {

        for ( AFCBusinessModelAt afcBusinessModelAt : buzObjList ) {
            cacheBO( afcBusinessModelAt, inExpiredTime );
        }
    }

    public void cacheBOList( List <AFCBusinessModelAt> buzObjList ) {

        cacheBOList( buzObjList, DEFAULT_EXPIRED_TIME );
    }

    /**
     * Cache object with default expiration time
     * 
     * @param buzObj
     */
    public void cacheBO( AFCBusinessModelAt buzObj ) {

        cacheBO( buzObj, DEFAULT_EXPIRED_TIME );
    }

    /**
     * Cache object with given expire time
     * 
     * @param buzObj
     * @param inExpiredTime
     */
    public void cacheBO( AFCBusinessModelAt buzObj, String inExpiredTime ) {

        if ( buzObj == null ) {
            return;
        }
        AFCObjectId objId = buzObj.getObjectId();
        if ( objId == null ) {
            return;
        }
        String key = buzObj.getObjectId().getKeyForGenCach();
        // cacheObject(key, buzObj, inExpiredTime);
    }

    //    public Object getObjectFromCache(Object key)
    //    {
    //        if (null ==key)
    //        {
    //            return null;
    //        }
    //
    //        GenCacheObject gco = (GenCacheObject) GenCache.get(key);
    //        if (!isNull(gco))
    //        {
    //            return gco.getCachedObject();
    //        }
    //
    //        return null;
    //
    //    }
    //
    //    public void cacheObject(Object key, Object cachedObject)
    //    {
    //        cacheObject(key, cachedObject, DEFAULT_EXPIRED_TIME);
    //    }
    //
    //    public void cacheObject(Object key, Object cachedObject, String inExpiredTime)
    //    {
    //        if (isEmpty(cachedObject) || isEmpty(key))
    //        {
    //            return;
    //        }
    //        if (isNull(inExpiredTime))
    //        {
    //            inExpiredTime = DEFAULT_EXPIRED_TIME;
    //        }
    //        GenCache.put(key, new GenCacheObject(cachedObject, inExpiredTime));
    //    }
}
