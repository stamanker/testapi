package ua.od.maxz.testapi.msgencodedecode;

import org.junit.Test;
import ua.od.maxz.testapi.MAxZStringUtils;

import static junit.framework.TestCase.assertEquals;

public class UtilsTest {

    @Test
    public void testXmlFormat() {
        String expected =
                "<a>\n" +
                "\t<b>\n" +
                "\t\t<c/>\n" +
                "\t</b>\n" +
                "\t<d>dfdfdfd</d>\n" +
                "</a>";
        assertEquals(expected, MAxZStringUtils.formatXml(expected.replaceAll("\n", "").replaceAll("\t", "")));
    }

    @Test
    public void testGetContent() {
        String input = "b x 123 12 12 z d }";
        String content = MAxZStringUtils.getContent(input, "x", "z");
        assertEquals(" 123 12 12 ", content);
    }
}
