package com.ems.sb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Emp Management System API",
        description = "API to manage Employees",
        version = "4.0",
        contact = @Contact(name = "API Support", email = "support@ems.com")
))
public class Config {
}
