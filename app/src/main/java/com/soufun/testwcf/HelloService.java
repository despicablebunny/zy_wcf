package com.soufun.testwcf;

/**
 * Created by zhangying on 2016/4/26.
 */
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class HelloService implements ISoapService {
    private static final String NameSpace = "http://interface.jrwf.test.fang.com/";
    private static final String URL = "http://interface.jrwf.test.fang.com/Android.svc/Android.svc";
    private static final String SOAP_ACTION = "http://interface.jrwf.test.fang.com/IAndroid/GetRoleClassify";
    private static final String MethodName = "GetRoleClassify";

    private String words;

    public HelloService(String words) {
        this.words = words;
    }

    public SoapObject LoadResult() {
        SoapObject soapObject = new SoapObject(NameSpace, MethodName);
//        soapObject.addProperty("UserID", "E20B1332-61CF-46B4-8EF1-00B7C668F0CF");
//        soapObject.addProperty("SystemID", "6014FA77-75C5-4F3B-9DAD-B12A34655C50");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11); // 版本
        envelope.bodyOut = soapObject;
        envelope.dotNet = true;

        HttpTransportSE trans = new HttpTransportSE(URL);
        trans.debug = true; // 使用调试功能
        SoapObject result = null;
        try {
            trans.call(SOAP_ACTION, envelope);
            result = (SoapObject) envelope.bodyIn;
            System.out.println("Call Successful!");
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            System.out.println("XmlPullParserException");
            e.printStackTrace();
        }
        return result;
    }
}
