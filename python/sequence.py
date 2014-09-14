# -*- coding: utf-8 -*-
u"""
Возьмём бесконечную цифровую последовательность, образованную склеиванием 
последовательных положительных чисел: S = 123456789101112131415...
Определите первое вхождение заданной последовательности A в бесконечной 
последовательности S (нумерация начинается с 1).
"""

def get_subsequence_pos(subsequence):
	subsequence = str(subsequence)
	subsequence_len = len(subsequence)
	sequence, sequence_len, sequence_counter = '', 0, 0

	while sequence != subsequence:
		sequence_counter += 1
		str_sequence_counter = str(sequence_counter)
		for c in str_sequence_counter:
			sequence_len += 1

			if sequence_len > subsequence_len:
				sequence = sequence[1:] + c  # чтобы не хранить всю последовательность в памяти
			else:
				sequence += c

			if sequence == subsequence:
				break;

	return sequence_len - subsequence_len + 1

print get_subsequence_pos(6789)  # => 6
print get_subsequence_pos(101)  # => 10