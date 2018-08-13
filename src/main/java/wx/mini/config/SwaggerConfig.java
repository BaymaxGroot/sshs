package wx.mini.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages="wx.mini.controller")
public class SwaggerConfig extends WebMvcConfigurerAdapter{

	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("微信小程序 API接口文档")
				.apiInfo(buildApiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder()
				.title("Lele's Database API Document")
				.description("SSM Combine Swagger2 Build Restful API")
				.version("1.0.0")
				.termsOfServiceUrl("http://www.baidu.com/")
				.contact(new Contact("Lele Zheng", "https://blog.csdn.net/csdn_lele", "baymax_lele@foxmail.com"))
				.build();
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

}
