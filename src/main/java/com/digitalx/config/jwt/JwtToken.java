package com.digitalx.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;
/**
 * @author pengjunlee
 * @create 2019-09-03 9:44
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 1L;

    // 加密后的 JWT token串
    private String token;

    private String userName;

    public JwtToken(String token) {
        this.token = token;
        this.userName = JwtUtils.getClaimFiled(token, "username");
    }

    @Override
    public Object getPrincipal() {
        return this.userName;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
