/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Shirish Ranjit
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */



package com.shirish.caching.expiringCache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * This is for expiring cache manager.
 * 
 * @author SRANJIT
 * 
 */
public class GenericCacheManager extends CacheManager {

    private static Logger              LOG                  = LogManager.getLogger( GenericCacheManager.class );

    //lets expire the cache in  milliseconds
    private static int                 millisecondsToLive = 240;

    private static GenericCacheManager handle               = null;


    /**
     * Private constructor that calls the constructor in the supper class.
     *
     */
    private GenericCacheManager(
                                int milliSecondSweepTimeIn, int millisecondsToLiveIn) {
        super( milliSecondSweepTimeIn );
        millisecondsToLive = millisecondsToLiveIn;
    }

    /**
     * The function returns the handle to the class. It creates if the class is
     * null.
     * 
     * @return FixIoiPublisher object
     * @throws Exception
     * 
     */
    public static synchronized GenericCacheManager getHandle() {

        if ( handle == null ) {
            return handle = new GenericCacheManager(3000, 200);
        }
        else {
            return handle;
        }
    }

    /**
     * This method allows to find data in cached by key.
     * 
     * @param key
     * @return
     */
    public synchronized CachedObject getfromCache(
                                                   String key ) throws Exception
    {



        try {
            CachedObject cacheobject = (CachedObject) this.getCache( key );
            return cacheobject;

        }
        catch ( Exception e ) {
            LOG.warn( "Exception in getting information from cache. "
                       + e.getMessage(), e );
            throw e;
        }

    }

    /**
     * This method allows to find  information is cached by key.
     * 
     * @param key
     * @return
     */
    public synchronized Object putInCache(
                                                 String key, CachedObject value ) throws Exception
    {

        CachedObject cacheobject = (CachedObject) this.getCache( key );

        try {
            if ( cacheobject == null ) {

                cacheobject = new CachedObject( value, key, millisecondsToLive );
                this.putCache( cacheobject );
                return cacheobject.getObject();

            }
            else {
                //System.out.println("\n\nNo brokers found in the datastore \n\n");
                return null;
            }


        }
        catch ( Exception e ) {
            //e.printStackTrace();
            LOG.error( "Exception in getting cache information from cache. "
                       + e.toString(), e );
            throw e;
        }

    }

}
