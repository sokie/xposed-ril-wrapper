package nl.sokie.xposedrilwrapper;

import android.os.Message;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    private static final String TAG = "Sokie:MainHook";

    public static Map<Integer, Integer> serialMap = new HashMap<>();

    private static void log(String msg) {
        XposedBridge.log(TAG + ": " + msg);
    }

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.android.phone")) {

            XposedHelpers.findAndHookMethod("com.android.internal.telephony.RIL",
                    lpparam.classLoader,
                    "readRilMessage",
                    InputStream.class,
                    byte[].class,
                    new RILWrapper());


            XposedHelpers.findAndHookMethod("com.android.internal.telephony.RILRequest",
                    lpparam.classLoader,
                    "obtain",
                    int.class, Message.class,
                    new XC_MethodHook() {

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);

                            Object obj = param.getResult();
                            Integer serial = (Integer)XposedHelpers.getObjectField(obj, "mSerial");

                            Integer requestType = (Integer)param.args[0];

                            log("RIL obtain got type "+ requestType + " for serial "+serial);
                            synchronized(serialMap) {
                                serialMap.put(serial, requestType);
                            }
                        }
                    });
        }
    }
}
