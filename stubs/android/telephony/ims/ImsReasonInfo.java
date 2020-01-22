/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */


package android.telephony.ims;


/**
 * Provides details on why an IMS call failed. Applications can use the methods in this class to
 * get local or network fault behind an IMS services failure. For example, if the code is
 * CODE_CALL_BARRED, then the call was blocked by network call barring configuration and it is not
 * the device's bug and the user can retry the call when network lift the barring.
 * Typical use case includes call backs when IMS call state changed with this class as a param
 * containing details on why IMS call changed state/failed.
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ImsReasonInfo implements android.os.Parcelable {

/**
 * @param code Value is {@link android.telephony.ims.ImsReasonInfo#CODE_UNSPECIFIED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_ILLEGAL_ARGUMENT}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_ILLEGAL_STATE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_INTERNAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_IMS_SERVICE_DOWN}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NO_PENDING_CALL}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_ENDED_BY_CONFERENCE_MERGE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_POWER_OFF}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_LOW_BATTERY}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NETWORK_NO_SERVICE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NETWORK_NO_LTE_COVERAGE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NETWORK_ROAMING}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NETWORK_IP_CHANGED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_SERVICE_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NOT_REGISTERED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_EXCEEDED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_BUSY}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_DECLINE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_VCC_ON_PROGRESSING}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_RESOURCE_RESERVATION_FAILED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_CS_RETRY_REQUIRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_VOLTE_RETRY_REQUIRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_TERMINATED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_HO_NOT_FEASIBLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_TIMEOUT_1XX_WAITING}, {@link android.telephony.ims.ImsReasonInfo#CODE_TIMEOUT_NO_ANSWER}, {@link android.telephony.ims.ImsReasonInfo#CODE_TIMEOUT_NO_ANSWER_CALL_UPDATE}, {@link android.telephony.ims.ImsReasonInfo#CODE_CALL_BARRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_FDN_BLOCKED}, {@link android.telephony.ims.ImsReasonInfo#CODE_IMEI_NOT_ACCEPTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_MODIFIED_TO_USSD}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_MODIFIED_TO_SS}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_MODIFIED_TO_DIAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_MODIFIED_TO_DIAL_VIDEO}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_VIDEO_MODIFIED_TO_DIAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_VIDEO_MODIFIED_TO_DIAL_VIDEO}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_VIDEO_MODIFIED_TO_SS}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_VIDEO_MODIFIED_TO_USSD}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REDIRECTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_BAD_REQUEST}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_FORBIDDEN}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_NOT_FOUND}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_NOT_SUPPORTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_TIMEOUT}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_TEMPRARILY_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_BAD_ADDRESS}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_BUSY}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_CANCELLED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_NOT_ACCEPTABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_NOT_REACHABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_CLIENT_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_TRANSACTION_DOES_NOT_EXIST}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_SERVER_INTERNAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_SERVICE_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_SERVER_TIMEOUT}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_SERVER_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_USER_REJECTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_GLOBAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_EMERGENCY_TEMP_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_EMERGENCY_PERM_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_USER_MARKED_UNWANTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_METHOD_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_PROXY_AUTHENTICATION_REQUIRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_ENTITY_TOO_LARGE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_URI_TOO_LARGE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_EXTENSION_REQUIRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_INTERVAL_TOO_BRIEF}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_CALL_OR_TRANS_DOES_NOT_EXIST}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_LOOP_DETECTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_TOO_MANY_HOPS}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_AMBIGUOUS}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_PENDING}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_UNDECIPHERABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_MEDIA_INIT_FAILED}, {@link android.telephony.ims.ImsReasonInfo#CODE_MEDIA_NO_DATA}, {@link android.telephony.ims.ImsReasonInfo#CODE_MEDIA_NOT_ACCEPTABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_MEDIA_UNSPECIFIED}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_TERMINATED}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_NOANSWER}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_IGNORE}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_DECLINE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOW_BATTERY}, {@link android.telephony.ims.ImsReasonInfo#CODE_BLACKLISTED_CALL_ID}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_TERMINATED_BY_REMOTE}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_REJECTED_SESSION_MODIFICATION}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_CANCELLED_SESSION_MODIFICATION}, {@link android.telephony.ims.ImsReasonInfo#CODE_SESSION_MODIFICATION_FAILED}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_NOT_SUPPORTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SERVICE_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_OPERATION_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_NETWORK_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_CB_PASSWORD_MISMATCH}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SS_MODIFIED_TO_DIAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SS_MODIFIED_TO_USSD}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SS_MODIFIED_TO_SS}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SS_MODIFIED_TO_DIAL_VIDEO}, {@link android.telephony.ims.ImsReasonInfo#CODE_ECBM_NOT_SUPPORTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_MULTIENDPOINT_NOT_SUPPORTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REGISTRATION_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_ANSWERED_ELSEWHERE}, {@link android.telephony.ims.ImsReasonInfo#CODE_CALL_PULL_OUT_OF_SYNC}, {@link android.telephony.ims.ImsReasonInfo#CODE_CALL_END_CAUSE_CALL_PULL}, {@link android.telephony.ims.ImsReasonInfo#CODE_CALL_DROP_IWLAN_TO_LTE_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECTED_ELSEWHERE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SUPP_SVC_FAILED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SUPP_SVC_CANCELLED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SUPP_SVC_REINVITE_COLLISION}, {@link android.telephony.ims.ImsReasonInfo#CODE_IWLAN_DPD_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_EPDG_TUNNEL_ESTABLISH_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_EPDG_TUNNEL_REKEY_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_EPDG_TUNNEL_LOST_CONNECTION}, {@link android.telephony.ims.ImsReasonInfo#CODE_MAXIMUM_NUMBER_OF_CALLS_REACHED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REMOTE_CALL_DECLINE}, {@link android.telephony.ims.ImsReasonInfo#CODE_DATA_LIMIT_REACHED}, {@link android.telephony.ims.ImsReasonInfo#CODE_DATA_DISABLED}, {@link android.telephony.ims.ImsReasonInfo#CODE_WIFI_LOST}, {@link android.telephony.ims.ImsReasonInfo#CODE_IKEV2_AUTH_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_OFF}, {@link android.telephony.ims.ImsReasonInfo#CODE_NO_VALID_SIM}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_INTERNAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_NETWORK_RESP_TIMEOUT}, {@link android.telephony.ims.ImsReasonInfo#CODE_NETWORK_REJECT}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_ACCESS_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_LINK_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_LINK_LOST}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_UPLINK_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_SETUP_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_RELEASE_NORMAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_RELEASE_ABNORMAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_ACCESS_CLASS_BLOCKED}, {@link android.telephony.ims.ImsReasonInfo#CODE_NETWORK_DETACH}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_ALTERNATE_EMERGENCY_CALL}, android.telephony.ims.ImsReasonInfo.CODE_UNOBTAINABLE_NUMBER, {@link android.telephony.ims.ImsReasonInfo#CODE_NO_CSFB_IN_CS_ROAM}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_UNKNOWN}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CALL_WAITING_DISABLED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_CALL_ON_OTHER_SUB}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_1X_COLLISION}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_SERVICE_NOT_REGISTERED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_CALL_TYPE_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_E911_CALL}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CALL_SETUP}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_MAX_CALL_LIMIT_REACHED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_UNSUPPORTED_SIP_HEADERS}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_UNSUPPORTED_SDP_HEADERS}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CALL_TRANSFER}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_INTERNAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_QOS_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_HANDOVER}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_VT_TTY_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CALL_UPGRADE}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_CONFERENCE_TTY_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CONFERENCE_CALL}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_VT_AVPF_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_ENCRYPTED_CALL}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CS_CALL}, android.telephony.ims.ImsReasonInfo.CODE_RETRY_ON_IMS_WITHOUT_RTT, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_1}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_2}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_3}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_4}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_5}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_6}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_7}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_8}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_9}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_10}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_11}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_12}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_13}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_14}, or {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_15}
 
 * @param extraMessage This value may be {@code null}.
 * @apiSince R
 */

public ImsReasonInfo(int code, int extraCode, @androidx.annotation.Nullable java.lang.String extraMessage) { throw new RuntimeException("Stub!"); }

/**
 * @return an integer representing more information about the completion of an operation.
 
 * Value is {@link android.telephony.ims.ImsReasonInfo#CODE_UNSPECIFIED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_ILLEGAL_ARGUMENT}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_ILLEGAL_STATE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_INTERNAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_IMS_SERVICE_DOWN}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NO_PENDING_CALL}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_ENDED_BY_CONFERENCE_MERGE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_POWER_OFF}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_LOW_BATTERY}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NETWORK_NO_SERVICE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NETWORK_NO_LTE_COVERAGE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NETWORK_ROAMING}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NETWORK_IP_CHANGED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_SERVICE_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_NOT_REGISTERED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_EXCEEDED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_BUSY}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_DECLINE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_VCC_ON_PROGRESSING}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_RESOURCE_RESERVATION_FAILED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_CS_RETRY_REQUIRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_VOLTE_RETRY_REQUIRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_CALL_TERMINATED}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOCAL_HO_NOT_FEASIBLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_TIMEOUT_1XX_WAITING}, {@link android.telephony.ims.ImsReasonInfo#CODE_TIMEOUT_NO_ANSWER}, {@link android.telephony.ims.ImsReasonInfo#CODE_TIMEOUT_NO_ANSWER_CALL_UPDATE}, {@link android.telephony.ims.ImsReasonInfo#CODE_CALL_BARRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_FDN_BLOCKED}, {@link android.telephony.ims.ImsReasonInfo#CODE_IMEI_NOT_ACCEPTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_MODIFIED_TO_USSD}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_MODIFIED_TO_SS}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_MODIFIED_TO_DIAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_MODIFIED_TO_DIAL_VIDEO}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_VIDEO_MODIFIED_TO_DIAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_VIDEO_MODIFIED_TO_DIAL_VIDEO}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_VIDEO_MODIFIED_TO_SS}, {@link android.telephony.ims.ImsReasonInfo#CODE_DIAL_VIDEO_MODIFIED_TO_USSD}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REDIRECTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_BAD_REQUEST}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_FORBIDDEN}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_NOT_FOUND}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_NOT_SUPPORTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_TIMEOUT}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_TEMPRARILY_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_BAD_ADDRESS}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_BUSY}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_CANCELLED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_NOT_ACCEPTABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_NOT_REACHABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_CLIENT_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_TRANSACTION_DOES_NOT_EXIST}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_SERVER_INTERNAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_SERVICE_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_SERVER_TIMEOUT}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_SERVER_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_USER_REJECTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_GLOBAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_EMERGENCY_TEMP_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_EMERGENCY_PERM_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_USER_MARKED_UNWANTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_METHOD_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_PROXY_AUTHENTICATION_REQUIRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_ENTITY_TOO_LARGE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_URI_TOO_LARGE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_EXTENSION_REQUIRED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_INTERVAL_TOO_BRIEF}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_CALL_OR_TRANS_DOES_NOT_EXIST}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_LOOP_DETECTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_TOO_MANY_HOPS}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_AMBIGUOUS}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_REQUEST_PENDING}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_UNDECIPHERABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_MEDIA_INIT_FAILED}, {@link android.telephony.ims.ImsReasonInfo#CODE_MEDIA_NO_DATA}, {@link android.telephony.ims.ImsReasonInfo#CODE_MEDIA_NOT_ACCEPTABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_MEDIA_UNSPECIFIED}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_TERMINATED}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_NOANSWER}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_IGNORE}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_DECLINE}, {@link android.telephony.ims.ImsReasonInfo#CODE_LOW_BATTERY}, {@link android.telephony.ims.ImsReasonInfo#CODE_BLACKLISTED_CALL_ID}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_TERMINATED_BY_REMOTE}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_REJECTED_SESSION_MODIFICATION}, {@link android.telephony.ims.ImsReasonInfo#CODE_USER_CANCELLED_SESSION_MODIFICATION}, {@link android.telephony.ims.ImsReasonInfo#CODE_SESSION_MODIFICATION_FAILED}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_NOT_SUPPORTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SERVICE_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_OPERATION_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_NETWORK_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_CB_PASSWORD_MISMATCH}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SS_MODIFIED_TO_DIAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SS_MODIFIED_TO_USSD}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SS_MODIFIED_TO_SS}, {@link android.telephony.ims.ImsReasonInfo#CODE_UT_SS_MODIFIED_TO_DIAL_VIDEO}, {@link android.telephony.ims.ImsReasonInfo#CODE_ECBM_NOT_SUPPORTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_MULTIENDPOINT_NOT_SUPPORTED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REGISTRATION_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_ANSWERED_ELSEWHERE}, {@link android.telephony.ims.ImsReasonInfo#CODE_CALL_PULL_OUT_OF_SYNC}, {@link android.telephony.ims.ImsReasonInfo#CODE_CALL_END_CAUSE_CALL_PULL}, {@link android.telephony.ims.ImsReasonInfo#CODE_CALL_DROP_IWLAN_TO_LTE_UNAVAILABLE}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECTED_ELSEWHERE}, {@link android.telephony.ims.ImsReasonInfo#CODE_SUPP_SVC_FAILED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SUPP_SVC_CANCELLED}, {@link android.telephony.ims.ImsReasonInfo#CODE_SUPP_SVC_REINVITE_COLLISION}, {@link android.telephony.ims.ImsReasonInfo#CODE_IWLAN_DPD_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_EPDG_TUNNEL_ESTABLISH_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_EPDG_TUNNEL_REKEY_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_EPDG_TUNNEL_LOST_CONNECTION}, {@link android.telephony.ims.ImsReasonInfo#CODE_MAXIMUM_NUMBER_OF_CALLS_REACHED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REMOTE_CALL_DECLINE}, {@link android.telephony.ims.ImsReasonInfo#CODE_DATA_LIMIT_REACHED}, {@link android.telephony.ims.ImsReasonInfo#CODE_DATA_DISABLED}, {@link android.telephony.ims.ImsReasonInfo#CODE_WIFI_LOST}, {@link android.telephony.ims.ImsReasonInfo#CODE_IKEV2_AUTH_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_OFF}, {@link android.telephony.ims.ImsReasonInfo#CODE_NO_VALID_SIM}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_INTERNAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_NETWORK_RESP_TIMEOUT}, {@link android.telephony.ims.ImsReasonInfo#CODE_NETWORK_REJECT}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_ACCESS_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_LINK_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_LINK_LOST}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_UPLINK_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_SETUP_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_RELEASE_NORMAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_RADIO_RELEASE_ABNORMAL}, {@link android.telephony.ims.ImsReasonInfo#CODE_ACCESS_CLASS_BLOCKED}, {@link android.telephony.ims.ImsReasonInfo#CODE_NETWORK_DETACH}, {@link android.telephony.ims.ImsReasonInfo#CODE_SIP_ALTERNATE_EMERGENCY_CALL}, android.telephony.ims.ImsReasonInfo.CODE_UNOBTAINABLE_NUMBER, {@link android.telephony.ims.ImsReasonInfo#CODE_NO_CSFB_IN_CS_ROAM}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_UNKNOWN}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CALL_WAITING_DISABLED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_CALL_ON_OTHER_SUB}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_1X_COLLISION}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_SERVICE_NOT_REGISTERED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_CALL_TYPE_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_E911_CALL}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CALL_SETUP}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_MAX_CALL_LIMIT_REACHED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_UNSUPPORTED_SIP_HEADERS}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_UNSUPPORTED_SDP_HEADERS}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CALL_TRANSFER}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_INTERNAL_ERROR}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_QOS_FAILURE}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_HANDOVER}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_VT_TTY_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CALL_UPGRADE}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_CONFERENCE_TTY_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CONFERENCE_CALL}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_VT_AVPF_NOT_ALLOWED}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_ENCRYPTED_CALL}, {@link android.telephony.ims.ImsReasonInfo#CODE_REJECT_ONGOING_CS_CALL}, android.telephony.ims.ImsReasonInfo.CODE_RETRY_ON_IMS_WITHOUT_RTT, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_1}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_2}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_3}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_4}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_5}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_6}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_7}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_8}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_9}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_10}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_11}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_12}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_13}, {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_14}, or {@link android.telephony.ims.ImsReasonInfo#CODE_OEM_CAUSE_15}
 * @apiSince R
 */

public int getCode() { throw new RuntimeException("Stub!"); }

/**
 * @return an optional OEM specified code that provides extra information.
 * @apiSince R
 */

public int getExtraCode() { throw new RuntimeException("Stub!"); }

/**
 * @return an optional OEM specified string that provides extra information about the operation
 * result.
 
 * This value may be {@code null}.
 * @apiSince R
 */

@androidx.annotation.Nullable
public java.lang.String getExtraMessage() { throw new RuntimeException("Stub!"); }

/**
 * @return the string format of {@link android.telephony.ims.ImsReasonInfo ImsReasonInfo}
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param out This value must never be {@code null}.
 * @apiSince R
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Call failed because of access class barring
 * @apiSince R
 */

public static final int CODE_ACCESS_CLASS_BLOCKED = 1512; // 0x5e8

/**
 * MT call has ended due to a release from the network because the call was answered elsewhere.
 * @apiSince R
 */

public static final int CODE_ANSWERED_ELSEWHERE = 1014; // 0x3f6

/**
 * Device declined a call due to a blacklisted caller ID.
 * @apiSince R
 */

public static final int CODE_BLACKLISTED_CALL_ID = 506; // 0x1fa

/**
 * The call was blocked by call barring configuration.
 * @apiSince R
 */

public static final int CODE_CALL_BARRED = 240; // 0xf0

/**
 * CALL DROP error code for the case when a device is ePDG capable and when the user is on an
 * active wifi call and at the edge of coverage and there is no qualified LTE network available
 * to handover the call to. We get a handover NOT_TRIGERRED message from the modem. This error
 * code is received as part of the handover message.
 * @apiSince R
 */

public static final int CODE_CALL_DROP_IWLAN_TO_LTE_UNAVAILABLE = 1100; // 0x44c

/**
 * For MultiEndpoint - Call has been pulled from primary to secondary.
 * @apiSince R
 */

public static final int CODE_CALL_END_CAUSE_CALL_PULL = 1016; // 0x3f8

/**
 * For MultiEndpoint - Call Pull request has failed.
 * @apiSince R
 */

public static final int CODE_CALL_PULL_OUT_OF_SYNC = 1015; // 0x3f7

/**
 * Indicates the call was disconnected due to the user disabling cellular data.
 * @apiSince R
 */

public static final int CODE_DATA_DISABLED = 1406; // 0x57e

/**
 * Indicates the call was disconnected due to the user reaching their data limit.
 * @apiSince R
 */

public static final int CODE_DATA_LIMIT_REACHED = 1405; // 0x57d

/**
 * Stk Call Control modified DIAL request to DIAL with modified data.
 * @apiSince R
 */

public static final int CODE_DIAL_MODIFIED_TO_DIAL = 246; // 0xf6

/**
 * Stk Call Control modified DIAL request to Video DIAL request.
 * @apiSince R
 */

public static final int CODE_DIAL_MODIFIED_TO_DIAL_VIDEO = 247; // 0xf7

/**
 * Stk Call Control modified DIAL request to SS request.
 * @apiSince R
 */

public static final int CODE_DIAL_MODIFIED_TO_SS = 245; // 0xf5

/**
 * Stk Call Control modified DIAL request to USSD request.
 * @apiSince R
 */

public static final int CODE_DIAL_MODIFIED_TO_USSD = 244; // 0xf4

/**
 * Stk Call Control modified Video DIAL request to DIAL request.
 * @apiSince R
 */

public static final int CODE_DIAL_VIDEO_MODIFIED_TO_DIAL = 248; // 0xf8

/**
 * Stk Call Control modified Video DIAL request to Video DIAL request.
 * @apiSince R
 */

public static final int CODE_DIAL_VIDEO_MODIFIED_TO_DIAL_VIDEO = 249; // 0xf9

/**
 * Stk Call Control modified Video DIAL request to SS request.
 * @apiSince R
 */

public static final int CODE_DIAL_VIDEO_MODIFIED_TO_SS = 250; // 0xfa

/**
 * Stk Call Control modified Video DIAL request to USSD request.
 * @apiSince R
 */

public static final int CODE_DIAL_VIDEO_MODIFIED_TO_USSD = 251; // 0xfb

/**
 * Emergency callback mode is not supported.
 * @apiSince R
 */

public static final int CODE_ECBM_NOT_SUPPORTED = 901; // 0x385

/**
 * Emergency call failed in the modem with a permanent fail cause and should not be redialed on
 * this slot. If there are any other slots available for emergency calling, try those.
 * @apiSince R
 */

public static final int CODE_EMERGENCY_PERM_FAILURE = 364; // 0x16c

/**
 * Emergency call failed in the modem with a temporary fail cause and should be redialed on this
 * slot.
 * @apiSince R
 */

public static final int CODE_EMERGENCY_TEMP_FAILURE = 363; // 0x16b

/**
 * Establishment of the ePDG Tunnel Failed.
 * @apiSince R
 */

public static final int CODE_EPDG_TUNNEL_ESTABLISH_FAILURE = 1400; // 0x578

/**
 * Connection to the packet gateway is lost.
 * @apiSince R
 */

public static final int CODE_EPDG_TUNNEL_LOST_CONNECTION = 1402; // 0x57a

/**
 * Re-keying of the ePDG Tunnel Failed; may not always result in teardown.
 * @apiSince R
 */

public static final int CODE_EPDG_TUNNEL_REKEY_FAILURE = 1401; // 0x579

/**
 * The operation is restricted to fixed dialing numbers only.
 * @apiSince R
 */

public static final int CODE_FDN_BLOCKED = 241; // 0xf1

/**
 * Indicates the registration attempt on IWLAN failed due to IKEv2 authetication failure
 * during tunnel establishment.
 * @apiSince R
 */

public static final int CODE_IKEV2_AUTH_FAILURE = 1408; // 0x580

/**
 * Network rejected the emergency call request because IMEI was used as identification
 * and this capability is not supported by the network.
 * @apiSince R
 */

public static final int CODE_IMEI_NOT_ACCEPTED = 243; // 0xf3

/**
 * DPD Procedure received no response or send failed.
 * @apiSince R
 */

public static final int CODE_IWLAN_DPD_FAILURE = 1300; // 0x514

/**
 * The call is busy.
 * @apiSince R
 */

public static final int CODE_LOCAL_CALL_BUSY = 142; // 0x8e

/**
 * VoLTE service can't be provided by the network or remote end, retry the call.
 * Resolve the extra code provided in (EXTRA_CODE_CALL_RETRY_*) if the below code is set
 * @apiSince R
 */

public static final int CODE_LOCAL_CALL_CS_RETRY_REQUIRED = 146; // 0x92

/**
 * The Call has been declined locally on this device.
 * @apiSince R
 */

public static final int CODE_LOCAL_CALL_DECLINE = 143; // 0x8f

/**
 * Maximum number of simultaneous calls exceeded
 * @apiSince R
 */

public static final int CODE_LOCAL_CALL_EXCEEDED = 141; // 0x8d

/**
 * Can not complete call; resource reservation is failed (QoS precondition)
 * @apiSince R
 */

public static final int CODE_LOCAL_CALL_RESOURCE_RESERVATION_FAILED = 145; // 0x91

/**
 * IMS call is already terminated (in TERMINATED state).
 * @apiSince R
 */

public static final int CODE_LOCAL_CALL_TERMINATED = 148; // 0x94

/**
 * Can not complete call; an SRVCC is in progress.
 * @apiSince R
 */

public static final int CODE_LOCAL_CALL_VCC_ON_PROGRESSING = 144; // 0x90

/**
 * VoLTE service can't be provided by the network temporarily, retry the call.
 * @apiSince R
 */

public static final int CODE_LOCAL_CALL_VOLTE_RETRY_REQUIRED = 147; // 0x93

/**
 * IMS Call ended during conference merge process
 * @apiSince R
 */

public static final int CODE_LOCAL_ENDED_BY_CONFERENCE_MERGE = 108; // 0x6c

/**
 * Call was disconnected because a handover is not feasible due to network conditions.
 * @apiSince R
 */

public static final int CODE_LOCAL_HO_NOT_FEASIBLE = 149; // 0x95

/**
 * The passed argument is invalid.
 * @apiSince R
 */

public static final int CODE_LOCAL_ILLEGAL_ARGUMENT = 101; // 0x65

/**
 * The operation was invoked while in an invalid call state.
 * @apiSince R
 */

public static final int CODE_LOCAL_ILLEGAL_STATE = 102; // 0x66

/**
 * ImsService has crashed (service connection is lost).
 * @apiSince R
 */

public static final int CODE_LOCAL_IMS_SERVICE_DOWN = 106; // 0x6a

/**
 * IMS service internal error
 * @apiSince R
 */

public static final int CODE_LOCAL_INTERNAL_ERROR = 103; // 0x67

/**
 * Service unavailable; low battery
 * @apiSince R
 */

public static final int CODE_LOCAL_LOW_BATTERY = 112; // 0x70

/**
 * Service unavailable; IP changed
 * @apiSince R
 */

public static final int CODE_LOCAL_NETWORK_IP_CHANGED = 124; // 0x7c

/**
 * Service unavailable; no LTE coverage
 * (VoLTE is not supported even though IMS is registered)
 * @apiSince R
 */

public static final int CODE_LOCAL_NETWORK_NO_LTE_COVERAGE = 122; // 0x7a

/**
 * Service unavailable; out of service (data service state)
 * @apiSince R
 */

public static final int CODE_LOCAL_NETWORK_NO_SERVICE = 121; // 0x79

/**
 * Service unavailable; located in roaming area
 * @apiSince R
 */

public static final int CODE_LOCAL_NETWORK_ROAMING = 123; // 0x7b

/**
 * Service unavailable; IMS is not registered
 * @apiSince R
 */

public static final int CODE_LOCAL_NOT_REGISTERED = 132; // 0x84

/**
 * No pending incoming call exists
 * @apiSince R
 */

public static final int CODE_LOCAL_NO_PENDING_CALL = 107; // 0x6b

/**
 * Service unavailable; radio power off
 * @apiSince R
 */

public static final int CODE_LOCAL_POWER_OFF = 111; // 0x6f

/**
 * Service unavailable; for an unspecified reason
 * @apiSince R
 */

public static final int CODE_LOCAL_SERVICE_UNAVAILABLE = 131; // 0x83

/**
 * Device declined/ended a call due to a low battery condition.
 * @apiSince R
 */

public static final int CODE_LOW_BATTERY = 505; // 0x1f9

/**
 * The maximum number of calls allowed has been reached.  Used in a multi-endpoint scenario
 * where the number of calls across all connected devices has reached the maximum.
 * @apiSince R
 */

public static final int CODE_MAXIMUM_NUMBER_OF_CALLS_REACHED = 1403; // 0x57b

/**
 * Media resource initialization failed
 * @apiSince R
 */

public static final int CODE_MEDIA_INIT_FAILED = 401; // 0x191

/**
 * Media is not supported; so dropped the call
 * @apiSince R
 */

public static final int CODE_MEDIA_NOT_ACCEPTABLE = 403; // 0x193

/**
 * RTP timeout (no audio / video traffic in the session)
 * @apiSince R
 */

public static final int CODE_MEDIA_NO_DATA = 402; // 0x192

/**
 * Unspecified media related error.
 * @apiSince R
 */

public static final int CODE_MEDIA_UNSPECIFIED = 404; // 0x194

/**
 * Fail code used to indicate that Multi-endpoint is not supported by the IMS framework.
 * @apiSince R
 */

public static final int CODE_MULTIENDPOINT_NOT_SUPPORTED = 902; // 0x386

/**
 * Call/IMS registration is failed/dropped because of a network detach
 * @apiSince R
 */

public static final int CODE_NETWORK_DETACH = 1513; // 0x5e9

/**
 * The failure is due to explicit reject from network
 * @apiSince R
 */

public static final int CODE_NETWORK_REJECT = 1504; // 0x5e0

/**
 * The failure is due to UE timer expired while waiting for a response from network
 * @apiSince R
 */

public static final int CODE_NETWORK_RESP_TIMEOUT = 1503; // 0x5df

/**
 * Call failed because WiFi call could not complete and circuit switch silent redial
 * is not allowed while roaming on another network.
 * @apiSince R
 */

public static final int CODE_NO_CSFB_IN_CS_ROAM = 1516; // 0x5ec

/**
 * The call cannot be established because of no valid SIM
 * @apiSince R
 */

public static final int CODE_NO_VALID_SIM = 1501; // 0x5dd

/** @apiSince R */

public static final int CODE_OEM_CAUSE_1 = 61441; // 0xf001

/** @apiSince R */

public static final int CODE_OEM_CAUSE_10 = 61450; // 0xf00a

/** @apiSince R */

public static final int CODE_OEM_CAUSE_11 = 61451; // 0xf00b

/** @apiSince R */

public static final int CODE_OEM_CAUSE_12 = 61452; // 0xf00c

/** @apiSince R */

public static final int CODE_OEM_CAUSE_13 = 61453; // 0xf00d

/** @apiSince R */

public static final int CODE_OEM_CAUSE_14 = 61454; // 0xf00e

/** @apiSince R */

public static final int CODE_OEM_CAUSE_15 = 61455; // 0xf00f

/** @apiSince R */

public static final int CODE_OEM_CAUSE_2 = 61442; // 0xf002

/** @apiSince R */

public static final int CODE_OEM_CAUSE_3 = 61443; // 0xf003

/** @apiSince R */

public static final int CODE_OEM_CAUSE_4 = 61444; // 0xf004

/** @apiSince R */

public static final int CODE_OEM_CAUSE_5 = 61445; // 0xf005

/** @apiSince R */

public static final int CODE_OEM_CAUSE_6 = 61446; // 0xf006

/** @apiSince R */

public static final int CODE_OEM_CAUSE_7 = 61447; // 0xf007

/** @apiSince R */

public static final int CODE_OEM_CAUSE_8 = 61448; // 0xf008

/** @apiSince R */

public static final int CODE_OEM_CAUSE_9 = 61449; // 0xf009

/**
 * The failure is due to radio access failure. ex. RACH failure
 * @apiSince R
 */

public static final int CODE_RADIO_ACCESS_FAILURE = 1505; // 0x5e1

/**
 * The failure is due internal error at modem
 * @apiSince R
 */

public static final int CODE_RADIO_INTERNAL_ERROR = 1502; // 0x5de

/**
 * Call/IMS registration failed/dropped because of a RLF
 * @apiSince R
 */

public static final int CODE_RADIO_LINK_FAILURE = 1506; // 0x5e2

/**
 * Call/IMS registration failed/dropped because of radio link lost
 * @apiSince R
 */

public static final int CODE_RADIO_LINK_LOST = 1507; // 0x5e3

/**
 * The call cannot be established because RADIO is OFF
 * @apiSince R
 */

public static final int CODE_RADIO_OFF = 1500; // 0x5dc

/**
 * Call failed/dropped because of RRC abnormally released by modem/network
 * @apiSince R
 */

public static final int CODE_RADIO_RELEASE_ABNORMAL = 1511; // 0x5e7

/**
 * Call failed/dropped because of RRC connection release from NW
 * @apiSince R
 */

public static final int CODE_RADIO_RELEASE_NORMAL = 1510; // 0x5e6

/**
 * Call failed because of a RRC connection setup failure
 * @apiSince R
 */

public static final int CODE_RADIO_SETUP_FAILURE = 1509; // 0x5e5

/**
 * The call Call/IMS registration failed because of a radio uplink issue
 * @apiSince R
 */

public static final int CODE_RADIO_UPLINK_FAILURE = 1508; // 0x5e4

/**
 * IMS Registration error code
 * @apiSince R
 */

public static final int CODE_REGISTRATION_ERROR = 1000; // 0x3e8

/**
 * For MultiEndPoint - Call was rejected elsewhere
 * @apiSince R
 */

public static final int CODE_REJECTED_ELSEWHERE = 1017; // 0x3f9

/**
 * CDMA call collision.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_1X_COLLISION = 1603; // 0x643

/**
 * A call is ongoing on another sub.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_CALL_ON_OTHER_SUB = 1602; // 0x642

/**
 * The call type is not allowed on the current RAT.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_CALL_TYPE_NOT_ALLOWED = 1605; // 0x645

/**
 * Call from conference server, when TTY mode is ON.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_CONFERENCE_TTY_NOT_ALLOWED = 1617; // 0x651

/**
 * An internal error occured while processing the call.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_INTERNAL_ERROR = 1612; // 0x64c

/**
 * Maximum number of allowed calls are already in progress.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_MAX_CALL_LIMIT_REACHED = 1608; // 0x648

/**
 * Another call is in the process of being establilshed.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_CALL_SETUP = 1607; // 0x647

/**
 * A call transfer is in progress.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_CALL_TRANSFER = 1611; // 0x64b

/**
 * A call upgrade is in progress.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_CALL_UPGRADE = 1616; // 0x650

/**
 * Ongoing call, and call waiting is disabled.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_CALL_WAITING_DISABLED = 1601; // 0x641

/**
 * A conference call is ongoing.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_CONFERENCE_CALL = 1618; // 0x652

/**
 * A CS call is ongoing.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_CS_CALL = 1621; // 0x655

/**
 * And emergency call is ongoing.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_E911_CALL = 1606; // 0x646

/**
 * And encrypted call is ongoing; other calls not supported.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_ENCRYPTED_CALL = 1620; // 0x654

/**
 * A call handover is in progress.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_ONGOING_HANDOVER = 1614; // 0x64e

/**
 * Call failure due to lack of dedicated bearer.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_QOS_FAILURE = 1613; // 0x64d

/**
 * IMS is not registered for service yet.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_SERVICE_NOT_REGISTERED = 1604; // 0x644

/**
 * The rejection cause is not known.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_UNKNOWN = 1600; // 0x640

/**
 * Invalid/unsupported SDP headers received.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_UNSUPPORTED_SDP_HEADERS = 1610; // 0x64a

/**
 * Invalid/unsupported SIP headers received.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_UNSUPPORTED_SIP_HEADERS = 1609; // 0x649

/**
 * A video call with AVPF is not supported.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_VT_AVPF_NOT_ALLOWED = 1619; // 0x653

/**
 * Video calling not supported with TTY.
 * <p>
 * Used with implicit call rejection.
 * @apiSince R
 */

public static final int CODE_REJECT_VT_TTY_NOT_ALLOWED = 1615; // 0x64f

/**
 * Similar to {@link #CODE_LOCAL_CALL_DECLINE}, except indicates that a remote device has
 * declined the call.  Used in a multi-endpoint scenario where a remote device declined an
 * incoming call.
 * @apiSince R
 */

public static final int CODE_REMOTE_CALL_DECLINE = 1404; // 0x57c

/**
 * UPGRADE DOWNGRADE operation failed
 * This can happen due to failure from SIP/RTP/SDP generation or a Call end is
 * triggered/received while Reinvite is in progress.
 * @apiSince R
 */

public static final int CODE_SESSION_MODIFICATION_FAILED = 1517; // 0x5ed

/**
 * Call failed due to SIP code 380 (Alternative Service response) while dialing an "undetected
 * emergency number".  This scenario is important in some regions where the carrier network will
 * identify other non-emergency help numbers (e.g. mountain rescue) when attempting to dial.
 * @apiSince R
 */

public static final int CODE_SIP_ALTERNATE_EMERGENCY_CALL = 1514; // 0x5ea

/**
 * SIP Response : 485
 * Request-URI is ambiguous
 *
 * @apiSince R
 */

public static final int CODE_SIP_AMBIGUOUS = 376; // 0x178

/**
 * SIP response 484 : Address Incomplete
 * @apiSince R
 */

public static final int CODE_SIP_BAD_ADDRESS = 337; // 0x151

/**
 * Sip 400 response : Bad Request
 * @apiSince R
 */

public static final int CODE_SIP_BAD_REQUEST = 331; // 0x14b

/**
 * Returned a busy response, may be one of the following:
 * SIP response 486 : Busy Here,
 * SIP response 600 : Busy Everywhere
 * @apiSince R
 */

public static final int CODE_SIP_BUSY = 338; // 0x152

/**
 * SIP Response : 481
 * Request received by the server does not match any dialog or transaction
 * @apiSince R
 */

public static final int CODE_SIP_CALL_OR_TRANS_DOES_NOT_EXIST = 372; // 0x174

/**
 * Received another unspecified error SIP response from the client.
 * @apiSince R
 */

public static final int CODE_SIP_CLIENT_ERROR = 342; // 0x156

/**
 * SIP Response : 421
 * Specific extension is required, which is not present in the HEADER
 * @apiSince R
 */

public static final int CODE_SIP_EXTENSION_REQUIRED = 370; // 0x172

/**
 * Sip 403 response : Forbidden
 * @apiSince R
 */

public static final int CODE_SIP_FORBIDDEN = 332; // 0x14c

/**
 * Unspecified 6xx error.
 * @apiSince R
 */

public static final int CODE_SIP_GLOBAL_ERROR = 362; // 0x16a

/**
 * SIP Response : 422
 * The session expiration field too small
 * @apiSince R
 */

public static final int CODE_SIP_INTERVAL_TOO_BRIEF = 371; // 0x173

/**
 * SIP Response : 482
 * Server has detected a loop
 * @apiSince R
 */

public static final int CODE_SIP_LOOP_DETECTED = 373; // 0x175

/**
 * SIP Response : 405
 * Method not allowed for the address in the Request URI
 * @apiSince R
 */

public static final int CODE_SIP_METHOD_NOT_ALLOWED = 366; // 0x16e

/**
 * Received a not acceptable response, will be one of the following:
 * SIP response 406 : Not Acceptable
 * SIP response 488 : Not Acceptable Here
 * SIP response 606 : Not Acceptable
 * @apiSince R
 */

public static final int CODE_SIP_NOT_ACCEPTABLE = 340; // 0x154

/**
 * Sip 404 response : Not Found
 * @apiSince R
 */

public static final int CODE_SIP_NOT_FOUND = 333; // 0x14d

/**
 * Received a not acceptable response, will be one of the following:
 * SIP response 410 : Gone
 * SIP response 604 : Does Not Exist Anywhere
 * @apiSince R
 */

public static final int CODE_SIP_NOT_REACHABLE = 341; // 0x155

/**
 * Not supported, because of one of the following:
 * SIP response 415 : Unsupported Media Type,
 * SIP response 416 : Unsupported URI Scheme,
 * SIP response 420 : Bad Extension
 * @apiSince R
 */

public static final int CODE_SIP_NOT_SUPPORTED = 334; // 0x14e

/**
 * SIP Response : 407
 * The request requires user authentication
 * @apiSince R
 */

public static final int CODE_SIP_PROXY_AUTHENTICATION_REQUIRED = 367; // 0x16f

/**
 * SIP 3xx response: SIP request is redirected
 * @apiSince R
 */

public static final int CODE_SIP_REDIRECTED = 321; // 0x141

/**
 * SIP response 487 : Request Terminated
 * @apiSince R
 */

public static final int CODE_SIP_REQUEST_CANCELLED = 339; // 0x153

/**
 * SIP Response : 413
 * Request body too large
 * @apiSince R
 */

public static final int CODE_SIP_REQUEST_ENTITY_TOO_LARGE = 368; // 0x170

/**
 * SIP Response : 491
 * Server has pending request for same dialog
 * @apiSince R
 */

public static final int CODE_SIP_REQUEST_PENDING = 377; // 0x179

/**
 * SIP response 408 : Request Timeout.
 * @apiSince R
 */

public static final int CODE_SIP_REQUEST_TIMEOUT = 335; // 0x14f

/**
 * SIP Response : 414
 * Request-URI too large
 * @apiSince R
 */

public static final int CODE_SIP_REQUEST_URI_TOO_LARGE = 369; // 0x171

/**
 * Received an unspecified SIP server error response.
 * @apiSince R
 */

public static final int CODE_SIP_SERVER_ERROR = 354; // 0x162

/**
 * SIP response 501 : Server Internal Error
 * @apiSince R
 */

public static final int CODE_SIP_SERVER_INTERNAL_ERROR = 351; // 0x15f

/**
 * SIP response 504 : Server Time-out
 * @apiSince R
 */

public static final int CODE_SIP_SERVER_TIMEOUT = 353; // 0x161

/**
 * SIP response 503 : Service Unavailable
 * @apiSince R
 */

public static final int CODE_SIP_SERVICE_UNAVAILABLE = 352; // 0x160

/**
 * SIP response 480 : Temporarily Unavailable
 * @apiSince R
 */

public static final int CODE_SIP_TEMPRARILY_UNAVAILABLE = 336; // 0x150

/**
 * SIP Response : 483
 * Max-Forwards value reached
 * @apiSince R
 */

public static final int CODE_SIP_TOO_MANY_HOPS = 374; // 0x176

/**
 * SIP response 481: Transaction Does Not Exist
 * @apiSince R
 */

public static final int CODE_SIP_TRANSACTION_DOES_NOT_EXIST = 343; // 0x157

/**
 * SIP Response : 493
 * The request cannot be decrypted by recipient
 * @apiSince R
 */

public static final int CODE_SIP_UNDECIPHERABLE = 378; // 0x17a

/**
 * Call failure code during hangup/reject if user marked the call as unwanted.
 *
 * Android Telephony will receive information whether ROBO call feature is supported by the
 * network from modem and propagate the same to AOSP as new ImsCallProfile members. OEMs can
 * check this information and provide an option to the user to mark the call as unwanted.
 * @apiSince R
 */

public static final int CODE_SIP_USER_MARKED_UNWANTED = 365; // 0x16d

/**
 * 603 : Decline
 * @apiSince R
 */

public static final int CODE_SIP_USER_REJECTED = 361; // 0x169

/**
 * Supplementary Services (HOLD/RESUME) - the command was cancelled.
 * @apiSince R
 */

public static final int CODE_SUPP_SVC_CANCELLED = 1202; // 0x4b2

/**
 * Supplementary Services (HOLD/RESUME) - the command failed.
 * @apiSince R
 */

public static final int CODE_SUPP_SVC_FAILED = 1201; // 0x4b1

/**
 * Supplementary Services (HOLD/RESUME) - the command resulted in a re-invite collision.
 * @apiSince R
 */

public static final int CODE_SUPP_SVC_REINVITE_COLLISION = 1203; // 0x4b3

/**
 * 1xx waiting timer is expired after sending INVITE request (MO calls only)
 * @apiSince R
 */

public static final int CODE_TIMEOUT_1XX_WAITING = 201; // 0xc9

/**
 * User didn't answer during call setup operation (MO/MT)
 * MO : 200 OK to INVITE request is not received,
 * MT : No action from user after alerting the call
 * @apiSince R
 */

public static final int CODE_TIMEOUT_NO_ANSWER = 202; // 0xca

/**
 * User no answer during call update operation (MO/MT)
 * MO : 200 OK to re-INVITE request is not received,
 * MT : No action from user after alerting the call
 * @apiSince R
 */

public static final int CODE_TIMEOUT_NO_ANSWER_CALL_UPDATE = 203; // 0xcb

/**
 * The Reason is unspecified.
 * @apiSince R
 */

public static final int CODE_UNSPECIFIED = 0; // 0x0

/**
 * Upgrade Downgrade request cancelled by the user who initiated it
 * @apiSince R
 */

public static final int CODE_USER_CANCELLED_SESSION_MODIFICATION = 512; // 0x200

/**
 * User declined an incoming call.
 * @apiSince R
 */

public static final int CODE_USER_DECLINE = 504; // 0x1f8

/**
 * User ignored an incoming call.
 * @apiSince R
 */

public static final int CODE_USER_IGNORE = 503; // 0x1f7

/**
 * No action was taken while an incoming call was ringing.
 * @apiSince R
 */

public static final int CODE_USER_NOANSWER = 502; // 0x1f6

/**
 * Upgrade Downgrade request rejected by
 * Remote user if the request is MO initiated
 * Local user if the request is MT initiated
 * @apiSince R
 */

public static final int CODE_USER_REJECTED_SESSION_MODIFICATION = 511; // 0x1ff

/**
 * User triggers the call to be terminated.
 * @apiSince R
 */

public static final int CODE_USER_TERMINATED = 501; // 0x1f5

/**
 * The call has been terminated by the network or remote user.
 * @apiSince R
 */

public static final int CODE_USER_TERMINATED_BY_REMOTE = 510; // 0x1fe

/**
 * The password entered for UT operations does not match the stored password.
 * @apiSince R
 */

public static final int CODE_UT_CB_PASSWORD_MISMATCH = 821; // 0x335

/**
 * The UT request resulted in a network error.
 * @apiSince R
 */

public static final int CODE_UT_NETWORK_ERROR = 804; // 0x324

/**
 * UT is currently not supported on this device.
 * @apiSince R
 */

public static final int CODE_UT_NOT_SUPPORTED = 801; // 0x321

/**
 * The requested UT operation is not allowed.
 * @apiSince R
 */

public static final int CODE_UT_OPERATION_NOT_ALLOWED = 803; // 0x323

/**
 * UT services are currently not available on this device.
 * @apiSince R
 */

public static final int CODE_UT_SERVICE_UNAVAILABLE = 802; // 0x322

/**
 * Sim Toolkit Call Control modified the UT operation to a dial command.
 * @apiSince R
 */

public static final int CODE_UT_SS_MODIFIED_TO_DIAL = 822; // 0x336

/**
 * Sim Toolkit Call Control modified the UT operation to a video call dial command.
 * @apiSince R
 */

public static final int CODE_UT_SS_MODIFIED_TO_DIAL_VIDEO = 825; // 0x339

/**
 * Sim Toolkit Call Control modified the UT operation to another supplementary service command.
 * @apiSince R
 */

public static final int CODE_UT_SS_MODIFIED_TO_SS = 824; // 0x338

/**
 * Sim Toolkit Call Control modified the UT operation to a USSD command.
 * @apiSince R
 */

public static final int CODE_UT_SS_MODIFIED_TO_USSD = 823; // 0x337

/**
 * Indicates a call was disconnected due to loss of wifi signal.
 * @apiSince R
 */

public static final int CODE_WIFI_LOST = 1407; // 0x57f

/** @apiSince R */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.ims.ImsReasonInfo> CREATOR;
static { CREATOR = null; }

/**
 * An extra that may be populated when the {@link #CODE_LOCAL_CALL_CS_RETRY_REQUIRED} result has
 * been returned.
 * <p>
 * Try to connect the call using CS by using the settings.
 * @apiSince R
 */

public static final int EXTRA_CODE_CALL_RETRY_BY_SETTINGS = 3; // 0x3

/**
 * An extra that may be populated when the {@link #CODE_LOCAL_CALL_CS_RETRY_REQUIRED} result has
 * been returned.
 * <p>
 * Try to connect the call using CS
 * @apiSince R
 */

public static final int EXTRA_CODE_CALL_RETRY_NORMAL = 1; // 0x1

/**
 * An extra that may be populated when the {@link #CODE_LOCAL_CALL_CS_RETRY_REQUIRED} result has
 * been returned.
 * <p>
 * Try to connect the call using CS and do not notify the user.
 * @apiSince R
 */

public static final int EXTRA_CODE_CALL_RETRY_SILENT_REDIAL = 2; // 0x2
}

