package uri.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

import uri.Host;
import uri.IPv4Address;
import uri.Uri;
import uri.UriParserFactory;

public class mytest{

    @Test
    public void leerscheme(){
        assertNull(UriParserFactory.create("").parse());
    }

@Test
public void correctscheme(){
 String scheme =UriParserFactory.create("https://").parse().getScheme();
 boolean 
 assertTrue("correcthttps", (scheme));
}

@Test
public void alphascheme(){
    Uri uri=UriParserFactory.create("h234://").parse();
assertEquals("startwithalphabet", "h234",uri.getScheme());
}

}