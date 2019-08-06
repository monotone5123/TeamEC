package com.internousdev.panther.dto.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.internousdev.panther.dto.CartInfoDTO;

public class CartInfoDTOTest {
	// test getCartinfoId()
	@Test
	public void test_getCartinfoId_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setCartinfoId(expected);
		int actual = dto.getCartinfoId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getCartinfoId_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setCartinfoId(expected);
		int actual = dto.getCartinfoId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getCartinfoId_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setCartinfoId(expected);
		int actual = dto.getCartinfoId();
		assertEquals(expected,actual);
	}

	// test setCartinfoId()
	@Test
	public void test_setCartinfoId_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setCartinfoId(expected);
		int actual = dto.getCartinfoId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setCartinfoId_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setCartinfoId(expected);
		int actual = dto.getCartinfoId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setCartinfoId_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setCartinfoId(expected);
		int actual = dto.getCartinfoId();
		assertEquals(expected,actual);
	}

	// test getUserId()
	@Test
	public void test_getUserId_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getUserId_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getUserId_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getUserId_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void test_getUserId_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getUserId_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getUserId_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getUserId_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getUserId_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getUserId_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}

	// test setUserId()
	@Test
	public void test_setUserId_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setUserId_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setUserId_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setUserId_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}

	@Test
	public void test_setUserId_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setUserId_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setUserId_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setUserId_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setUserId_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setUserId_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setUserId(expected);
		String actual = dto.getUserId();
		assertEquals(expected,actual);
	}

	// test getProductId()
	@Test
	public void test_getProductId_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductId_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductId_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected,actual);
	}

	// test setProductId()
	@Test
	public void test_setProductId_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductId_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductId_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductId(expected);
		int actual = dto.getProductId();
		assertEquals(expected,actual);
	}

	// test getProductCount()
	@Test
	public void test_getProductCount_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductCount_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductCount_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected,actual);
	}

	// test setProductCount()
	@Test
	public void test_setProductCount_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductCount_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductCount_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductCount(expected);
		int actual = dto.getProductCount();
		assertEquals(expected,actual);
	}

	// test getPrice()
	@Test
	public void test_getPrice_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getPrice_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getPrice_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected,actual);
	}

	// test setPrice()
	@Test
	public void test_setPrice_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setPrice_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setPrice_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setPrice(expected);
		int actual = dto.getPrice();
		assertEquals(expected,actual);
	}

	// test getProductName()
	@Test
	public void test_getProductName_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductName_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductName_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductName_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void test_getProductName_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductName_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductName_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductName_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductName_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductName_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}

	// test setProductName()
	@Test
	public void test_setProductName_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductName_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductName_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductName_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}

	@Test
	public void test_setProductName_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductName_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductName_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductName_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductName_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductName_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setProductName(expected);
		String actual = dto.getProductName();
		assertEquals(expected,actual);
	}

	// test getProductNameKana()
	@Test
	public void test_getProductNameKana_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductNameKana_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductNameKana_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductNameKana_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void test_getProductNameKana_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductNameKana_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductNameKana_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductNameKana_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductNameKana_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductNameKana_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	// test setProductNameKana()
	@Test
	public void test_setProductNameKana_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductNameKana_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductNameKana_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductNameKana_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	@Test
	public void test_setProductNameKana_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductNameKana_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductNameKana_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductNameKana_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductNameKana_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductNameKana_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setProductNameKana(expected);
		String actual = dto.getProductNameKana();
		assertEquals(expected,actual);
	}

	// test getImageFilePath()
	@Test
	public void test_getImageFilePath_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFilePath_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFilePath_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFilePath_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void test_getImageFilePath_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFilePath_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFilePath_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFilePath_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFilePath_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFilePath_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	// test setImageFilePath()
	@Test
	public void test_setImageFilePath_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFilePath_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFilePath_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFilePath_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	@Test
	public void test_setImageFilePath_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFilePath_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFilePath_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFilePath_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFilePath_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFilePath_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setImageFilePath(expected);
		String actual = dto.getImageFilePath();
		assertEquals(expected,actual);
	}

	// test getImageFileName()
	@Test
	public void test_getImageFileName_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFileName_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFileName_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFileName_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void test_getImageFileName_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFileName_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFileName_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFileName_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFileName_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getImageFileName_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}

	// test setImageFileName()
	@Test
	public void test_setImageFileName_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFileName_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFileName_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFileName_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}

	@Test
	public void test_setImageFileName_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFileName_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFileName_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFileName_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFileName_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setImageFileName_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setImageFileName(expected);
		String actual = dto.getImageFileName();
		assertEquals(expected,actual);
	}

	// test getReleaseDate()
	@Test
	public void test_getReleaseDate_null() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setReleaseDate(expected);
		Date actual = dto.getReleaseDate();
		assertEquals(expected, actual);
	}
	@Test
	public void test_getReleaseDate_date() {
		CartInfoDTO dto = new CartInfoDTO();

		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected;
		try {
			expected = sdf.parse("20180420 12:00:00");
			dto.setReleaseDate(expected);
			assertEquals(expected, dto.getReleaseDate());
		} catch (ParseException e) {
			fail();
		}
	}

	// test setReleaseDate()
	@Test
	public void test_setReleaseDate_null() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setReleaseDate(expected);
		Date actual = dto.getReleaseDate();
		assertEquals(expected, actual);
	}
	@Test
	public void test_setReleaseDate_date() {
		CartInfoDTO dto = new CartInfoDTO();

		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected;
		try {
			expected = sdf.parse("20180420 12:00:00");
			dto.setReleaseDate(expected);
			assertEquals(expected, dto.getReleaseDate());
		} catch (ParseException e) {
			fail();
		}
	}

	// test getReleaseCompany()
	@Test
	public void test_getReleaseCompany_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getReleaseCompany_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getReleaseCompany_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getReleaseCompany_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void test_getReleaseCompany_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getReleaseCompany_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getReleaseCompany_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getReleaseCompany_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getReleaseCompany_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getReleaseCompany_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	// test setReleaseCompany()
	@Test
	public void test_setReleaseCompany_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setReleaseCompany_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setReleaseCompany_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setReleaseCompany_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}

	@Test
	public void test_setReleaseCompany_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setReleaseCompany_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setReleaseCompany_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setReleaseCompany_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setReleaseCompany_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setReleaseCompany_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setReleaseCompany(expected);
		String actual = dto.getReleaseCompany();
		assertEquals(expected,actual);
	}


	// test getProductDescription()
	@Test
	public void test_getProductDescription_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getStatus_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getStatus_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductDescription_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}

	@Test
	public void test_getProductDescription_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductDescription_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductDescription_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductDescription_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductDescription_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getProductDescription_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}

	// test setStatus()
	@Test
	public void test_setProductDescription_null() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductDescription_emptyCharacter() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductDescription_space() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " ";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductDescription_fullSpace() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "　";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}

	@Test
	public void test_setProductDescription_alphabeticCharacters() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "abc";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductDescription_halfWidthDigit() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "123";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductDescription_hiragana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "てすと";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductDescription_katakana() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "テスト";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductDescription_kanji() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}
	@Test
	public void test_setProductDescription_all() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "漢字 テスト　てすと123abc";

		dto.setProductDescription(expected);
		String actual = dto.getProductDescription();
		assertEquals(expected,actual);
	}

	// test getSubprice()
	@Test
	public void test_getSubprice_max() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setSubprice(expected);
		int actual = dto.getSubprice();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getSubtotal_min() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483648;

		dto.setSubprice(expected);
		int actual = dto.getSubprice();
		assertEquals(expected,actual);
	}
	@Test
	public void test_getSubprice_0() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setSubprice(expected);
		int actual = dto.getSubprice();
		assertEquals(expected,actual);
	}

	// test setSubprice()
		@Test
		public void test_setSubprice_max() {
			CartInfoDTO dto = new CartInfoDTO();
			int expected = 2147483647;

			dto.setSubprice(expected);
			int actual = dto.getSubprice();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setSubprice_min() {
			CartInfoDTO dto = new CartInfoDTO();
			int expected = -2147483648;

			dto.setSubprice(expected);
			int actual = dto.getSubprice();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setSubprice_0() {
			CartInfoDTO dto = new CartInfoDTO();
			int expected = 0;

			dto.setSubprice(expected);
			int actual = dto.getSubprice();
			assertEquals(expected,actual);
		}
	}
