package betahouse;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@ServletComponentScan
@ComponentScan
@MapperScan("betahouse.model.mapper")
@SpringBootApplication
public class ThemisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThemisApplication.class, args);
	}
    //配置mybatis的分页插件pageHelper
//    @Bean
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum","true");
//        properties.setProperty("rowBoundsWithCount","true");
//        properties.setProperty("reasonable","true");
//        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }
}

