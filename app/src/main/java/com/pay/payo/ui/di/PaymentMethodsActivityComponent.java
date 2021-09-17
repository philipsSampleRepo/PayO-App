package com.pay.payo.ui.di;

import com.pay.payo.adapter.PaymentMethodsAdapter;
import com.pay.payo.di.PerActivityScope;
import com.pay.payo.ui.PaymentMethodsActivity;
import com.pay.payo.viewmodels.NetworksViewModel;

import dagger.Subcomponent;

@PerActivityScope
@Subcomponent(modules = PaymentMethodsActivityModule.class)
public interface PaymentMethodsActivityComponent {

    NetworksViewModel getNetworksViewModel();

    PaymentMethodsAdapter getPaymentMethodsAdapter();

    void injectActivity(PaymentMethodsActivity activity);

    @Subcomponent.Factory
    interface Factory {
        PaymentMethodsActivityComponent create(PaymentMethodsActivityModule methodsActivityModule);
    }
}
