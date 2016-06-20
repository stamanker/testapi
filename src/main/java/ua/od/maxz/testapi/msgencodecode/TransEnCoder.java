package ua.od.maxz.testapi.msgencodecode;

import ua.od.maxz.testapi.JsonUtils;

/**
 * User: maxz
 */
public class TransEnCoder {

    public static String encode(Object req) {
        return JsonUtils.toJson(new TransportEntity(req.getClass(), JsonUtils.toJson(req)));
    }

    public static IReq decode(String encodedJson) {
        try {
            TransportEntity decoded = JsonUtils.fromJson(encodedJson, TransportEntity.class);
            Class clazz = Class.forName(decoded.className);
            return (IReq) JsonUtils.fromJson(decoded.msgJson, clazz);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }


}
