package com.example.demo.scheduler;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTask {

    @Value("${driverpath}")
    private String webDriverPath;

    static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);

    @Scheduled(cron = "*/30 * * * * ?")
    public void executeOpenBrowser() throws IOException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver","E:\\EROS\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",webDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        options.addArguments("--headless");
        options.addArguments("--disable-extensions"); //to disable browser extension popup
        options.addArguments("--disable-gpu");

        ChromeDriverService driverService = ChromeDriverService.createDefaultService();
        ChromeDriver driver = new ChromeDriver(driverService, options);
//
//        Map<String, Object> commandParams = new HashMap<>();
//        commandParams.put("cmd", "Page.setDownloadBehavior");
//        Map<String, String> params = new HashMap<>();
//        params.put("behavior", "allow");
//        params.put("downloadPath", "E:\\EROS\\si-bot\\");
//        commandParams.put("params", params);
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        String command = objectMapper.writeValueAsString(commandParams);
//        String u = driverService.getUrl().toString() + "/session/" + driver.getSessionId() + "/chromium/send_command";
//        HttpPost request = new HttpPost(u);
//        request.addHeader("content-type", "application/json");
//        request.setEntity(new StringEntity(command));
//        httpClient.execute(request);
        LOGGER.info(((RemoteWebDriver)driver).getCapabilities().toString());
        driver.get("https://www.omgeo.com/login");
        LOGGER.info("PageSource " + driver.getPageSource());
//        driver.get("http://www.seleniumhq.org/download/");
//        driver.findElement(By.linkText("32 bit Windows IE")).click();
        LOGGER.info("File downloaded successfully");


    }

}
