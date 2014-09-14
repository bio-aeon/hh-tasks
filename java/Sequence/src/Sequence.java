/*
Возьмём бесконечную цифровую последовательность, образованную склеиванием 
последовательных положительных чисел: S = 123456789101112131415...
Определите первое вхождение заданной последовательности A в бесконечной 
последовательности S (нумерация начинается с 1).
*/

public class Sequence {
	public static void main (String[] args) {
		Service serv = new Service();

		System.out.println(serv.getSubsequencePos("6789"));
		System.out.println(serv.getSubsequencePos("101"));
	}	
}

class Service {
	public int getSubsequencePos(String subsequence) {
		int subsequenceLen = subsequence.length();
		String sequence = "";
		int sequenceLen = 0, sequenceCounter = 0;
		

		while(!sequence.equals(subsequence)) {
			sequenceCounter++;
			String strSequenceCounter = sequenceCounter + "";

			for(int i = 0; i < strSequenceCounter.length(); i++) {
				char c = strSequenceCounter.charAt(i);
				sequenceLen++;

				if(sequenceLen > subsequenceLen) {
					sequence = sequence.substring(1) + c; // чтобы не хранить всю последовательность в памяти
				}
				else {
					sequence += c;
				}

				if(sequence.equals(subsequence)) {
					break;
				}
			}
		}

		return sequenceLen - subsequenceLen + 1;
	}
}