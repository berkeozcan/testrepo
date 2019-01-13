package com.barisboot.barisspringboot.service.impl;

import com.barisboot.barisspringboot.service.TestService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String addString(String firstString, String secondString) {
        return StringUtils.join(Lists.newArrayList(firstString, secondString), ", ");
    }
}
