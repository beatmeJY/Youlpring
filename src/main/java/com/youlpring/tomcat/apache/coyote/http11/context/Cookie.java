package com.youlpring.tomcat.apache.coyote.http11.context;

import com.youlpring.jws.common.config.CookieConfiguration;
import com.youlpring.tomcat.apache.coyote.http11.constants.CookieConstant;

public class Cookie {

    private final CookieName name;
    private String value;
    private Long maxAge = CookieConfiguration.DEFAULT_MAX_AGE;
    private boolean httpOnly = CookieConfiguration.DEFAULT_HTTPONLY;
    private boolean secure = CookieConfiguration.DEFAULT_HTTPONLY;
    public String path = CookieConfiguration.DEFAULT_PATH;
    public String domain;

    public Cookie(CookieName name, String value) {
        this.name = name;
        this.value = value;
    }

    public void setMaxAge(Long maxAge) {
        this.maxAge = maxAge;
    }

    public void setHttpOnly(boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name.name();
    }

    public Long getMaxAge() {
        return maxAge;
    }

    public String getValue() {
        return value;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name.name()).append("=").append(value).append(";");
        builder.append(CookieConstant.MAX_AGE).append("=").append(maxAge).append(";");
        builder.append(CookieConstant.SECURE).append("=").append(secure).append(";");
        builder.append(CookieConstant.HTTP_ONLY).append("=").append(httpOnly).append(";");
        builder.append(CookieConstant.PATH).append("=").append(path).append(";");
        builder.append(domain != null ? CookieConstant.DOMAIN + "=" + domain + ";" : "");
        return builder.toString();
    }
}
