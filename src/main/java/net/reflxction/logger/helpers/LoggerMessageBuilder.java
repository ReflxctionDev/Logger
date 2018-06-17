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
package net.reflxction.logger.helpers;

import java.util.List;

public class LoggerMessageBuilder {

    // Message
    private String message;

    // StringBuilder to manage the string
    private StringBuilder builder;

    /**
     * @param message Message that the logger will start on
     */
    public LoggerMessageBuilder(String message) {
        this.message = message;
        this.builder = new StringBuilder(message);
    }

    /**
     * Appends a message to the string
     *
     * @param message Text to add
     */
    public LoggerMessageBuilder append(String message) {
        builder.append(message);
        return this;
    }

    /**
     * Reverses the current string (e.g "Hi" becomes "iH")
     */
    public LoggerMessageBuilder reverse() {
        builder.reverse();
        return this;
    }

    /**
     * Length of the current string
     *
     * @return Length of the string
     */
    public int getStringLength() {
        return message.length();
    }

    /**
     * Adds an array to the message
     *
     * @param messages Array to add
     */
    public LoggerMessageBuilder append(String[] messages) {
        for (String m : messages) {
            builder.append(m);
        }
        return this;
    }

    /**
     * Adds a list to the message
     *
     * @param messages List to add
     */
    public LoggerMessageBuilder append(List<String> messages) {
        for (String m : messages) {
            builder.append(m);
        }
        return this;
    }

    /**
     * Adds a new line to the string (portable)
     */
    public LoggerMessageBuilder addNewLine() {
        builder.append(System.lineSeparator());
        return this;
    }

    /**
     * Returns the main StringBuilder
     *
     * @return The StringBuilder used to build the message
     */
    public StringBuilder getStringBuilder() {
        return builder;
    }

    /**
     * Returns the message
     *
     * @return String which is equal to the message (after modifies)
     */
    public String getMessage() {
        return builder.toString();
    }
}
