from functools import reduce

def frequency(tokens):

    freq_dict = reduce(lambda acc, word: {**acc, word: acc.get(word, 0) + 1}, tokens, {})
    return freq_dict

def top_n_words(freq_dict, n):

    sorted_words = sorted(freq_dict.items(), key=lambda item: item[1], reverse=True)
    return sorted_words[:n]
