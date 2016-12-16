/**
 * 
 */
package com.shirish.camelExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shirish
 *
 */
@Configuration
public class CamelAppConfig {

	/**
	 * 
	 */
	public CamelAppConfig() {
		
		
	}
	
	@Bean
	public MsgProcessor msgProcessor(){
		return new MsgProcessor();
	}

}
