/*
 * * Copyright 2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.reflxction.logger.utils;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;
import org.json.JSONTokener;

public class LoggerUtils {

    // Instance of the OkHttpClient class.
    private static OkHttpClient httpClient = new OkHttpClient.Builder().build();

    /**
     * Creates a Hastebin link with the entered text
     *
     * @param text Text to be included in the hastebin url
     * @return Link with the hastebin page which contains the given text
     */
    public static String hastebin(final String text) {
        try {
            return "https://hastebin.com/" + new JSONObject(new JSONTokener(httpClient
                    .newCall(new Request.Builder()
                            .post(RequestBody.create(MediaType.parse("text/plain"), text))
                            .url("https://hastebin.com/documents")
                            .header("User-Agent", "RLogger").build())
                    .execute()
                    .body()
                    .charStream())).getString("key");
        } catch (final Exception e) {
            return null;
        }
    }

    public static OkHttpClient getHttpClient() {
        return httpClient;
    }

}
