package com.atsc.cloudribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class CloudRibbonApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 *  ---------------------
	 作者：q_0718
	 来源：CSDN
	 原文：https://blog.csdn.net/q_0718/article/details/80269864
	 版权声明：本文为博主原创文章，转载请附上博文链接！
	 *
	 * Ribbon 是一个基于 HTTP 和 TCP 客户端的负载均衡器
	 它可以在客户端配置 ribbonServerList（服务端列表），然后轮询请求以实现均衡负载
	 它在联合 Eureka 使用时
	 ribbonServerList 会被 DiscoveryEnabledNIWSServerList 重写，扩展成从 Eureka 注册中心获取服务端列表
	 同时它也会用 NIWSDiscoveryPing 来取代 IPing，它将职责委托给 Eureka 来确定服务端是否已经启动


	 如何理解客户端Ribbon 
	 zuul也有负载均衡的功能，它是针对外部请求做负载，那客户端ribbon的负载均衡又是怎么一回事？

	 客户端ribbon的负载均衡，解决的是服务发起方（在Eureka注册的服务）对被调用的服务的负载，
	 比如我们查询商品服务要调用显示库存和商品明细服务，通过商品服务的接口将两个服务组合，
	 可以减少外部应用的请求，比如手机App发起一次请求即可，可以节省网络带宽，也更省电。

	 ribbon是对服务之间调用做负载，是服务之间的负载均衡，zuul是可以对外部请求做负载均衡。 
	 */





}
