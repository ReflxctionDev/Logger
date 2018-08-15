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
package net.reflxction.logger.core;

/**
 * Settings for the logger
 */
public class LoggerSettings {

    // Whether it should print separators or not
    private boolean separators = false;

    // The separator character
    private String separatorChar = "";

    // Whether it should print timestamps or not (e.g [HH:MM:SS])
    private boolean timestamps = true;

    // The default settings for the logger
    public static final LoggerSettings DEFAULT = new LoggerSettings().setTimestamps(true);

    /**
     * Whether it should print separators when logging or not
     *
     * @return Whether it should print separators when logging or not
     */
    boolean separators() {
        return separators;
    }

    /**
     * Sets whether it should print separators or not.
     * This method automatically sets the value of {@link #separators} to {@code true}, and
     * the given parameter will update the value of {@link #separatorChar}
     *
     * @param separatorChar The separator char
     */
    private LoggerSettings setSeparators(String separatorChar) {
        this.separators = true;
        setSeparatorChar(separatorChar);
        return this;
    }

    /**
     * The separator character
     *
     * @return The separator character
     */
    public String getSeparatorChar() {
        return separatorChar;
    }

    /**
     * Sets the separator character
     *
     * @param separatorChar New character to set
     * @see LoggerSettings#setSeparators(String)
     */
    private void setSeparatorChar(String separatorChar) {
        this.separatorChar = separatorChar;
    }

    /**
     * Whether it should prefix logging messages with timestamps
     *
     * @return Whether it should prefix logging messages with timestamps
     */
    public boolean timestamps() {
        return timestamps;
    }

    /**
     * Sets whether it should prefix logging messages with timestamps
     *
     * @param timestamps New value to set
     */
    public LoggerSettings setTimestamps(boolean timestamps) {
        this.timestamps = timestamps;
        return this;
    }
}
