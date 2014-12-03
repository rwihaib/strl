/*
 *  Licensed to GraphHopper and Peter Karich under one or more contributor
 *  license agreements. See the NOTICE file distributed with this work for 
 *  additional information regarding copyright ownership.
 * 
 *  GraphHopper licenses this file to you under the Apache License, 
 *  Version 2.0 (the "License"); you may not use this file except in 
 *  compliance with the License. You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.graphhopper.storage;

/**
 * This class is used to create the shortest-path-tree from linked entities.
 * <p/>
 * @author Peter Karich
 */
public class EdgeEntry extends Edge implements Cloneable
{
    public EdgeEntry parent;

    public EdgeEntry( int edgeId, int adjNode, double weight )
    {
        super(edgeId, adjNode, weight);
    }

    @Override
    public EdgeEntry clone()
    {
        return new EdgeEntry(edge, adjNode, weight);
    }

    public EdgeEntry cloneFull()
    {
        EdgeEntry de = clone();
        EdgeEntry tmpPrev = parent;
        EdgeEntry cl = de;
        while (tmpPrev != null)
        {
            cl.parent = tmpPrev.clone();
            cl = cl.parent;
            tmpPrev = tmpPrev.parent;
        }
        return de;
    }
}
