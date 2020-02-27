package i18nPackage;

import java.util.Map;
import java.util.TreeMap;

public class TranslationMap {
	
	private Map<String, TreeMap<String, String>> languages;
	
	public TranslationMap() {
		
		languages = new TreeMap<String, TreeMap<String, String>>();
	}

	public String addTranslation(String language, String code, String translation) {
		
		TreeMap<String, String> languageMap;
		
		// check if language exist and create it if not
		if (!languages.containsKey(language)) {
			// add new language
			languages.put(language, new TreeMap<String, String>());
		}
		
		// get language to update
		languageMap = (TreeMap<String, String>) languages.get(language);
		
		// add translation to language
		languageMap.put(code, translation);
		
		return makeJSON(language, code, translation);
	}
	
	private String makeJSON(String language, String code, String translation) {
		
		String json = "{ ";
		json += "\"language\": \"" + language + "\", ";
		json += "\"phrase\": \"" + code + "\", ";
		json += "\"translation\": \"" + translation + "\", ";
		json += "\"translationAdded\": \"" + true + "\" ";
		json += "}";
		
		return json;
	}

	public TreeMap<String, String> getLanguage(String language) {
		
		return languages.get(language);
	}
}
