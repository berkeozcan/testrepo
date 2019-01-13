package com.barisboot.barisspringboot.rest;

import com.barisboot.barisspringboot.service.TestService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@RequestMapping("/restapi")
@RestController
public class RestTestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "makeupper", method = RequestMethod.GET)
    public String makeUpper(@RequestParam(value = "text") String text) {
        return StringUtils.upperCase(text);
    }

    @RequestMapping(value = "concat", method = RequestMethod.GET)
    public String concat(@RequestParam(value = "text1") String text1, @RequestParam(value = "text2") String text2) {
        return testService.addString(text1, text2);
    }

    @RequestMapping(value = "makelower", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String makeLowerPost(@RequestBody String text) {
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("asd"));
        return StringUtils.lowerCase(text);
    }
}
