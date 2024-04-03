package ch.micro.customerservice.web;

import ch.micro.customerservice.GlobalConfig.GlobalConfig;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("Config")
@AllArgsConstructor
@RefreshScope
public class ConfigTest {

//    @Value("${global.params.p1}")
//    private int p1_value ;
//    @Value("${customer.params.x}")
//    private int x_value;


    private GlobalConfig globalConfig;


//    @GetMapping
//    public Map<String , Integer> getConfig(){
//        return Map.of("global.params.p1" , p1_value , "global.params.x" , x_value);
//    }

    @GetMapping("/getGlobalConfig")
    public Map<String , Integer> getGlobalConfig(){
        return Map.of("global.params.x" , globalConfig.getX() , "global.params.y" , globalConfig.getY());
    }
}
