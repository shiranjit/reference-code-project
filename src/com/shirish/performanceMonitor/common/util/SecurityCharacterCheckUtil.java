package com.shirish.performanceMonitor.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecurityCharacterCheckUtil
{
    public static final String REGEX = "[\\p{Cntrl}]";
    private static Pattern p = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);

    public static boolean checkSpecialSign(Object obj)
    {

        if (obj == null)
        {
            return false;
        }

        if (obj instanceof String)
        {

            String str = (String) obj;
            Matcher matcher = p.matcher(str);
            if (matcher.find())
            {
                return true;
            }
        }

        return false;
    }

    public static Object replaceSpecialSign(Object obj, String replacement)
    {
        if (obj instanceof String)
        {
            String str = (String) obj;
            obj = str.replaceAll(REGEX, replacement);
        }
        return obj;
    }
}
