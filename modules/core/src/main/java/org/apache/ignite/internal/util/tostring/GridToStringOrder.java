/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.util.tostring;

import java.lang.annotation.*;

/**
 * Attach this annotation to a field to provide its order in
 * {@code toString()} output. By default the order the order is the same as
 * the order of declaration in the class. Fields with smaller order value
 * will come before in {@code toString()} output. If order is not specified
 * the {@link Integer#MAX_VALUE} will be used.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GridToStringOrder {
    /**
     * Numeric order value.
     */
    @SuppressWarnings({"JavaDoc"}) int value();
}
