package io._10a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class StartupBean implements Serializable {

	Logger logger = LoggerFactory.getLogger(getClass());

	@PostConstruct
	public void init() {
		logger.info("Wystartowało!");
	}

	public String getDupa(){
		return "Dupa";
	}

}
