package com.myself.service;

import com.myself.model.ExampleModel;
import org.springframework.stereotype.Service;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    @Override
    public ExampleModel get(String modelId) {
        return new ExampleModel("example", 1001);
    }
}