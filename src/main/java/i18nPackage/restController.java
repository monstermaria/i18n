package i18nPackage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class restController {
	
	@Autowired
	private MessageSource messageSource;
		
	@GetMapping("/translate")
	public String translate(@RequestHeader(name = "Accept-Language", required = false) String localeString, String phrase) {
		
		TranslatorLogic translator = new TranslatorLogic(messageSource, localeString, phrase);
				
		return translator.getTranslation();
	}
}
