package com.wealth.common.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.wealth.common.config.MtlsFeignClientCommonConfig;
import com.wealth.common.config.NexusServiceFeignClientMtlsConfig;


@FeignClient(
		    name = "${growx.nexusService.name}",
		    url = "${growx.nexusService.url}",configuration = MtlsFeignClientCommonConfig.class
)

public interface NexusServiceFeignClient {

	@GetMapping("/growx/api/v1/nexus/requestHeader/getCacheData")
	 public String getCacheData(@RequestHeader String key,@RequestHeader("X-USER-CODE") String userCode,@RequestHeader("APPID") String appId);
	 @GetMapping("/growx/api/v1/nexus/requestHeader/setCacheData")
	 public String setCacheData(@RequestHeader String key,@RequestHeader String data,@RequestHeader("X-USER-CODE") String userCode,@RequestHeader("APPID") String appId);
	 @GetMapping("/growx/api/v1/nexus/requestHeader/removeCacheData")
	 public boolean removeCacheData(@RequestHeader String key,@RequestHeader("X-USER-CODE") String userCode,@RequestHeader("APPID") String appId);
	
	
	
}
