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

import java.util.ArrayList;
import java.util.List;

/**
 * Logger class
 */
public class Logger {

    // Name of the logger
    private String name;

    // If it should add separators
    private boolean separators = false;

    // String which is a repeating character between every message that is printed
    private String sep;

    // List which contains all loggers
    private static List<Logger> loggers = new ArrayList<>();

    /**
     * @param name Name of the logger which it should be known with
     */
    public Logger(String name, boolean separators) {
        this.name = name;
        this.separators = separators;
        this.sep = "";
        loggers.add(this);
    }

    /**
     * Prints a message to the console output
     *
     * @param message Message to print
     * @param level   Warning level of the message
     * @see LoggerLevel
     */
    public void print(String message, LoggerLevel level) {
        if (level != LoggerLevel.INFO) {
            if(separators) print(getRepeatedSeparator());
            print("[" + name + "] " + level + " - " + message);
            if(separators) print(getRepeatedSeparator());
        } else {
            if(separators) print(getRepeatedSeparator());
            print("[" + name + "] - " + message);
            if(separators) print(getRepeatedSeparator());
        }
    }

    /**
     * Prints an error message to the console output
     *
     * @param message Message to be printed
     */
    public void error(String message) {
        print(message, LoggerLevel.FATAL);
    }

    /**
     * Prints a warning message to the console output
     *
     * @param message Message to be printed
     */
    public void warning(String message) {
        print(message, LoggerLevel.WARNING);
    }

    /**
     * Prints a success message to the console output
     *
     * @param message Message to be printed
     */
    public void success(String message) {
        print(message, LoggerLevel.SUCCESS);
    }

    /**
     * Prints a normal message to the console output
     *
     * @param message Message to be printed
     */
    public void info(String message) {
        print(message, LoggerLevel.INFO);
    }

    /**
     * A list of all available loggers
     *
     * @return List which contains all loggers
     */
    public static List<Logger> getLoggers() {
        return loggers;
    }

    /**
     * Name of the logger
     *
     * @return The name of the current logger
     */
    public String getName() {
        return name;
    }

    /**
     * A shortcut to PrintStream#println();
     *
     * @param object Object to print
     * @see java.io.PrintStream
     */
    private void print(Object object) {
        System.out.println(object.toString());
    }

    /**
     * Set if it should add separators between logged messages
     *
     * @param flag If it should add separators
     */
    public void setSeperators(boolean flag) {
        this.separators = flag;
    }

    /**
     * Set the separator string which repeats
     *
     * @param sep String to set the separator to
     */
    public void setSeparatorString(String sep) {
        this.sep = sep;
    }

    private String getRepeatedSeparator() {
        StringBuilder builder = new StringBuilder(sep);
        for (int i = 0; i < 15; i++) {
            builder.append(sep);
        }
        return builder.toString();
    }

    /**
     * Gives a logger with the given
     *
     * @param name Name to find the logger with
     * @return Logger with the given name, or a new logger if the logger name given isn't available
     */
    public static Logger getLogger(String name) {
        for (Logger logger : getLoggers()) {
            if (logger.getName().equalsIgnoreCase(name)) {
                return logger;
            }
        }
        return new Logger(name, false);
    }


}
