package io.avchain.rhymecard.dto.request;

import io.avchain.rhymecard.config.CommonConfig;

public class LoginDto {
    String id                   ;
    String email                ;
    String password             ;
    String osCode               = CommonConfig._OS_CODE_;
    String systemCode           = CommonConfig._SYSTEM_CODE_;
    String systemTypeCode       = CommonConfig.SYSTEM_TYPE_CODE;
    String systemTypeVersion    = CommonConfig._SYSTEM_TYPE_VERSION_;
    String deviceId             = "";

    public LoginDto(String id, String email, String password, String deviceId) {
        this.id                 = id                ;
        this.email              = email             ;
        this.password           = password          ;
        this.deviceId           = deviceId          ;
    }
}
