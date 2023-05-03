package br.com.currencyconverter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties
public class ConfigProperties {

    @Value("${urlbase.servico.testeprojeto}")
    String urlBaseTestProjeto;

}
