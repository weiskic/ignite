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

package org.apache.ignite.internal.websession;

import junit.framework.*;

/**
 * Test suite for web sessions caching functionality.
 */
@SuppressWarnings("PublicInnerClass")
public class IgniteWebSessionSelfTestSuite extends TestSuite {
    /**
     * @return Test suite.
     * @throws Exception Thrown in case of the failure.
     */
    public static TestSuite suite() throws Exception {
        TestSuite suite = new TestSuite("Ignite Web Sessions Test Suite");

        suite.addTestSuite(WebSessionSelfTest.class);
        suite.addTestSuite(WebSessionTransactionalSelfTest.class);
        suite.addTestSuite(WebSessionReplicatedSelfTest.class);

        return suite;
    }

    /**
     * Tests web sessions with TRANSACTIONAL cache.
     */
    public static class WebSessionTransactionalSelfTest extends WebSessionSelfTest {
        /** {@inheritDoc} */
        @Override protected String getCacheName() {
            return "partitioned_tx";
        }

        /** {@inheritDoc} */
        @Override public void testRestarts() throws Exception {
            // TODO GG-8166, enable when fixed.
        }
    }

    /**
     * Tests web sessions with REPLICATED cache.
     */
    public static class WebSessionReplicatedSelfTest extends WebSessionSelfTest {
        /** {@inheritDoc} */
        @Override protected String getCacheName() {
            return "replicated";
        }
    }
}
