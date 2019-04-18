package com.github.fac30ff.java.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.miscellaneous.CapitalizationFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;

public class MyCustomAnalyzer extends Analyzer {
  protected TokenStreamComponents createComponents(String s) {
    final StandardTokenizer src = new StandardTokenizer();
    TokenStream tokenStream = new StandardFilter(src);
    tokenStream = new LowerCaseFilter(tokenStream);
    tokenStream = new StopFilter(tokenStream, StandardAnalyzer.STOP_WORDS_SET);
    tokenStream = new PorterStemFilter(tokenStream);
    tokenStream = new CapitalizationFilter(tokenStream);
    return new TokenStreamComponents(src, tokenStream);
  }
}
