package com.abolkog.springboot.tut.util;

import com.abolkog.springboot.tut.security.AppUser;
import com.abolkog.springboot.tut.security.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {

        if (userService.findAll().isEmpty()) {
            logger.info("No Users accounts found. Creating some users");

            AppUser user = new AppUser("sss@sss.com", "password", "sss");
            userService.save(user);
        }
    }
}
