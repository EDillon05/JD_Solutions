//package com.dilon.filemanagerapp.config;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.info.License;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import io.swagger.v3.oas.annotations.servers.Server;
//import org.springframework.stereotype.Service;
//
//@OpenAPIDefinition(
//        info = @Info(
//                contact = @Contact(
//                        name = "Cesar Dillon",
//                        email = "cesar.dillon1275@alumnos.udg.mx",
//                        url = "https://github.com/EDillon05"
//                ),
//                description = "API documentation for the File Manager App",
//                title = "OpenApi specification for CurricuLink",
//                version = "1.1",
//                license = @License(
//                        name = "MIT"
//                ),
//                termsOfService = "Terms of service"
//        ),
//        servers = {
//                @Server(
//                        description = "Local server",
//                        url = "http://localhost:8050"
//                ),
//                @Server(
//                        description = "Research server",
//                        url = "https://api.dilon.com"
//                )
//        },
//        security = {
//                @SecurityRequirement(
//                        name = "bearerAuth"
//                )
//        }
//)
//@SecurityScheme(
//        name = "bearerAuth",
//        description = "JWT auth description",
//        scheme = "bearer",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        in = SecuritySchemeIn.HEADER
//)
//public class OpenApiConfig {
//}
