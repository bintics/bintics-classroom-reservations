package com.bintics.subscriptions.infraestructure;

import com.bintics.context.subscriptions.application.GetSubscriptionUseCase;
import com.bintics.context.subscriptions.domain.SubscriptionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionsConfig {

    @Bean
    public GetSubscriptionUseCase getSubscriptionUseCase(SubscriptionRepository subscriptionRepository) {
        return new GetSubscriptionUseCase(subscriptionRepository);
    }

}
