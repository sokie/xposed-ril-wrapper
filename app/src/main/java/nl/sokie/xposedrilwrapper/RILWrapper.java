package nl.sokie.xposedrilwrapper;

import android.os.Parcel;
import android.util.SparseArray;

import java.lang.reflect.Method;
import java.util.Arrays;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class RILWrapper extends XC_MethodHook {

    static final int RESPONSE_SOLICITED = 0;
    static final int RESPONSE_UNSOLICITED = 1;

    //REQUESTS
    static final int RIL_REQUEST_GET_SIM_STATUS = 1;
    static final int RIL_REQUEST_ENTER_SIM_PIN = 2;
    static final int RIL_REQUEST_ENTER_SIM_PUK = 3;
    static final int RIL_REQUEST_ENTER_SIM_PIN2 = 4;
    static final int RIL_REQUEST_ENTER_SIM_PUK2 = 5;
    static final int RIL_REQUEST_CHANGE_SIM_PIN = 6;
    static final int RIL_REQUEST_CHANGE_SIM_PIN2 = 7;
    static final int RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION = 8;
    static final int RIL_REQUEST_GET_CURRENT_CALLS = 9;
    static final int RIL_REQUEST_DIAL = 10;
    static final int RIL_REQUEST_GET_IMSI = 11;
    static final int RIL_REQUEST_HANGUP = 12;
    static final int RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND = 13;
    static final int RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND = 14;
    static final int RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE = 15;
    static final int RIL_REQUEST_CONFERENCE = 16;
    static final int RIL_REQUEST_UDUB = 17;
    static final int RIL_REQUEST_LAST_CALL_FAIL_CAUSE = 18;
    static final int RIL_REQUEST_SIGNAL_STRENGTH = 19;
    static final int RIL_REQUEST_VOICE_REGISTRATION_STATE = 20;
    static final int RIL_REQUEST_DATA_REGISTRATION_STATE = 21;
    static final int RIL_REQUEST_OPERATOR = 22;
    static final int RIL_REQUEST_RADIO_POWER = 23;
    static final int RIL_REQUEST_DTMF = 24;
    static final int RIL_REQUEST_SEND_SMS = 25;
    static final int RIL_REQUEST_SEND_SMS_EXPECT_MORE = 26;
    static final int RIL_REQUEST_SETUP_DATA_CALL = 27;
    static final int RIL_REQUEST_SIM_IO = 28;
    static final int RIL_REQUEST_SEND_USSD = 29;
    static final int RIL_REQUEST_CANCEL_USSD = 30;
    static final int RIL_REQUEST_GET_CLIR = 31;
    static final int RIL_REQUEST_SET_CLIR = 32;
    static final int RIL_REQUEST_QUERY_CALL_FORWARD_STATUS = 33;
    static final int RIL_REQUEST_SET_CALL_FORWARD = 34;
    static final int RIL_REQUEST_QUERY_CALL_WAITING = 35;
    static final int RIL_REQUEST_SET_CALL_WAITING = 36;
    static final int RIL_REQUEST_SMS_ACKNOWLEDGE = 37;
    static final int RIL_REQUEST_GET_IMEI = 38;
    static final int RIL_REQUEST_GET_IMEISV = 39;
    static final int RIL_REQUEST_ANSWER = 40;
    static final int RIL_REQUEST_DEACTIVATE_DATA_CALL = 41;
    static final int RIL_REQUEST_QUERY_FACILITY_LOCK = 42;
    static final int RIL_REQUEST_SET_FACILITY_LOCK = 43;
    static final int RIL_REQUEST_CHANGE_BARRING_PASSWORD = 44;
    static final int RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE = 45;
    static final int RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC = 46;
    static final int RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL = 47;
    static final int RIL_REQUEST_QUERY_AVAILABLE_NETWORKS = 48;
    static final int RIL_REQUEST_DTMF_START = 49;
    static final int RIL_REQUEST_DTMF_STOP = 50;
    static final int RIL_REQUEST_BASEBAND_VERSION = 51;
    static final int RIL_REQUEST_SEPARATE_CONNECTION = 52;
    static final int RIL_REQUEST_SET_MUTE = 53;
    static final int RIL_REQUEST_GET_MUTE = 54;
    static final int RIL_REQUEST_QUERY_CLIP = 55;
    static final int RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE = 56;
    static final int RIL_REQUEST_DATA_CALL_LIST = 57;
    static final int RIL_REQUEST_RESET_RADIO = 58;
    static final int RIL_REQUEST_OEM_HOOK_RAW = 59;
    static final int RIL_REQUEST_OEM_HOOK_STRINGS = 60;
    static final int RIL_REQUEST_SCREEN_STATE = 61;
    static final int RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION = 62;
    static final int RIL_REQUEST_WRITE_SMS_TO_SIM = 63;
    static final int RIL_REQUEST_DELETE_SMS_ON_SIM = 64;
    static final int RIL_REQUEST_SET_BAND_MODE = 65;
    static final int RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE = 66;
    static final int RIL_REQUEST_STK_GET_PROFILE = 67;
    static final int RIL_REQUEST_STK_SET_PROFILE = 68;
    static final int RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND = 69;
    static final int RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE = 70;
    static final int RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM = 71;
    static final int RIL_REQUEST_EXPLICIT_CALL_TRANSFER = 72;
    static final int RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE = 73;
    static final int RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE = 74;
    static final int RIL_REQUEST_GET_NEIGHBORING_CELL_IDS = 75;
    static final int RIL_REQUEST_SET_LOCATION_UPDATES = 76;
    static final int RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE = 77;
    static final int RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE = 78;
    static final int RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE = 79;
    static final int RIL_REQUEST_SET_TTY_MODE = 80;
    static final int RIL_REQUEST_QUERY_TTY_MODE = 81;
    static final int RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE = 82;
    static final int RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE = 83;
    static final int RIL_REQUEST_CDMA_FLASH = 84;
    static final int RIL_REQUEST_CDMA_BURST_DTMF = 85;
    static final int RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY = 86;
    static final int RIL_REQUEST_CDMA_SEND_SMS = 87;
    static final int RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE = 88;
    static final int RIL_REQUEST_GSM_GET_BROADCAST_CONFIG = 89;
    static final int RIL_REQUEST_GSM_SET_BROADCAST_CONFIG = 90;
    static final int RIL_REQUEST_GSM_BROADCAST_ACTIVATION = 91;
    static final int RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG = 92;
    static final int RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG = 93;
    static final int RIL_REQUEST_CDMA_BROADCAST_ACTIVATION = 94;
    static final int RIL_REQUEST_CDMA_SUBSCRIPTION = 95;
    static final int RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM = 96;
    static final int RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM = 97;
    static final int RIL_REQUEST_DEVICE_IDENTITY = 98;
    static final int RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE = 99;
    static final int RIL_REQUEST_GET_SMSC_ADDRESS = 100;
    static final int RIL_REQUEST_SET_SMSC_ADDRESS = 101;
    static final int RIL_REQUEST_REPORT_SMS_MEMORY_STATUS = 102;
    static final int RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING = 103;
    static final int RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE = 104;
    static final int RIL_REQUEST_ISIM_AUTHENTICATION = 105;
    static final int RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU = 106;
    static final int RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS = 107;
    static final int RIL_REQUEST_VOICE_RADIO_TECH = 108;
    static final int RIL_REQUEST_GET_CELL_INFO_LIST = 109;
    static final int RIL_REQUEST_SET_UNSOL_CELL_INFO_LIST_RATE = 110;
    static final int RIL_REQUEST_SET_INITIAL_ATTACH_APN = 111;
    static final int RIL_REQUEST_IMS_REGISTRATION_STATE = 112;
    static final int RIL_REQUEST_IMS_SEND_SMS = 113;
    static final int RIL_REQUEST_SIM_TRANSMIT_APDU_BASIC = 114;
    static final int RIL_REQUEST_SIM_OPEN_CHANNEL = 115;
    static final int RIL_REQUEST_SIM_CLOSE_CHANNEL = 116;
    static final int RIL_REQUEST_SIM_TRANSMIT_APDU_CHANNEL = 117;
    static final int RIL_REQUEST_NV_READ_ITEM = 118;
    static final int RIL_REQUEST_NV_WRITE_ITEM = 119;
    static final int RIL_REQUEST_NV_WRITE_CDMA_PRL = 120;
    static final int RIL_REQUEST_NV_RESET_CONFIG = 121;
    static final int RIL_REQUEST_SET_UICC_SUBSCRIPTION = 122;
    static final int RIL_REQUEST_ALLOW_DATA = 123;
    static final int RIL_REQUEST_GET_HARDWARE_CONFIG = 124;
    static final int RIL_REQUEST_SIM_AUTHENTICATION = 125;
    static final int RIL_REQUEST_GET_DC_RT_INFO = 126;
    static final int RIL_REQUEST_SET_DC_RT_INFO_RATE = 127;
    static final int RIL_REQUEST_SET_DATA_PROFILE = 128;
    static final int RIL_REQUEST_SHUTDOWN = 129;
    static final int RIL_REQUEST_GET_RADIO_CAPABILITY = 130;
    static final int RIL_REQUEST_SET_RADIO_CAPABILITY = 131;
    static final int RIL_REQUEST_START_LCE = 132;
    static final int RIL_REQUEST_STOP_LCE = 133;
    static final int RIL_REQUEST_PULL_LCEDATA = 134;
    static final int RIL_REQUEST_GET_ACTIVITY_INFO = 135;

    //UNSOLICITED
    static final int RIL_UNSOL_RESPONSE_BASE = 1000;
    static final int RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED = 1000;
    static final int RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED = 1001;
    static final int RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED = 1002;
    static final int RIL_UNSOL_RESPONSE_NEW_SMS = 1003;
    static final int RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT = 1004;
    static final int RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM = 1005;
    static final int RIL_UNSOL_ON_USSD = 1006;
    static final int RIL_UNSOL_ON_USSD_REQUEST = 1007;
    static final int RIL_UNSOL_NITZ_TIME_RECEIVED = 1008;
    static final int RIL_UNSOL_SIGNAL_STRENGTH = 1009;
    static final int RIL_UNSOL_DATA_CALL_LIST_CHANGED = 1010;
    static final int RIL_UNSOL_SUPP_SVC_NOTIFICATION = 1011;
    static final int RIL_UNSOL_STK_SESSION_END = 1012;
    static final int RIL_UNSOL_STK_PROACTIVE_COMMAND = 1013;
    static final int RIL_UNSOL_STK_EVENT_NOTIFY = 1014;
    static final int RIL_UNSOL_STK_CALL_SETUP = 1015;
    static final int RIL_UNSOL_SIM_SMS_STORAGE_FULL = 1016;
    static final int RIL_UNSOL_SIM_REFRESH = 1017;
    static final int RIL_UNSOL_CALL_RING = 1018;
    static final int RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED = 1019;
    static final int RIL_UNSOL_RESPONSE_CDMA_NEW_SMS = 1020;
    static final int RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS = 1021;
    static final int RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL = 1022;
    static final int RIL_UNSOL_RESTRICTED_STATE_CHANGED = 1023;
    static final int RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE = 1024;
    static final int RIL_UNSOL_CDMA_CALL_WAITING = 1025;
    static final int RIL_UNSOL_CDMA_OTA_PROVISION_STATUS = 1026;
    static final int RIL_UNSOL_CDMA_INFO_REC = 1027;
    static final int RIL_UNSOL_OEM_HOOK_RAW = 1028;
    static final int RIL_UNSOL_RINGBACK_TONE = 1029;
    static final int RIL_UNSOL_RESEND_INCALL_MUTE = 1030;
    static final int RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED = 1031;
    static final int RIL_UNSOl_CDMA_PRL_CHANGED = 1032;
    static final int RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE = 1033;
    static final int RIL_UNSOL_RIL_CONNECTED = 1034;
    static final int RIL_UNSOL_VOICE_RADIO_TECH_CHANGED = 1035;
    static final int RIL_UNSOL_CELL_INFO_LIST = 1036;
    static final int RIL_UNSOL_RESPONSE_IMS_NETWORK_STATE_CHANGED = 1037;
    static final int RIL_UNSOL_UICC_SUBSCRIPTION_STATUS_CHANGED = 1038;
    static final int RIL_UNSOL_SRVCC_STATE_NOTIFY = 1039;
    static final int RIL_UNSOL_HARDWARE_CONFIG_CHANGED = 1040;
    static final int RIL_UNSOL_DC_RT_INFO_CHANGED = 1041;
    static final int RIL_UNSOL_RADIO_CAPABILITY = 1042;
    static final int RIL_UNSOL_ON_SS = 1043;
    static final int RIL_UNSOL_STK_CC_ALPHA_NOTIFY = 1044;
    static final int RIL_UNSOL_LCEDATA_RECV = 1045;

    // SAMSUNG SGS STATES
    static final int RIL_UNSOL_O2_HOME_ZONE_INFO = 11007;
    static final int RIL_UNSOL_DEVICE_READY_NOTI = 11008;
    static final int RIL_UNSOL_GPS_NOTI = 11009;
    static final int RIL_UNSOL_AM = 11010;
    static final int RIL_UNSOL_DATA_SUSPEND_RESUME = 11012;
    static final int RIL_UNSOL_DUN_PIN_CONTROL_SIGNAL = 11011;
    static final int RIL_UNSOL_HSDPA_STATE_CHANGED = 11016;
    static final int RIL_REQUEST_DIAL_EMERGENCY = 10016;
    static final int RIL_UNSOL_WB_AMR_STATE = 11017;
    static final int RIL_UNSOL_TWO_MIC_STATE = 11018;

    private static final String TAG = "Sokie:RILWrapper";

    private static void log(String msg) {
        XposedBridge.log(TAG + ": " + msg);
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);

        int messageLenth = Integer.parseInt(param.getResult().toString());
        byte[] arr = (byte[]) param.args[1];

        String byteStr = "";
        for (int i = 0; i < messageLenth; i++) {
            byteStr += arr[i];
            byteStr += " ";
        }
        log("readRilMessage size: " + messageLenth + " bytes: " + byteStr);

        parseRIL(arr);
    }

    public void parseRIL(byte[] bytes) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(bytes, 0, bytes.length);
        parcel.setDataPosition(0);

        int type;
        type = parcel.readInt();

        if (type == RESPONSE_UNSOLICITED) {
            processUnsolicited(parcel);
        } else if (type == RESPONSE_SOLICITED) {
            processSolicited(parcel);
        }
    }

    private void
    processUnsolicited(Parcel p) {
        int response;
        Object ret = null;
        response = p.readInt();

        log("received unsolicited RIL message: " + responseToString(response) + " with type:" + response);

        try {
            switch (response) {
                case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_RESPONSE_NEW_SMS:
                    ret = responseString(p);
                    break;
                case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT:
                    ret = responseString(p);
                    break;
                case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOL_ON_USSD:
                    ret = responseStrings(p);
                    break;
                case RIL_UNSOL_NITZ_TIME_RECEIVED:
                    ret = responseString(p);
                    break;
                case RIL_UNSOL_SIGNAL_STRENGTH:
                    ret = makeSignalStrengthFromRilParcel(p);
                    break;
                case RIL_UNSOL_DATA_CALL_LIST_CHANGED: /* ret = responseDataCallList(p); */
                    break;
                case RIL_UNSOL_SUPP_SVC_NOTIFICATION: ret = responseSuppServiceNotification(p);
                    break;
                case RIL_UNSOL_STK_SESSION_END:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_STK_PROACTIVE_COMMAND:
                    ret = responseString(p);
                    break;
                case RIL_UNSOL_STK_EVENT_NOTIFY:
                    ret = responseString(p);
                    break;
                case RIL_UNSOL_STK_CALL_SETUP:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOL_SIM_SMS_STORAGE_FULL:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_SIM_REFRESH: ret =  responseSimRefresh(p);
                    break;
                case RIL_UNSOL_CALL_RING:  ret =  responseCallRing(p);
                    break;
                case RIL_UNSOL_RESTRICTED_STATE_CHANGED:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS:  /* ret =  responseCdmaSms(p); */
                    break;
                case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS:
                    ret = responseRaw(p);
                    break;
                case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_CDMA_CALL_WAITING: /* ret = responseCdmaCallWaiting(p); */
                    break;
                case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOL_CDMA_INFO_REC: /* ret = responseCdmaInformationRecord(p); */
                    break;
                case RIL_UNSOL_OEM_HOOK_RAW:
                    ret = responseRaw(p);
                    break;
                case RIL_UNSOL_RINGBACK_TONE:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOL_RESEND_INCALL_MUTE:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOl_CDMA_PRL_CHANGED:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_RIL_CONNECTED:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOL_VOICE_RADIO_TECH_CHANGED:
                    ret = responseInts(p);
                    break;
                case RIL_UNSOL_CELL_INFO_LIST: /* ret = responseCellInfoList(p); */
                    break;
                case RIL_UNSOL_RESPONSE_IMS_NETWORK_STATE_CHANGED:
                    ret = responseVoid(p);
                    break;
                case RIL_UNSOL_UICC_SUBSCRIPTION_STATUS_CHANGED: ret =  responseInts(p); break;
                case RIL_UNSOL_SRVCC_STATE_NOTIFY: ret = responseInts(p); break;
                case RIL_UNSOL_HARDWARE_CONFIG_CHANGED: ret = responseHardwareConfig(p); break;
                case RIL_UNSOL_RADIO_CAPABILITY:
                    ret = responseRadioCapability(p); break;
                case RIL_UNSOL_ON_SS: /* ret =  responseSsData(p); */ break;
                case RIL_UNSOL_STK_CC_ALPHA_NOTIFY: ret =  responseString(p); break;

                //SAMSUNG EVENTS
                case RIL_UNSOL_DEVICE_READY_NOTI: ret = responseVoid(p); break;
                case RIL_UNSOL_GPS_NOTI: ret = responseVoid(p); break; // Ignored in TW RIL.
                // SAMSUNG STATES
                case RIL_UNSOL_AM: ret = responseString(p); break;
                case RIL_UNSOL_DUN_PIN_CONTROL_SIGNAL: ret = responseVoid(p); break;
                case RIL_UNSOL_DATA_SUSPEND_RESUME: ret = responseInts(p); break;
                //TODO: this is a samsung specific return type
                //case RIL_UNSOL_RIL_CONNECTED: ret = responseString(p); break;
                case RIL_UNSOL_TWO_MIC_STATE: ret = responseInts(p); break;
                case RIL_UNSOL_WB_AMR_STATE: ret = responseInts(p); break;

                default:
                    //throw new RuntimeException("Unrecognized unsol response: " + response);
                    //break; (implied)
            }
            retToLog(RESPONSE_UNSOLICITED, response, ret);
        } catch (Throwable tr) {
            log("Exception processing unsol response: " + response +
                    "Exception:" + tr.toString());
            return;
        }
    }


    private void
    processSolicited(Parcel p) {
        int serial, error;

        serial = p.readInt();
        error = p.readInt();
        Integer type;

        synchronized(MainHook.serialMap) {
            type = MainHook.serialMap.get(serial);
        }
        if(type == null)
            return;

        log("received solicited RIL message: " + requestToString(type) + " ( " + type + " )");

        Object ret = null;
        if (error == 0 || p.dataAvail() > 0) {
            try {
                switch (type) {

                    case RIL_REQUEST_GET_SIM_STATUS: /* ret =  responseIccCardStatus(p); */
                        break;
                    case RIL_REQUEST_ENTER_SIM_PIN:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_ENTER_SIM_PUK:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_ENTER_SIM_PIN2:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_ENTER_SIM_PUK2:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_CHANGE_SIM_PIN:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_CHANGE_SIM_PIN2:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_GET_CURRENT_CALLS: /* ret =  responseCallList(p); */
                        break;
                    case RIL_REQUEST_DIAL:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_GET_IMSI:
                        ret = responseString(p);
                        break;
                    case RIL_REQUEST_HANGUP:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND: {
                        ret =  responseVoid(p);
                        break;
                    }
                    case RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CONFERENCE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_UDUB:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_LAST_CALL_FAIL_CAUSE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_SIGNAL_STRENGTH:
                        ret = makeSignalStrengthFromRilParcel(p);
                        break;
                    case RIL_REQUEST_VOICE_REGISTRATION_STATE:
                        ret = responseStrings(p);
                        break;
                    case RIL_REQUEST_DATA_REGISTRATION_STATE:
                        ret = responseStrings(p);
                        break;
                    case RIL_REQUEST_OPERATOR:
                        ret = responseStrings(p);
                        break;
                    case RIL_REQUEST_RADIO_POWER:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_DTMF:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SEND_SMS: ret =  responseSMS(p);
                        break;
                    case RIL_REQUEST_SEND_SMS_EXPECT_MORE: ret =  responseSMS(p);
                        break;
                    case RIL_REQUEST_SETUP_DATA_CALL: /* ret =  responseSetupDataCall(p); */
                        break;
                    case RIL_REQUEST_SIM_IO: ret =  responseICC_IO(p);
                        break;
                    case RIL_REQUEST_SEND_USSD:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CANCEL_USSD:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_GET_CLIR:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_SET_CLIR:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_QUERY_CALL_FORWARD_STATUS: /* ret =  responseCallForward(p); */
                        break;
                    case RIL_REQUEST_SET_CALL_FORWARD:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_QUERY_CALL_WAITING:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_SET_CALL_WAITING:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SMS_ACKNOWLEDGE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_GET_IMEI:
                        ret = responseString(p);
                        break;
                    case RIL_REQUEST_GET_IMEISV:
                        ret = responseString(p);
                        break;
                    case RIL_REQUEST_ANSWER:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_DEACTIVATE_DATA_CALL:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_QUERY_FACILITY_LOCK:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_SET_FACILITY_LOCK:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_CHANGE_BARRING_PASSWORD:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_QUERY_AVAILABLE_NETWORKS: /* ret =  responseOperatorInfos(p); */
                        break;
                    case RIL_REQUEST_DTMF_START:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_DTMF_STOP:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_BASEBAND_VERSION:
                        ret = responseString(p);
                        break;
                    case RIL_REQUEST_SEPARATE_CONNECTION:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SET_MUTE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_GET_MUTE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_QUERY_CLIP:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_DATA_CALL_LIST: /* ret =  responseDataCallList(p); */
                        break;
                    case RIL_REQUEST_RESET_RADIO:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_OEM_HOOK_RAW:
                        ret = responseRaw(p);
                        break;
                    case RIL_REQUEST_OEM_HOOK_STRINGS:
                        ret = responseStrings(p);
                        break;
                    case RIL_REQUEST_SCREEN_STATE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_WRITE_SMS_TO_SIM:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_DELETE_SMS_ON_SIM:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SET_BAND_MODE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_STK_GET_PROFILE:
                        ret = responseString(p);
                        break;
                    case RIL_REQUEST_STK_SET_PROFILE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND:
                        ret = responseString(p);
                        break;
                    case RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_EXPLICIT_CALL_TRANSFER:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE:  ret =  responseGetPreferredNetworkType(p);
                        break;
                    case RIL_REQUEST_GET_NEIGHBORING_CELL_IDS: /* ret = responseCellList(p); */
                        break;
                    case RIL_REQUEST_SET_LOCATION_UPDATES:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_SET_TTY_MODE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_QUERY_TTY_MODE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_CDMA_FLASH:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_BURST_DTMF:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_SEND_SMS:  ret =  responseSMS(p);
                        break;
                    case RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_GSM_GET_BROADCAST_CONFIG: /* ret =  responseGmsBroadcastConfig(p); */
                        break;
                    case RIL_REQUEST_GSM_SET_BROADCAST_CONFIG:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_GSM_BROADCAST_ACTIVATION:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG: /* ret =  responseCdmaBroadcastConfig(p); */
                        break;
                    case RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_BROADCAST_ACTIVATION:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_SUBSCRIPTION:
                        ret = responseStrings(p);
                        break;
                    case RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_DEVICE_IDENTITY:
                        ret = responseStrings(p);
                        break;
                    case RIL_REQUEST_GET_SMSC_ADDRESS:
                        ret = responseString(p);
                        break;
                    case RIL_REQUEST_SET_SMSC_ADDRESS:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_REPORT_SMS_MEMORY_STATUS:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_ISIM_AUTHENTICATION:
                        ret = responseString(p);
                        break;
                    case RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS: ret = responseICC_IO(p);
                        break;
                    case RIL_REQUEST_VOICE_RADIO_TECH:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_GET_CELL_INFO_LIST: /* ret = responseCellInfoList(p); */
                        break;
                    case RIL_REQUEST_SET_UNSOL_CELL_INFO_LIST_RATE:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SET_INITIAL_ATTACH_APN:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_IMS_REGISTRATION_STATE:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_IMS_SEND_SMS: ret =  responseSMS(p);
                        break;
                    case RIL_REQUEST_SIM_TRANSMIT_APDU_BASIC: ret =  responseICC_IO(p);
                        break;
                    case RIL_REQUEST_SIM_OPEN_CHANNEL:
                        ret = responseInts(p);
                        break;
                    case RIL_REQUEST_SIM_CLOSE_CHANNEL:
                        ret = responseVoid(p);
                        break;
                    case RIL_REQUEST_SIM_TRANSMIT_APDU_CHANNEL: ret = responseICC_IO(p);
                        break;
                    case RIL_REQUEST_NV_READ_ITEM: ret = responseString(p); break;
                    case RIL_REQUEST_NV_WRITE_ITEM: ret = responseVoid(p); break;
                    case RIL_REQUEST_NV_WRITE_CDMA_PRL: ret = responseVoid(p); break;
                    case RIL_REQUEST_NV_RESET_CONFIG: ret = responseVoid(p); break;
                    case RIL_REQUEST_SET_UICC_SUBSCRIPTION: ret = responseVoid(p); break;
                    case RIL_REQUEST_ALLOW_DATA: ret = responseVoid(p); break;
                    case RIL_REQUEST_GET_HARDWARE_CONFIG: ret = responseHardwareConfig(p); break;
                    case RIL_REQUEST_SIM_AUTHENTICATION: ret =  responseICC_IOBase64(p); break;
                    case RIL_REQUEST_SHUTDOWN: ret = responseVoid(p); break;
                    case RIL_REQUEST_GET_RADIO_CAPABILITY: ret =  responseRadioCapability(p); break;
                    case RIL_REQUEST_SET_RADIO_CAPABILITY: ret =  responseRadioCapability(p); break;

                    default:
                        //break;
                }
                retToLog(RESPONSE_SOLICITED, type, ret);
            } catch (Throwable tr) {
                // Exceptions here usually mean invalid RIL responses
                log("exception" + tr.getMessage());
            }
        }
    }

    private Object
    responseVoid(Parcel p) {
        log("Event has NO parameters");
        return null;
    }

    private Object
    responseString(Parcel p) {
        String response;
        response = p.readString();
        return response;
    }

    private Object
    responseStrings(Parcel p) {

        String response[] = p.createStringArray();

        return response;
    }

    private Object
    responseRaw(Parcel p) {
        byte response[];
        response = p.createByteArray();
        return response;
    }

    private Object
    responseInts(Parcel p) {
        int numInts;
        int response[];
        numInts = p.readInt();
        response = new int[numInts];
        for (int i = 0; i < numInts; i++) {
            response[i] = p.readInt();
        }
        return response;
    }


    //Preferred network type
    private Object responseGetPreferredNetworkType(Parcel p) {
        int [] response = (int[]) responseInts(p);
        if (response.length >= 1) {
            // Since this is the response for getPreferredNetworkType
            // we'll assume that it should be the value we want the
            // vendor ril to take if we reestablish a connection to it.
            log("[mPreferredNetworkType="+response[0]+"]");
        }
        return response;
    }

    private Object
    responseSMS(Parcel p) {
        int messageRef, errorCode;
        String ackPDU;
        messageRef = p.readInt();
        ackPDU = p.readString();
        errorCode = p.readInt();
        log("[messageRef="+messageRef+",ackPDU="+ackPDU+",errorCode="+errorCode+"]");
        return null;
    }

    private Object
    responseICC_IO(Parcel p) {
        int sw1, sw2;

        sw1 = p.readInt();
        sw2 = p.readInt();
        String s = p.readString();

        log("["
                + " 0x" + Integer.toHexString(sw1)
                + " 0x" + Integer.toHexString(sw2) + " "
                + s + "]");

        return null;
    }

    private Object
    responseICC_IOBase64(Parcel p) {
        int sw1, sw2;

        sw1 = p.readInt();
        sw2 = p.readInt();

        String s = p.readString();

        log("[ "
                + " 0x" + Integer.toHexString(sw1)
                + " 0x" + Integer.toHexString(sw2) + " "
                + s + " ]");

        return null;
    }

    private Object
    responseSimRefresh(Parcel p) {

        int refreshResult = p.readInt();
        int efId   = p.readInt();
        String aid = p.readString();
        log("[refreshResult="+refreshResult+",efId="+efId+",aid="+aid+"]");
        return null;
    }

    private Object makeSignalStrengthFromRilParcel(Parcel in) {

        int mGsmSignalStrength = in.readInt();
        int mGsmBitErrorRate = in.readInt();
        int mCdmaDbm = in.readInt();
        int mCdmaEcio = in.readInt();
        int mEvdoDbm = in.readInt();
        int mEvdoEcio = in.readInt();
        int mEvdoSnr = in.readInt();
        int mLteSignalStrength = in.readInt();
        int mLteRsrp = in.readInt();
        int mLteRsrq = in.readInt();
        int mLteRssnr = in.readInt();
        int mLteCqi = in.readInt();
        int mTdScdmaRscp = in.readInt();
        log("["
            +"mGsmSignalStrength="+mGsmSignalStrength
                        +",mGsmBitErrorRate="+mGsmBitErrorRate
                        +",mCdmaDbm="+mCdmaDbm
                        +",mCdmaEcio="+mCdmaEcio
                        +",mEvdoDbm="+mEvdoDbm
                        +",mEvdoEcio="+mEvdoEcio
                        +",mEvdoSnr="+mEvdoSnr
                        +",mLteSignalStrength="+mLteSignalStrength
                        +",mLteRsrp="+mLteRsrp
                        +",mLteRsrq="+mLteRsrq
                        +",mLteRssnr="+mLteRssnr
                        +",mLteCqi="+mLteCqi
                        +",mTdScdmaRscp="+mTdScdmaRscp
        +"]");
        return null;
    }

    private Object
    responseSuppServiceNotification(Parcel p) {

        int notificationType = p.readInt();
        int code = p.readInt();
        int index = p.readInt();
        int type = p.readInt();
        String number = p.readString();
        log("["
                        +"notificationType="+notificationType
                        +"code="+code
                        +"index="+index
                        +"type="+type
                        +"number="+number
        +"]"
        );
        return null;
    }

    private Object
    responseCallRing(Parcel p){
        char response[] = new char[4];
        response[0] = (char) p.readInt();    // isPresent
        response[1] = (char) p.readInt();    // signalType
        response[2] = (char) p.readInt();    // alertPitch
        response[3] = (char) p.readInt();    // signal
        log("["
        +"isPresent="+response[0]
                +",signalType="+response[1]
                        +",alertPitch="+response[2]
                        +",signal="+response[3]
        );
        return null;
    }

    private Object
    responseHardwareConfig(Parcel p) {
        int num;

        num = p.readInt();
        if(num > 100) return null;

        for (int i = 0 ; i < num ; i++) {
            int type = p.readInt();
            switch(type) {
                case 0: {
                    String id = p.readString();
                    int state = p.readInt();
                    int model = p.readInt();
                    int ratBits = p.readInt();
                    int maxV = p.readInt();
                    int maxD = p.readInt();
                    int maxS = p.readInt();
                    log("type=DEV_HARDWARE_TYPE_MODEM"
                                    +"id="+id
                                    +"state="+state
                                    +"model="+model
                                    +"ratBits="+ratBits
                                    +"maxV="+maxV
                                    +"maxD="+maxD
                                    +"maxS="+maxS
                    );

                    break;
                }
                case 1: {
                    String id = p.readString();
                    int state = p.readInt();
                    String link = p.readString();
                    log("type=DEV_HARDWARE_TYPE_SIM"
                            +"id="+id
                            +"state="+state
                            +"link="+link);

                    break;
                }
                default: {

                }
            }
        }
        log("responseHardwareConfig: num=" + num);

        return null;
    }

    private Object
    responseRadioCapability(Parcel p) {
        int version = p.readInt();
        int session = p.readInt();
        int phase = p.readInt();
        int rat = p.readInt();
        String logicModemUuid = p.readString();
        int status = p.readInt();

        log("responseRadioCapability: version= " + version +
                ", session=" + session +
                ", phase=" + phase +
                ", rat=" + rat +
                ", logicModemUuid=" + logicModemUuid +
                ", status=" + status);

        return null;
    }

    private static void retToLog(int type, int request, Object ret){
        if (ret == null) return;

        StringBuilder sb;
        String s;
        int length;
        if (ret instanceof int[]){
            int[] intArray = (int[]) ret;
            length = intArray.length;
            sb = new StringBuilder("{");
            if (length > 0) {
                int i = 0;
                sb.append(intArray[i++]);
                while ( i < length) {
                    sb.append(", ").append(intArray[i++]);
                }
            }
            sb.append("}");
            s = sb.toString();
        } else if (ret instanceof String[]) {
            String[] strings = (String[]) ret;
            length = strings.length;
            sb = new StringBuilder("{");
            if (length > 0) {
                int i = 0;
                sb.append(strings[i++]);
                while (i < length) {
                    sb.append(", ").append(strings[i++]);
                }
            }
            sb.append("}");
            s = sb.toString();
        }else if (ret instanceof byte[]){
            byte[] byteArray = (byte[]) ret;
            length = byteArray.length;
            sb = new StringBuilder("{");
            if (length > 0) {
                int i = 0;
                sb.append(byteArray[i++]);
                while ( i < length) {
                    sb.append(", ").append(byteArray[i++]);
                }
            }
            sb.append("}");
            s = sb.toString();
        } else {
            s = ret.toString();
        }
        if(type == RESPONSE_UNSOLICITED){
            log(responseToString(request) +" "+ s);
        }else{
            log(requestToString(request) +" "+ s);
        }
    }

    static String
    requestToString(int request) {

        switch (request) {
            case RIL_REQUEST_GET_SIM_STATUS:
                return "GET_SIM_STATUS";
            case RIL_REQUEST_ENTER_SIM_PIN:
                return "ENTER_SIM_PIN";
            case RIL_REQUEST_ENTER_SIM_PUK:
                return "ENTER_SIM_PUK";
            case RIL_REQUEST_ENTER_SIM_PIN2:
                return "ENTER_SIM_PIN2";
            case RIL_REQUEST_ENTER_SIM_PUK2:
                return "ENTER_SIM_PUK2";
            case RIL_REQUEST_CHANGE_SIM_PIN:
                return "CHANGE_SIM_PIN";
            case RIL_REQUEST_CHANGE_SIM_PIN2:
                return "CHANGE_SIM_PIN2";
            case RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION:
                return "ENTER_NETWORK_DEPERSONALIZATION";
            case RIL_REQUEST_GET_CURRENT_CALLS:
                return "GET_CURRENT_CALLS";
            case RIL_REQUEST_DIAL:
                return "DIAL";
            case RIL_REQUEST_GET_IMSI:
                return "GET_IMSI";
            case RIL_REQUEST_HANGUP:
                return "HANGUP";
            case RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND:
                return "HANGUP_WAITING_OR_BACKGROUND";
            case RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND:
                return "HANGUP_FOREGROUND_RESUME_BACKGROUND";
            case RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE:
                return "REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE";
            case RIL_REQUEST_CONFERENCE:
                return "CONFERENCE";
            case RIL_REQUEST_UDUB:
                return "UDUB";
            case RIL_REQUEST_LAST_CALL_FAIL_CAUSE:
                return "LAST_CALL_FAIL_CAUSE";
            case RIL_REQUEST_SIGNAL_STRENGTH:
                return "SIGNAL_STRENGTH";
            case RIL_REQUEST_VOICE_REGISTRATION_STATE:
                return "VOICE_REGISTRATION_STATE";
            case RIL_REQUEST_DATA_REGISTRATION_STATE:
                return "DATA_REGISTRATION_STATE";
            case RIL_REQUEST_OPERATOR:
                return "OPERATOR";
            case RIL_REQUEST_RADIO_POWER:
                return "RADIO_POWER";
            case RIL_REQUEST_DTMF:
                return "DTMF";
            case RIL_REQUEST_SEND_SMS:
                return "SEND_SMS";
            case RIL_REQUEST_SEND_SMS_EXPECT_MORE:
                return "SEND_SMS_EXPECT_MORE";
            case RIL_REQUEST_SETUP_DATA_CALL:
                return "SETUP_DATA_CALL";
            case RIL_REQUEST_SIM_IO:
                return "SIM_IO";
            case RIL_REQUEST_SEND_USSD:
                return "SEND_USSD";
            case RIL_REQUEST_CANCEL_USSD:
                return "CANCEL_USSD";
            case RIL_REQUEST_GET_CLIR:
                return "GET_CLIR";
            case RIL_REQUEST_SET_CLIR:
                return "SET_CLIR";
            case RIL_REQUEST_QUERY_CALL_FORWARD_STATUS:
                return "QUERY_CALL_FORWARD_STATUS";
            case RIL_REQUEST_SET_CALL_FORWARD:
                return "SET_CALL_FORWARD";
            case RIL_REQUEST_QUERY_CALL_WAITING:
                return "QUERY_CALL_WAITING";
            case RIL_REQUEST_SET_CALL_WAITING:
                return "SET_CALL_WAITING";
            case RIL_REQUEST_SMS_ACKNOWLEDGE:
                return "SMS_ACKNOWLEDGE";
            case RIL_REQUEST_GET_IMEI:
                return "GET_IMEI";
            case RIL_REQUEST_GET_IMEISV:
                return "GET_IMEISV";
            case RIL_REQUEST_ANSWER:
                return "ANSWER";
            case RIL_REQUEST_DEACTIVATE_DATA_CALL:
                return "DEACTIVATE_DATA_CALL";
            case RIL_REQUEST_QUERY_FACILITY_LOCK:
                return "QUERY_FACILITY_LOCK";
            case RIL_REQUEST_SET_FACILITY_LOCK:
                return "SET_FACILITY_LOCK";
            case RIL_REQUEST_CHANGE_BARRING_PASSWORD:
                return "CHANGE_BARRING_PASSWORD";
            case RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE:
                return "QUERY_NETWORK_SELECTION_MODE";
            case RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC:
                return "SET_NETWORK_SELECTION_AUTOMATIC";
            case RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL:
                return "SET_NETWORK_SELECTION_MANUAL";
            case RIL_REQUEST_QUERY_AVAILABLE_NETWORKS:
                return "QUERY_AVAILABLE_NETWORKS ";
            case RIL_REQUEST_DTMF_START:
                return "DTMF_START";
            case RIL_REQUEST_DTMF_STOP:
                return "DTMF_STOP";
            case RIL_REQUEST_BASEBAND_VERSION:
                return "BASEBAND_VERSION";
            case RIL_REQUEST_SEPARATE_CONNECTION:
                return "SEPARATE_CONNECTION";
            case RIL_REQUEST_SET_MUTE:
                return "SET_MUTE";
            case RIL_REQUEST_GET_MUTE:
                return "GET_MUTE";
            case RIL_REQUEST_QUERY_CLIP:
                return "QUERY_CLIP";
            case RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE:
                return "LAST_DATA_CALL_FAIL_CAUSE";
            case RIL_REQUEST_DATA_CALL_LIST:
                return "DATA_CALL_LIST";
            case RIL_REQUEST_RESET_RADIO:
                return "RESET_RADIO";
            case RIL_REQUEST_OEM_HOOK_RAW:
                return "OEM_HOOK_RAW";
            case RIL_REQUEST_OEM_HOOK_STRINGS:
                return "OEM_HOOK_STRINGS";
            case RIL_REQUEST_SCREEN_STATE:
                return "SCREEN_STATE";
            case RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION:
                return "SET_SUPP_SVC_NOTIFICATION";
            case RIL_REQUEST_WRITE_SMS_TO_SIM:
                return "WRITE_SMS_TO_SIM";
            case RIL_REQUEST_DELETE_SMS_ON_SIM:
                return "DELETE_SMS_ON_SIM";
            case RIL_REQUEST_SET_BAND_MODE:
                return "SET_BAND_MODE";
            case RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE:
                return "QUERY_AVAILABLE_BAND_MODE";
            case RIL_REQUEST_STK_GET_PROFILE:
                return "REQUEST_STK_GET_PROFILE";
            case RIL_REQUEST_STK_SET_PROFILE:
                return "REQUEST_STK_SET_PROFILE";
            case RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND:
                return "REQUEST_STK_SEND_ENVELOPE_COMMAND";
            case RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE:
                return "REQUEST_STK_SEND_TERMINAL_RESPONSE";
            case RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM:
                return "REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM";
            case RIL_REQUEST_EXPLICIT_CALL_TRANSFER:
                return "REQUEST_EXPLICIT_CALL_TRANSFER";
            case RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE:
                return "REQUEST_SET_PREFERRED_NETWORK_TYPE";
            case RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE:
                return "REQUEST_GET_PREFERRED_NETWORK_TYPE";
            case RIL_REQUEST_GET_NEIGHBORING_CELL_IDS:
                return "REQUEST_GET_NEIGHBORING_CELL_IDS";
            case RIL_REQUEST_SET_LOCATION_UPDATES:
                return "REQUEST_SET_LOCATION_UPDATES";
            case RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE:
                return "RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE";
            case RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE:
                return "RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE";
            case RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE:
                return "RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE";
            case RIL_REQUEST_SET_TTY_MODE:
                return "RIL_REQUEST_SET_TTY_MODE";
            case RIL_REQUEST_QUERY_TTY_MODE:
                return "RIL_REQUEST_QUERY_TTY_MODE";
            case RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE:
                return "RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE";
            case RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE:
                return "RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE";
            case RIL_REQUEST_CDMA_FLASH:
                return "RIL_REQUEST_CDMA_FLASH";
            case RIL_REQUEST_CDMA_BURST_DTMF:
                return "RIL_REQUEST_CDMA_BURST_DTMF";
            case RIL_REQUEST_CDMA_SEND_SMS:
                return "RIL_REQUEST_CDMA_SEND_SMS";
            case RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE:
                return "RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE";
            case RIL_REQUEST_GSM_GET_BROADCAST_CONFIG:
                return "RIL_REQUEST_GSM_GET_BROADCAST_CONFIG";
            case RIL_REQUEST_GSM_SET_BROADCAST_CONFIG:
                return "RIL_REQUEST_GSM_SET_BROADCAST_CONFIG";
            case RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG:
                return "RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG";
            case RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG:
                return "RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG";
            case RIL_REQUEST_GSM_BROADCAST_ACTIVATION:
                return "RIL_REQUEST_GSM_BROADCAST_ACTIVATION";
            case RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY:
                return "RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY";
            case RIL_REQUEST_CDMA_BROADCAST_ACTIVATION:
                return "RIL_REQUEST_CDMA_BROADCAST_ACTIVATION";
            case RIL_REQUEST_CDMA_SUBSCRIPTION:
                return "RIL_REQUEST_CDMA_SUBSCRIPTION";
            case RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM:
                return "RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM";
            case RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM:
                return "RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM";
            case RIL_REQUEST_DEVICE_IDENTITY:
                return "RIL_REQUEST_DEVICE_IDENTITY";
            case RIL_REQUEST_GET_SMSC_ADDRESS:
                return "RIL_REQUEST_GET_SMSC_ADDRESS";
            case RIL_REQUEST_SET_SMSC_ADDRESS:
                return "RIL_REQUEST_SET_SMSC_ADDRESS";
            case RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE:
                return "REQUEST_EXIT_EMERGENCY_CALLBACK_MODE";
            case RIL_REQUEST_REPORT_SMS_MEMORY_STATUS:
                return "RIL_REQUEST_REPORT_SMS_MEMORY_STATUS";
            case RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING:
                return "RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING";
            case RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE:
                return "RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE";
            case RIL_REQUEST_ISIM_AUTHENTICATION:
                return "RIL_REQUEST_ISIM_AUTHENTICATION";
            case RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU:
                return "RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU";
            case RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS:
                return "RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS";
            case RIL_REQUEST_VOICE_RADIO_TECH:
                return "RIL_REQUEST_VOICE_RADIO_TECH";
            case RIL_REQUEST_GET_CELL_INFO_LIST:
                return "RIL_REQUEST_GET_CELL_INFO_LIST";
            case RIL_REQUEST_SET_UNSOL_CELL_INFO_LIST_RATE:
                return "RIL_REQUEST_SET_CELL_INFO_LIST_RATE";
            case RIL_REQUEST_SET_INITIAL_ATTACH_APN:
                return "RIL_REQUEST_SET_INITIAL_ATTACH_APN";
            case RIL_REQUEST_IMS_REGISTRATION_STATE:
                return "RIL_REQUEST_IMS_REGISTRATION_STATE";
            case RIL_REQUEST_IMS_SEND_SMS:
                return "RIL_REQUEST_IMS_SEND_SMS";
            case RIL_REQUEST_SIM_TRANSMIT_APDU_BASIC:
                return "RIL_REQUEST_SIM_TRANSMIT_APDU_BASIC";
            case RIL_REQUEST_SIM_OPEN_CHANNEL:
                return "RIL_REQUEST_SIM_OPEN_CHANNEL";
            case RIL_REQUEST_SIM_CLOSE_CHANNEL:
                return "RIL_REQUEST_SIM_CLOSE_CHANNEL";
            case RIL_REQUEST_SIM_TRANSMIT_APDU_CHANNEL:
                return "RIL_REQUEST_SIM_TRANSMIT_APDU_CHANNEL";
            case RIL_REQUEST_NV_READ_ITEM: return "RIL_REQUEST_NV_READ_ITEM";
            case RIL_REQUEST_NV_WRITE_ITEM: return "RIL_REQUEST_NV_WRITE_ITEM";
            case RIL_REQUEST_NV_WRITE_CDMA_PRL: return "RIL_REQUEST_NV_WRITE_CDMA_PRL";
            case RIL_REQUEST_NV_RESET_CONFIG: return "RIL_REQUEST_NV_RESET_CONFIG";
            case RIL_REQUEST_SET_UICC_SUBSCRIPTION: return "RIL_REQUEST_SET_UICC_SUBSCRIPTION";
            case RIL_REQUEST_ALLOW_DATA: return "RIL_REQUEST_ALLOW_DATA";
            case RIL_REQUEST_GET_HARDWARE_CONFIG: return "GET_HARDWARE_CONFIG";
            case RIL_REQUEST_SIM_AUTHENTICATION: return "RIL_REQUEST_SIM_AUTHENTICATION";
            case RIL_REQUEST_SHUTDOWN: return "RIL_REQUEST_SHUTDOWN";
            case RIL_REQUEST_SET_RADIO_CAPABILITY:
                return "RIL_REQUEST_SET_RADIO_CAPABILITY";
            case RIL_REQUEST_GET_RADIO_CAPABILITY:
                return "RIL_REQUEST_GET_RADIO_CAPABILITY";
            default:
                return "<unknown request>";
        }
    }

    static String
    responseToString(int request) {
        switch (request) {
            case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED:
                return "UNSOL_RESPONSE_RADIO_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED:
                return "UNSOL_RESPONSE_CALL_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED:
                return "UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_NEW_SMS:
                return "UNSOL_RESPONSE_NEW_SMS";
            case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT:
                return "UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT";
            case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM:
                return "UNSOL_RESPONSE_NEW_SMS_ON_SIM";
            case RIL_UNSOL_ON_USSD:
                return "UNSOL_ON_USSD";
            case RIL_UNSOL_ON_USSD_REQUEST:
                return "UNSOL_ON_USSD_REQUEST";
            case RIL_UNSOL_NITZ_TIME_RECEIVED:
                return "UNSOL_NITZ_TIME_RECEIVED";
            case RIL_UNSOL_SIGNAL_STRENGTH:
                return "UNSOL_SIGNAL_STRENGTH";
            case RIL_UNSOL_DATA_CALL_LIST_CHANGED:
                return "UNSOL_DATA_CALL_LIST_CHANGED";
            case RIL_UNSOL_SUPP_SVC_NOTIFICATION:
                return "UNSOL_SUPP_SVC_NOTIFICATION";
            case RIL_UNSOL_STK_SESSION_END:
                return "UNSOL_STK_SESSION_END";
            case RIL_UNSOL_STK_PROACTIVE_COMMAND:
                return "UNSOL_STK_PROACTIVE_COMMAND";
            case RIL_UNSOL_STK_EVENT_NOTIFY:
                return "UNSOL_STK_EVENT_NOTIFY";
            case RIL_UNSOL_STK_CALL_SETUP:
                return "UNSOL_STK_CALL_SETUP";
            case RIL_UNSOL_SIM_SMS_STORAGE_FULL:
                return "UNSOL_SIM_SMS_STORAGE_FULL";
            case RIL_UNSOL_SIM_REFRESH:
                return "UNSOL_SIM_REFRESH";
            case RIL_UNSOL_CALL_RING:
                return "UNSOL_CALL_RING";
            case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED:
                return "UNSOL_RESPONSE_SIM_STATUS_CHANGED";
            case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS:
                return "UNSOL_RESPONSE_CDMA_NEW_SMS";
            case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS:
                return "UNSOL_RESPONSE_NEW_BROADCAST_SMS";
            case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL:
                return "UNSOL_CDMA_RUIM_SMS_STORAGE_FULL";
            case RIL_UNSOL_RESTRICTED_STATE_CHANGED:
                return "UNSOL_RESTRICTED_STATE_CHANGED";
            case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE:
                return "UNSOL_ENTER_EMERGENCY_CALLBACK_MODE";
            case RIL_UNSOL_CDMA_CALL_WAITING:
                return "UNSOL_CDMA_CALL_WAITING";
            case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS:
                return "UNSOL_CDMA_OTA_PROVISION_STATUS";
            case RIL_UNSOL_CDMA_INFO_REC:
                return "UNSOL_CDMA_INFO_REC";
            case RIL_UNSOL_OEM_HOOK_RAW:
                return "UNSOL_OEM_HOOK_RAW";
            case RIL_UNSOL_RINGBACK_TONE:
                return "UNSOL_RINGBACK_TONE";
            case RIL_UNSOL_RESEND_INCALL_MUTE:
                return "UNSOL_RESEND_INCALL_MUTE";
            case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED:
                return "CDMA_SUBSCRIPTION_SOURCE_CHANGED";
            case RIL_UNSOl_CDMA_PRL_CHANGED:
                return "UNSOL_CDMA_PRL_CHANGED";
            case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE:
                return "UNSOL_EXIT_EMERGENCY_CALLBACK_MODE";
            case RIL_UNSOL_RIL_CONNECTED:
                return "UNSOL_RIL_CONNECTED";
            case RIL_UNSOL_VOICE_RADIO_TECH_CHANGED:
                return "UNSOL_VOICE_RADIO_TECH_CHANGED";
            case RIL_UNSOL_CELL_INFO_LIST:
                return "UNSOL_CELL_INFO_LIST";
            case RIL_UNSOL_RESPONSE_IMS_NETWORK_STATE_CHANGED:
                return "UNSOL_RESPONSE_IMS_NETWORK_STATE_CHANGED";
            case RIL_UNSOL_UICC_SUBSCRIPTION_STATUS_CHANGED:
                return "RIL_UNSOL_UICC_SUBSCRIPTION_STATUS_CHANGED";
            case RIL_UNSOL_SRVCC_STATE_NOTIFY:
                return "UNSOL_SRVCC_STATE_NOTIFY";
            case RIL_UNSOL_HARDWARE_CONFIG_CHANGED: return "RIL_UNSOL_HARDWARE_CONFIG_CHANGED";
            case RIL_UNSOL_RADIO_CAPABILITY:
                return "RIL_UNSOL_RADIO_CAPABILITY";
            case RIL_UNSOL_ON_SS: return "UNSOL_ON_SS";
            case RIL_UNSOL_STK_CC_ALPHA_NOTIFY: return "UNSOL_STK_CC_ALPHA_NOTIFY";
            default:
                return "<unknown response>";
        }
    }
}
