/*
 * Copyright (C) 2000-2019 Heinz Max Kabutz
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Heinz Max Kabutz licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.javaspecialists.books.dynamicproxies.ch05;

import java.lang.reflect.*;
import java.util.*;

// tag::BetterArrayList[]
public class BetterArrayList<E> extends ArrayList<E> {
   private final Class<E> type;

   public BetterArrayList(int initialCapacity, Class<E> type) {
      super(initialCapacity);
      this.type = type;
   }

   public BetterArrayList(Class<E> type) {
      super();
      this.type = type;
   }

   public BetterArrayList(Collection<? extends E> ts, Class<E> type) {
      super(ts);
      this.type = type;
   }

   // You can modify the return type of an overridden method in Java 5,
   // with some restrictions.
   @Override
   public E[] toArray() {
      return toArray((E[]) Array.newInstance(type, size()));
   }
}
// end::BetterArrayList[]
