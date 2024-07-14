package com.account.config;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.account.exception.CustomerNotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class CustomFeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            return new CustomerNotFoundException("Customer not found with id: " + extractCustomerIdFromPath(response.request().url()));
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }

    private Long extractCustomerIdFromPath(String url) {
        String[] parts = url.split("/");
        return Long.valueOf(parts[parts.length - 1]);
    }
}
