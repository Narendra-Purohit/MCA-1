import re

def tokenize(text):
    """Simple whitespace and punctuation tokenizer"""
    return re.findall(r'\b\w+\b', text.lower())

def remove_stopwords(tokens, stopwords):
    """Remove stopwords using filter and lambda"""
    return list(filter(lambda word: word not in stopwords, tokens))

def filter_by_length(tokens, min_length):
    """Filter words longer than min_length using lambda"""
    return list(filter(lambda word: len(word) > min_length, tokens))
