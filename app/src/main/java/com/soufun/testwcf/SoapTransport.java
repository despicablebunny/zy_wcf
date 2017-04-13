package com.soufun.testwcf;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.kxml2.io.KXmlSerializer;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

/**
 * Created by zhangying on 2016/11/4.
 */

public class SoapTransport {
    public static final int DEFAULT_TIMEOUT = 20000; // 20 seconds
    public static final int DEFAULT_BUFFER_SIZE = 256*1024; // 256 Kb
    private HttpURLConnection getConnect(Proxy proxy, String url, int timeout) throws IOException {
        HttpURLConnection connection = (proxy == null)
                ? (HttpURLConnection) new URL(url).openConnection()
                : (HttpURLConnection) new URL(url).openConnection(proxy);
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);
        return connection;
    }
    public void call(String soapAction, SoapEnvelope envelope, List headers, File outputFile,String url,int timeout)
            throws HttpResponseException, IOException, XmlPullParserException {
//
//        if (soapAction == null) {
//            soapAction = "\"\"";
//        }
//
//        byte[] requestData = createRequestData(envelope, "UTF-8");
//
//        requestDump = debug ? new String(requestData) : null;
//        responseDump = null;
//
        HttpURLConnection connection = getConnect(null,url,timeout);
//
//        connection.setRequestProperty("User-Agent", USER_AGENT);
//        // SOAPAction is not a valid header for VER12 so do not add
//        // it
//        // @see "http://code.google.com/p/ksoap2-android/issues/detail?id=67
//        if (envelope.version != SoapSerializationEnvelope.VER12) {
//            connection.setRequestProperty("SOAPAction", soapAction);
//        }
//
//        if (envelope.version == SoapSerializationEnvelope.VER12) {
//            connection.setRequestProperty("Content-Type", CONTENT_TYPE_SOAP_XML_CHARSET_UTF_8);
//        } else {
//            connection.setRequestProperty("Content-Type", CONTENT_TYPE_XML_CHARSET_UTF_8);
//        }
//
//        // this seems to cause issues so we are removing it
//        //connection.setRequestProperty("Connection", "close");
//        connection.setRequestProperty("Accept-Encoding", "gzip");
//
//
//        // Pass the headers provided by the user along with the call
//        if (headers != null) {
//            for (int i = 0; i < headers.size(); i++) {
//                HeaderProperty hp = (HeaderProperty) headers.get(i);
//                connection.setRequestProperty(hp.getKey(), hp.getValue());
//            }
//        }
//
//        connection.setRequestMethod("POST");
//        sendData(requestData, connection,envelope);
//        requestData = null;
//        InputStream is = null;
//        List retHeaders = null;
//        byte[] buf = null; // To allow releasing the resource after used
//        int contentLength = 8192; // To determine the size of the response and adjust buffer size
//        boolean gZippedContent = false;
//        boolean xmlContent = false;
//        int status = connection.getResponseCode();
//
//        try {
//            retHeaders = connection.getResponseProperties();
//
//            for (int i = 0; i < retHeaders.size(); i++) {
//                HeaderProperty hp = (HeaderProperty)retHeaders.get(i);
//                // HTTP response code has null key
//                if (null == hp.getKey()) {
//                    continue;
//                }
//
//                // If we know the size of the response, we should use the size to initiate vars
//                if (hp.getKey().equalsIgnoreCase("content-length") ) {
//                    if ( hp.getValue() != null ) {
//                        try {
//                            contentLength = Integer.parseInt( hp.getValue() );
//                        } catch ( NumberFormatException nfe ) {
//                            contentLength = 8192;
//                        }
//                    }
//                }
//
//
//                // Check the content-type header to see if we're getting back XML, in case of a
//                // SOAP fault on 500 codes
//                if (hp.getKey().equalsIgnoreCase("Content-Type")
//                        && hp.getValue().contains("xml")) {
//                    xmlContent = true;
//                }
//
//
//                // ignoring case since users found that all smaller case is used on some server
//                // and even if it is wrong according to spec, we rather have it work..
//                if (hp.getKey().equalsIgnoreCase("Content-Encoding")
//                        && hp.getValue().equalsIgnoreCase("gzip")) {
//                    gZippedContent = true;
//                }
//            }
//
//            //first check the response code....
//            if (status != 200) {
//                //throw new IOException("HTTP request failed, HTTP status: " + status);
//                throw new HttpResponseException("HTTP request failed, HTTP status: " + status, status,retHeaders);
//            }
//
//            if (contentLength > 0) {
//                if (gZippedContent) {
//                    is = getUnZippedInputStream(
//                            new BufferedInputStream(connection.openInputStream(),contentLength));
//                } else {
//                    is = new BufferedInputStream(connection.openInputStream(),contentLength);
//                }
//            }
//        } catch (IOException e) {
//            if (contentLength > 0) {
//                if(gZippedContent) {
//                    is = getUnZippedInputStream(
//                            new BufferedInputStream(connection.getErrorStream(),contentLength));
//                } else {
//                    is = new BufferedInputStream(connection.getErrorStream(),contentLength);
//                }
//            }
//
//            if ( e instanceof HttpResponseException) {
//                if (!xmlContent) {
//                    if (debug && is != null) {
//                        //go ahead and read the error stream into the debug buffers/file if needed.
//                        readDebug(is, contentLength, outputFile);
//                    }
//
//                    //we never want to drop through to attempting to parse the HTTP error stream as a SOAP response.
//                    connection.disconnect();
//                    throw e;
//                }
//            }
//        }
//
//        if (debug) {
//            is = readDebug(is, contentLength, outputFile);
//        }
//
//        parseResponse(envelope, is,retHeaders);
//
//        // release all resources
//        // input stream is will be released inside parseResponse
//        is = null;
//        buf = null;
//        //This fixes Issue 173 read my explanation here: https://code.google.com/p/ksoap2-android/issues/detail?id=173
//        connection.disconnect();
//        connection = null;
        return ;
    }
    /**
     * 序列化请求.
     */
    protected byte[] createRequestData(SoapEnvelope envelope, String encoding)
            throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(DEFAULT_BUFFER_SIZE);
        byte result[] = null;
//        bos.write(xmlVersionTag.getBytes());
        XmlSerializer xw = new SoapXmlSerializer();

//        final Iterator keysIter = prefixes.keySet().iterator();
//
//        xw.setOutput(bos, encoding);
//        while (keysIter.hasNext()) {
//            String key = (String) keysIter.next();
//            xw.setPrefix(key, (String) prefixes.get(key));
//        }
        envelope.write(xw);
        xw.flush();
        bos.write('\r');
        bos.write('\n');
        bos.flush();
        result = bos.toByteArray();
        xw = null;
        bos = null;
        return result;
    }
    protected void sendData(byte[] requestData, HttpURLConnection connection, SoapEnvelope envelope)
            throws IOException
    {
        connection.setRequestProperty("Content-Length", "" + requestData.length);
        connection.setFixedLengthStreamingMode(requestData.length);

        OutputStream os = connection.getOutputStream();
        os.write(requestData, 0, requestData.length);
        os.flush();
        os.close();
    }
}
