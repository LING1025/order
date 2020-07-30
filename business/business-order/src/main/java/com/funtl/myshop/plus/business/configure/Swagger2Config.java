package com.funtl.myshop.plus.business.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>
 * Description: http://ip:port/swagger-ui.html
 * </p>
 *   http://ip:port/swagger-ui.html
 * Swagger 注解说明
 *
 * Swagger 通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
 *
 *     @Api：修饰整个类，描述 Controller 的作用
 *     @ApiOperation：描述一个类的一个方法，或者说一个接口
 *     @ApiParam：单个参数描述
 *     @ApiModel：用对象来接收参数
 *     @ApiProperty：用对象接收参数时，描述对象的一个字段
 *     @ApiResponse：HTTP 响应其中 1 个描述
 *     @ApiResponses：HTTP 响应整体描述
 *     @ApiIgnore：使用该注解忽略这个API
 *     @ApiError：发生错误返回的信息
 *     @ApiImplicitParam：一个请求参数
 *     @ApiImplicitParams：多个请求参数
 *
 */

@Configuration
public class Swagger2Config {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.funtl.myshop.plus.business.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("移动端格上租赁 API文档")
                .description("移动端格上租赁 api网关接口，http://192.168.168.62:9999/api")
                .version("1.0")
                .build();
    }

}
