package uri.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;





import org.junit.Test;

import uri.Host;
import uri.IPv4Address;
import uri.Uri;
import uri.UriParserFactory;

/**
 * This class provides a very simple example of how to write tests for this project.
 * You can implement your own tests within this class or any other class within this package.
 * Tests in other packages will not be run and considered for completion of the project.
 */
public class SimpleTests {

	/**
	 * Helper function to determine if the given host is an instance of {@link IPv4Address}.
	 *
	 * @param host the host
	 * @return {@code true} if the host is an instance of {@link IPv4Address}
	 */
	public boolean isIPv4Address(Host host) {
		return host instanceof IPv4Address;
	}

	/**
	 * Helper function to retrieve the byte array representation of a given host which must be an instance of {@link IPv4Address}.
	 *
	 * @param host the host
	 * @return the byte array representation of the IPv4 address
	 */
	public byte[] getIPv4Octets(Host host) {
		if (!isIPv4Address(host))
			throw new IllegalArgumentException("host must be an IPv4 address");
		return ((IPv4Address) host).getOctets();
	}

	@Test
	public void testNonNull() {
		assertNotNull(UriParserFactory.create("scheme://").parse());
	}

	@Test
	public void testNegativeSimple() {
		assertNull(UriParserFactory.create("").parse());
	}

	@Test
	public void testIPv4AddressSimple() {
		Host host = UriParserFactory.create("scheme://1.2.3.4").parse().getHost();
		assertTrue("host must be an IPv4 address", isIPv4Address(host));
	}


//My test
@Test
public void leerscheme(){
	assertNull(UriParserFactory.create("").parse());
}

@Test
public void alphabetscheme(){
	Uri uri= UriParserFactory.create("https://").parse();
	assertEquals("https", uri.getScheme());

}
@Test
public void numberscheme(){
	Uri uri= UriParserFactory.create("1234://").parse();
	assertNull("1234", uri);

}
@Test
public void alphabetwithnumbersscheme(){
	Uri uri= UriParserFactory.create("htt123://").parse();
	assertEquals("htt123", uri.getScheme());
}

@Test
public void capitalalphabetwithnumbersscheme(){
	Uri uri= UriParserFactory.create("HTTP123://").parse();
	assertEquals("HTTP123", uri.getScheme());

}

@Test
public void smallwithcapitalscheme(){
	Uri uri= UriParserFactory.create("htPSS://").parse();
	assertEquals("htPSS", uri.getScheme());
}

@Test
public void capwithsmallscheme(){
	Uri uri= UriParserFactory.create("HTps://").parse();
	assertEquals("HTps", uri.getScheme());

}

@Test
public void alphanumberalphascheme(){
	Uri uri= UriParserFactory.create("htt12ps://").parse();
	assertEquals("htt12ps", uri.getScheme());

}

@Test
public void numbersalphascheme(){
	Uri uri= UriParserFactory.create("123http://").parse();
	assertNull("123http", uri);
}

@Test
public void capalphanumberalphascheme(){
	Uri uri= UriParserFactory.create("HTT123PS://").parse();
	assertEquals("HTT123PS", uri.getScheme());
}

@Test
public void numberscapalphascheme(){
	Uri uri= UriParserFactory.create("123HTTPS://").parse();
	assertNull("123HTTPS", uri);
}

@Test
public void capitalscheme(){
	Uri uri= UriParserFactory.create("HTTPS://").parse();
	assertEquals("HTTPS", uri.getScheme());
}


public void hexascheme(){
	Uri uri= UriParserFactory.create("2E6.A3://").parse();
	assertNull("", uri);
}


//MYTEST USERINFO


@Test
public void alphauserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://uds@").parse().getUserInfo();
	assertEquals("uds", UMS);
}

@Test
public void ohneuserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://@").parse().getUserInfo();
	assertEquals("", UMS);
}
@Test
public void alphanumberuserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://usr12@").parse().getUserInfo();
	assertEquals("usr12", UMS);
}
@Test
public void charinfoscheme(){
	Uri UMS= UriParserFactory.create("htt123://usr*@").parse();
	assertNull("", UMS);

}
@Test
public void capuserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://USR@").parse().getUserInfo();
	assertEquals("USR", UMS);
}

@Test
public void CAPdigituserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://UIN12@").parse().getUserInfo();
	assertEquals("UIN12", UMS);
}
@Test
public void digituserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://12@").parse().getUserInfo();
	assertEquals("12", UMS);
}
@Test
public void digitalphauserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://12pro@").parse().getUserInfo();
	assertEquals("12pro", UMS);
}
@Test
public void digitcapalphauserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://21PROG@").parse().getUserInfo();
	assertEquals("21PROG", UMS);
}

@Test
public void hexadigituserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://2E6.A3@").parse().getUserInfo();
	assertEquals("2E6.A3", UMS);
}
@Test
public void dotdigituserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://.A3@").parse().getUserInfo();
	assertEquals(".A3", UMS);
}

@Test
public void hexaalphauserinfoscheme(){
	String UMS= UriParserFactory.create("htt123://2E6.A3.bc.mn@").parse().getUserInfo();
	assertEquals("2E6.A3.bc.mn", UMS);
}

@Test
public void percentagedigitinfoscheme(){
	String UMS= UriParserFactory.create("htt123://%12@").parse().getUserInfo();
	assertEquals("%12", UMS);
}
@Test
public void percentagedigitalphainfoscheme(){
	String UMS= UriParserFactory.create("htt123://%12ab@").parse().getUserInfo();
	assertEquals("%12ab", UMS);
}


@Test
public void percentagedigitcapinfoscheme(){
	String UMS= UriParserFactory.create("htt123://%12AB@").parse().getUserInfo();
	assertEquals("%12AB", UMS);
}

@Test
public void percentagealphacapdigitinfoscheme(){
	String UMS= UriParserFactory.create("htt123://%cAP12@").parse().getUserInfo();
	assertEquals("%cAP12", UMS);
}

@Test
public void percentagealphasmalldigitinfoscheme(){
	String UMS= UriParserFactory.create("htt123://%c12@").parse().getUserInfo();
	assertEquals("%c12", UMS);
}

@Test
public void nullpercentagedigitinfoscheme(){
	Uri UMS= UriParserFactory.create("htt123://%%@").parse();
	assertNull("%%", UMS);
}


@Test
public void numnullpercentagedigitinfoscheme(){
	Uri UMS= UriParserFactory.create("htt123://%12%@").parse();
	assertNull("%12%", UMS);
}




@Test
public void charnullpercentagedigitinfoscheme(){
	Uri UMS= UriParserFactory.create("htt123://%ab%@").parse();
	assertNull("%ab%", UMS);
}



@Test
public void capcharnullpercentagedigitinfoscheme(){
	Uri UMS= UriParserFactory.create("htt123://%AB%@").parse();
	assertNull("%AB%", UMS);
}


//my path tests


@Test
public void slashcharpath(){
	Uri wayp=UriParserFactory.create("htt123://@host/*").parse();
assertNull("/*", wayp);
}



@Test
public void slashhexacharpath(){
	Uri wayp=UriParserFactory.create("htt123://@host/2E6.A3*").parse();
assertNull("/bun12*3", wayp);
}

@Test
public void slashpath(){
	String wayp=UriParserFactory.create("htt123://@host/").parse().getPath();
assertEquals("/", wayp);
}
@Test
public void slashalphapath(){
	String wayp=UriParserFactory.create("htt123://@host/bun").parse().getPath();
assertEquals("/bun", wayp);
}

@Test
public void slashalphanumberpath(){
	String wayp=UriParserFactory.create("htt123://@host/bun123").parse().getPath();
assertEquals("/bun123", wayp);
}
@Test
public void slashalphanumberdotpath(){
	String wayp=UriParserFactory.create("htt123://@host/bun123.").parse().getPath();
assertEquals("/bun123.", wayp);
}

@Test
public void slashalphanumbercharpath(){
	Uri wayp=UriParserFactory.create("htt123://@host/bun12*3").parse();
assertNull("/bun12*3", wayp);
}

@Test
public void slashalcapitalphanumberpath(){
	String wayp=UriParserFactory.create("htt123://@host/BUN").parse().getPath();
assertEquals("/BUN", wayp);
}

@Test
public void slashalphanumbercapdigitpath(){
	String wayp=UriParserFactory.create("htt123://@host/BUN123").parse().getPath();
assertEquals("/BUN123", wayp);
}


@Test
public void CAPslashalphanumberdotpath(){
	String wayp=UriParserFactory.create("htt123://@host/123BUN.").parse().getPath();
assertEquals("/123BUN.", wayp);
}
@Test
public void digitslashalphanumberpath(){
	String wayp=UriParserFactory.create("htt123://@host/123pat").parse().getPath();
assertEquals("/123pat", wayp);
}

@Test
public void emptyslashalphanumberpath(){
	String wayp=UriParserFactory.create("htt123://@host?").parse().getPath();
assertEquals("", wayp);
}

@Test
public void dotdotpath(){
	String wayp=UriParserFactory.create("htt123://@host/.").parse().getPath();
assertEquals("/.", wayp);
}

@Test
public void doubledotpath(){
	String wayp=UriParserFactory.create("htt123://@host/..").parse().getPath();
assertEquals("/..", wayp);
}

@Test
public void threedotspath(){
	Uri wayp=UriParserFactory.create("htt123://@host/...").parse();
assertNull("", wayp);
}


@Test
public void slashstarpath(){
	Uri wayp=UriParserFactory.create("htt123://@host/*").parse();
assertNull("/bun123", wayp);
}

@Test
public void hexapath(){
String wayp = UriParserFactory.create("htt123://@host/2E6.A3").parse().getPath();
assertEquals("/2E6.A3", wayp);
}


//MY TESTS FOR QUERY IMPLIMENTATIONS

@Test
public void equalquery(){
	String last =UriParserFactory.create("htt123://@host/?=").parse().getQuery();
	assertEquals("=", last);
}

@Test
public void equalalphaquery(){
	String last =UriParserFactory.create("htt123://@host/?bd=cd").parse().getQuery();
	assertEquals("bd=cd", last);
}

@Test
public void alphaandquery(){
	String last =UriParserFactory.create("htt123://@host/?pr&og").parse().getQuery();
	assertEquals("pr&og", last);
}

@Test
public void numberandquery(){
	String last =UriParserFactory.create("htt123://@host/?1=2").parse().getQuery();
	assertEquals("1=2", last);
}

@Test
public void capitalandquery(){
	String last =UriParserFactory.create("htt123://@host/?AB&PG").parse().getQuery();
	assertEquals("AB&PG", last);
}

@Test
public void digitanddigitquery(){
	String last =UriParserFactory.create("htt123://@host/?5&6").parse().getQuery();
	assertEquals("5&6", last);
}

@Test
public void capitalequalquery(){
	String last =UriParserFactory.create("htt123://@host/?BA=GL").parse().getQuery();
	assertEquals("BA=GL", last);
}

@Test
public void ANDquery(){
	String last =UriParserFactory.create("htt123://@host/?&").parse().getQuery();
	assertEquals("&", last);
}

@Test
public void emptyquery(){
	String last =UriParserFactory.create("htt123://@host/?").parse().getQuery();
	assertEquals("", last);
}


@Test
public void alphabetquery(){
	String last =UriParserFactory.create("htt123://@host/?bgd").parse().getQuery();
	assertEquals("bgd", last);
}

@Test
public void capalphaquery(){
	String last =UriParserFactory.create("htt123://@host/?ABCD").parse().getQuery();
	assertEquals("ABCD", last);

}


@Test
public void digitsquery(){
	String last =UriParserFactory.create("htt123://@host/?1234").parse().getQuery();
	assertEquals("1234", last);
}


@Test
public void specialcharquery(){
	Uri last =UriParserFactory.create("htt123://@host/?12+21").parse();
	assertNull("12+21", last);
}

@Test
public void alphaequalquery(){
	String last =UriParserFactory.create("htt123://@host/?ab+cd").parse().getQuery();
	assertEquals("ab+cd", last);
}

@Test
public void hexaquery(){
	String last =UriParserFactory.create("htt123://@host/?2E6.A3").parse().getQuery();
	assertEquals("2E6.A3", last);
}

@Test
public void dotquery(){
	String last =UriParserFactory.create("htt123://@host/?.").parse().getQuery();
	assertEquals(".", last);
}


@Test
public void doubledotquery(){
	String last =UriParserFactory.create("htt123://@host/?..").parse().getQuery();
	assertEquals("..", last);
}


@Test
public void tripledotquery(){
	String last =UriParserFactory.create("htt123://@host/?.....").parse().getQuery();
	assertEquals(".....", last);
}



@Test
public void dotslashquery(){
	Uri last =UriParserFactory.create("htt123://@host/?./.").parse();
	assertNull("./.", last);
}


@Test
public void dotequalquery(){
	String last =UriParserFactory.create("htt123://@host/?.=.").parse().getQuery();
	assertEquals(".=.", last);

}


@Test
public void dotandquery(){
	String last =UriParserFactory.create("htt123://@host/?.&.").parse().getQuery();
	assertEquals(".&.", last);
}



//mytesthost

@Test
public void emptyhost1(){
	Host host = UriParserFactory.create("scheme://").parse().getHost();
	assertEquals("",host.toString());	
}

@Test
public void alphahost2(){
	Host host = UriParserFactory.create("scheme://@andi").parse().getHost();
	assertEquals("andi",host.toString());

}
@Test
public void capitalhost3(){
	Host host = UriParserFactory.create("scheme://@ANDI").parse().getHost();
	assertEquals("ANDI",host.toString());

}

@Test
public void digithost4(){
	Host host = UriParserFactory.create("scheme://@1234").parse().getHost();
	assertEquals("1234",host.toString());
}

@Test
	public void alphadigithost5(){
		Host host = UriParserFactory.create("scheme://@123andi").parse().getHost();
		assertEquals("123andi",host.toString());
	

}
@Test
	public void capalphadigithost6(){
		Host host = UriParserFactory.create("scheme://@123CHIDIYA").parse().getHost();
		assertEquals("123CHIDIYA",host.toString());

	}

@Test
	public void digitalphahost7(){
		Host host = UriParserFactory.create("scheme://@CHIDIYA213").parse().getHost();
		assertEquals("CHIDIYA213",host.toString());


}
@Test
	public void smallapalphadigithost8(){
		Host host = UriParserFactory.create("scheme://@abc23").parse().getHost();
		assertEquals("abc23",host.toString());

	}

@Test
	public void specialchar9(){
		Uri host = UriParserFactory.create("scheme://@123CHIDIY+A").parse();
		assertNull("123CHIDIY+A",host);

	}

@Test
	public void digitspecialchar10(){
		Uri host = UriParserFactory.create("scheme://@123+").parse();
		assertNull("123+",host);

	}

@Test
	public void ip4add(){
		 Host host = UriParserFactory.create("scheme://@246.1.212.3").parse().getHost();
		assertTrue("this is a valid ipv4",isIPv4Address(host));
	}

@Test
	public void ip4addbigger(){
		 Host host = UriParserFactory.create("scheme://@256.1.2.3").parse().getHost();
		assertFalse("the host cannot be greater than 255",isIPv4Address(host));
	}

@Test
	public void ipv4addsmalldigit(){
		 Host host = UriParserFactory.create("scheme://@256.1.2").parse().getHost();
		assertFalse("the ipv4 is less than 4 digits",isIPv4Address(host));
	}


@Test
	public void ip4addbigge(){
		 Host host = UriParserFactory.create("scheme://@256.1.2.3").parse().getHost();
		assertFalse("the host cannot be greater than 255",isIPv4Address(host));
	}

@Test

public void hostoctets(){
	Host host = UriParserFactory.create("scheme://@246.1.212.3").parse().getHost();
	byte[] octetarray={(byte)246,1,(byte)212,3};
	assertArrayEquals(octetarray, getIPv4Octets(host));
	
}



}
