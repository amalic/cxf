/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.ws.security.kerberos;

import org.apache.cxf.Bus;
import org.apache.cxf.message.Message;
import org.apache.cxf.ws.security.SecurityConstants;

/**
 * 
 */
public final class KerberosUtils {

    private KerberosUtils() {
        //utility class
    }
    
    public static KerberosClient getClient(Message message, String type) {
        if (type == null) {
            type = "";
        } else {
            type = "." + type + "-client";
        }
        KerberosClient client = (KerberosClient)message
            .getContextualProperty(SecurityConstants.KERBEROS_CLIENT);
        if (client == null) {
            client = new KerberosClient(message.getExchange().get(Bus.class));
        }
        return client;
    }
    
}
