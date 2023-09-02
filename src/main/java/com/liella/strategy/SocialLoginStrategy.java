package com.liella.strategy;

/**
 * 第三方登录策略
 *
 * @author  liyuu
 */
public interface SocialLoginStrategy {

    /**
     * 登录
     *
     * @param data data
     * @return {@link String} Token
     */
    String login(String data);
}
