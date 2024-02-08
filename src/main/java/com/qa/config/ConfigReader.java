package com.qa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static ConfigReader instance;
	private Properties properties;

	private ConfigReader() {
		loadProperties();
	}

	public static ConfigReader getInstance() {
		if (instance == null) {
			synchronized (ConfigReader.class) {
				if (instance == null) {
					instance = new ConfigReader();
				}
			}
		}
		return instance;
	}

	private void loadProperties() {
		try (InputStream inputStream = getClass().getResourceAsStream("/config.properties")) {
			properties = new Properties();
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new IOException("Unable to find config.properties file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}

	public String getURL() {
		return properties.getProperty("url");
	}

	public String getUsername() {
		return properties.getProperty("username");
	}

	public String getPassword() {
		return properties.getProperty("password");
	}
}
