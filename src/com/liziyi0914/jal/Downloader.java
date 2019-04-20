/*
 * Copyright 2019 liziyi0914.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liziyi0914.jal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author liziyi0914
 */
public class Downloader {

    public static byte[] downLoadFromURL(String urlStr) throws IOException, Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(3 * 1000);
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt) Java");
        conn.connect();
        if(conn.getResponseCode()!=200){
            return null;
        }
        InputStream inputStream = conn.getInputStream();
        byte[] buffer = new byte[inputStream.available()];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int read;
        while((read=inputStream.read())!=-1){
            bos.write(read);
        }
        byte[] getData = bos.toByteArray();
        bos.close();
        return getData;
    }

}
