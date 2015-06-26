/*
 * Copyright 2015 Stormpath, Inc.
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
package com.stormpath.sdk.servlet.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * An http {@code Saver} is able to save (persist) a value for later access.
 *
 * @param <T> the type of value to be persisted.
 * @since 1.0.RC3
 */
public interface Saver<T> {

    /**
     * Persists the specified value for later access.  A null or empty {@code value} indicates that the value should be
     * removed.
     *
     * @param request  inbound request
     * @param response outbound response
     * @param value    value to save for later access or {@code null} to remove any previously saved value.
     */
    void set(HttpServletRequest request, HttpServletResponse response, T value);

}
