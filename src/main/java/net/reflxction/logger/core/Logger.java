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

import net.reflxction.logger.utils.Debugger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Logger class
 */
public class Logger {

    // Name of the logger
    private String name;

    // The logger settings
    private LoggerSettings settings;

    // Debugger of this logger
    private Debugger debugger;

    // List which contains all loggers
    private static List<Logger> loggers = new ArrayList<>();

    /**
     * Creates a new logger with the default settings
     *
     * @param name Name of the logger which it should be known with
     */
    public Logger(String name) {
        this(name, LoggerSettings.DEFAULT);
    }

    /**
     * Initiates a new logger with the given settings
     *
     * @param name     Name of the logger which it should be known with
     * @param settings Settings of the logger
     * @see LoggerSettings
     */
    public Logger(String name, LoggerSettings settings) {
        this.name = name;
        this.settings = settings;
        loggers.add(this);
        debugger = new Debugger(this);
    }


    /**
     * Prints a separator
     */
    private void printSeparator() {
        if (settings.separators()) printRaw(getRepeatedSeparator());
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
            printSeparator();
            printRaw("[" + name + "] " + level + " - " + message);
            printSeparator();
        } else {
            printSeparator();
            printRaw("[" + name + "] - " + message);
            printSeparator();
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
    public void printRaw(Object object) {
        if (settings.timestamps()) System.out.println(getTimestamp() + " " + object.toString());
        else System.out.println(object.toString());
    }

    /**
     * Returns a timestamp in the [HH:mm:ss] format
     *
     * @return The current timestamp in the [HH:mm:ss] format
     */
    private String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateFormat = sdf.format(new Date());
        return String.format("[%s]", dateFormat);
    }

    /**
     * The separators as a string, e.g "--------------------"
     *
     * @return The separators as a string, e.g "--------------------"
     */
    private String getRepeatedSeparator() {
        StringBuilder builder = new StringBuilder(settings.getSeparatorChar());
        for (int i = 0; i < 15; i++) {
            builder.append(settings.getSeparatorChar());
        }
        return builder.toString();
    }

    /**
     * Returns the debugger assigned with this logger
     *
     * @return The debugger assigned with this logger
     */
    public Debugger getDebugger() {
        return debugger;
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
        return new Logger(name);
    }
}
