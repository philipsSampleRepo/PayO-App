package com.pay.payo.application.di;

import com.pay.payo.network.APIService;
import com.pay.payo.persistence.NetworkInfoDatabase;
import com.pay.payo.repository.Repository;
import com.pay.payo.ui.di.PaymentMethodsActivityComponent;
import com.pay.payo.utils.AppExecutors;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    APIService getApiService();

    AppExecutors getAppExecutors();

    NetworkInfoDatabase getNetworkInfoDb();

    Repository getRepository();

    PaymentMethodsActivityComponent.Factory getActivityComponentFactory();

    @Component.Factory
    interface Factory {
        ApplicationComponent create(ApplicationModule module);
    }
}
