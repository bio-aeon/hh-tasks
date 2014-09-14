# -*- coding: utf-8 -*-
u"""
Даны два отсортированных числовых массива одинаковой длины N. 
Найдите медиану числового массива длины 2N, содержащего все 
числа из двух данных массивов.
"""

def merge(left, right):
    result = []
    while len(left) > 0 and len(right) > 0:
        if left[0] <= right[0]:
            result.append(left.pop(0))
        else:
            result.append(right.pop(0))

    if len(left) > 0:
        result += left

    if len(right) > 0:
        result += right 

    return result
    

def get_median(list_one, list_two):
    half_length = len(list_one)
    result_list = merge(list_one, list_two)  # слияние отсортированных массивов

    return (result_list[half_length - 1] + result_list[half_length]) / 2.0


print get_median([1, 2, 3, 4], [1, 4, 5, 6])  # => 3.5