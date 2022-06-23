package uri.implementation;

import java.util.regex.Pattern;

import uri.Host;
import uri.Uri;

// TODO implement this class or another implementation of Uri

public class UriImplementation implements Uri {
      String surjicalstrike;

      public UriImplementation(String uri){
	       this.surjicalstrike= uri;

}
	@Override
	public String getScheme() {
		if(surjicalstrike.contains("://")){
	String[] inputscheme= surjicalstrike.split("://");
	String inputscheme1=inputscheme[0];
	int schemelength=inputscheme1.length();
	if(schemelength!=2){
		return null;
	}
	if (Pattern.matches("^\\d*", inputscheme1)){
		return null;
	}
	
	if(Pattern.matches("\\w+", inputscheme1)){
      return inputscheme1;

	}else
       return null;
}else{
	return null;
}
	}

	@Override
	public String getQuery() {
		// TODO implement this
		if(surjicalstrike.contains("?")){
			String[] inputquery1=surjicalstrike.split("?");
			 String inputquery=inputquery1[1];
		int	 querylength= inputquery.length() ;
			if (querylength==2){
				
        if(Pattern.matches("^\\w*[&].*\\w*", inputquery)){
       return inputquery;
		}
	    
         if(Pattern.matches("^\\w*[=].*\\w*", inputquery)){
			 return inputquery;

  }
      if(inputquery.equals("")){
		  return inputquery;
	  }
	  else{
		  return "exception";
	  } 
	}
		else{
			return null;
		}	


		}else{

		return null;
	}
}


	@Override
	public String getUserInfo() {

		
		if(surjicalstrike.contains("://")){
			String inuser=surjicalstrike.split("://")[1];
			int userlength1=inuser.length();
   if(userlength1!=2){
	return null;
}else{
	

			if(inuser.contains("@")){
				String enduser=inuser.split("@")[0];
				 int endlength=enduser.length();
				if(endlength!=2){
					return null;
				}else{

				 if(Pattern.matches("^\\w*[:].*.", enduser)){
					 return enduser;
				 }
				 if(Pattern.matches("^\\w*", enduser)){
					 return enduser;
				 }
				 else{
					 return "exception";
				 }
				}
				}
				 else{
					 return null;
				 }
				}

				}
				else{
					return null;
				}

			}



	

	@Override
	public Host getHost() {
		// TODO implement this
		return null;
	}

	@Override
	public String getPath() {
		if(surjicalstrike.contains("://")){

			String mypath=surjicalstrike.split("://")[1];
			   if(mypath.contains("/")&& mypath.contains("?")){
				String path2= mypath.split("/",2)[1];
				String path3= path2.split("?",2)[0];

                  if(Pattern.matches("\\w*",path3)){
                    return ("/"+path3);
				   }
				   if(Pattern.matches("", path3)){
					   return path3;
				   }
				   else{
					   return "exception";
				      }
				   }
			    
			    else{
					return null;
				}
			
			
			} 
			else{
				return null;
			}
	}
}	






		

