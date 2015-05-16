/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderSupport;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * 系统配置容器，包含加载配置文件
 *
 * @author gejb
 * @since 2015-05-16
 */
public class ConfigurationContainer {
    private static final Log logger = LogFactory.getLog(ConfigurationContainer.class);
    /**
     * 系统配置属性文件名称
     */
    private final static String APPLICATION_PROPERTIES_NAME = "/org/silencer/voter/config/application.properties";

    private Properties configuration;

    private ConfigurationContainer() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(APPLICATION_PROPERTIES_NAME);
        try {
            configuration = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            logger.error("load " + APPLICATION_PROPERTIES_NAME + " failed.");
        }
    }

    private String getValue(String key) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null) {
            return systemProperty;
        }
        if (configuration.containsKey(key)) {
            return configuration.getProperty(key);
        }
        return null;
    }

    public String getString(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public String getString(String key, String defaultValue) {
        String value = getValue(key);
        return value != null ? value : defaultValue;
    }

    public Integer getInteger(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Integer.valueOf(value);
    }

    public Integer getInteger(String key, Integer defaultValue) {
        String value = getValue(key);
        return value != null ? Integer.valueOf(value) : defaultValue;
    }

    public Double getDouble(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Double.valueOf(value);
    }

    public Double getDouble(String key, Integer defaultValue) {
        String value = getValue(key);
        return value != null ? Double.valueOf(value) : defaultValue;
    }

    public Boolean getBoolean(String key) {
        String value = getValue(key);
        if (value == null) {
            throw new NoSuchElementException();
        }
        return Boolean.valueOf(value);
    }

    public Boolean getBoolean(String key, boolean defaultValue) {
        String value = getValue(key);
        return value != null ? Boolean.valueOf(value) : defaultValue;
    }

    /**
     * 单例模式（懒加载）
     *
     * @return 系统配置容器
     */
    public static ConfigurationContainer getContainer() {
        return ConfigurationContainerHolder.instance;
    }

    private static class ConfigurationContainerHolder {
        private static ConfigurationContainer instance = new ConfigurationContainer();
    }
}
