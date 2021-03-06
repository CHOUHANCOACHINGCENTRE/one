/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizers;

/**
 *
 * @author Puneet
 */

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.POS;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tokenizers.Token.TokenType;

/**
 * Recognizes content words (noun, verb, adjective, and adverb) from a
 * List of Token objects. Only TokenType.WORD tokens are considered in
 * this recognizer, and are converted to TokenType.CONTENT_WORD. Words
 * are looked up against the WordNet dictionary.
 */

public class ContentWordRecognizer implements IRecognizer {

  private IDictionary dictionary;
  private List<POS> allowablePartsOfSpeech = Arrays.asList(new POS[] {
    POS.NOUN, POS.VERB, POS.ADJECTIVE, POS.ADVERB});
  
  public void init() throws Exception {
    this.dictionary = new Dictionary(
      new URL("file", null, "D:\\Dropbox\\sandeep2\\WNdb-3.0\\dict"));
    dictionary.open();
  }

  public List<Token> recognize(List<Token> tokens) {
    List<Token> outputTokens = new ArrayList<Token>();
    for (Token token : tokens) {
      Token outputToken = new Token(token.getValue(), token.getType());
      if (token.getType() == TokenType.WORD) {
        String word = token.getValue();
        for (POS allowablePartOfSpeech : allowablePartsOfSpeech) {
          IIndexWord indexWord = 
            dictionary.getIndexWord(word, allowablePartOfSpeech);
          if (indexWord != null) {
            outputToken.setType(TokenType.CONTENT_WORD);
            break;
          }
        }
      }
      outputTokens.add(outputToken);
    }
    return outputTokens;
  }
}
