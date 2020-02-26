package i18nPackage;

import java.util.Locale;
import java.util.TreeMap;

import org.springframework.context.MessageSource;


public class TranslatorLogic {
	
	private TranslationMap translationMap;
	private MessageSource messageSource;
	private String localeString;
	private Locale locale;
	private boolean defaultLocaleUsed = false;
	private String phrase;
	private String translation;
	
	public TranslatorLogic(MessageSource messageSource, TranslationMap translationMap, String localeString, String phrase) {
		
		this.messageSource = messageSource;
		this.translationMap = translationMap;
		this.localeString = localeString;
		this.phrase = phrase;
		
		setLocale(localeString);
	}
	
	private Locale setLocale(String localeString) {

		// use locale provided in the request
		if (localeString != null) {
			locale = Locale.forLanguageTag(localeString);
		}
		
		if (locale == null) {
			System.out.println("Locale is null");
			locale = Locale.ENGLISH;
			defaultLocaleUsed = true;
		}
		
		switch (locale.toString()) {
		case "en":
			System.out.println("Locale is en");
			break;
		case "sv":
			System.out.println("Locale is sv");
			break;
		case "de":
			System.out.println("Locale is de");
			break;
		default:
			System.out.println("Locale is not handled: " + locale);
			locale = Locale.ENGLISH;
			defaultLocaleUsed = true;
		}

		return locale;
	}
	
	public String getTranslation() {
					
		try {
			translation = messageSource.getMessage(phrase, null, locale);
		} catch (Exception e) {

			TreeMap<String, String> language = translationMap.getLanguage(locale.getLanguage());
			translation = null;
			
			if (language != null) {
				translation = language.get(phrase);
			}
		}
		
		return makeJSON();
	}
	
	public String makeJSON() {
		
		String json = "{ ";
		json += "\"phrase\": \"" + phrase + "\", ";
		json += "\"translation\": \"" + translation + "\", ";
		json += "\"requestedLanguage\": \"" + localeString + "\", ";
		json += "\"defaultLocaleUsed\": \"" + defaultLocaleUsed + "\", ";
		json += "\"deliveredLanguage\": \"" + locale + "\" ";
		json += "}";
		
		return json;
	}
}
