package com.shirish.performanceMonitor.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import com.shirish.performanceMonitor.common.AFCException;
import com.shirish.performanceMonitor.common.AFCInvalidInputException;

/**
 * Utility class for methods that are common to different classes.
 * 
 * @author e474415 (Vigny)
 * @version 1.0
 * @updated 20-Nov-2013 3:09:40 PM
 */
public class AFCStringUtils {

	public static final String ERROR_MSG_2 = " is null or empty. ";
	public static final String ERROR_MSG_1 = "INCORRECT PARAMETER PASSED: The value of ";
	public static final String EMPTY_STRING = "";
	public static final String COMMA_STRING = ",";
	public static final int ERROR_INTERNAL_PARAM_ISSUE = 1;

	private static List<Pattern> plist = new ArrayList<Pattern>();

	// public final static String INTEGER_FORMAT = "###,###,###,###,###";

	static {

		plist.add(Pattern.compile("<script>(.*?)</script>",
				Pattern.CASE_INSENSITIVE));
		// Avoid anything in a src='...' type of expression
		plist.add(Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		plist.add(Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		// Remove any lonesome </script> tag
		plist.add(Pattern.compile("</script>", Pattern.CASE_INSENSITIVE));
		// Remove any lonesome <script ...> tag
		plist.add(Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE
				| Pattern.MULTILINE | Pattern.DOTALL));
		// Avoid eval(...) expressions
		plist.add(Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE
				| Pattern.MULTILINE | Pattern.DOTALL));
		// Avoid expression(...) expressions
		plist.add(Pattern.compile("expression\\((.*?)\\)",
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
		// Avoid javascript:... expressions
		plist.add(Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE));
		// Avoid vbscript:... expressions
		plist.add(Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE));
		// Avoid onload= expressions
		plist.add(Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE
				| Pattern.MULTILINE | Pattern.DOTALL));
	}

	public static boolean checkEmailAddressNoEx(String inEmailAddress) {
		boolean status = false;
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inEmailAddress);
		status = m.find();
		if (status == true) {
			String[] parts = inEmailAddress.split("@");
			String localPart = parts[0];
			String domainPart = parts[1];
			if (localPart.length() > 255 || domainPart.length() > 64) {
				status = false;
			}

		}
		return status;

	}

	/**
	 * A convenience method to check for special characters passed in a method
	 * argument.
	 * 
	 * @param inString
	 *            The String that needs to be checked for special characters.
	 * @throws AFCException
	 */
	public static void checkSpecialCharacters(String inString)
			throws AFCInvalidInputException {

		// delete non-unicode requirement
		if (!checkSpecialCharactersNoEx(inString)) {
			throw new AFCInvalidInputException(ERROR_INTERNAL_PARAM_ISSUE,
					inString);
		}

		// A convenience method to check for
		// special characters passed in a method
		// argument. Steps:
		// 1) If the String has non Unicode
		// characters, throw
		// ParameterFormatException setting the
		// parameter name and the special
		// character found in the Exception
		// 2) If the String has other special
		// characters (*,&,$,!,.,/,?,^), throw
		// ParameterFormatException setting the
		// parameter name and the special
		// character found in the Exception
		// 3) Otherwise return.
	}

	public static boolean checkSpecialCharactersNoEx(String inString) {

		String[] specialChar = { "*", "&", "$", "!", ".", "/", "?", "^" };
		for (int i = 0, n = specialChar.length; i < n; i++) {
			if (inString.indexOf(specialChar[i]) != -1) {
				return false;
			}
		}
		return true;
	}

	public static String logProcessTime(String logString, long baseTime) {
		try {
			long diff = System.currentTimeMillis() - baseTime;
			String s = logString + " Time Taken : " + diff + " ms";
			return s;
		} catch (Exception e) {
		}
		return AFCStringUtils.EMPTY_STRING;
	}

	public static void checkInput(double inDouble)
			throws AFCInvalidInputException {
		if (Double.isNaN(inDouble) || Double.isInfinite(inDouble)) {
			throw new AFCInvalidInputException(ERROR_INTERNAL_PARAM_ISSUE,
					String.valueOf(inDouble));
		}
	}

	public static void checkInput(float inFloat)
			throws AFCInvalidInputException {
		if (Float.isNaN(inFloat) || Float.isInfinite(inFloat)) {
			throw new AFCInvalidInputException(ERROR_INTERNAL_PARAM_ISSUE,
					String.valueOf(inFloat));
		}
	}

	public static boolean parse(String booleanStr) {
		return Boolean.valueOf(booleanStr).booleanValue();
	}

	/**
	 * @param comment
	 * @param commentLength
	 * @return
	 */
	public static String substring(String input, int expectedLength) {
		String output = input;

		if (input != null && input.length() > expectedLength) {
			output = input.substring(0, expectedLength);
		}

		return output;
	}

	public static void checkXSS(String value) throws AFCInvalidInputException {
		// Avoid anything between script tags
		if (value == null) {
			return;
		}

		for (Pattern p : plist) {
			boolean find = p.matcher(value).find();
			if (find) {
				throw new AFCInvalidInputException(ERROR_INTERNAL_PARAM_ISSUE,
						value);
			}
		}

	}

	/**
	 * Escapes the characters in a String using HTML entities. For example:
	 * "bread" & "butter" becomes: &quot;bread&quot; &amp; &quot;butter&quot;.
	 * 
	 * @param str
	 *            the String to escape, may be null
	 * @return a new escaped String, null if null string input
	 */
	public static String escapeHtml(String str) {
		return StringEscapeUtils.escapeHtml4(str);
	}

	/**
	 * Unescapes a string containing entity escapes to a string containing the
	 * actual Unicode characters corresponding to the escapes. For example, the
	 * string "&lt;Fran&ccedil;ais&gt;" will become "<Franais>"
	 * 
	 * @param str
	 *            the String to unescape, may be null
	 * @return a new unescaped String, null if null string input
	 */
	public static String unescapeHtml(String str) {
		return StringEscapeUtils.unescapeHtml4(str);
	}

	public static boolean isNull(Object obj) {
		return null == obj;
	}

	public static boolean isBlank(String str) {
		return StringUtils.isBlank(str);
	}

	public static boolean checkForNullAndEmpty(String inVal) {
		if (inVal == null || "".equals(inVal)) {
			return true;
		}
		return false;
	}

	public static List<String> splitString(String inObj) {
		Set<String> nodup = new HashSet<String>();
		String[] arr = ("" + inObj).split("[,;|]");
		for (String str : arr) {
			nodup.add(str.trim());
		}
		return new ArrayList<String>(nodup);
	}

	public static String[] splitSpace(String REGEX, String valueObj, int limit) {
		if (valueObj == null) {
			return null;
		}
		Pattern p = Pattern.compile(REGEX);
		String[] items = p.split(valueObj, limit);
		return items;
	}

	public static String convertNullToEmptyStr(String inObj) {
		if (inObj == null) {
			return "";
		}
		return inObj;
	}

	public static String asString(Object obj) {
		return obj == null ? "null" : obj.toString();
	}

	public static String trim(String arg) {
		return StringUtils.trim(arg);
	}

	public static String upperCase(String arg) {
		return StringUtils.upperCase(arg);
	}

	public static String trimToUpperCase(String arg) {
		return upperCase(trim(arg));
	}

	public static String lowerCase(String arg) {
		return StringUtils.lowerCase(arg);
	}

	public static String trimToLowerCase(String arg) {
		return trim(lowerCase(arg));
	}

	public static int size(Collection<?> coll) {
		if (isNull(coll)) {
			return 0;
		}
		return coll.size();
	}

	public static int size(Object[] arr) {
		if (isNull(arr)) {
			return 0;
		}
		return arr.length;
	}

	public static boolean equals(String arg1, String arg2) {
		if (arg1 == arg2) {
			return true;
		}
		if (arg1 == null || arg2 == null) {
			return false;
		}
		return arg1.equals(arg2);
	}

	public static String convertCollectionToString(Collection<String> coll,
			String delimiter) {
		if (coll == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		for (String value : coll) {
			sb.append(value);
			sb.append(delimiter);
		}

		if (sb.length() > 0) {
			sb.delete(sb.length() - delimiter.length(), sb.length());
		}
		return sb.toString();

	}

}