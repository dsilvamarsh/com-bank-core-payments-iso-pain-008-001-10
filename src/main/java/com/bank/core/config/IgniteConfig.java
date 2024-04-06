package com.bank.core.config;

import org.apache.ignite.Ignition;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.client.ThinClientKubernetesAddressFinder;
import org.apache.ignite.configuration.ClientConfiguration;
import org.apache.ignite.kubernetes.configuration.KubernetesConnectionConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteConfig {

	@Bean
	public ClientConfiguration clientConfiguration() {
		ClientConfiguration cfg = new ClientConfiguration();
		cfg.setAddresses("localhost:10800");
		return cfg;
	}

	// @Bean
	public ClientConfiguration kubeConfig() {
		KubernetesConnectionConfiguration kconf = new KubernetesConnectionConfiguration();
		kconf.setNamespace("devops-tools");
		kconf.setServiceName("ignite-service");
		ClientConfiguration cfg = new ClientConfiguration();
		cfg.setAddressesFinder(new ThinClientKubernetesAddressFinder(kconf));
		
		return cfg;

	}

	@Bean
	public IgniteClient igniteClient(ClientConfiguration cfg) {

		return Ignition.startClient(cfg);

	}

}
