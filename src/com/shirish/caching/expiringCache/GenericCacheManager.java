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

import org.apache.log4j.Logger;

/**
 * 
 * This is for broker cache manager.
 * 
 * @author SRANJIT
 * 
 */
public class GenericCacheManager extends CacheManager {

    private static Logger              LOG        = Logger.getLogger( GenericCacheManager.class );

    //lets expire the broker cache in 4 hours.
    private static int                 minutesToLive = 240;

    private static GenericCacheManager handle        = null;


    /**
     * Private constructor that calls the constructor in the supper class.
     *
     */
    private GenericCacheManager() {
        super();
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
            return handle = new GenericCacheManager();
        }
        else {
            return handle;
        }
    }

    /**
     * This method allows to find broker with CriteriaVO. The broker information
     * is cached by key.
     * 
     * @param key
     * @return
     */
    public synchronized CachedObject getfromCache(String key ) throws Exception
    {



        try {
            CachedObject cacheobject = (CachedObject) this.getCache( key );
            return cacheobject;

        }
        catch ( Exception e ) {
            //e.printStackTrace();
            LOG.error( "Exception in getting broker information from cache. "
                          + e.toString(), e );
            throw e;
        }

    }

    /**
     * This method allows to find broker with CriteriaVO. The broker information
     * is cached by key.
     * 
     * @param key
     * @return
     */
    public synchronized CachedObject putInCache(String key, CachedObject value ) throws Exception
    {

        CachedObject cacheobject = (CachedObject) this.getCache( key );

        try {
            if ( cacheobject == null ) {

                cacheobject = new CachedObject( value, key, minutesToLive );
                this.putCache( cacheobject );
                return cacheobject;

            }
            else {
                //System.out.println("\n\nNo brokers found in the datastore \n\n");
                return null;
            }


        }
        catch ( Exception e ) {
            //e.printStackTrace();
            LOG.error( "Exception in getting broker information from cache. "
                          + e.toString(), e );
            throw e;
        }

    }

}
