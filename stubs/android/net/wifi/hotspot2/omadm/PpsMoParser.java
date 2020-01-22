/**
 * Copyright (c) 2016, The Android Open Source Project
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


package android.net.wifi.hotspot2.omadm;

import android.net.wifi.hotspot2.pps.Credential;
import android.net.wifi.hotspot2.PasspointConfiguration;

/**
 * Utility class for converting OMA-DM (Open Mobile Alliance's Device Management)
 * PPS-MO (PerProviderSubscription Management Object) XML tree to a
 * {@link android.net.wifi.hotspot2.PasspointConfiguration PasspointConfiguration} object.
 *
 * Currently this only supports PerProviderSubscription/HomeSP and
 * PerProviderSubscription/Credential subtree for Hotspot 2.0 Release 1 support.
 *
 * For more info, refer to Hotspot 2.0 PPS MO defined in section 9.1 of the Hotspot 2.0
 * Release 2 Technical Specification.
 *
 * Below is a sample XML string for a Release 1 PPS MO tree:
 *
 * <MgmtTree xmlns="syncml:dmddf1.2">
 *   <VerDTD>1.2</VerDTD>
 *   <Node>
 *     <NodeName>PerProviderSubscription</NodeName>
 *     <RTProperties>
 *       <Type>
 *         <DDFName>urn:wfa:mo:hotspot2dot0­perprovidersubscription:1.0</DDFName>
 *       </Type>
 *     </RTProperties>
 *     <Node>
 *       <NodeName>i001</NodeName>
 *       <Node>
 *         <NodeName>HomeSP</NodeName>
 *         <Node>
 *           <NodeName>FriendlyName</NodeName>
 *           <Value>Century House</Value>
 *         </Node>
 *         <Node>
 *           <NodeName>FQDN</NodeName>
 *           <Value>mi6.co.uk</Value>
 *         </Node>
 *         <Node>
 *           <NodeName>RoamingConsortiumOI</NodeName>
 *           <Value>112233,445566</Value>
 *         </Node>
 *       </Node>
 *       <Node>
 *         <NodeName>Credential</NodeName>
 *         <Node>
 *           <NodeName>Realm</NodeName>
 *           <Value>shaken.stirred.com</Value>
 *         </Node>
 *         <Node>
 *           <NodeName>UsernamePassword</NodeName>
 *           <Node>
 *             <NodeName>Username</NodeName>
 *             <Value>james</Value>
 *           </Node>
 *           <Node>
 *             <NodeName>Password</NodeName>
 *             <Value>Ym9uZDAwNw==</Value>
 *           </Node>
 *           <Node>
 *             <NodeName>EAPMethod</NodeName>
 *             <Node>
 *               <NodeName>EAPType</NodeName>
 *               <Value>21</Value>
 *             </Node>
 *             <Node>
 *               <NodeName>InnerMethod</NodeName>
 *               <Value>MS-CHAP-V2</Value>
 *             </Node>
 *           </Node>
 *         </Node>
 *       </Node>
 *     </Node>
 *   </Node>
 * </MgmtTree>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PpsMoParser {

PpsMoParser() { throw new RuntimeException("Stub!"); }

/**
 * Convert a XML string representation of a PPS MO (PerProviderSubscription
 * Management Object) tree to a {@link android.net.wifi.hotspot2.PasspointConfiguration PasspointConfiguration} object.
 *
 * @param xmlString XML string representation of a PPS MO tree
 * @return {@link android.net.wifi.hotspot2.PasspointConfiguration PasspointConfiguration} or null
 * @apiSince 26
 */

public static android.net.wifi.hotspot2.PasspointConfiguration parseMoText(java.lang.String xmlString) { throw new RuntimeException("Stub!"); }
}

