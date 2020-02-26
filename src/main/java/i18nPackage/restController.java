package i18nPackage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class restController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TranslationMap translationMap;
		
	@GetMapping("/translate")
	public String translate(@RequestHeader(name = "Accept-Language", required = false) String localeString, String phrase) {
		
		TranslatorLogic translator = new TranslatorLogic(messageSource, translationMap, localeString, phrase);
				
		return translator.getTranslation();
	}
	
	@PostMapping("/add-translation")
	public String addTranslation(String language, String phrase, String translation) {
		
		return translationMap.addTranslation(language, phrase, translation);
	}
}
