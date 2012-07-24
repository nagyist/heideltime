package de.unihd.dbs.uima.annotator.heideltime.resources;

/**
 * Hardcoded Language information for use with HeidelTime/Standalone. Contains
 * information on the resource folder name as well as the relevant treetagger
 * parameter file and command line switch.
 * 
 * @author Julian Zell
 */
public enum Language {
	/*
	 * set languages here
	 */
	ENGLISH		("english", "english", "english", "-e"),
	GERMAN		("german", "german", "german", ""),
	DUTCH		("dutch", "dutch", "dutch", ""),
	ENGLISHCOLL	("englishcoll", "englishcoll", "english", "-e"),
	ENGLISHSCI	("englishsci", "englishsci", "english", "-e"),
	ITALIAN		("italian", "italian", "italian", "-i"),
	FRENCH		("french", "french", "french", "-f"),
	VIETNAMESE	("vietnamese", "vietnamese", "english", ""),
	WILDCARD	("", "", "", ""), // if no match was found, this gets filled with parameter
	; // ends the enum element list
	
	private String languageName;
	private String treeTaggerSwitch;
	private String treeTaggerLangName;
	private String resourceFolder;
	
	/**
	 * Constructor for the Language elements.
	 * @param languageName formal name of the language
	 * @param resourceFolder folder name in the classpath that contains the resources
	 * @param treeTaggerLangName name of the treetagger parameter file (for treetaggerwrapper)
	 * @param treeTaggerSwitch special switch for the treetagger
	 */
	Language(String languageName, String resourceFolder, String treeTaggerLangName, String treeTaggerSwitch) {
		this.languageName = languageName;
		this.resourceFolder = resourceFolder;
		this.treeTaggerLangName = treeTaggerLangName;
		this.treeTaggerSwitch = treeTaggerSwitch;
	}
	
	/**
	 * Takes a string and checks whether we have hardcoded parameter support for the given language. 
	 * @param name name of the language, e.g. "english", "german"
	 * @return Language enum element that represents the requested language
	 */
	public final static Language getLanguageFromString(String name) {
		// loop through languages that aren't the wildcard one to see if we have special info on that language
		for(Language l : Language.values()) {
			if(l != WILDCARD && name.toLowerCase().equals(l.getName().toLowerCase())) {
				return l;
			}
		}
		
		// if looping through present enums didn't yield a result, throw one that is customized with the name parameter
		Language.WILDCARD.languageName = name;
		Language.WILDCARD.treeTaggerLangName = name;
		Language.WILDCARD.resourceFolder = name;
		return WILDCARD;
	}
	
	/*
	 * getters
	 */
	
	public final String getName() {
		return this.languageName;
	}
	
	public final String getTreeTaggerSwitch() {
		return this.treeTaggerSwitch;
	}
	
	public final String getTreeTaggerLangName() {
		return this.treeTaggerLangName;
	}
	
	public final String getResourceFolder() {
		return this.resourceFolder;
	}
}