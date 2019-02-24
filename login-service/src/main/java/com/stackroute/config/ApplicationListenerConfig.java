package com.stackroute.config;


import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerConfig implements org.springframework.context.ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user = new User();
        user.setId((long)1);
        user.setUsername("admin");
        user.setPassword("$2a$10$3ZISFbyeW97sMuNHhFrkfuAuLbeNwcKYXDuG2A7twyPoLyhPVwnZ.");

                userRepository.save(user);
    }
}
