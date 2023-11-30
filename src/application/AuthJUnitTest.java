package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthJUnitTest {

	User TestUser1 = new User("Andrew", "Bandit", 665577, 5, "mUser1");
	User TestUser2 = new User("Cameron", "Mossberg", 995566, 4, "mUser2");
	User TestUser3 = new User("Zachary", "Boombox", 332211, 3, "mUser3");
	
	//idTest 1 - 3 assert wether the given ID returns true for the given user.
	@Test
	void idTest1() {
		assertTrue(Authorization.AssertID(TestUser1, 665577));
	}
	
	@Test
	void idTest2() {
		assertTrue(Authorization.AssertID(TestUser2, 995566));
	}
	
	@Test
	void idTest3() {
		assertTrue(Authorization.AssertID(TestUser3, 332211));
	}
	
	//idTests 4 - 6 ensure the method flags false for improper ID.
	@Test
	void idTest4() {
		assertFalse(Authorization.AssertID(TestUser1, 445566));
	}
	
	@Test
	void idTest5() {
		assertFalse(Authorization.AssertID(TestUser2, 554466));
	}
	
	@Test
	void idTest6() {
		assertFalse(Authorization.AssertID(TestUser3, 112233));
	}
	
	//rankTest 1 - 3 assert wether the user has the correct rank.
	@Test
	void rankTest1() {
		assertTrue(Authorization.AssertRank(TestUser1, 5));
	}
	
	@Test
	void rankTest2() {
		assertTrue(Authorization.AssertRank(TestUser2, 4));
	}
	
	@Test
	void rankTest3() {
		assertTrue(Authorization.AssertRank(TestUser3, 3));
	}
	
	//rankTest 4 - 6 ensures the method properly flags false.
	@Test
	void rankTest4() {
		assertFalse(Authorization.AssertRank(TestUser1, 4));
	}
	
	@Test
	void rankTest5() {
		assertFalse(Authorization.AssertRank(TestUser2, 5));
	}
	
	@Test
	void rankTest6() {
		assertFalse(Authorization.AssertRank(TestUser3, 2));
	}
	
	//userTest 1 - 3 assert wether the user is authorized or not.
	@Test
	void userTest1() {
		assertTrue(Authorization.AssertUser(TestUser1, 5, 665577));
	}
	
	@Test
	void userTest2() {
		assertTrue(Authorization.AssertUser(TestUser2, 4, 995566));
	}
	
	@Test
	void userTest3() {
		assertTrue(Authorization.AssertUser(TestUser3, 3, 332211));
	}
	
	//userTest 4 - 6 ensures the method properly flags false.
	@Test
	void userTest4() {
		assertFalse(Authorization.AssertUser(TestUser1, 4, 444444));
	}
	
	@Test
	void userTest5() {
		assertFalse(Authorization.AssertUser(TestUser2, 3, 555555));
	}
	
	@Test
	void userTest6() {
		assertFalse(Authorization.AssertUser(TestUser3, 1, 111111));
	}
	
	//loginTest 1 - 3 test a proper login that should be authorized.
	@Test
	void loginTest1() {
		assertTrue(Authorization.Login("Andrew", "Bandit"));
	}
	
	@Test
	void loginTest2() {
		assertTrue(Authorization.Login("Cameron", "Mossberg"));
	}
	
	@Test
	void loginTest3() {
		assertTrue(Authorization.Login("Zachary", "Boombox"));
	}
	
	//loginTest 4 - 6 test an improper login that should be refused.
	@Test
	void loginTest4() {
		assertFalse(Authorization.Login("Andrew", "bandit"));
	}
	
	@Test
	void loginTest5() {
		assertFalse(Authorization.Login("Cameron", "asdf"));
	}
	
	@Test
	void loginTest6() {
		assertFalse(Authorization.Login("Zachary", ""));
	}
	
	

}
