package uri.implementation;

import uri.Uri;
import uri.UriParser;

// TODO implement this class or another implementation of UriParser


public class UriParserImplementation implements UriParser {
	String surjicalstrike;

 public UriParserImplementation(String uri){
	 this.surjicalstrike= uri;
 }

	@Override
	public Uri parse() {
		UriImplementation strike =new UriImplementation(surjicalstrike);
if(strike.getScheme()==null){
	return null;
}
if(strike.getQuery()!=null&& strike.getScheme().equals("exception")){
	return null;
}
if(strike.getScheme().equals("exception")){
	return null;
}
		return strike;
	}


}
