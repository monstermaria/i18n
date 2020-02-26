package i18nPackage;

import java.util.Locale;

//import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@SpringBootApplication
public class I18nApplication {

	public static void main(String[] args) {
		SpringApplication.run(I18nApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		// default locale is sv_SE on my computer, this gives swedish as the default translation
		messageSource.setDefaultLocale(Locale.ENGLISH);
		return messageSource;
	}
	
	@Bean
	public TranslationMap translationMap() {
		return new TranslationMap();
	}
}
