package com.shirish.performanceMonitor.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompareUtil
{

    //AR: Added a comment to test the CVS Merge and clearcase sync process. 
    public static boolean isContains(String[] fullSet, String[] subSet)
    {
        if (isEmpty(subSet))
        {
            return true;
        }

        if (isEmpty(fullSet))
        {
            return false;
        }
        return Arrays.asList(fullSet).containsAll(Arrays.asList(subSet));
    }

    /**
     * 
     * @param fullSet a string set
     * @param elem 
     * @return the full set contain the passed elem or not
     */
    public static boolean isContains(String[] fullSet, String elem)
    {
        if (isEmpty(fullSet))
        {
            return false;
        }
        return Arrays.asList(fullSet).contains(elem);
    }

    public static boolean equals(String[] fullSet, String[] subSet)
    {
        if (isEmpty(fullSet) && isEmpty(subSet))
        {
            return true;
        }

        if (length(fullSet) != length(subSet))
        {
            return false;
        }

        List<String> fullList = Arrays.asList(fullSet);
        List<String> subList = Arrays.asList(subSet);
        return fullList.containsAll(subList) && subList.containsAll(fullList);
    }

    public static int length(String[] strs)
    {
        if (isEmpty(strs))
        {
            return 0;
        }
        return strs.length;
    }

    public static String[] convert(String inAttributes)
    {
        if (inAttributes == null || inAttributes.trim().equals(""))
        {
            return new String[] {};
        }
        String[] inArray = inAttributes.trim().split("\\s*,\\s*");
        return inArray;
    }

    public static String[] convert(String[][] inAttributes)
    {
        if (inAttributes == null)
        {
            return new String[] {};
        }
        List<String> list = new ArrayList<String>();
        for (String[] strs : inAttributes)
        {
            if (strs == null || strs.length == 0)
            {
                continue;
            }
            list.add(strs[0]);
        }
        return list.toArray(new String[0]);
    }

    public static Set<String> convertToSet(String inAttributes)
    {
        String[] convertedArray = CompareUtil.convert(inAttributes);
        Set<String> set = new HashSet<String>();
        for (String strs : convertedArray)
        {
            if (strs == null)
            {
                continue;
            }
            set.add(strs);
        }
        return set;
    }

    public static boolean isContainsAnyOne(String[] fullSet, String[] subSet)
    {
        if (isEmpty(subSet))
        {
            return true;
        }

        if (isEmpty(fullSet))
        {
            return false;
        }

        List<String> fullList = Arrays.asList(fullSet);
        for (String s : subSet)
        {
            if (fullList.contains(s))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isEmpty(String[] arg)
    {
        if (arg == null)
        {
            return true;
        }
        return arg.length == 0;
    }

    public static String[] remove(String[] target, String[] needRemoved)
    {
        if (target == null)
        {
            throw new RuntimeException("target array is null!");
        }
        if (isEmpty(needRemoved))
        {
            return target;
        }
        String[] result = target;
        for (String needRemove : needRemoved)
        {
            result = remove(result, needRemove);

        }
        return result;
    }

    public static String[] remove(String[] target, String needRemove)
    {
        if (target == null)
        {
            throw new RuntimeException("target array is null!");
        }
        if (needRemove == null)
        {
            return target;
        }
        int index = searchFirst(target, needRemove);
        if (index == -1)
        {
            return target;
        }
        else
        {
            String[] result = new String[target.length - 1];
            System.arraycopy(target, 0, result, 0, index);
            System.arraycopy(target, index + 1, result, index, target.length - index - 1);
            return remove(result, needRemove);
        }

    }

    public static int searchFirst(String[] target, String key)
    {
        if (isEmpty(target) || key == null)
        {
            return -1;
        }
        for (int i = 0; i < target.length; i++)
        {
            if (key.equals(target[i]))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param arr1
     * @param arr2
     * @return combined array
     */
    public static String[][] combineArray(String[][] arr1, String[][] arr2)
    {
        if (arr1 == null || arr1.length <= 0)
        {
            return arr2;
        }

        if (arr2 == null || arr2.length <= 0)
        {
            return arr1;
        }

        String[][] finalArr = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, finalArr, arr1.length, arr2.length);
        return finalArr;
    }
}
