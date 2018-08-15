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

import net.reflxction.logger.core.Logger;

/**
 * A useful utility for debugging variables and lines
 */
public class Debugger {

    // Logger to log for
    private Logger logger;

    /**
     * Initiates a new debugger
     *
     * @param logger Logger to log for
     */
    public Debugger(Logger logger) {
        this.logger = logger;
    }

    /**
     * The current code line number
     *
     * @return The current code line number
     */
    private int getLine() {
        return Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    /**
     * Debugs a specific variable and prints the value.
     * The debug message will include:
     * - Class name (with package)
     * - Line that the method was called in
     * - Variable name
     * - Actual value of the given variable
     *
     * @param t       Object to debug
     * @param nameOfT Name of the variable. This should always be the name of t but as a string,
     *                so if the method was called to debug the variable 'personAge', it should
     *                be called as {@code debug(personAge, "personAge")}.
     * @return The object passed to the method
     */
    public <T> T debug(T t, String nameOfT) {
        String debuggedString = t.getClass().getName() +
                " - line " +
                getLine() +
                ": " +
                nameOfT +
                " = " +
                t;
        logger.printRaw(debuggedString);
        return t;
    }

}
