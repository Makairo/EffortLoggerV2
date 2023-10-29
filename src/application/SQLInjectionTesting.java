package application;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

class SQLInjectionTesting {
	User test1 = new User("JerryGao", "\\123", 2100, 3);

	@Test
	public void ST1(){
		assertEquals(false, SQLInjectionHandling.SQLTestMini(test1));

	}
	
	User test2 = new User("dfasd","\''''", 21, 3);
	//testing for all the forbidden chars \ ' "
	@Test
	public void ST2() {
		assertEquals(false, SQLInjectionHandling.SQLTestMini(test2));
		
	}
	User test3 = new User ("dfsafds","\"", 34, 12);
	// testing for "
	@Test
	public void ST3() {
		assertEquals(false, SQLInjectionHandling.SQLTestMini(test3));
	}
	
	User test4 = new User ("dsa","fasd",34312,13);
	//testing if it works for a complying input
	@Test
	public void ST4() {
		assertEquals(true, SQLInjectionHandling.SQLTestMini(test4));
	}
	//testing for non-ascii characters
	@Test
	public void ST5() {
		assertEquals(false, SQLInjectionHandling.ASCIICheck("你好大家~=[]()%+{}@;’#!$_&-  éè  ;∞¥₤€"));
	}
	//testing that it works for ascii characters
	@Test
	public void ST6() {
		assertEquals(true, SQLInjectionHandling.ASCIICheck("abcdefghijklmnopqrstuvwxyz"));
	}
	//testing on empty string
	@Test
	public void ST7() {
		assertEquals(true, SQLInjectionHandling.ASCIICheck(""));
	}
	//testing on a single non ascii character
	@Test
	public void ST8() {
		assertEquals(false, SQLInjectionHandling.ASCIICheck("Ä"));
	}
	//testing for length (this is 33)
	@Test
	public void ST9() {
		assertEquals(false, SQLInjectionHandling.ASCIICheck("123456789012345678901234567890123"));
	}
	//testing for length (this is 32)
	@Test
	public void ST10() {
		assertEquals(true, SQLInjectionHandling.ASCIICheck("12345678901234567890123456789012"));
	}
	//testing for character '
	User test11 = new User("dfasd","'", 21, 3);
	@Test
	public void ST11() {
		assertEquals(false, SQLInjectionHandling.SQLTestMini(test11));
	}
	//testing for character \
	User test12 = new User("dfasd","\\", 21, 3);
	public void ST12() {
		assertEquals(false, SQLInjectionHandling.SQLTestMini(test12));
	}
}