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

package org.apache.ignite.loadtests.streamer;

import org.apache.ignite.*;
import org.apache.ignite.lang.*;
import org.apache.ignite.internal.util.typedef.*;

import java.util.*;

/**
 * Closure for events generation.
 */
class EventClosure implements IgniteInClosure<IgniteStreamer> {
    /** Random range. */
    private int rndRange = 100;

    /** {@inheritDoc} */
    @Override public void apply(IgniteStreamer streamer) {
        Random rnd = new Random();

        while (!Thread.interrupted()) {
            try {
                streamer.addEvent(rnd.nextInt(rndRange));
            }
            catch (IgniteCheckedException e) {
                X.println("Failed to add streamer event: " + e);
            }
        }
    }

    /**
     * @return Random range.
     */
    public int getRandomRange() {
        return rndRange;
    }

    /**
     * @param rndRange Random range.
     */
    public void setRandomRange(int rndRange) {
        this.rndRange = rndRange;
    }
}
