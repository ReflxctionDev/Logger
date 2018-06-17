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

public enum LoggerLevel {

    // Success of an action/a method
    SUCCESS("[Success]"),

    // Warning, the program may not function correctly, but will function
    WARNING("[Warning]"),

    // Fatal problem, the problem may not function
    FATAL("[Fatal]"),

    // A normal logging level
    INFO("");

    // Name of the level
    private String name;

    LoggerLevel(String name) {
        this.name = name;
    }

    /**
     * Overrides the toString() method, so we don't need to call any other methods when we need the string value (As Java calls toString() whenever it's between strings)
     *
     * @return Level of the warning
     */
    @Override
    public String toString() {
        return name;
    }
}
