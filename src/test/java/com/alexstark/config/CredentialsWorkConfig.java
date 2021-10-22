package com.alexstark.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentialsWork.properties"})
public interface CredentialsWorkConfig extends Config {
    String login();
    String password();
    String browserURL();
}
