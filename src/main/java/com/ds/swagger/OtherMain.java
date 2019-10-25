package com.ds.swagger;

import com.ds.swagger.client.ServiceInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OtherMain implements CommandLineRunner {

    @Autowired
    private ServiceInvoker invoker;

    public static void main(String[] args) {
        SpringApplication.run(OtherMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("PUMBA");
        //invoker.callExternalService();
        invoker.findAllUsers();
        System.exit(0);
    }
}
