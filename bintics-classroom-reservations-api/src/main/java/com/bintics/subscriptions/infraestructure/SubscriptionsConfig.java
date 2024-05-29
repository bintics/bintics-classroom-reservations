package com.bintics.subscriptions.infraestructure;

import com.bintics.context.subscriptions.application.GetSubscriptionUseCase;
import com.bintics.context.subscriptions.application.SearchSubscriptionUseCase;
import com.bintics.context.subscriptions.domain.SubscriptionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionsConfig {

    @Bean
    public GetSubscriptionUseCase getSubscriptionUseCase(SubscriptionRepository subscriptionRepository) {
        return new GetSubscriptionUseCase(subscriptionRepository);
    }

    @Bean
    public SearchSubscriptionUseCase searchSubscriptionUseCase(SubscriptionRepository repository) {
        return new SearchSubscriptionUseCase(repository);
    }

}
