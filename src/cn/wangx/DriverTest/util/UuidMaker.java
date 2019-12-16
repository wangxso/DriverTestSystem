package cn.wangx.DriverTest.util;

import java.util.UUID;

public class UuidMaker {
    public static String makeUUid(){
        UUID uuidd = UUID.randomUUID();
        String uuid = uuidd.toString();
        uuid = uuid.replace("-","").substring(0,18);
        return uuid;
    }
}
