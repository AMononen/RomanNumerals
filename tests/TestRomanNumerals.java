import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {
	int iResult;
	
	@Test
	public void OneIDigitTest()
	{
		RomanNumerals RomNums = new RomanNumerals();
		iResult = RomNums.convertToInteger("I");
		assertEquals("Incorrect result, I = 1", 1, iResult);
	}
	@Test
	public void Max3OccurencesTest()
	{
		// 1. Symbols I,X,C and M can repeated at most 3 times in a row.
		//I
		RomanNumerals RomNums = new RomanNumerals();
		String romanNum = "II";
		int validCount = 3;
		char cSymbol = 'I';
		boolean bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		
		romanNum = "III";
		validCount = 3;
		cSymbol = 'I';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		
		romanNum = "IIII";
		validCount = 3;
		cSymbol = 'I';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertFalse("Invalid format, IIII",bValidFormat);
		
		//X
		romanNum = "XX";
		validCount = 3;
		cSymbol = 'X';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		romanNum = "XXX";
		validCount = 3;
		cSymbol = 'X';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		romanNum = "XXXX";
		validCount = 3;
		cSymbol = 'X';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertFalse("Invalid format",bValidFormat);
		
		//C
		romanNum = "CC";
		validCount = 3;
		cSymbol = 'C';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		romanNum = "CCC";
		validCount = 3;
		cSymbol = 'C';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		romanNum = "CCCC";
		validCount = 3;
		cSymbol = 'C';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertFalse("Invalid format",bValidFormat);
		//M
		romanNum = "MM";
		validCount = 3;
		cSymbol = 'M';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		romanNum = "MMM";
		validCount = 3;
		cSymbol = 'M';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		romanNum = "MMMM";
		validCount = 3;
		cSymbol = 'M';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertFalse("Invalid format",bValidFormat);
	}
	@Test
	public void NotRepeatedValueTest() 
	{
		//The symbols V,L,D can never be repeated.
		RomanNumerals RomNums = new RomanNumerals();
		String romanNum = "V";
		int validCount = 1;
		char cSymbol = 'V';
		boolean bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		romanNum = "VVVV";
		validCount = 1;
		cSymbol = 'V';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertFalse("Invalid format",bValidFormat);
		//L
		romanNum = "L";
		validCount = 1;
		cSymbol = 'L';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertTrue("Invalid format",bValidFormat);
		romanNum = "LLL";
		validCount = 1;
		cSymbol = 'L';
		bValidFormat = RomNums.IsRomanNumFormatValid(romanNum, validCount, cSymbol);
		assertFalse("Invalid format",bValidFormat);
	}
	@Test 
	public void  AddCharToResultTest()
	{
		//The '1' symbols('I','X' and 'C') can only be subtracted from the 2 next
	    // highest values ('IV'	and	'IX','XL'and 'XC','CD' and	'CM').	
		//Valid values
		//IV
		RomanNumerals RomNums = new RomanNumerals();
		int iCurrentResult = 5;
	    char AddedChar = 'I';
	    char PrevChar = 'V';
		iResult = RomNums.AddCharToResult(iCurrentResult, AddedChar, PrevChar);
		assertEquals("Incorrect result", 4, iResult);
        //IX
		iCurrentResult = 10;
	    AddedChar = 'I';
	    PrevChar = 'X';
		iResult = RomNums.AddCharToResult(iCurrentResult, AddedChar, PrevChar);
		assertEquals("Incorrect result", 9, iResult);
		//XL
		iCurrentResult = 50;
	    AddedChar = 'X';
	    PrevChar = 'L';
		iResult = RomNums.AddCharToResult(iCurrentResult, AddedChar, PrevChar);
		assertEquals("Incorrect result", 40, iResult);
		//XC
		iCurrentResult = 100;
	    AddedChar = 'X';
	    PrevChar = 'C';
		iResult = RomNums.AddCharToResult(iCurrentResult, AddedChar, PrevChar);
		assertEquals("Incorrect result", 90, iResult);
		//CD
		iCurrentResult = 500;
	    AddedChar = 'C';
	    PrevChar = 'D';
		iResult = RomNums.AddCharToResult(iCurrentResult, AddedChar, PrevChar);
		assertEquals("Incorrect result", 400, iResult);
		//CM
		iCurrentResult = 1000;
	    AddedChar = 'C';
	    PrevChar = 'M';
		iResult = RomNums.AddCharToResult(iCurrentResult, AddedChar, PrevChar);
		assertEquals("Incorrect result", 900, iResult);
		//Invalid values
		//IL
		iCurrentResult = 50;
	    AddedChar = 'I';
	    PrevChar = 'L';
		iResult = RomNums.AddCharToResult(iCurrentResult, AddedChar, PrevChar);
		assertEquals("Incorrect result", 0, iResult);
		//XD
		iCurrentResult = 500;
	    AddedChar = 'X';
	    PrevChar = 'D';
		iResult = RomNums.AddCharToResult(iCurrentResult, AddedChar, PrevChar);
		assertEquals("Incorrect result", 0, iResult);
	}
	@Test
	public void OneSubtractionPerNumeralTest()
	{
		//NOT IMPLEMENTED
		//Only one subtraction can be made per numeral('XC'is allowed, 'XXC'is not).
		RomanNumerals RomNums = new RomanNumerals();
		String romanNum = "XC";
		iResult = RomNums.convertToInteger(romanNum);
		assertEquals("Incorrect result", 90, iResult);
        //XXC not implemented
		/*romanNum = "XXC";
		iResult = RomNums.convertToInteger(romanNum);
		assertEquals("Incorrect result", 0, iResult);*/
	}
	@Test
	public void LastTest()
	{
		//XC
		RomanNumerals RomNums = new RomanNumerals();
		String romanNum = "MCMLXXXIV";
		iResult = RomNums.convertToInteger(romanNum);
		assertEquals("Incorrect result", 1984, iResult);
		romanNum = "MMXIV";
		iResult = RomNums.convertToInteger(romanNum);
		assertEquals("Incorrect result", 2014, iResult);
	}
}	
	