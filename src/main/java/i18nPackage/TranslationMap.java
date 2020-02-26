package i18nPackage;

import java.util.Map;
import java.util.TreeMap;

public class TranslationMap {
	
	private Map<String, TreeMap<String, String>> languages;
	
	public TranslationMap() {
		
		languages = new TreeMap<String, TreeMap<String, String>>();
	}

	public String addTranslation(String language, String code, String translation) {
		
		TreeMap<String, String> languageMap = new TreeMap<String, String>();
		
		if (!languages.containsKey(language)) {
			// add new language
			languages.put(language, languageMap);
		}
		
		languageMap = (TreeMap<String, String>) languages.get(language);
		
		languageMap.put(code, translation);
		
		return "Successfully inserted translation";
	}
	
	public TreeMap<String, String> getLanguage(String language) {
		return languages.get(language);
	}
}
