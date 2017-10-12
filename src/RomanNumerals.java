
public class RomanNumerals {
	public int convertToInteger(String romanNum) 
	{
		int iResult = 0;
		//Check valid format
		char [] max3occurences = {'I','X','C','M'};
		char [] notRepeated = {'V','L','D'};
		// 1. Symbols I,X,C and M can repeated at most 3 times in a row.
		for (char ch: max3occurences) {
			if(!IsRomanNumFormatValid(romanNum, 3, ch))
				return 0;
		}
		// 2. Symbols V,L,D can never repeated
		for (char ch: notRepeated) {
			if(!IsRomanNumFormatValid(romanNum, 1, ch))
				return 0;
		}
		
		for(int i = romanNum.length()-1; i >= 0  ; i = i - 1)
		{
			if(romanNum.length()> 1 && i < romanNum.length()-1 && i >= 0)
			{
				 iResult = AddCharToResult(iResult, romanNum.charAt(i),romanNum.charAt(i+1));
			}
			else 	
			{
				iResult = AddCharToResult(iResult, romanNum.charAt(i), '#');
			}
		}
	 return iResult;	
	}
	
	public  int AddCharToResult(int Result, char AddedChar, char PrevChar)
	{
		switch (AddedChar) {
		  case 'I': 
			if(PrevChar == 'V' || PrevChar == 'X') 
			{
				Result = Result - 1;
			}
			else if (PrevChar == 'L' || PrevChar == 'C'|| PrevChar == 'D'|| PrevChar == 'M')
			{
				System.out.println("Invalid format of Roman numeral");
				Result = 0;
			}
			else
			{
				Result = Result + 1;
			}
		  break;
		case 'X': 
			if(PrevChar == 'L' | PrevChar == 'C') 
			{
				Result = Result - 10;
			}
			else if (PrevChar == 'D'|| PrevChar == 'M')
			{
				System.out.println("Invalid format of Roman numeral");
				Result = 0;
			}	
			else 
			{
				Result = Result + 10;
			}
		  break;
		case 'C': 
			if(PrevChar == 'D' | PrevChar == 'M') 
			{
				Result = Result - 100;
				//iResult = -100;
			}
			else 
			{
				Result = Result + 100;
				//iResult = 100;
			}
		  break;
		case 'V':
			Result  = Result + 5;
			break;
		case 'L':
			Result = Result + 50;
			break;
		case 'D':
			Result = Result + 500;
			break;
		case 'M':
			Result = Result + 1000;
		  break;
		}
		return Result;
	}
	
	public boolean IsRomanNumFormatValid(String romanNum, int validCount, char cSymbol)
	{
		int count = romanNum.length() - romanNum.replaceAll(Character.toString(cSymbol), "").length();
		if(count>validCount)
		{
			System.out.println("Roman number is invalid format.");
			return false;
		}
		return true;
	}
}

	