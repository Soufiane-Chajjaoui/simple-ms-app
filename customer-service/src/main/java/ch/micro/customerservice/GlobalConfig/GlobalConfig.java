package ch.micro.customerservice.GlobalConfig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer.params")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {
    private int x ;
    private int y ;
}
