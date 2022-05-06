package com.jwdnd.simplechat;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimplechatApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimplechatApplication.class, args);
	}
}
