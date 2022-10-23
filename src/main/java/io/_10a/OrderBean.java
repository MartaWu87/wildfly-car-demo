package io._10a;

import io._10a.controller.OrderController;
import io._10a.entity.Customer;
import io._10a.entity.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class OrderBean implements Serializable {

    Logger logger = LoggerFactory.getLogger(OrderBean.class);

    @Inject
    OrderController orderController;

    public String createOrder(Model model) {
        logger.info("model.name: {} {} {} {} {} {}", model.getName(), model.getEngine(), model.getDrivetrain(), model.getTransmission(), model.getVersion(), model.getPrice());
//        logger.info("customer.name: {} {}", customer.getName(), customer.getEmail());
        Customer customer = new Customer();
        customer.setName("mario");
        customer.setEmail("mario@wp.pl");
        orderController.createOrder(model, customer);
        return "success";

    }
}
