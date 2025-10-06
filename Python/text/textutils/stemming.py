def simple_stem(word):

    suffixes = ['ing', 'ly', 'ed', 's', 'es']
    for suffix in suffixes:
        if word.endswith(suffix):
            return word[:-len(suffix)]
    return word

def stem_tokens(tokens):

    return list(map(simple_stem, tokens))
