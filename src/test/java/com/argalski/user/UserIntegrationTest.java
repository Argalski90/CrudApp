package com.argalski.user;

import com.argalski.entity.User;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserIntegrationTest {

    @Value("${local.server.port}")
    private int localServerPort;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGetAll() {
        ResponseEntity<Collection> responseEntity = restTemplate.getForEntity("http://localhost:{port}/users", Collection.class,localServerPort);
        Collection<User> users = responseEntity.getBody();
        Assert.notEmpty(users, "Empty User's collection");
    }

    @Test
    public void testCreateRead() {
        User user = new User(4L, "Test", "Test 1");

        HttpEntity<User> httpEntity = new HttpEntity<>(user);
        restTemplate.exchange(String.format("http://localhost:%s/users", localServerPort), HttpMethod.POST, httpEntity, User.class);

        ResponseEntity<User> responseEntity = restTemplate.getForEntity(String.format("http://localhost:{port}/users/{id}", localServerPort), User.class, localServerPort, 4);
        User savedUser = responseEntity.getBody();
        Assert.notNull(savedUser, "User is null");
    }

    @SpringBootApplication(scanBasePackages = "com.argalski")
    static class Config {
        @Bean
        public RestTemplate restTemplate() {
            return createRestTemplate();
        }

        private RestTemplate createRestTemplate() {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);


            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/json"));
            converter.setObjectMapper(objectMapper);

            BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());

            RestTemplate restTemplate = new RestTemplate(bufferingClientHttpRequestFactory);
            restTemplate.setMessageConverters(Collections.singletonList(converter));
            return restTemplate;
        }
    }

}
