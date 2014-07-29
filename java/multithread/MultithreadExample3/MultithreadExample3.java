class MultithreadExample3
{
	public static void main (String args[])
	{
		Thread thread = new Thread (new SmallLetters ());
		thread.start ();
		char arr [] = {'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ',
				'ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
		for (char ch : arr)
		{
			System.out.print (ch);
		}
	}
}
