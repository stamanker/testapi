package ua.od.maxz.testapi.msgencodedecode;

import org.junit.Test;
import ua.od.maxz.testapi.msgencodecode.IReq;
import ua.od.maxz.testapi.msgencodecode.SpecificEntity;
import ua.od.maxz.testapi.msgencodecode.TransEnCoder;
import ua.od.maxz.testapi.msgencodecode.commands.CommandA;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;



public class TransEnCoderTest {

    /**
     * Can't encode List<String> or somethign that don't have empty/default constructor
     */
    @Test
    public void testEncodeDecodeIReq() {
        String jsonEncoded = TransEnCoder.encode(
            new CommandA("string data", new SpecificEntity("a", "b", "c"))
        );
        System.out.println("encoded = " + jsonEncoded);

        IReq decode = TransEnCoder.decode(jsonEncoded);
        System.out.println("decoded "+decode.getClass().getName()+" = " + decode);
    }

}
