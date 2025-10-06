from textutils import tokenize, remove_stopwords, filter_by_length, stem_tokens, frequency, top_n_words

text = "The quick brown foxes were jumping happily over the happily dogs."

stopwords = {'the', 'were', 'over'}

tokens = tokenize(text)
print("Tokens:", tokens)

filtered_tokens = remove_stopwords(tokens, stopwords)
print("Without Stopwords:", filtered_tokens)

long_words = filter_by_length(filtered_tokens, 4)
print("Words longer than 4:", long_words)

stemmed_tokens = stem_tokens(filtered_tokens)
print("Stemmed Tokens:", stemmed_tokens)

freq = frequency(stemmed_tokens)
print("Frequency:", freq)

top_words = top_n_words(freq, 3)
print("Top 3 Words:", top_words)
