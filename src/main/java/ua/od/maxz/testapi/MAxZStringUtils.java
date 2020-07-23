package ua.od.maxz.testapi;

import java.util.*;

/**
 * Version: 1.3
 * User: maxz
 */
public class MAxZStringUtils {

    private static final char[] SPECIAL_CHARACTERS = {
            '\\', '\t', '\n', //'\r', '\f'//, '\a', '\e', '\cx'
    };

    private static final String[] SPECIAL_CHARACTERS_REPLACEMENTS = {
            "\\\\", "\\t", "\\n"//, "\\r", "\\f"//, "\\a", "\\e", "\\cx"
    };

    public static String trimToSize(String word, int limit) {
        return word.length() > limit ? word.substring(0, limit) : word;
    }

    public static enum Case {
        s,
        i
    }

    public static String getContent(String source, char start, String end) {
        return getContent(source, start + "", end);
    }

    public static String getContent(String source, String start, String end) {
        int startIndex = source.indexOf(start);
        int endIndex;
        if (!isEmpty(end)) {
            endIndex = source.indexOf(end, startIndex + start.length());
        } else {
            endIndex = -1;
        }
        if (endIndex == -1) {
            endIndex = source.length();
        }
        if (startIndex < 0 || startIndex + 1 >= endIndex) {
            return "";
        }
        int beginIndex = startIndex + start.length();
//        if(start.length()==1) {
//            beginIndex++;
//        }
        return source.substring(beginIndex, endIndex);
    }

    private static String getInverseCase(String preCondition) {
        String ret = "";
        for (int i = 0; i < preCondition.length(); i++) {
            String c = preCondition.charAt(i) + "";
            String cInv = c.toUpperCase();
            if (c.equals(cInv)) {
                cInv = c.toLowerCase();
            }
            ret += cInv;
        }
        return ret;
    }

    public static boolean isEmpty(String arg) {
        return arg == null || arg.isEmpty();
    }

    public static String replaceInBrackets(String pattern, String child, String start, String end) {
        return replaceInBrackets(new StringBuilder(pattern), child, start, end);
    }

    public static String replaceInBrackets(StringBuilder pattern, String child, String start, String end) {
        int from = pattern.indexOf(start);
        String preParty = pattern.substring(0, from);
        String res = preParty;
        res += child;
        int skipCount = 0;
        do {
            from++;
            char c = pattern.charAt(from);
            String cc = "" + c;
            if (cc.equals(start)) {
                skipCount++;
            } else if (cc.equals(end)) {
                skipCount--;
                if (skipCount < 0) {
                    from++; // duplicated
                    break;
                }
            }
        } while (true);
        String afterParty = pattern.substring(from, pattern.length());
        res += afterParty;
        return res;
    }

    public static String deleteBrackets(String str, char first, char second, int startFrom) {
        if (startFrom >= str.length()) {
            throw new IllegalArgumentException("start > length");
        }
        StringBuilder ret = new StringBuilder(str.substring(0, startFrom));
        boolean found = false;
        int skip = 0;
        for (int i = startFrom; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == first) {
                if (!found) {
                    found = true;
                    continue;
                } else {
                    skip++;
                }
            }
            if (c == second) {
                if (skip > 0) {
                    skip--;
                } else {
                    continue;
                }
            }
            ret.append(c);
        }
        return ret.toString();
    }

    public static String beforeFirst(String source, String s) {
        int i = source.indexOf(s);
        if (i == -1) {
            return source;
        }
        return source.substring(0, i);
    }

    public static String beforeLast(String source, String s) {
        int i = source.lastIndexOf(s);
        if (i == -1) {
            return source;
        }
        return source.substring(0, i);
    }

    public static String afterFirst(String source, String from) {
        if (isEmpty(from)) {
            return source;
        }
        int index = source.indexOf(from);
        if (index < 0) {
            return source;
        }
        return source.substring(index + from.length());
    }

    public static String afterFirstOrEmpty(String source, String from) {
        if (isEmpty(from)) {
            return "";
        }
        int index = source.indexOf(from);
        if (index < 0) {
            return "";
        }
        return source.substring(index + from.length());
    }

    public static String afterLast(String uri, String after) {
        int i = uri.lastIndexOf(after);
        if (i == -1) {
            return uri;
        }
        return uri.substring(i + after.length());
    }

    public static int count(String source, String chars) {
        int ret = 0;
        int i = 0;
        while ((i = source.indexOf(chars, i)) != -1) {
            ret++;
            i = i + chars.length();
        }
        return ret;
    }

    public static String truncate(String arg, int truncateLen, char divider) {
        for (int i = truncateLen - 1; i >= 0; i--) {
            if (arg.charAt(i) == divider) {
                return arg.substring(0, i);
            }
        }
        return "";
    }

    public static String replaceSpecialCharacters(String arg) {
        for (int i = 0; i < SPECIAL_CHARACTERS.length; i++) {
            arg = arg.replace(SPECIAL_CHARACTERS[i] + "", SPECIAL_CHARACTERS_REPLACEMENTS[i]);
        }
        return arg;
    }

    public static String escapeSpecialChars(String value) {
        if (value != null) {
            value = value.replace("\\", "\\\\").replace("'", "\\'").replace(";", "\\;");
        }
        return value;
    }

    public static boolean containsLetter(String text) {
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static String removeEndSlash(String arg) {
        if (arg.endsWith("/")) {
            return arg.substring(0, arg.length() - 1);
        }
        return arg;
    }

    public static String removeStartSlash(String arg) {
        if (arg.startsWith("/")) {
            return arg.substring(1, arg.length());
        }
        return arg;
    }

    public static String format(int i) {
        return new Formatter(Locale.getDefault()).format("%,3d", i).toString();
    }

    public static String format(long lomg) {
        return new Formatter(Locale.getDefault()).format("%,3d", lomg).toString();
    }

    public static String[] toArray(Collection<String> data) {
        return data.toArray(new String[0]);
    }

    public static String formatXml(String arg) {
        try {
            String result = "";
            int indentSize = 0;
            int indentThisTag = 0;
            for (int i = 0; i < arg.length(); i++) {
                char c = arg.charAt(i);
                if (c == '<') {
                    if (arg.charAt(i + 1) == '/') {
                        indentSize--;
                        if (indentThisTag != indentSize + 1) {
                            result += "\n";
                            result += "\t".repeat(indentSize);
                        }
                    } else {
                        if (indentThisTag != indentSize - 1) {
                            if(indentSize>0) {
                                result += "\n";
                            }
                            result += "\t".repeat(indentSize);
                        }
                        indentSize++;
                        indentThisTag = indentSize;
                    }
                } else if (c == '>' && arg.charAt(i - 1) == '/') {
                    indentSize--;
                }
                result += c;
            }
            return result;
        } catch (Exception e) {
            return arg;
        }
    }

}
